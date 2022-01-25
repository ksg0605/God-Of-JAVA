# 10장 연습문제
1. Animal이라는 클래스를 만들자(패키지는 c.inheritance로 선언하자)
2. 동물의 공통적인 특징이 어떤 것이 있는지 Animal 클래스에 선언될 변수들을 생각하여 추가하자.  
   (예: name, kind, legCount, iq, hasWing)
3. 동물이 공통적으로 어떤 행위를 하는지, Animal 클래스에 선언될 메소드들을 생각하여 추가하자  
   (예: move, eatFood)
4. Animal 클래스의 속성(변수 지정)과 행위(메소드 선언)에 대한 정의가 끝났으면, Dog라는 자식 클래스를 만들고, 필요한 메소드를 overriding하고 필요한 변수를 추가하자
5. 이번에는 Cat이라는 자식 클래스를 만들자. 마찬가지로 필요한 메소드를 overriding하고 필요한 변수를 추가하자
6. 4와5에서 각각 Dog와 Cat이라는 클래스르 만들면서 두 동뭉의 공통적인 사항이 있는지 확인해 보자  
만약 공통적인 것이 있다면 Animal 클래스에 해당 변수나 메소드를 선언해도 되는지 생각해보자
7. 6에서 변경해야 하는 사항이 발생하면 관련 클래스들을 수정하자

```java
package c.inheritance;

public class Animal {

    String name = "";
    String kind = "";
    int legCount = 0;
    int iq = 0;
    boolean hasWing = true;

    public void move() {

    }

    public void eatFood() {

    }
}
```

```java
package c.inheritance;

public class Dog extends Animal {
    public void move() {

    }

    public void eatFood() {

    }

    public void bark() {

    }

}


```
```java
package c.inheritance;

public class Cat extends Animal {
    public void move() {

    }

    public void eatFood() {

    }

    public void meow() {

    }
}
```


---
1. 상속을 받는 클래스의 선언문에 사용하는 선언문은 무엇인가요  
extends
2. 상속을 받은 클래스의 생성자를 수행하면 부모의 생성자도 자동으로 수행되나요?  
매개변수가 없으면 자동으로 수행 / 있으면 불가
3. 부모 클래스의 생성자를 자식 클래스에서 직접 선택하려고 할 때 사용하는 예약어는 무엇인가요?  
super()
4. 메소드 Overriding과 Overloading을 정확하게 설명해 보세요  
Overriding : 부모 클래스의 이름과 매개변수가 같은 메소드를 자식 클래스에서 사용하는 것  
Overloading : 같은 클래스에서 이름이 같은 메소드를 매개변수만 바꿔서 선언할 수 있다.
5. A가 부모, B가 자식 클래스라면 A a = new B(); 의 형태로 객체 생성이 가능한가요?  
가능하다.
6. 명시적으로 형 변환을 하기 전에 타입을 확인하려면 어떤 예약어를 사용해야 하나요?  
insteadof
7. 6에서 사용한 예약어의 좌측에는 어떤 값이, 우측에는 어떤 값이 들어가나요?  
좌측에는 객체, 우측에는 타입을 확인 할 클래스
8. 6의 예약어의 수행 결과는 어떤 탕비으로 제공되나요?  
boolean
9. Polymorphism이라는 것은 도데체 뭔가요?  
다형성 : 형 변환을 하더라도 실제 호출되는 것은 원래 객체에 있는 메소드가 호출된다.