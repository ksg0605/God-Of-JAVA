# 4장 정보를 어디에 넣고 싶은데
## 자바에서는 네 가지의 변수가 존재해요
변수: 내용을 어디엔가 담아 두는 공간
   
자바에는 네 가지 변수가 있다. 
1. 지역 변수: local variables
   - 중괄호 내에서 선언된 변수
2. 매개 변수: parameters
   - 메소드에 넘겨주는 변수
3. 인스턴스 변수: instance variables
   - 메소드 밖에, 클래스 안에 선언된 변수, 앞에는 static이라는 예약어가 없어야 한다. 
4. 클래스 변수: class variables
   - 인스턴스 변수처럼 메소드 밖에, 클래스 안에 선언된 변수 중에서 타입 선언 앞에 static이라는 예약어가 있는 변수

```java
public class Car {
    int speed;
    int distance;
    String color;
    // 이화 생략
}
```
앞 장에서 살펴본 Car 클래스의 speed, distance, color가 인스턴스 변수에 속한다.   
만약 이 인스턴스 변수들 가장 앞에 static이라는 단어를 붙이면 그 변수는 클래스 변수다
   
````java
public class VariableTypes {
    int instanceVariable;
    static int classVariable;
    public void method(int parameter) {
        int localVariable;
    }
}
````

1. 지역 변수: local variables
   - 지역 변수를 선언한 중괄호 내에서만 유효하다.
2. 매개 변수: parameters
   - 메소드가 호출될 떄 생명이 시작되고, 메소드가 끝나면 소멸된다.
3. 인스턴스 변수: instance variables
   - 객체가 생성될 때 생명이 시작되고, 그 객체를 참조하고 있는 다른 객체가 없으면 소멸된다. 
4. 클래스 변수: class variables
   - 클래스가 처음 호출될 때 생명이 시작되고, 자바 프로그램이 끝날 때 소멸된다. 

## 예제를 통해서 지역 변수를 확실히 익히자
가장 많이 사용하는 지역 변수에 대해서 살펴보자.
````java
public class VariableTypes {
    int instanceVariable;
    static int classVariable;
    public void method(int parameter) {
        int localVariable;
    }
}
````
여기서 지역 변수는 lovalVariable 뿐이다. 그런데, 다음과 같은 메소드가 추가되었다. 
````java
public class VariableTypes {
    int instanceVariable;
    static int classVariable;
    public void method(int parameter) {
        int localVariable;
    }
    public void anotherMethod() {
        int localVariable;
    }
}
````
method에서의 localVariable과 anotherMethod에서의 localVariable은 다른 변수이다.  
앞에서의 설명을 보면 "지역 변수를 선언한 중괄호 내에서만 유효하다." 라고 되어 있다.  
두 변수는 각각 다른 중괄호에 있기 떄문에 서로 다른 변수다.  
anotherMethod()가 다음과 같이 바뀌었다. 
````java
public class VariableTypes {
    int instanceVariable;
    static int classVariable;
    public void method(int parameter) {
        int localVariable;
    }
    public void anotherMethod() {
        if(true){
            int localVariable;
        }
        if(true){
            int localVariable;
        }
    }
}
````
두 개의 번수는 서로 다른 중괄호 안에 있기 때문에 사로 상관 없는 변수이다. 단지 이름만 같을 뿐이다.    
마지막으로 anotherMethod()가 다음과 같이 변경되었다. 
````java
public class VariableTypes {
    int instanceVariable;
    static int classVariable;
    public void method(int parameter) {
        int localVariable;
    }
    public void anotherMethod() {
        if(true){
            int localVariable;
            if(true){
                int localVariable;
            }
        }
    }
}
````
두 개의 변수는 서로 같은 중괄호 안에 선언되어 있다.  
이렇게 사용하면 절대 안 된다. 이를 컴파일하면 에러가 발생한다.

## 변수 이름은 이렇게

