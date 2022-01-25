# 10장 자바는 상속이라는 것이 있어요
```java
package c.inheritance;

public class Parent {
    public Parent() {
        System.out.println("Parent Constructor");
    }
    public void printName() {
        System.out.println("Parent printName()");
    }
}
```

```java
package c.inheritance;

public class Child extends Parent {
    public Child() {
        System.out.println("Child Constructor");
    }
}
```
- 자바의 예약어인 extends는 그 뒤의 클래스를 상속받는다는 말
- 부모 클래스에 선언되어 있는 public, protected로 선언된 모든 변수와 메소드를 사용 가능
- 다른 패키지에 선언된 부모 클래스의 접근 제어자가 없거나 private로 선언된 것은 사용 불가


```java
package c.inheritance;

public class InheritancePrint {
    public static void main(String[] args) {
        Child child = new Child();
        child.printName();
    }
}
```
- 확장을 한 클래스가 생성자를 호출하면 자동으로 부모 클래스의 기본 생성자가 호출
- 다음으로 자식 클래스의 생성자에 있는 내용들이 수행

  
- 부모 클래스에서는 기본 생성자를 만들어 놓는 것 이외에는 상속을 위해서 아무런 작업을 할 필요는 없다.
- 자식 클래스는 클래스 선언시 extends 다음에 부모 클래스 이름을 적어준다.
- 자식 클래스의 생성자가 호출되면, 자동으로 부모 클래스의 매개 변수 없는 생성자가 실행된다.
- 자식 클래스에서는 부모 클래스에 있는 public, protected로 선언된 모든 인스턴스 및 클래스 변수와 메소드를 사용할 수 있다.

  
- 자식 클래스가 부모 클래스가 갖고 있는 변수와 메소드를 상속받음으로써, 이중, 삼중의 일을 안 해도 된다.

```java
package c.inheritance;

public class ChildPrint extends Parent {
    public ChildPrint() {
        System.out.println("ChildPrint Constructor");
    }
    public void printAge() {
        System.out.println("printAge() - 18 month");
    }
}
```
  
- 확장한 클래스는 추가적인 메소드를 만들어도 전혀 문제가 없다.
- 자바에서는 다중 상속이 안 된다.

## 상속과 생성자
- 부모 클래스에서는 기본 생성자를 만들어 놓는 것 이외에는 상속을 위해서 아무런 작업을 할 필요는 없다.
- 부모 클래스의 상속을 받은 자식 클래스의 모든 생성자가 실행될 때 부모 클래스의 기본 생성자를 찾는데,  
- 부모 클래스에 기본 생성자가 없으면 오류 발생
  - 부모 클래스에 매개변수가 없는 기본 생성자를 만든다.
  - 자식 클래스에서 부모 클래스의 생성자를 명시적으로 지정하는 super()를 사용한다.

### super()
- 메소드처럼 super() 라고 사용하면 부모 클래스의 생성자를 호출한다는 것을 의미
- super.printName() 으로 사용하면 부모 클래스에 있는 printName() 이라는 메소드를 호출한다는 의미이다.

```java
package c.inheritance;

public class ParentArg {
    public ParentArg(String name) {
        System.out.println("ParentArg(" + name + ") Constructor");
    }
    public ParentArg(InheritancePrint obj) {
        System.out.println("ParentArg(InheritancePrint) Constructor");
    }
    public void printName() {
        System.out.println("printName() - ParentArg");
    }
}
```

```java
package c.inheritance;

public class ChildArg extends ParentArg {
    public ChildArg() {
        super("ChildArg");
        System.out.println("Child Constructor");
    }
}
```


## 메소드 overriding
- 부모의 기능을 자식이 모두 포함한다고 볼 수 있다.
- Overriding은 상속 관계를 보다 유연하게 활용하기 위한 메소드
- 자식 클래스에서 부모 클래스에 있는 메소드와 동일하게 선언하는 것을 오버라이딩이라고 함
- 접근 제어자, 리턴 타입, 메소드 이름, 매개 변수 타입 및 개수가 모두 동알해야 한다.
- 다른 무엇보다 더 중요한, 최우선시 되는

```java
package c.inheritance;

public class ParentOverriding {
    public ParentOverriding() {
      System.out.println("ParentOverriding Constructor");
    }
    public void printName() {
      System.out.println("printName() - ParentOverriding");
    }
}
```

```java
package c.inheritance;

public class ChildOverriding extends ParentOverriding {
    public ChildOverriding() {
      System.out.println("ChildOverriding Constructor");
    }
    public void printName() {
      System.out.println("ChildOverriding printName()");
    }
}
```

