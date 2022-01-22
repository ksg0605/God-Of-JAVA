# 8장 참조 자료형에 대해서 더 자세히 알아봅시다
## 참조 자료형은 나머지 다에요
자바의 타입
- 기본 자료형
- 참조 자료형
  - new를 사용해서 객체를 생성하는가
  - String은 new 없이도 생성 가능
  - new 뒤에 나오는 것이 참조 자료형
  - 클래스를 만들면 보통 인스턴스 변수와 클래스 변수를 만들고, 생성자와 메소드를 만들어야 한다.

## 기본 생성자
- 생성자를 만들지 않아도 자동으로 만들어지는 기본 생성자가 있다.
- main() 메소드에서 실습 클래스의 이름으로 객체를 생성한 것
```java
public class ReferenceDefault {
  public static void main(String[] args) {
    ReferenceDefault referenceDefault = new ReferenceDefault();
  }
}
```
- main() 메소드를 보면 ReferenceDefault 클래스의 인스턴스인 reference를 만든것을 볼 수 있다.
- 등호 우측에 new 옆에 있는 ReferenceDefault()가 생성자.
- 아무런 매개 변수가 없는 생성자는 다른 생성자가 없을 경우 기본으로 컴파일할 때 만들어진다.

```java
public class ReferenceString {
  public ReferenceString(String arg) {
        
  }
  public static void main(String[] args) {
    ReferenceString referenceString = new ReferenceString();  
  }
}
```
- 위와 같은 경우에는 "actual and formal argument lists differ in length"오류가 발생
- 기본 생성자는 다른 생성자가 있으면 자동으로 만들어지지 않는다

```java
public class ReferenceString {
  public ReferenceString() {}
  public ReferenceString(String arg) {}

  public static void main(String[] args) {
    ReferenceString referenceString = new ReferenceString();
  }
}
```

- 생성자는 클래스의 객체(또는 인스턴스)를 생성하기 위해서 존재한다.
- main() 메소드에서 reference 라는 것이 바로 객체다
- 생성자에 리턴 타입이 없는 이유는 생성자의 리턴 타입은 클래스의 객체이기 때문
- 클래스와 이름이 동일해야 컴파일러가 생성자 라는 것을 알아 차림
- 가장 윗부분에 선언

## 생성자는 몇 개까지 만들 수 있을까?
- 개수는 상관 없다
- DTO라는 자바의 패턴
- 속성을 갖는 클래스를 만들고, 그 속성들을 쉽게 전달하기 위해서 DTO라는 것을 만듦
- Data Transfer Object
  - 데이터를 다른 서버로 전달하기 위함
- VO Value Object
  - 데이터를 담아 두기 위한 목적

> 패턴은 비슷한 기능을 하는 규칙에 하나의 이름을 정해 놓은 것

```java
public class MemberDTO {
    public String name;
    public String phone;
    public String email;
}
```
- DTO의 장점
- 메소드를 선언할 때 하나의 리턴 타입만 선언 가능
- 복합적인 데이터를 리턴하려면 String[]과 같이 배열을 리턴해도 되겠지만.
- int 타입까지 포함되어 있다면 매우 애매해진다.
- 메소드의 리턴 타입에 MemberDTO로 선언하고, 그 객체를 리턴해준다.

```java
public MemberDTO getMemberDTO() {
    MemberDTO dto = new MemberDTO();
    
    return dto;
        }
```

```java
public class MemberDTO {
    public String name;
    public String phone;
    public String email;
    public MemberDTO() {
//        아무 정보도 모를 때
    }
    public MemberDTO(String name) {
//        이름만 알 때
      this.name = name;
    }
    public MemberDTO(String name, String phone) {
//        이름과 전화번호만 알 때
      this.name = name;
      this.phone = phone;
    }
    public MemberDTO(String name, String phone, String email) {
//        모든 정보를 알고 있을 때
      this.name = name;
      this.phone = phone;
      this.email = email;
    }
}
```