변수의 이름은 어떻게 정하면 될까? 기본적인 규칙은 다음과 같다.  
- 길이의 제한은 없다.
- 첫 문자는 유니코드 문자, 알파벳, $, _만 올 수 있다. 그런데 보통 변수 이름은 일반적으로 $과 _로 시작하지 않는다.
- 두 번째 문자부터는 유니코드 문자, 알파벳, 숫자, $, _ 중 아무것이나 사용할 수 있다.
- 보통은 메소드 이름처럼 지정해서 사용한다. 첫 문자는 소문자로 시작하는 단어이고, 두 번쨰 단어의 첫 문자만 대문자로 시작하면 된다.
- 상수(constant value)의 경우에는 모두 대문자로 지정하며, 단어와 단어 사이에는 _로 구분을 한다. 여기서 상수는 절대 변하지 않는 값을 이야기한다. 따라서, 계속 값이 변하는 일반적인 변수에는 _를 붙이지 않는다.

## 크게 보면 자바에는 두 가지 자료형이 있답니다.
자바의 타입(자료형)
- 기본 자료형(Primitive data type)
  - 정해져 있다.
- 참조 자료형(Reference data type)
  - 마음대로 만들 수 있다.

> 이게 초기화다.   
> int a = 10;   

> 이것도 초기화다.
> Calculator calculator = new Calculator();


등호 오른쪽 부분을 잘 보자   
int를 초기화할 때에는 그냥 값을 바로 적어 주었고, Calculator를 초기화 할 때에는 new라는 예약어로 생성을 한다.  
자바에서는 이렇게 new를 사용해서 초기화 하는 것을 참조 자료형, 그렇지 않고 바로 초기화가 가능한 것을 기본 자료형이라고 한다.  
> 변수를 선언할 때에는 초기화를 해 줘야 변수가 사용할 수 있는 상황이 된다고 기억하면 된다. 

참조 자료형 중에서 딱 하나 초기화할 때 예외적인 것이 있다. 문자열을 다루는 String이다.  
String을 초기화할 떄에는 대부분의 개발ㅇ자들은 다음과 같이 초기화한다.  
> String bookName1 = "God Of Java";   

그런데, 다음과 같이 정의해도 상관 없다.  
> String bookName2 = new String("God Of Java");

String만이 참조 자료형이지만 new를 사용해서 객체를 생성하지 않아도 되는 유일한 타입이라고 알고 있으면 된다.

## 기본 자료형은 8개에요
기본 자료형은 숫자와 boolean 타입 두 가지로 나뉜다. 그리고 숫자는 정수형과 소수형으로 나뉜다.   
이러한 기본 자료형을 나열해보면 다음과 같다.
- 정수형: byte, short, int, long, char
- 소수형: float, double
- 기타: boolean

|타입|최소|최대|
|---|---|---|
|byte|-128|127|
|short|-32,768|32,767|
|int|-2,147,483,648|2,147,483,647|
|long|-9,223,372,036,854,775,808|9,223,327,036,854,775,807|
|char|0(' `u0000')|65,535(' `uffff')|

예시를 통해서 byte에 대해서 조금 더 알아보자.  
````java
public class PrimitiveTypes {
   public static void main(String[] args) {
      PrimitiveTypes primitiveTypes = new PrimitiveTypes();
      primitiveTypes.checkByte();
   }
   public void checkByte() {
       byte byteMin = -128;
       byte byteMax = 127;  
       System.out.println("byteMin=" + byteMin);
       System.out.println("byteMax=" + byteMax);
       byteMin = (byte)(byteMin - 1);
       byteMax = (byte)(byteMax + 1);   
       System.out.println("byteMin - 1 = " + byteMin);    
       System.out.println("byteMax + 1 = " + byteMax);
   }
}
````
여기서 처음으로 형변환이 나왔는데, 해당 결과를 원하는 타입으로 바꾸는 것이다.

## 다른 정수형 타입들은 어떻게 활용하나?
- short
  - byte로 표현하기는 부족하고, int로 표현하기에는 너무 공간 낭비가 심하다고 생각할 때 사용하는 것이다.

````java
public class PrimitiveTypes {
   public static void main(String[] args) {
      PrimitiveTypes primitiveTypes = new PrimitiveTypes();
      primitiveTypes.checkByte();
   }
   public void checkByte() {
       byte byteMin = -128;
       byte byteMax = 127;  
       System.out.println("byteMin=" + byteMin);
       System.out.println("byteMax=" + byteMax);
       byteMin = (byte)(byteMin - 1);
       byteMax = (byte)(byteMax + 1);   
       System.out.println("byteMin - 1 = " + byteMin);    
       System.out.println("byteMax + 1 = " + byteMax);
   }
   public void checkOtherTypes() {
       short shortMax = 32767;
       int intMax = 21474836487;
       long longMax = 9223372036854775807L;
   }
}
````
long 뒤에는 L을 붙여 주어야 한다. 자바는 기본적으로 숫자를 int로 인식하기 떄문이다. 

