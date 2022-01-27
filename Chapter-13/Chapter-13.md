# 13장 인터페이스와 추상클래스, enum

## 메소드 내용이 럾는 interface
- .class 파일을 만들 수 있는 것에는 클래스만 있는 것이 아님
- interface 와 abstract 클래스도 가능
  
### 방법론의 일반적인 절차
- 분석
- 설계
- 개발 및 테스트
- 시스템 릴리즈

### 분석
- 요구사할 분석

### 설계
- 어떤 메소드를 만들 것인지
- 데이터를 어떻게 저장할지 등등

### 개발 및 테스트
- 실제 시스템에서 재공해야 하는 기능 개발
- 필요한 기능들이 제대로 동작하는지 확인하는 테스트 작업 수행

### 시스템 릴리즈
- 시스템을 사용자들에게 제공하는 단계
- 유지 / 보수


   

> 설계 단계에서 인터페이스를 만들어 두면 개발할 때 메소드의 이름을 어떻게 할지, 매개 변수를 어떻게 할지를 일일이 고민하지 않아도 된다. 


### 인터페이스와 abstract 클래스를 사용하는 이유
- 설계시 선언해 두면 개발할 때 기능을 구현하는 데에만 집중할 수 있다
- 개발자의 역량에 따른 메소드의 이름과 매개 변수 선언의 격차를 줄일 수 있다.
- 공통적인 인터페이스와 abstract 클래스를 선언해 놓으면, 선언과 구현을 구분할 수 있다.

## 인터페이스를 직접 만들어 보자
- 실제 코드는 만들지 않더라도 어떤 메소드들이 있어야 하는지를 정의하려고 할 때 인터페이스 사용
- interface 내부에 선언된 메소드들은 몸통이 있으면 안 된다.
- 메소드 선언 이후에 중괄호를 열고 닫거나 중괄호 안에 한 줄의 코드도 있으면 안 된다.

```java
package c.service;

import c.model.MemberDTO;

public interface MemberManager {
    public boolean addMember(MemberDTO member);
    public boolean removeMember(String name, String phone);
    public boolean updateMember(MemberDTO member);
}
```
```java
package c.service;

import c.model.MemberDTO;

public class MemberManagerImpl implements MemberManager {

    @Override
    public boolean addMember(MemberDTO member) {
        return false;
    }

    @Override
    public boolean removeMember(MemberDTO member) {
        return false;
    }

    @Override
    public boolean updateMember(MemberDTO member) {
        return false;
    }

}
```

- 인터페이스를 구현할 경우에는 반드시 인터페이스에 정의된 메소드들을 구현해야만 한다
- 인터페이스에 정의된 메소드들을 모두 구현해야만 컴피일이 정상적으로 수행된다.
- 설계 단계에서 인터페이스를 만들고, 개발 단계에서 메소드 작성
- 또다른 용도로 외부에 노출되는 것을 정의해 놓고자 할 떄 사용

```java
package c;

import c.service.*;

public class InterfaceExample {
    public static void main(String[] args) {
        MemberManager memberManager = new MemberManagerImpl();
    }
}
```

- 겉으로 보기에 member의 타입은 MemberManager이다. 
- 그리고 MemberManagerImpl 클래스에는 인터페이스에 선언되어 있는 모든 메소드들이 구현되어 있다.
- 실제 member의 타입은 MemberManager가 되기 떄문에 
- member에 선언된 메소드들을 실행하면 MemberManagerImpl에 있는 메소드들이 실행

## 일부 완성되어 있는 abstract 클래스
- 추상 클래스
- abstract 클래스는 자바에서 마음대로 초기화하고 실행할 수 없도록 되어 있다.
- abstract 클래스를 구현해 놓은 클래스로 초기화 및 실행이 가능하다.
```java
package c.service;

import c.model.MemberDTO;

public abstract class MemberManagerAbstract {

    public abstract boolean addMember(MemberDTO member);

    public abstract boolean removeMember(String name, String phone);

    public abstract boolean updateMember(MemberDTO member);

    public void printLog(String data) {
        System.out.println("Data=" + data);''
    }
}
```

- abstract 클래스는 abstract로 선언한 메소드가 하나라도 있을 때 선언
- 인터페이스와 달리 구현되어 있는 메소드가 있어도 상관 없다
  

