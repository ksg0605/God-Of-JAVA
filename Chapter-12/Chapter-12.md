#12장 모든 클래스의 부모 클래스는 Object에요
## 모든 자바 클래스의 부모인 java.lang.Object 클래스
- 모든 클래스의 부모 클래스가 있다
```java
package c.inheritance;

public class InheritanceObject {
    public static void main(String[] args) {
        InheritanceObject inheritanceObject = new InheritanceObject();
        System.out.println(inheritanceObject.toString());
    }
}
```
- 아무런 상속을 받지 않으면 java.lang.Object 클래스를 확장한다.
- 자식 클래스는 Object 클래스의 손자뻘

## Object 클래스에서 제공하는 메소드들의 종류는?
- Object 클래스에 선언되어 있는 메소드는 객체를 처리하기 위한 메소드와 쓰레드를 위한 메소드로 나뉜다.
> 쓰레드는 프로그램이 실행되는 작은 단위 중 하나
- 객체 처리를 위한 메소드  


| 메소드 | 설명 |    
|---|---|
| protected Object clone() | 객체의 복사본을 만들어 리턴한다. |
| public boolean equals(Object obj) | 현재 객체와 매개 변수로 넘겨받은 객체가 같은지 확인한다. 같으면 true를, 다르면 false를 리턴한다. |
| protected void finalize() | 현재 객체가 더 이상 쓸모가 없어졌을 때 가비지 컬렉터에 의해서 이 메소드가 호출된다. |
| public Class<?> getClass() | 현재 객체의 Class 클래스의 객체를 리턴한다. | 
| public int hashCode() | 객체에 대한 해시 코드 값을 리턴한다. 해시 코드라는 것은 16진수로 제공되는 객체의 메모리 주소를 말한다 |
| public String toString | 객체를 문자열로 표현하는 값을 리턴한다. |
> 가비지 컬렉터로 객체가 필요 없어졌을 때 처리 해준다

- 쓰레드 처리를 위한 메소드  

| 메소드 | 설명 |   
|---|---|
| public void notify() | 이 객체의 모니터에 대기하고 있는 단일 쓰레드를 꺠운다. |
| public void notifyAll() | 이 객체의 모니터에 대기하고 있는 모든 쓰레드를 꺠운다. |
| public void wait() | 다른 쓰레드가 현재 객체에 대한 notify() 메소드나 notifyAll() 매소드를 호출할 때까지 현재 쓰레드가 대기하고 있도록 한다 |
| public void wait(long timeout) | wait()와 동일한 기능, 매개변수 동안 대기한다. |
| public void wait(long timeout, int nanos) | wait()와 동일한 기능, 매개변수 동안 대기한다. 밀리초 + 나노초 |

## Object 클래스에서 가장 많이 쓰이는 toString() 메소드
- 기본 중의 기본
- 객체를 처리하기 위한 메소드들이 중요
  

- toString()
  - System.out.println() 메소드에 매개 변수로 들어가는 겨웅 자동 호출
  - 객체에 대하여 더하기 연산을 하는 겨웅 자동 호출
  - 객체를 그냥 출력하는 것과 객체의 toString() 메소드를 출력하는 것은 동일하다
  - String을 제외한 참조 자료형에 더하기 연산을 수행하면 자동으로 toString() 메소드가 호출되어 객체의 위치에는 String 값이 놓이게 된다.
  - 실제 Object 클래스에 구현되어 있는 toString() 메소드
    - > getClass().getName() + '@ ' + Intefer.toHexString(hashCode())
  - Overriding 해서도 사용 가능

```java
package c.inheritance;

public class ToString1 {
    
    public static void main(String[] args) {
        ToString1 toString1 = new ToString1();
        toString1.toStringMethod(toString1);
    }
    
    public void toStringMethod(Object object) {
        System.out.println(object);
        System.out.println(object.toString());
        System.out.println("plus " + object);
    }
    
    public void toStringMethod2() {
      System.out.println(this);
      System.out.println(toString());
      System.out.println("plus " + this);
    }
}
```
```java
package c.inheritance;

public class ToString2 {

  public static void main(String[] args) {
    ToString2 toString2 = new ToString2();
    toString2.toStringMethod(toString2);
  }

  public void toStringMethod(Object object) {
    System.out.println(this);
    System.out.println(toString());
    System.out.println("plus " + this);
  }

  public String toString() {
    return "ToString class";
  }


}
```
  
- equals()
- hashCode()
- getClass()
- clone()
- finalize()

## 객체는 == 만으로 같은지 확인이 안 되므로, equals()를 사용하죠
- 값을 비교하는 것이 아닌 주소값을 비교

```java
package c.inheritance;

public class MemberDTO {

  public String name;
  public String phone;
  public String email;

  public MemberDTO(String name) {
    this.name = name;
  }

  public MemberDTO(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  public MemberDTO(String name, String phone, String email) {
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public String toString() {
    return "Name : " + name + "\n" + "Phone : " + phone + "\n" + "eMail : " + email;
  }
}
```

