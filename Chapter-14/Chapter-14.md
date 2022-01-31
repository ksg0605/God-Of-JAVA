# 14장 다 배운 것 같지만, 예외라는 중요한 것이 있어요

## 자바에서 매우 중요한 예외
- 예외를 생각하지 않으면 안전한 프로그램 개발이 쉽지 않다
- null인 객체에 메소드를 호출한다던지
- 5개의 공간을 가지는 배열을 만들었는데 6번째 값을 읽으라고 하든지
- 어떤 파일을 읽으라고 했는데 읽을 파일이 존재하지 않는다든지
- 네트워크 연결이 되어 있는 어떤 서버가 갑자기 작동을 멈춰서 연결이 꾾겨버리든지

## try-catch는 짝이다

```java
package c.exception;

public class ExceptionSample {

    public static void main(String[] args) {
        ExceptionSample exceptionSample = new ExceptionSample();
        exceptionSample.arrayOutOfBounds();
    }

    public void arrayOutOfBounds() {
        int [] intArray = new int[5];
        System.out.println(intArray[5]);
    }
}
```

```java
package c.exception;

public class ExceptionSample {

    public static void main(String[] args) {
        ExceptionSample exceptionSample = new ExceptionSample();
        exceptionSample.arrayoutOfBoundsTryCatch();
    }

    public void arrayoutOfBounds() {
        int [] intArray = new int[5];
        System.out.println(intArray[5]);
    }

    public void arrayoutOfBoundsTryCatch() {
        try {
            int [] intArray = new int[5];
            System.out.println(intArray[5]);
            System.out.println("This code should run.");
        } catch (Exception e) {

        }
    }
}
```
- try-catch 블록
- try 뒤에 예외가 발생하는 문장들을 묶고
- catch 괄호 안에 예외가 발생했을 때 처리
- 모든 문장을 묶어줄 필요는 없고, 예외가 발생하는 부분만 묶어주면 된다.
- try 블록 안에서 예외가 발생하면 그 이하의 문장은 실행되지 않고 바로 catch 블록으로 넘어간다

```java
package c.exception;

public class ExceptionSample {

    public static void main(String[] args) {
        ExceptionSample exceptionSample = new ExceptionSample();
        exceptionSample.arrayoutOfBoundsTryCatch();
    }

    public void arrayoutOfBounds() {
        int [] intArray = new int[5];
        System.out.println(intArray[5]);
    }

    public void arrayoutOfBoundsTryCatch() {
        int [] intArray = new int[5];
        try {
            System.out.println(intArray[5]);
            System.out.println("This code should run.");
        } catch (Exception e) {
            System.err.println("Exception occured.");
        }
        System.out.println("This code must run.");
    }
}
```
- try 블록 내에서 예외가 발생하면, 예외가 발생한 줄 이후에 있는 try 블록 내에 있는 코드는 수행되지 않는다.
- 다음에 catch 블록에 있는 문장이 실행됨
- try 블록 내에서 예외가 발생하지 않으면 catch 내에 있는 코드는 실행되지 않는다
  

- try-catch에서 예외가 발생하지 않을 경우
  - try 내에 있는 모든 문장이 실행되고 try-catch 문장 이후의 내용이 실행된다.
- try-catch에서 예외가 발생하는 경우
  - try 내에서 예외가 발생한 이후의 문장들은 실행되지 않는다
  - catch 내에 있는 문장은 반드시 실행되고, try-catch 문장 이후의 내용이 실행된다.

## try-catch를 사용하면서 처음에 적응하기 힘든 변수 선언
- try 블록 내에서 선언한 변수를 catch에서 사용할 수 없다.
```java
package c.exception;

public class ExceptionVariable {
  public static void main(String[] args) {
    ExceptionVariable exceptionVariable = new ExceptionVariable();
    exceptionVariable.checkVariable();

  }
  public void checkVariable() {
    int[] intArray = new int[5];
    try {
      System.out.println(intArray[5]);
    } catch (Exception e) {
      System.out.println(intArray.length);
    }
    System.out.println("This code must run.");
  }
}
```

- 예외가 발생해서 intArray의 길이를 출력하고 try-catch 이후의 출력문이 실행되었다.
- try 블록 안에 변수를 선언하면 catch에서는 모르기 때문에 일반적으로 try 블록 앞에 선언한다.

## finally야~ 넌 무슨 일이 생겨도 반드시 실행해야 돼
- 자바에서 예외를 처리할 떄의 finally는 어떠한 경우에도 넌 반드시 실행해~~ 라는 의미이다.
```java
package c.exception;

public class FinallySample {
    public static void main(String[] args) {
        FinallySample finallySample = new FinallySample();
        finallySample.finallySample();

    }
    public void finallySample() {
        int[] intArray = new int[5];
        try {
            System.out.println(intArray[5]);
        } catch (Exception e) {
            System.out.println(intArray.length);
        } finally {
            System.out.println("Here is finally");
        }
        System.out.println("This code must run.");
    }
}
```