- 자바의 생성자는 매개 변수 개수의 제한은 없고 몇개를 만들어도 상관 없다.
- 너무 많으면 관리가 힘듦
- this
- 객체의 변수와 매개 변수의 이름이 동일할 때, 인스턴스의 변수를 구분하기 위해서 사용

```java
public class ReferenceConstructor {
    
  public static void main(String[] args) {
    ReferenceConstructor referenceConstructor = new ReferenceConstructor();
    referenceConstructor.makeMemberObject();
  }
  
  public void makeMemberObject() {
    MemberDTO dto1 = new MemberDTO();  
    MemberDTO dto1 = new MemberDTO("Sangmin");  
    MemberDTO dto1 = new MemberDTO("Sangmin", "01000000000");  
    MemberDTO dto1 = new MemberDTO("Sangmin"m "01000000000", "god@godofjava.com");  
  }
}
```
- 네 가지 생성자를 모두 활용하여 객체를 생성할 수 있다.
  - dto1: 모두 null
  - dto2: 이름 지정, null, null
  - dto3: 이름과 전화번호 지정, null
  - dto4: 모두 지정

## 이 객체의 변수와 매개 변수를 구분하기 위한 this
- this는 생성자와 메소드 안에서 사용할 수 있다.

```java
public class MemberDTO {
    public String name;
    public String phone;
    public String email;
    public MemberDTO(String name) {
        this.name = name;
    }
}
```

## 메소드 overloading
- 클래스의 생성자는 매개 변수들을 서로 다르게 하여 선언할 수 있다.
- 메소드도 이름은 같게 하고 맥새 변수들을 다르게 하여 만들 수 있다.

```java
public class ReferenceOverloading {
    
  public static void main(String[] args) {
    ReferenceOverloading referenceOverloading = new ReferenceOverloading();
  }
  
  public void print(int data) {
      
  }
  public void print(String data) {
      
  }
  public void print(int intData, String stringData) {
      
  }
  public void print(String stringData, int intData) {
      
  }
}
```

- 각 메소드의 매개 변수의 종류와 개수, 순서가 다르다.
- 첫 번째 print() 메소드는 int를 매개 변수로 하고 있고,
- 두 번째 print() 메소드는 String을 매개 변수로 하고 있다.
- 세 번째 메소드와 네 번째 메소드를 보면 각 매개 변수들의 이름은 같지만, 세 번째 메소드는 int, String 순서이며, 네 번째 메소드는 String, int 순이다.
- 개수가 같아도 타입의 순서가 다르면 다른 메소드처럼 인식
- 중요한 것은 이름이 아닌 타입
- 메소드의 이름을 같도록 하고, 매개 변수만을 다르게 하는 것을 바로 오버로딩이라고 한다.
- 메소드 오버로딩은 "같은 역할을 하는 메소드는 같은 메소드 이름을 가져야 한다."
- 생성자도 매개 변수에 따라서 다르게 인식된다. (이것도 오버로딩의 일종)

## 메소드에서 값 넘겨주기
자바에서 메소드가 종료되는 조건
- 메소드의 모든 문장이 실행되었을 때
- return 문장에 도달했을 때
- 예외가 발생했을 때

void
- 빈 공간
- 하나도 없는
- 무효의
- 메소드의 모든 문장이 수행되면 메소드 종료
- 리턴이 없다.
     

- 메소드 이름 앞에 변수의 타입을 지정해 주고
- 메소드 내에서는 그 타입을 생성하고 가공한 후
- return 이라는 예약어를 사용하여 리턴

여러 개를 넘기고 싶다면?
- 앞에서 배운 DTO 시용

## static 메소드와 일반 메소드의 차이
```java
public class ReferenceStatic {
  public static void main(String[] args) {
    ReferenceStatic.staticMethod();
  }
  public static void staticMethod() {
    System.out.println("This is a staticMethod");
  }
}
```
- static 메소드는 객체를 생성하지 않고서도 메소드를 호출 할 수 있다.
- static 메소드는 클래스 변수만 사용할 수 있다.

