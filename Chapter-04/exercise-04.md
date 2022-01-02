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