```java
package c.inheritance;

public class Equals {

  public static void main(String[] args) {
    Equals equals = new Equals();
    equals.equalMethod();
    equals.equalMethod2();
  }

  public void equalMethod() {
    MemberDTO obj1 = new MemberDTO("Sangmin");
    MemberDTO obj2 = new MemberDTO("Sangmin");
    if (obj1 == obj2) {
      System.out.println("obj1 and obj2 is same");
    }
    else {
      System.out.println("obj1 and obj2 is different");
    }
  }

  public void equalMethod2() {
    MemberDTO obj1 = new MemberDTO("Sangmin");
    MemberDTO obj2 = new MemberDTO("Sangmin");
    if (obj1.equals(obj2)) {
      System.out.println("obj1 and obj2 is same");
    }
    else {
      System.out.println("obj1 and obj2 is different");
    }
  }
}
```


- 두 객체는 각각의 생성자를 사용하여 만들었기 때문에 주소값이 다르다
- 참조 자료형은 equals() 메소드로 비교해야 한다.
- 비교 대상 객체에도 equals() 메소드를 Overriding 해야 한다.
- 하지 않으면 equals() 메소드에서는 hashCode() 값을 비교한다.

```java
package c.inheritance;

public class MemberDTO {

  public String name;
  public String phone;
  public String email;

  public MemberDTO(String name) {
    this.name = name;
  }

  public MemberDTO(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  public MemberDTO(String name, String phone, String email) {
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public String toString() {
    return "Name : " + name + "\n" + "Phone : " + phone + "\n" + "eMail : " + email;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    MemberDTO other = (MemberDTO) obj;

    if (name == null) {
      if (other.name != null) return false;
    }
    else if (!name.equals(other.name)) return false;

    if (email == null) {
      if (other.email != null) return false;
    }
    else if (!email.equals(other.email)) return false;

    if (phone == null) {
      if (other.phone != null) return false;
    }
    else if (!phone.equals(other.phone)) return false;

    return true;
  }
}

```

__equals() 메소드를 Overriding 할 때에는 반드시 다섯 조건을 만족시켜야 한다.__
- 재귀 : null이 아닌 x라는 객체의 x.equals(x) 결과는 항상 true여야 한다.
- 대칭 : null이 아닌 x와 y 객체가 있을 때 y.equals(x)가 true를 리턴했다면, x.equals(y)도 반드시 true를 리턴해야만 한다.
- 타동적 : null이 아닌 x, y, z가 있을 때 x.equals(y)가 true를 리턴하고, y.equals(z)가 true를 리턴하면, x.equals(z)는 반드시 true를 리턴해야만 한다.
- 일관 : null이 아닌 x와 y가 있을 때 객체가 변경되지 않은 상황에서는 몇 번을 호출하더라도 x.equals(y)의 결과는 항상 true이거나 false여야만 한다.
- null과의 비교 : null이 아닌 x라는 객체의 x.equals(null) 결과는 항상 false여야만 한다.
  

- equals() 메소드를 Overriding 할 때는 hashCode() 메소드도 같이 Overriding 해야만 한다.

```java
package c.inheritance;

public class MemberDTO {

    public String name;
    public String phone;
    public String email;

    public MemberDTO(String name) {
        this.name = name;
    }

    public MemberDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public MemberDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name : " + name + "\n" + "Phone : " + phone + "\n" + "eMail : " + email;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        MemberDTO other = (MemberDTO) obj;

        if (name == null) {
            if (other.name != null) return false;
        }
        else if (!name.equals(other.name)) return false;

        if (email == null) {
            if (other.email != null) return false;
        }
        else if (!email.equals(other.email)) return false;

        if (phone == null) {
            if (other.phone != null) return false;
        }
        else if (!phone.equals(other.phone)) return false;

        return true;
    }

    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }
}
```

## 객체의 고유값을 나타내는 hashCode()
- hashCode() 메소드는 기본적으로 객체의 메모리 주소를 16진수로 리턴
- 어떤 두 개의 객체가 서로 동일하다면, hashCode() 값은 무조건 동일하다.
- equals() 메소드를 Override 하면, hashCode() 메소드도 Ocerride 해서 동일한 결과가 나와야 한다.

__hashCode() 메소드를 Overriding 할 때 따라야 할 조건__
- 자바 애플리케이션이 수행되는 동안에 어떤 객체에 대해서 이 메소드가 호출될 때에는 항상 동일한 int 값을 리턴해 주여야 한다.  
하지만, 자바를 실행할 때마다 같은 값이어야 할 필요는 없다.
- 어떤 두개의 객체에 대하여 equals() 메소드를 사용하여 비교한 결과가 true일 경우에,  
두 객체의 hashCode() 메소드를 호출하면 동일한 int 값을 리턴해야만 한다.
- 두 객체를 equals() 메소드를 사용하여 비교한 결과 false를 리턴했다고 해서,  
hashCode() 메소드를 호출한 int 값이 무조건 달라야 할 필요는 없다.  
하지만, 이 경우에 서로 다른 int 값을 제공하면 hashtable의 성능을 향상시키는 데 도움이 된다.

