# 4장 연습문제
1. ProfilePrint라는 클래스를 만들고, byte 타입의 나이를 나타내는 age와 String 타입의 이름을 나타내는 name이라는 "인스턴스 변수"를 선언하자.
```java
class ProfilePrint {
    byte age;
    String name;
} 
```
2. ProfilePrint 클래스에 그 사람이 결혼했는지 여부를 boolean 타입의 "인스턴스 변수"로 선언하고, 그 이름은 isMarried로 지정하자.
```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;
} 
```
3. byte 타입의 매개 변수를 받아 인스턴스 변수의 나이를 지정하는 public void setAge(byte age) 메소드를 만들자.

```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }
} 
```
4. 나이를 리턴하는 getAge()라는 이름의 메소드를 만들자.

```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }
} 
```
5. String 타입의 매개 변수를 받아 인스턴스 변수인 name을 지정하는 public void setName(String name) 메소드를 만들자.

```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
} 
```
6. 이름을 리턴하는 getName()이라는 메소드를 만들자.

```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
} 
```
7. 결혼 여부를 지정하는 public void setMarried(boolean flag) 메소드를 만들자.

```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarried(boolean flag) {
        isMarried = flag;
    }
} 
```
8. 결혼 여부를 리턴하는 public boolean isMarried() 메소드를 만들자.

```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarried(boolean flag) {
        isMarried = flag;
    }

    public boolean isMarried() {
        return isMarried;
    }
} 
```
9. ProfilePrint 클래스를 실행할 수 있도록 ProfilePrint 클래스에 public static void main(String args[]) 메소드를 만들자.
```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarried(boolean flag) {
        isMarried = flag;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public static void main(String[] args) {
    }
} 
```
10. main() 메소드에서 ProfilePrint 클래스의 객체를 생성한 후 그 객체의 3, 5, 7 에서 생성한 메소드를 호출하도록 만들자. 메소드를 호출할 떄에는 본인의 나이, 이름, 결혼 여부를 매개 변수로 넘겨주자.
```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarried(boolean flag) {
        isMarried = flag;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public static void main(String[] args) {
        ProfilePrint profilePrint = new ProfilePrint();
        myAge = profilePrint.setAge(27);
        myName = profilePrint.setName("김선규");
        myIsMarried = profilePrint.isMarried(false);
    }
} 
```
11. 4, 6, 8 에서 생성한 메소드를 호출하여 그 결과를 출력하자.
```java
class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarried(boolean flag) {
        isMarried = flag;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public static void main(String[] args) {
        ProfilePrint profilePrint = new ProfilePrint();
        myAge = profilePrint.setAge(27);
        myName = profilePrint.setName("김선규");
        myIsMarried = profilePrint.isMarried(false);
        System.out.println(profilePrint.getAge());
        System.out.println(profilePrint.getName());
        System.out.println(profilePrint.isMarried());
    }
} 
```
---
1. 네가지 종류의 변수는 어떻게 구분할 수 있나요?  
지역 변수, 매개 변수, 인스턴스 변수, 클래스 변수
2. 변수의 이름을 지을 때 대문자로 시작해도 되나요?  
가능하지만 소문자로 시작하는 것이 좋다.
3. 자료형에는 기본 자료형과 어떤 자료형이 있나요?  
참조 자료형
4. 기본 자료형 중 정수형에는 어떤 것들이 있나요?  
byte, short, int, long 
5. byte는 몇 비트(bit)로 되어 있나요?  
8비트로 구성되어 있다. 
6. byte는 왜 만들었을까요?  
적은 공간에 많은 내용을 저장하기 위해서
7. int와 long 중 어떤 타입이 더 큰 숫자를 처리할 수 있나요?  
long
8. 소수점을 처리하는 타입은 어떤 것이 있나요?  
float, double  
9. char은 정수형인가요?  
정수형이다.
10. a라는 것을 char로 정의할 때 어떤 기호로 감싸주어야 하나요?  
char
11. true와 false 두개의 값만을 가지는 타입은 어떤 것인가요?  
boolean