## 두 개 이상의 catch
- try-catch문을 쓸 때 catch에 Exception e 라고 아무 생각 없이 썼다.
- catch 블록이 시작되기 전에 (중괄호가 시작되기 전에) 소괄호에는 예외의 종류를 명시한다.
- 다시말해서 항상 Exception e 라고 쓰는 것은 아니다.

```java
package c.exception;

public class MultiCatchSample {
    public static void main(String[] args) {

    }
    public void multiCatch() {
        int[] intArray = new int[5];
        try {
            System.out.println(intaArray[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occured");
        } catch (Exception e) {
            System.out.println(intArray.length);
        }
    }
}
```
- try는 한 번만 쓰고 catch는 여러개 만들어도 문제 없다.
- catch 블록은 순서를 따진다.
- 모든 예외의 부모 클래스는 java.lang.Exception 클래스
- 예외는 부모 예외 클래스가 이미 catch를 하고, 자식 클래스가 그 아래에서 catch를 하도록 되어 있을 경우에는 자식 클래스가 예외를 처리할 기회가 없다.
- Exception 클래스가 모든 클래스의 부모 클래스이고, 배열에서 발생시키는 ArrayIndexOutOfBoundsException은 Exeption 클래스의 자식 클래스이기 때문에 절대로 Exception 클래스로 처리한 catch 블록 이후에 선언한 선언한 블록은 처리될 일이 없다.
- 필요없는 것을 왜 만들었냐 라고 컴파일러가 에러 발생
```java
package c.exception;

public class MultiCatchSample {

    public static void main(String[] args) {

    }

    public void multiCatch() {
        int[] intArray = new int[5];
        try {
            System.out.println(intaArray[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occured");
        } catch (Exception e) {
            System.out.println(intArray.length);
        }
    }

    public void multiCatchOrderChange() {
        int[] intArray = new int[5];
        try {
            System.out.println(intArray[5]);
        } catch (Exception e) {
            System.out.println(intArray.length);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred");
        }
    }

    public void multiCatchThree() {
        int[] intArray = new int[5];
        try {
            System.out.println(intArray[5]);
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException occurred");
        }
        catch (Exception e) {
            System.out.println(intArray.length);
        }
    }
}
```
- catch 문을 사용할 때에는 지금과 같이 Exception 클래스로 catch 하는 것을 가장 아래에 추가할 것을 권장한다.
  

- try 다음에 오는 catch 블록은 1개 이상 올 수 있다.
- 먼저 선언한 catch 블록의 예외 클래스가 다음에 선언한 catch 블록의 부모에 속하면, 자식에 속하는 catch 블록은 절대 실행될 일이 없으므로 컴파일이 되지 않는다.
- 하나의 try 블록에서 예외가 발생하면 그 예외와 관련이 있는 catch 블록을 찾아서 실행한다.
- catch 블록 중 발생한 예외와 관련있는 블록이 없으면, 예외가 발생되면서 해당 쓰레드는 끝난다.

## 예외의 종류는 세 가지다.
- checked exception
- error
- runtime exception 혹은 unchecked exception
  

- 두 번째와 세 번째에 있는 error과 unchecked exception을 제외한 모든 예외는 checked exception 이다.
### error
- 자바 프로그램 밖에서 발생한 예외
- Exception 클래스는 예외가 아니다.
- Error로 끝나면 에러이고 Exception으로 끝나면 예외다
### runtime exception
- 런타임 예외는 예외가 발생할 것을 미리 감지하지 못했을 때 발생
- RuntimeException을 확장한 예외들
- 컴파일할 떄 예외가 발생하지 않지만 실행시 발생할 가능성이 있다.
- 컴파일시에 체크를 하지 않기 때문에 unchecked exception 이라고도 부른다.
  

- Throwable
  - Error
  - Exception
    - RuntimeException
      - NullPointerException
      - NumberFormatException
      - ClassCastException
      - ...
    - IOException
    - SQLException
    - MalformedURLException

## 모든 예외의 할아버지는 java.lang.Throwable 클래스다
- Exception, Error 클래스는 Throwable 클래스를 상속받아 처리하도록 되어 있다.
  
- Throwable()
  - Throwable(String message)
  - Throwable(String message, Throwable cause)
  - Throwable(String cause)
- 예외 메시지를 String 으로 넘겨주거나
- 예외의 원인을 Throwable 객체로 넘겨 줄 수도 있다.

### getMesssage()
- 예외 메시지를 String 형태로 제공 받는다
- 예외가 출력되었을 때 어떤 예외가 발생되었는지를 확인할 때 매우 유용하다
- 즉 메시지를 활용하여 별도의 예외 메시지를 사용자에게 보여주려고 할 때 매우 유용하다