```java
public class ReferenceStatic {
    String name = "Min";
    public static void staticMethodCallVariable() {
      System.out.println(name);
    }
}
```

## static 블록
- 어떤 클래스의 객체가 생성되면서 딱 한 번만 불려야 하는 코드
- 객체는 여러 개를 생성하지만 한 번만 호출되어야 하는 코드가 있을 때 사용

```java
static {
//    딱 한번만 수행되는 코드
        }
```
- 객체가 생성되기 전에 한 번만 호출된다.
- 클래스 내에 선언
- 메소드 내에서는 선언 불가


## Pass by value, pass by reference
```java
public class ReferencePass {
    
  public static void main(String[] args) {
      
    ReferencePass referencePass = new ReferencePass();
    referencePass.callPassByValue();
  }
  
  public void callPassByValue() {
      
      int a = 10;
      String b = "b";
      
    System.out.println("before passByValue");
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    
    passByValue(a, b);
    
    System.out.println("after passByValue");
    System.out.println("a = " + a);
    System.out.println("b = " + b);
  }
  
  public void passByValue(int a, String b) {
      
      a = 20;
      b = "z";
      
    System.out.println("in passByValue");
    System.out.println("a = " + a);
    System.out.println("b = " + b);
  }
}
```

```shell
before passByValue
a = 10
b = b
in passByValue
a = 20
b = z
after passByValue
a = 10
b = b
```
- int인 a나 String인 b는 기존 값이 변경되지 않는다.
- Pass By Value는 값을 전달하는 작업이고, 호출되기 전과 후에 데이터가 변경되지 않는다.
- Pass By Reference로 값을 전달하면 호출한 메소드의 데이터에도 영향이 있다. 
- 메소드의 매개 변수로 참조 자료형을 넘길 경우에는 메소드 안에서 객체의 상태를 변경한 결과에 영향을 받게 된다.
  
> 모든 기본 자료형은 Pass By Value 이다.
> 참조 자료형은 값이 아닌 참조가 전달되는 Pass By Reference 이다.


## 매개 변수를 지정하는 특이한 방법
매개 변수가 몇 개가 될지, 호출할 때마다 바뀌는 경우에는 어떻게 해야 할까?
- 배열을 넘겨주는 방법
```java
public class MethodVarargs {
  public static void main(String[] args) {
    MethodVarargs methodVarargs = new MethodVarargs();
    methodVarargs.calculateNumbersWithArray(new int [] {1, 2, 3, 4, 5});
  }
  public void calculateNumbersWithArray(int [] numbers) {
      
  }
}
```
- 임의 개수의 매개 변수 (Arbitrary Number of Arguments)를 넘겨주는 방법
- "타입...변수명" 으로 선언하면 numbers는 배열로 인식한다.
- 공백없이 연속해서 적어줄 것
```java
public class MethodVarargs {
  public static void main(String[] args) {
    MethodVarargs methodVarargs = new MethodVarargs();
    methodVarargs.calculateNumbersWithArray(new int[] {1, 2, 3, 4, 5});
    methodVarargs.calculateNumbers(1,2, 3, 4, 5);
  }
  public void calculateNumbersWithArray(int [] numbers) {}
  public void calculateNumbers(int...numbers){}
}
```
- 필요에 따라서 매개 변수 수를 정하기 애매한 경우 타입과 변수명 사이에 점 세개를 연달아 입력한다.
- 하나의 메소드에서 한 번만 사용 가능하고
- 가장 마지막에 선언해야 한다.
```java
public class MethodVarargs {
  public static void main(String[] args) {
    MethodVarargs methodVarargs = new MethodVarargs();
    methodVarargs.calculateNumbersWithArray(new int[] {1, 2, 3, 4, 5});
    methodVarargs.calculateNumbers(1,2, 3, 4, 5);
  }
  public void calculateNumbersWithArray(int [] numbers) {}
  public void calculateNumbers(int...numbers) {
      int total = 0;
      for(int number : numbers) {
          total += number;
      }
    System.out.println("Total = " + total);
  }
}
```