## 소수점을 처리하고 싶어요

- float: single-precision 32-bit IEEE 754 floating point
- double: double-precision 64-bit IEEE 754 floating point

이 두가지 소수점은 간단한 계산에서는 사용해도 무방하지만,   
돈 계산과 같이 중요한 부분에서는 이 타입들을 사용해서는 안 된다.   
왜냐하면 float와 double은 43비트와 64비트로 제공할 수 있는 범위를 넘어서면 그 값의 정확성을 보장하지 못하기 떄문이다.  
그래서 자바에서는 정확한 계산이 요구될 떄에는 java.math.BigDecimal이라는 클래스를 사용해야만 한다.  
   
소수점 처리할 때 일반적으로는 double을 많이 사용한다. 그리고 대량으로 소수점 자리수가 적은 데이터를 저장하려고 할 떄 float를 사용하면 안 된다.  

## char와 boolean은 어떻게 쓰는 거지?

- char: 
  - 보통 character라고 읽는다. 
  - 문자열과 관련된 부분에서 사용한다. 
  - 정의할 때 홑따옴표를 사용한다.

```java
public class PrimitiveTypes {
    public static void main(String[] args) {
        PrimitiveTypes primitiveTypes = new PrimitiveTypes();
        primitiveTypes.checkByte();
        primitiveTypes.checkChar();
    }
    public void checkByte() {
        byte byteMin = -128;
        byte byteMax = 127;
        System.out.println("byteMin=" + byteMin);
        System.out.println("byteMax=" + byteMax);
        byteMin = (byte)(byteMin - 1);
        byteMax = (byte)(byteMax + 1);
        System.out.println("byteMin - 1 = " + byteMin);
        System.out.println("byteMax + 1 = " + byteMax);
    }
    public void checkOtherTypes() {
        short shortMax = 32767;
        int intMax = 2147483647;
        long longMax = 9223372036854775807L;
    }
    public void checkChar() {
        char charMin = '\u0000';
        char charMax = '\uffff';
        System.out.println("charMin = [" + charMin + "]");
        System.out.println("charMax = [" + charMax + "]");
    }
}
```   

> int intValue = 'a';   
> checkChar() 메소드에 이 코드를 넣고 출력문을 넣자

   
```java
public class PrimitiveTypes {
    public static void main(String[] args) {
        PrimitiveTypes primitiveTypes = new PrimitiveTypes();
        primitiveTypes.checkByte();
        primitiveTypes.checkChar();
    }
    public void checkByte() {
        byte byteMin = -128;
        byte byteMax = 127;
        System.out.println("byteMin=" + byteMin);
        System.out.println("byteMax=" + byteMax);
        byteMin = (byte)(byteMin - 1);
        byteMax = (byte)(byteMax + 1);
        System.out.println("byteMin - 1 = " + byteMin);
        System.out.println("byteMax + 1 = " + byteMax);
    }
    public void checkOtherTypes() {
        short shortMax = 32767;
        int intMax = 2147483647;
        long longMax = 9223372036854775807L;
    }
    public void checkChar() {
        char charMin = '\u0000';
        char charMax = '\uffff';
        System.out.println("charMin = [" + charMin + "]");
        System.out.println("charMax = [" + charMax + "]");
        int intValue = 'a';
        System.out.println("intValue=["+intValue+"]");
    }
}
```

## 기본 자료형의 기본 값은 뭘까?

자바의 모든 자료형은 값을 지정하지 않으면 기본값을 사용한다.  
그런데, 지역 변수로 기본 자료형을 사용할 떄에는 기본 값이 자동으로 적용되지 않고, 반드시 값을 지정해야만 한다.  
메소드 안에서 정의한 변수에 값을 지정하지 않고 사용하려고 하면, 컴파일도 되지 않는다.  
