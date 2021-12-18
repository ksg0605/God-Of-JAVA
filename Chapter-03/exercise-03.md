# 3장 연습문제
1. 앞 장에서 살펴본 Profile 클래스에 String 타입의 name과 int 타입의 age라는 변수를 선언해 보자.  
   예를 들면 name은 다음과 같이 선언하면 된다. 
```java
public class Profile {
    String name;
    int age;
    public static void main(String[] args) {
    }
}  
```
2. str이라는 이름의 문자열을 받아서 name을 지정하는 public void setName(String str)이라는 메소드를 작성하자. 그리고, 매개 변수로 받은 str 값을 name에 할당하자. 
```java
public void setName(String str) {
    name = str;
        }
```
3. 2와 같은 방법으로 val이라는 이름의 int 값을 받아서 age를 지정하는 public void setAge(int val) 이라는 메소드를 Profile 클래스에 작성하자.

```java
public class Profile {
    String name;
    int age;
    public static void main(String[] args) {
    }

   public void setName(String str) {
      name = str;
   }
    public int setAge(int val) {
        age = val;
    }
}  
```
4. name 값을 출력해주는 public void printName() 메소드를 Profile 클래스에 작성하자
```java
public class Profile {
    String name;
    int age;
    public static void main(String[] args) {
    }

   public void setName(String str) {
      name = str;
   }
   public int setAge(int val) {
      age = val;
   }
    public void printName() {
        System.out.println(name);
    }
}  
```
5. age 값을 출력해주는 public void printAge() 메소드를 Profile 클래스에 작성하자.
```java
public class Profile {
    String name;
    int age;
    public static void main(String[] args) {
    }

   public void setName(String str) {
      name = str;
   }
   public int setAge(int val) {
      age = val;
   }
    public void printName() {
        System.out.println(name);
    }
    public void printAge() {
       System.out.println(age);
    }
}  
```
6. main() 메소드에서 profile이라는 Profile 클래스의 객체를 선언하자.
```java
public class Profile {
    String name;
    int age;
    public static void main(String[] args) {
        profile = new Profile();
    }
    
   public void setName(String str) {
      name = str;
   }
   public int setAge(int val) {
      age = val;
   }
    public void printName() {
        System.out.println(name);
    }
    public void printAge() {
       System.out.println(age);
    }
}  
```
7. profile 객체의 name을 지정하기 위해서 setName() 메소드를 사용하여 "Min" 이라는 값을 넘겨주자.  
   그리고 그 다음 줄에 age를 지정하기 위해서 setAge() 메소드를 사용하여 20이라는 값을 넘겨주자.
```java
public class Profile {
   String name;
   int age;
   public static void main(String[] args) {
       profile = new Profile();
       profile.setName("min");
       profile.setAge(20);
   }
   public void setName(String str) {
       name = str;
   }
   public int setAge(int val) {
       age = val;
   }
   public void printName() {
       System.out.println(name);
   }
   public void printAge() {
       System.out.println(age);
   }
}
```
8. profile 객체의 printName()을 호출하여 이름을 출력하고, printAge()를 호출하여 나이를 출력하자.  
   이 코드를 컴파일하고 출력한 다음에 실행한 결과는 다음과 같이 나와야만 한다. 
> My name is Min   
> My age is 20

```java
public class Profile {
   String name;
   int age;
   public static void main(String[] args) {
      Profile profile = new Profile();
      profile.setName("Min");
      profile.setAge(20);
      System.out.println("My name is " + profile.printName());
      System.out.println("My age is " + profile.printAge());
   }
   public void setName(String str) {
      name = str;
   }
   public void setAge(int val) {
      age = val;
   }
   public String printName() {
      return name;
   }
   public int printAge() {
      return age;
   }
}
```
---
1. 클래스와 객체의 차이점을 말해 주세요.
   - 포르쉐라는 차가 있더라도 개똥이의 포르쉐와 소똥이의 포르쉐는 다르다. 포르쉐는 클래스, 개똥이의 포르쉐는 객체
2. 객체를 생성하기 위해서 꼭 사용해야 하는 예약어는 뭐라고 했죠?
   - 생성자(constructor)
   - Car dogCar = new Car();
3. 객체를 생성하기 위해서 사용하는 메소드 같이 생긴 클래스 이름에 소괄호가 있는 것을 뭐라고 하나요?
   - 생성자
4. 객체의 메소드를 사용하려면 어떤 기호를 객체 이름과 메소드 이름 사이에 넣어주어야 하나요?
   - .
5. 여러분들이 메소드를 사용하기 위해서는 어떤 것을 만들어야 하나요?
   - 메소드를 만들기 위해 객체를 생성해야 한다. 
6. 5번 문제에서 만들어야 하는 것은 어떤 예약어를 사용하고, 클래스에 무엇을 사용해야 하나요?
   - Car dogCar = new Car();