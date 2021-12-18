# 자바를 제대로 알려면 객체가 무엇인지를 알아야 해요

## 자바는 객체지향 언어라고 해요

모든 사물에도 상태와 행위가 있다.
1. 책
   1. 상태
      1. 펼쳐져 있는 상태
      2. 덮여 있는 상태
   2. 행위
      1. 펼치는 행위
      2. 페이지를 넘기는 행위
      3. 덮는 행위

2. 자동차
   1. 상태
      1. 시속 50km/h로 주행중인 상태
      2. 512km를 주행한 상태
      3. 차 색깔이 빨간색인 상태
   2. 행위
      1. 가속을 하는 해우이
      2. 감속을 하는 행위
      3. 문이 열리는 행위

3. 핸드폰
   1. 상태
      1. 전원이 켜진 상태
      2.전원이 꺼진 상태
      3.화면이 켜진 상태
      4.화면이 꺼진 상태
   2. 행위
      1. 전화를 하는 행위
      2. 전화를 받는 행위
      3. 메신저를 하는 행위
      4. 인터넷을 하는 행위

모든 사물을 각각의 개페로 나눌 수 있으며, 행위를 찾아 낼 수 있다.
   
자동차를 자바로 표현한다면
```java
public class Car {
    public Car() {
        
    }
}
```
Car 클래스 밑에 있는 메소드 같이 생긴 것은 생성자(Constructor)라고 부른다  
생성자는 Car 클래스의 객체를 생성할 때 필요하다.  
이 Car 클래스의 주행중인 상태, 주행한 상태, 차 색깔의 상태 등을 다음과 같이 변수로 나타낼 수 있다.  
```java
public class Car {
    public Car() {
    }
    int speed;
    int distance;
    String color;
}
```
이렇게 변수를 지정함으로써 클래스의 상태를 정할 수 있다.
```java
public class Car {
    int speed;
    int distance;
    String color;
    
    public Car() {
    }
    public void speedUp() {
        // 내용 생략
    }
    public void breakDown() {
        // 내용 생략
    }
}
```
이렇게 속도를 올리는 speedUp() 메소드와 속도를 줄이는 breakDown() 메소드로 클래스의 상태를 변경하는 행위를 지정할 수 있다.

__SmartPhone 클래스__

```java
public class SmartPhone {
   boolean isDeviceTurnOn;
   boolean isDeviceTurnOff;
   boolean isScreenTurnOn;
   boolean isScreenTurnOff;

   public SmartPhone() {
   }

   public void setDeviceTurnOn(boolean deviceTurnOn) {
      // 내용 생
   }

   public void setDeviceTurnOff(boolean deviceTurnOff) {
      // 내용 생략
   }

   public void setScreenTurnOn(boolean screenTurnOn) {
      // 내용 생략
   }

   public void setScreenTurnOff(boolean screenTurnOff) {
      // 내용 생략
   }
}
```

## 클래스와 객체는 구분하셔야 해요
각각의 실제 사물을 나타내기 위한 것을 "객체(object)" 혹은 "안스턴스(instance)" 라고 한다.  
자동차를 관리하는 CarManager 클래스를 만들고, 그 안에 main() 클래스를 만들자
```java
public class CarManager {
   public static void main(String[] args) {
      // 앞으로 여기에 코드가 들어감
   }
}
```

이 CarManager 라는 클래스에서 서로 다른 차를 나타내기 위해서는 Car 클래스를 이용하여 생성한다.

```java
Car dogCar =  new Car();
Car cowCar =  new Car();
```

### Car()
여기에 "Car()" 라고 하는 메소드 같이 생긴 "생성자(constructor)" 를 사용하고 있다.  
생성자는 객체를 생성하기 위한 유일한 도구다.  
Car() 처럼 매개 변수가 없는 생성자는 만들지 않아도 괜찮다.  
매개 뱐수가 없는 생성자를 "기본 생성자(default constructor)" 라고 한다.  
기본 생성자는 클래스를 컴파일할 떄 javac를 실행하면 클래스 파일 안에 자동으로 만들어진다.  
 
