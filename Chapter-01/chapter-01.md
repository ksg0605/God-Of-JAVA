# 1장 프로그래밍이란 무엇인가?

## 프로그래밍의 P

__프로그래밍을 작성하는 것 (디지털 도어락을 예시로)__
- 비밀번호를 입력하고 미리 만들어 놓은 어떤 프로그램에서 제공하는 결과를 기다릴 수도 있고
- 비밀번호를 입력 받아 비밀 번호가 맞는지 확인하는 것을 직접 작성할 수도 있다.

> 프로그래밍을 한다는 것은 모두 이러한 작업을 반복적으로 수행하면서 어떤 기능들을 만들어 내는 것이다.

## 자바 프로그램의 메소드는 이렇게 생겼어요

앞 절에서 살펴본 도어락의 비밀번호를 확인하는 자바 프로그램
```java
public boolean checkPassword(String password) {
    // 중간 내용
        }
```
password라는 비밀번호가 넘어가고, 중간에 계산을 하는 부분이 checkPassword() 라는 것이다.  
그 결과로 boolean이라는 것이 나온다.
- 어떤 값을 주고 결과를 넘겨주는 것을 자바에서는 "메소드"라고 한다. 그리고, checkPassword()라는 것은 "메소드 이름"이 된다. 이 메소드는 "checkPassword"메소드라고 부른다.
- password라는 것은 매개 변수라고 부른다. 있어도 되고 없어도 된다.
- boolean은 리턴 타입이라고 한다.

> 참고)  
> 지금 살펴본 메소드를 선언할 떄의 순서는 꼭 지켜 줘야만 한다. 만약 다음처럼.
> ```java
> public checkPassword(String password) boolean {
> }
> ```
> 리턴 타입을 메소드 이름보다 나중에 쓰거나,
> ```java
> (String password) public boolean checkPassword {
> }
> ```
> 매개 변수를 맨 앞에 쓰면 자바라는 언어에서는 "너 뭐하는 거니?" 라고 하면서 에러를 뱉어낸다.

## 자바의 가장 작은 단위는 클래스랍니다.

자바의 메소드는 무소속으로 존재할 수 없기 때문에 클래스라는 것 안에 포함되어야 한다.
```java
public class DoorLockManager {
    // 중간 생략
}
```
여기서 DoorLockManager라고 적혀있는 것이 바로 클래스 이름이다. 반드시 앞에 class 라는 단어가 있어야 한다.  
그 앞에는 public 이라는 접근 제어자가 있다.  
정리하자면 **public class 클래스 이름** 순서라는 것을 기억하자
  
배운 것을 모아보자면 다음과 같다.
```java
public class DoorLockManager {
    public boolean checkPassword(String password) {
        
    }
}
```
이렇게 클래스 안에 메소드가 위치한다.  
하나의 클래스 안에는 0개 이상의 여러 메소드가 존재할 수 있다. 

```java
public class DoorLockManager {
    public boolean checkPassword(String password) {
        // 중간 생략
    }
    public void setPassword(String password) {
        // 중간 생략
    }
    public void resetPassword() {
        // 중간 생략
    }
}
```

## 클래스는 상태를 갖고 있어야 합니다.
자바와 같은 언어를 객체지향 프로그래밍 언어(Object Oriented Programming Language)라고 한다.  
앞의 DoorLockManager 라는 클래스는 현실에 있는 사물을 클래스로 나타낸 것이다. 이 클래스라는 것은 다음의 조건을 만족해야만 한다.
> __클래스는 상태(state)와 행동(behavior)이 있어야만 한다.__

- 메소드가 행동

__상태는__
- 클래스 안에,
- 메소드 밖에 정의한다.

```java
public class DoorLockManager {
    String currentPassword;
    public boolean checkPassword(String password) {
        // 중간 생략
    }
    // 이하 메소드 생략
}
```
이와 같이 어떤 값을 포함할 currentPassword 와 같은 것을 "변수(variable)"이라고 한다.  
이를 클래스의 상태를 결정짓는 "상태" 라고 표현한다.

## 프로그래미의 가장 기본은 =를 이해하는 것

정수 num1과 num2를 더하는 add()라는 메소드를 만들어보자
```java
public class Calculator {
    public int add(int num1, int num2) {
        int sum;
        sum = num1 + num2;
        return sum;
    }
}
```

```java
public class Calculator {
    public int add(int num1, int num2) {
        int sum;
        sum = num1 + num2;
        return sum;
    }
    
    public int addAll(int num1, int num2, int num3) {
        int sum;
        sum = num1 + num2 + num3;
        return sum;
    }
}
```

*Java에서 사용하는 기본적인 사칙연산*
> 참고) 자바에서 사용하는 기본적인 사칙연산은 다음과 같다. 여기서는 num1은 0, num2sms 5일 때의 예이다.

|연산 종류|기호|예|결과|     
|-------|--|-|--|   
| 더하기 | + | num1 + num2 | 15 |   
| 빼기 | - | num1 - num2 | 5 |    
| 곱하기 | * | num1 * num2 | 50 |   
| 나누기 | / | num1 / num2 | 2 |

## 한 줄을 의미하는 세미콜론
모든 자바 코드의 한 줄이 끝날 때에는 ;을 적어 주어야만 한다.  
그렇지 않으면 그 다음 줄도 같은 줄로 생각한다.  

## 모든 프로그래밍 언어에는 예약어라는 것이 있어요

앞서 살펴본 Calculator 클래스를 다시 보자.
```java
public class Calculator {
public int add(int num1, int num2) {
int sum;
sum = num1 + num2;
return sum;
}
}
```

여기에 있는 예약어는 public, class, int, return 이다.   
예약어라는 것은 "예약되어 있으니까 쓰지 못하는 단어" 라고 보면 된다.
- 예약어라는 것이 있고,
- 예약어는 클래스, 메소드, 변수의 이름으로 사용할 수 없다.