- abstract 클래스는 클래스 선언시 abstract라는 예약어가 클래스 앞에 추가되면 된다
- abstract 클래스 안에는 abstract로 선언된 메소드가 0개 이상 있으면 된다.
- abstract로 선언된 메소드가 하나라도 있으면, 그 클래스는 반드시 abstract로 선언되어야만 한다
- abstract 클래스는 몸통이 있는 메소드가 0개 이상 있어도 전혀 상관 없으며  static이나 final 메소드가 있어도 된다.
- 인터페이스는 안 된다.
- abstract 클래스는 인터페이스처럼 implements 를 사용하여 구현할 수 없다. 클래스이기 때문


```java
package c.service;

import c.model.MemberDTO;

public class MemberManagerImpl2 extends MemberManagerAbstract {

    public boolean addMember(MemberDTO menber) {
        return false;
    }

    public boolean removeMember(String name, String phone) {
        return false;
    }

    public boolean updateMember(MemberDTO member) {
        return false;
    }
}
```

- 인터페이스를 선언하다 보니, 어떤 메소드는 미리 만들어놓아도 문제가 발생하지 않는다
- 클래스를 만들기는 좀 애매하고
- 아주 공통적인 기능을 미리 구현해 놓으면 많은 도움이 된다.
  

| | 인터페이스 | abstract 클래스 | 클래스 |  
|---|----|----|----|
| 선언 시 사용하는 예약어 | interface | abstract class | class |
| 구현 안 된 메소드 포함 가능 여부 | 가능 (필수) | 가능 | 불가 |
| 구현된 메소드 포함 가능 여부 | 불가 | 가능 | 가능 (필수) |
| static 메소드 선언 가능 여부 | 불가 | 가능 | 가능 |
| final 메소드 선언 가능 여부 | 불가 | 가능 | 가능 |
| 상속 (extends) 가능 | 불가 | 가능 | 가능 |
| 구현 (implements) 가능 | 가능 | 불가 | 불가 |

- 언제 인터페이스를 사용해야 할지, abstract를 사용해야 할지를 구분해야 하는 것이 중요

## 나는 내 자식들에게 하나도 안 물려 줄꺼여

### 클래스에 final을 선언할 때에는
- final은 클래스, 메소드, 변수에 선언할 수 있다.
- 클래스 선언시 final을 접근 제어자와 class 예약어 사이에 추가할 수 있다.

```java
package c.util;

public final class FinalClass {
    
}
```
- 클래스가 final 로 선언되어 있으면 상속을 해 줄 수 없다.
- 더이상 확장해서는 안 되는 클래스, 누군가 이 클래스를 상속 받아서 내용을 변경해서는 안 되는 클래스를 선언할 때 final응 사용

### 메소드를 final로 선언하는 이유는
- 메소드를 final로 선언하면 더이상 Overriding 할 수 없다.

### 변수에서 final을 쓰는 것은 메소드나 클래스에서 쓰는 것과 비교하면 많이 다르다
- 더 이상 바꿀 수 없다
- 인스턴스 변수나 static으로 선언된 클래스 변수는 선언과 함께 값을 지정해야만 한다.
- 변수 생성과 동시에 초기화해야 한다.
  - 객체를 final로 선언한다면
  - 객체는 두 번 이상 생성할 수 없다
  - 하지만 객체 안에 선언되어 있는 변수들은 final이 아님

## enum 클래스라는 상수의 집합도 있다.
- final로 고정
- class 대신 enum으로 선언하면 상수들의 집합
```java
package c.enums;

public enum OverTimeValues {
  THREE_HOUR,
  FIVE_HOUR,
  WEEKEND_FOUR_HOUR,
  WEEKEND_EIGHT_HOUR;
}

```

```java
package c.enums;

public class OverTimeManager {

  public static void main(String[] args) {
    OverTimeManager overTimeManager = new OverTimeManager();
    int myAmount = overTimeManager.getOverTimeAmount(OverTimeValues.THREE_HOUR);
    System.out.println(myAmount);
  }
    
  public int getOverTimeAmount(OverTimeValues value) {
      int amount = 0;
      System.out.println(value);
      switch (value) {
          case THREE_HOUR:
              amount = 18000;
              break;

          case FIVE_HOUR:
              amout = 30000;
              break;

          case WEEKEND_FOUR_HOUR:
              amout = 40000;
              break;

          case WEEKEND_EIGHT_HOUR:
              amount = 60000;
              break;
      }
      return amount;
  }
}
```