```java
package c.inheritance;

public class InheritanceOverriding {
  public static void main(String[] args) {
    ChildOverriding childOverriding = new InheritanceOverriding();
    childOverriding.printName();
  }
}
```

- ParentOverriding 클래스에 선언된 printName() 메소드가 수행된 것이 아니라, ChildOverriding 클래스에 선언된 printName() 메소드가 호출되었다.
- 부모 클래스에 선언되어 있는 메소드와 동일하게 선언되어 있는 메소드를 자식 클래스에 선언하면 자식 클래스의 메소드만 실행된다. 
- 생성자의 경우 자동으로 부모 클래스에 있는 생성자를 호출하는 super()가 추가되지만, 메소드는 그렇지 않다.
- 자식에서는 접근 제어자의 권한이 확대되어도 괜찮지만 축소는 불가

### 정리
- 메소드 오버라이딩은 부모 클래스의 메소드와 동알한 시그니처를 갖는 자식 클래스의 메소드가 존재할 때 성립된다.
- 오버라이딩된 메소드는 부모 클래스와 동일한 리턴 타입을 가져야만 한다.
- 오버라이딩된 메소드의 접근 제어자는 부모 클래스에 있는 메소드와 달라도 되지만, 접근 권한이 확장되는 경우에만 허용된다.
- 접근 권한이 축소될 경우에는 컴파일 에러가 발생한다.

- Overloading : 확장 (메소드의 매개 변수들을 확장하기 떄문)
- Overriding : 덮어 씀 (부모 클래스의 메소드 시그니처를 복제해서 자식 클래스에서 새로운 것을 만들어 내어 부모 클래스의 기능을 무시하고 자식 클래스에서 덮어 씀)

## 참조 자료형의 형 변환
```java
package c.inheritance;

public class ParentCasting {
    public ParentCasting() {
        
    }
    public ParentCasting(String name) {
        
    }
    public void printName() {
      System.out.println("printName() - Parent");
    }
}
```

```java
package c.inheritance;

public class ChildCasting extends ParentCasting {
    public ChildCasting() {
        
    }
    public ChildCasting(String name) {
        
    }
    public void printName() {
      System.out.println("printName() - Child");
    }
    public void printAge() {
      System.out.println("printAge() - 18 month");
    }
}
```

원래의 객체 생성 방법
```java
ParentCasting parentCasting = new ParentCasting();
ChildCasting childCasting = new ChildCasting();
```

상속 관계가 성립되면, 다음과 같이 객체를 생성할 수도 있다.
```java
ParentCasting obj = new ChildCasting();

// 이건 불가능
ChildCasting obj2 = new ParentCasting(); 
```

- 자식 클래스에서는 부모 클래스의 메소드와 변수들을 사용할 수 있다.
- 거꾸로 부모 클래스에서는 자식 클래스의 메소드와 변수를 사용할 수 없다.
- 자식 객체를 생성할 때 부모 생성자를 사용하면 안 된다.

```java
package c.inheritance;

public class InheritanceCasting {
  public static void main(String[] args) {
    InheritanceCasting inheritanceCasting = new InheritanceCasting();
//    inheritanceCasting.objectCast();
//    inheritanceCasting.objectCast2();
    inheritanceCasting.objectCastArray();
  }
  
  public void objectCastArray() {
      ParentCasting parentCasting = new ParentCasting();
      ChildCasting childCasting = new ChildCasting();
      
      ParentCasting parentCasting2 = child;
      ChildCasting childCasting2 = parentCasting;
  }
}
```

```java
package c.inheritance;

public class InheritanceCasting {
public static void main(String[] args) {
InheritanceCasting inheritanceCasting = new InheritanceCasting();
//    inheritanceCasting.objectCast();
//    inheritanceCasting.objectCast2();
inheritanceCasting.objectCastArray();
}

    public void objectCastArray() {
        ParentCasting[] parentArray = new ParentCasting[3];
        parentArray[0] = new ChildCasting();
        parentArray[1] = new ParentCasting();
        parentArray[2] = new ChildCasting();
//        ChildCasting childCasting = new ChildCasting();
//
//        ParentCasting parentCasting2 = childCasting;
//        ChildCasting childCasting2 = (ChildCasting)parentCasting;
}

    public void objectCast2() {
        ChildCasting childCasting = new ChildCasting();
        ParentCasting parentCasting = childCasting;
        ChildCasting childCasting2 = (ChildCasting)parentCasting;
    }
}
```
- 일반적으로 여러 개의 값을 처리하거나 매개 변수로 값을 전달할 때에는 보통 부모 클래스의 타입으로 보낸다.
- 배열과 같이 여러 값을 한번에 보낼 때 각 타입별로 구분해서 메소드를 만들어야 하는 문제가 생길 수도 있기 때문이다.
- 배열의 타입이 자식인지 부모인지 어떨게 구분하는가
- instanceof 사용