### toString()
- 예외 메시지를 String 형태로 제공 받는다
- getMessage() 메소드보다는 약간 더 자세하게 예외 클래스 이름도 같이 제공한다.

### printStackTrace()
- 가장 첫 줄에는 예외 메시지를 출력하고 
- 두번째 줄부터는 예외가 발생하게 된 메소드들의 호출 관계(스택 트레이스)를 출력해준다
```java
package c.exception;

public class ThrowableSample {

    public static void main(String[] args) {
        ThrowableSample throwableSample = new ThrowableSample();
        throwableSample.throwable();
    }

    public void throwable() {
        int[] intArray = new int[5];
        try {
            intArray = null;
            System.out.println(intArray[5]);
        }
        catch (Throwable t) {
            System.out.println(t.getMessage());
            System.out.println(t.toString());
            t.printStackTrace();
        }
    }
}
```

## 난 예외를 던질 거니까 throws라고 써 놓을게
- try 블록 내에서 throw 라고 명시한 흐 개발자가 예외 클래스의 객체를 생성한다
- 다른 예외가 발생한 상황과 동일하게 throw한 문장 이후에 있는 모든 try 블록 내의 문장들은 수행이 되지 않고 catch 블록으로 이동한다
- number가 12보다 크면 예외를 던지고 그 밑에 출력 문장은 수행되지 않는다.
- catch 블록 중에 throw한 예외와 동일하거나 상속 관계에 있는 예외가 있다면 그 블록에서 예외를 처리할 수 있다.
- 해당하는 예외가 없다면 발생된 예외는 메소드 밖으로 던진다
- 예외가 발생된 메소드를 호출한 메소드로 던진다.
- 이때 throws를 사용

```java
package c.exception;

public class ThrowSample {

    public static void main(String[] args) {

    }

    public void throwException(int number) {
        try {
            if (number > 12) {
                throw new Exception("Number is over than 12");
            }
            System.out.println("Number is " + number);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
```java
package c.exception;

public class ThrowSample {

    public static void main(String[] args) {

    }

    public void throwException(int number) throws Exception {
        if (number > 12) {
            throw new Exception("Number is over than 12")
        }
        System.out.println("Number is " + number);
    }
}
```
- 메소드 선언에 해놓으면, 예외가 발생했을 때 try-catch로 묶어주지 않아도 그 메소드를 호출한 메소드로 예외처리를 위임
- throws가 선언되어 있으 전혀 문제없이 컴파일 및 실행이 가능하다
- 이 메소드를 호출한 메소드에서는 메소드를 반드시 try-catch 블록으로 감싸주어야 한다.
  
- 메소드를 선언할 때 매개 변수 소괄호 뒤에 throws 라는 에약어를 적어준 뒤 예외를 선언하면, 해당 메소드에서 선언한 예외가 발생했을 때 호출한 메소드로 예외가 전달된다.
- 만약 메소드에서 두 가지 이상의 예외를 던질 수 있다면, implements 처럼 콤마로 구분하여 예외 클래스 이름을 적어주면 된다.
- try 블록 내에서 예외를 발생시킬 때에는 throw 라는 예약어를 적어준 뒤 예외 객체를 생성하거나, 생성되어 있는 객체를 명시해준다
- throw한 예외 클래스가 catch 블록에 선언되어 있지 않거나, throws 선언에 포함되어 있지 ㅇ낳으면 컴파일 에러가 발생한다.
- catch 블록에서 예외를 throw 할 경우에도 메소드 선언의 throws 구문에 해당 예외가 정의되어 있다.
```java
public void multiThrows() throws NullPointerException, Exception {
    // 여러가지의 예외를 던질 때 thorws 구문에 예외 클래스를 여러 개 나열하는 예제
        }
```

## 내가 예외를 만들 수도 있다구??
```java
pacakage c.exception;

public class MyException extends Exception {
    
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
        }
}
```

```java
package c.exception;

public class CustomException {

    public static void main(String[] args) {
        CustomException customException = new CustomException();
    }

    public void throwMyException(int number) throws MyException {
        try {
            if (number > 12) {
                throw new MyException("Number is over than 12");
            }
        }
        catch (MyException e) {
            e,printStackTrace();
        }
    }
}
```

## 자바 예외 처리 전략
- 임의의 예외 클래스를 만들 때
- 반드시 try-catch 로 묶어줄 필요가 있을 경우에만 Exception 클래스를 확장한다
- 일반적으로 실행시 예외를 처리할 수 있는 경우에는 RuntimeException 클래스를 확장하는 것을 권장한다
- catch 문 내에 아무런 작업 없이 공백을 놔두면 예외 분석이 어려워지므로 꼭 로그 처리와 같은 예외 처리를 해줘야만 한다.