## enum을 보다 제대로 사용하기
- 클래스 선언시 상수 값을 지정하는 것은 가능
- 동적 할당은 불가
```java
package c.enums;

public enum OverTimeValues2 {

    THREE_HOUR(18000),
    FIVE_HOUR(30000),
    WEEKEND_FOUR_HOUR(40000),
    WEEKEND_EIGHT_HOUR(60000),

    private final int amount;

    OverTimeValues2(int amount) {
        this.amount = amount;
    }

    pubic int getAmount() {
        return amount;
    }
}
```
- 상수 아래에 amount 라는 변수가 final 로 선언되어 있다.
- 이 변수는 다음 줄에 있는 OverTimeValues2 의 생성자에서 매개 변수로 넘겨받은 값을 할당할 때 사용된다.
- enum 클래스의 생성자는 아무것도 명시하지 않는 package-private와 private만 접근 제어자로 사용할 수 있다.
- getAmount() 메소드는 enum 클래스의 변수로 선언한 amount 값을 리턴하기 위해서 만듦
- enum 클래스에도 보통 클래스와 마찬가지로 메소드를 선언해서 사용 가능

```java
package c.enums;

public class OverTimeManager2 {
  public static void main(String[] args) {
    OverTimeValues2 value2 = OverTimeValues2.FIVE_HOUR;
    System.out.println(value2);
    System.out.println(value2.getAmount());
  }
}
```

## enum 클래스의 부모는 무조건 java.lang.Enum 이어야 해요
- Enum 클래스의 생성자  

| 접근 제어자 | 메소드 | 설명 |
|----|----|---|
| protected | Enum(String name, int ordinal) | 컴파일러에서 자동으로 호출되도록 해놓은 생성자다. 하지만 개발자가 이 생성자를 호출할 수 는 없다 |

- Enum 클래스의 부모 클래스는 Object 클래스이기 때문에 Object 클래스의 메소드들은 모두 사용할 수 있다.
- 하지만 Enum 클래스는 개발자들이 Object 클래스 중 4개의 메소드를 Overriding 하지 못하도록 막아놓았다.  

| 메소드 | 내용 | 
|------|-----|
| clone() | 객체를 복제하기 위한 메소드다. 하지만, 이 메소드는 enum 클래스에서 사용하면 안 된다. 만약 호출될 경우엔 CloneNotSupportedException 이라는 예외를 발생시키도록 되어 있다. |
| finalize() | GC가 발생할 때 처리하기 위한 메소드다 |
| hashCode() | int 타입의 해시 코드 값을 리턴하는 메소드다. |
| equals() | 두 개의 객체가 동일한지를 확인하는 메소드다. |

- hashCode() 와 equals() 메소드는 사용해도 무방
- clone() 과 finalize() 메소드는 사용하면 안 된다.  

- Enum 클래스에서 선언되어 있는 메소드  

| 메소드 | 내용 |
|------|-----|
| compareTo(E e) | 매개 변수로 enum 타입과의 순서 (ordinal) 차이를 리턴한다. |
| getDeclaringClass() | 클래스 타입의 enum을 리턴한다. |
| name() | 상수의 이름을 리턴한다. |
| ordinal() | 상수의 순서를 리턴한다. |
| valueOf(Class<T> enumType, String name) | static 메소드다. 첫 번째 매개 변수로는 클래스 타입의 enum을, 두 번째 매개 변수로는 상수의 이름을 넘겨주면 된다. |

- compareTo() 메소드를 많이 사용

```java
package c.enums;

public class OverTimeManager2 {
    public static void main(String[] args) {
        OverTimeValues2 value2 = OverTimeValues2.FIVE_HOUR;
        System.out.println(value2);
        System.out.println(value2.getAmount());
        
        OverTimeValues2 value3 = OverTimeValue2.THREE_HOUR;
        System.out.println(value2.compareTo(value3));
    }
}
```
```java
package c.enums;

public class OverTimeManager3 {
    public static void main(String[] args) {
        OverTimeValues2 []valuesList = OverTimeValues2.values();
        for(OverTimeValues2 value : valuesList) {
            System.out.println(value);
        }
    }
}
```