```java
package c.inheritance;

public class InheritanceCasting {
    public static void main(String[] args) {
        InheritanceCasting inheritanceCasting = new InheritanceCasting();
//    inheritanceCasting.objectCast();
//    inheritanceCasting.objectCast2();
        inheritanceCasting.objectCastArray();
    }

    public void objectCastArray() {
        ParentCasting[] parentArray = new ParentCasting[3];
        parentArray[0] = new ChildCasting();
        parentArray[1] = new ParentCasting();
        parentArray[2] = new ChildCasting();
//        ChildCasting childCasting = new ChildCasting();
//
//        ParentCasting parentCasting2 = childCasting;
//        ChildCasting childCasting2 = (ChildCasting)parentCasting;
    }

    public void objectCast2() {
        ChildCasting childCasting = new ChildCasting();
        ParentCasting parentCasting = childCasting;
        ChildCasting childCasting2 = (ChildCasting)parentCasting;
    }
    
    private void objectTypeCheck(ParentCasting[] parentArray) {
        for(ParentCasting tempParent : parentArray) {
            if(tempParent instanceof ChildCasting) {
              System.out.println("ChildCasting");
            }
            else if(tempParent instanceof ParentCasting) {
              System.out.println("ParentCasting");
            }
        }
    }
}
```

- instanceof의 앞에는 객체를, 뒤에는 클래스(타입)을 지정해 주면 된다.
- 그러면 true나 false 같은 boolean 형태의 결과를 제공
- instanceof를 사용하여 타입을 점검할 때는 가장 하위에 있는 자식 타입부터 확인을 해야 제대로 타입 점검이 가능하다.

### 정리
- 참조 자료형도 형 변환이 가능하다
- 자식 타입의 객체를 부모 타입으로 형 변환하는 것은 자동으로 된다.
- 부모 타입의 객체를 자식 타입으로 형 변환을 할 떄에는 명시적으로 타입을 지정해 주어야 한다.
- 이때 부모 타입의 실제 객체는 자식 타입이어야만 한다.
- instanceof 명령어를 사용하면 객체의 타입을 확인할 수 있다.
- instanceof로 타입 확인을 할 때 부모 타입도 true라는 결과를 제공한다.

## Polymorphism
- 다형성
```java
package c.inheritance;

public class ChildOther extends Parent {
    public ChildOther() {
        
    }
    
    public void printName() {
      System.out.println("ChildOTher - printName()");
    }
}
```

- 자식의 개수는 상관없다.

```java
package c.inheritance;

public class InheritancePoly {
  public static void main(String[] args) {
    InheritancePoly inheritancePoly = new InheritancePoly();
    inheritancePoly.callPrintNames();
  }
  
  public void callPrintNames() {
    Parent parent1 = new Parent();
    Parent parent2 = new Child();
    Parent parent3 = new ChildOther();
    
    parent1.printName();
    parent2.printName();
    parent3.printName();
  }
}
```

- 선언시에는 모두 Parent 타입으로 선언했지만
- 실제로 호출된 메소드는 생성자를 사용한 클래스에 있는 것이 호출
- 각 객체의 실제 타입이 다르기 떄문인다.
- 형 변환을 하더라도, 실제 호출된느 것은 원래 객체에 있는 메소드가 호출된다는 것이 다형성

## 자식 클래서에서 할 수 있는 일들을 다시 정리해보자
### 생성자
- 자식 클래스의 생성자가 호출되면 자동으로 부모 클래스의 매개 변수가 없는 기본 생성자가 호출된다.
- 명시적으로 super()라고 할 수 있다.
- 부모 클래스의 생성자를 명시적으로 호출하려면 super()를 사용하면 된다.

### 변수
- 부모 클래스에 private로 선언된 변수를 제외한 모든 변수가 자신의 클래스에 선언된 것처럼 사용할 수 있다.
- 부모 클래스에 선언된 변수와 동일한 이름을 가지는 변수를 선언할 수도 있다.
- 하지만 이렇게 엎어 쓰는것은 권장하지 않는다.
- 부모 클래스에 선언되어 있지 않는 이름의 변수를 선언할 수 있다.

### 메소드
- 변수처럼 부모 클래스에 선언된 메소드들이 자신의 클래스에 선언된 것처럼 사용할 수 있다.
- 부모 클래스에 선언된 메소드와 동일한 시그니처를 사용함으로써 메소드를 overriding 할 수 있다.
- 부모 클래스에 선언되어 있지 않은 이름의 새로운 메소드를 선언할 수 있다.

