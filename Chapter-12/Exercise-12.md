# 12장 연습문제
1. name, address, phone, email 변수가 선언되어 있는 것을 확인하자
2. Student 클래스의 내용, 즉 name, address, phone, email 값이 같으면 같은 클래스로 인식이 되도록 equals() 메소드를 직접 작성해보자
3. ManageStudent 클래스에 매개 변수 및 리턴값이 없는 checkEquals() 라는 메소드를 만들자
4. checkEquals() 메소드에 다음과 같이 값이 동일한 두 개의 Student 객체를 생성하자  
> Student a = new Student("Min", "Seoul", "01011112222", "ask@godofjava.com");  
> Student b = new Student("Min", "Seoul", "01011112222", "ask@godofjava.com");
5. a와 b 객체가 같으면 "Equal"을, 다르면 "Not Equal"을 출력하는 문장을 checkEquals() 메소드에 추가하자
6. ManageStudent 클래스의 main() 메소드에서 나머지 메소드 호출은 주석 처리하고, checkEquals() 메소드를 호출하도록 하자.
7. ManageStudent 클래스를 컴파일하고, 실행 결과가 "Equal" 로 출력되는지 확인하자.
```java
package c.inheritance;

public class Student {
    String name;
    String address;
    String phone;
    String email;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String address, String phone, String email) {
        this.name = name;
        this.address= address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString(){
        return name + " " + address + " " + phone + " " + email;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null) return false;
        }
        else if (!name.equals(other.name)) return false;

        if (address == null) {
            if (other.address != null) return false;
        }
        else if (!address.equals(other.address)) return false;

        if (phone == null) {
            if (other.phone != null) return false;
        }
        else if (!phone.equals(other.phone)) return false;

        if (email == null) {
            if (other.email != null) return false;
        }
        else if (!email.equals(other.email)) return false;

        return true;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

//    IntelliJ 자동 생성 메소드
//    @Override
//    public boolean equals(Object object) {
//        if (this == object) return true;
//        if (object == null || getClass() != object.getClass()) return false;
//        if (!super.equals(object)) return false;
//        Student student = (Student) object;
//        return java.util.Objects.equals(name, student.name) && java.util.Objects.equals(address, student.address) && java.util.Objects.equals(phone, student.phone) && java.util.Objects.equals(email, student.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return java.util.Objects.hash(super.hashCode(), name, address, phone, email);
//    }
}
```

```java
package c.inheritance;

public class ManageStudent {
    public static void main(String[] args) {
        Student student[] = null;
        ManageStudent manageStudent = new ManageStudent();
//        student = manageStudent.addStudent();
//        manageStudent.printStudent(student);
        manageStudent.checkEquals();
    }

    public Student[] addStudent() {
        Student[] student = new Student[3];
        student[0] = new Student("Lim");
        student[1] = new Student("Min");
        student[2] = new Student("Sook", "Seoul", "01011112222", "ask@godofjava.com");
        return student;
    }

    public void printStudent(Student[] student) {
        for(Student data : student) {
            System.out.println(data);
        }
    }

    public void checkEquals() {
        Student a = new Student("Min", "Seoul", "01011112222", "ask@godofjava.com");
        Student b = new Student("Min", "Seoul", "01011112222", "ask@godofjava.com");

        if (a.equals(b)) {
            System.out.println("Equal");
        }
        else
            System.out.println("Not Equal");
    }

}
```
---
1. 모든 클래스의 최상위 부모 클래스인 Object 클래스는 어떤 패키지에 선언되어 있나요?  
java.lang
2. 클래스가 어떻게 선언되어 있는지 확인할 수 있는 명령어의 이름은 무엇인가요?  
javap
3. Object 클래스에 선언되어 있는 모든 메소드는 여러분들이 Overriding 해야 하나요?  
하지 않아도 됨
4. Object 클래스의 clone() 메소드의 용도는 무엇인가요?  
객체의 복사본을 만들어 리턴
5. System.out.println() 메소드를 사용하여 클래스를 출력했을 때 호출되는 Object 클래스에 있는 메소드는 무엇인가요?  
toString() 메소드
6. 객체의 주소를 비교하는 것이 아닌, 값을 비교하려면 Object 클래스에 선언되어 있는 어떤 메소드를 Overriding 해야 하나요?  
equals()
7. Object 클래스에 선언되어 있는 hashCode()라는 메소드는 어떤 타입의 값을 리턴하나요?  
int