### new
그리고 new 라는 것은 예약어이다. 이 new 라는 단어 뒤에는 클래스의 생성자를 지정하면 된다.  
"Car" 라는 클래스는 그냥 껍데기일 뿐이고, new라는 예약어를 통해서 생성자인 Car()를 호출하면 dogCar나 cowCar라는 객체가 생성된다.  
즉, 클래스는 대부분 그 차제만으로 일을 할 수 없고, 객체를 생성해야만 우리가 일을 시킬 수 있다.  
```java
cowCar.speedUp();
```

다시 말해서, 소똥이 차의 속도를 높이고 싶다면 cowCar 객체를 만들고, 그 객체의 speedUp() 메소드를 불러주면 된다.  
<br/>
작성된 전체 소스는 다음과 같다.

```java
public class CarManager {
   public static void main(String[] args) {
        Car dogCar = new Car();
        Car cowCar = new Car();
        cowCar.speedUp();
   }
}
```

## Car 클래스를 구현하자
```java
public class Car {
    int speed;
    int distance;
    String color;
    
    public Car() {
    }
    public void speedUp() {
        // 내용 생략
    }
    public void breakDown() {
        // 내용 생략
    }
}
```
여기서 speedUp() 메소드와 breakDown() 메소드는 구현이 되지 않았다.    
구현 조건
- speedUp() 메소드를 호출하면 speed는 5씩 증가한다.
- breakDown() 메소드를 호출하면 speed는 10씩 감소한다. 

```java
public void speedUp() {
    speed = speed + 5;
        }
```
```java
public void breakDown() {
    speed = speed - 10;
        }
```

여기서 speed 라는 변수는 speedUp() 메소드에 선언되어 있지 않았다.  
하지만 Car 클래스에 선언되어 있다.  
이렇게 속도를 증가시키고, 감소시켜도 현재의 속도를 확인할 수 있는 방법이 없다.  
따라서 현재 속도를 확인할 수 있는 getCurrentSpeed() 메소드를 만들자.

```java
public class Car {
   int speed;
   int distance;
   String color;

   public Car() {
   }

   public void speedUp() {
      speed = speed + 5;
   }

   public void breakDown() {
      speed = speed - 10;
   }

   public int getCurrentSpeed() {
      return speed;
   }
}
```
개똥이 차의 속도를 증가시키고 감소시키기
```java
public class CarManager {
   public static void main(String[] args) {
        Car dogCar = new Car();
        dogCar.speedUp();
        dogCar.speedUp();
        System.out.println(dogCar.getCurrentSpeed());
        dogCar.breakDown();
        System.out.println(dogCar.getCurrentSpeed());
   }
}
```

## 계산기 클래스를 만들어보자
계산기의 기본적인 기능인 더하기, 빼기, 곱하기, 나누기 기능을 제공하느 클래스와 메소드를 만들어보자  
각 메소드는 두 개의 정수를 매개 변수로 받아서 계산해야만 한다.  
참고로 더하기는 add, 빼기는 subtract, 곱하기는 multiply, 나누기는 divide 다.  
```java
public class Calculator {
   public static void main(String[] args) {
      System.out.println("Calculator class started");
   }
   public int add(int a, int b) {
       return a + b;
   }
   public int subtract(int a, int b) {
       return a - b;
   }
   public int multiply(int a, int b) {
       return a * b;
   }
   public int divide(int a, int b) {
       return a / b;
   }
}
```

a에는 10을 지정해 주고, b에는 5를 지정해 주었다.  
calc.add(10, 5); 이렇게 지정해도 전혀 문제되지 않는다. 하지만 값을 계속 넘겨줄 때에는 변수를 지정해서 매개 변수로 넘겨 주는 것이 좋다.  

```java
public static void main(String[]args){
    System.out.println("Calcualator class is started");
    Calculator calc = new Calculator();
    int a = 10;
    int b = 5;
    System.out.println("add=" + calc.add(a, b));
    System.out.println("subtract=" + calc.subtract(a, b));
    System.out.println("multiply=" + calc.multiply(a, b));
    System.out.println("divide=" + calc.divide(a, b));
        }
```