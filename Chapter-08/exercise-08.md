# 8장 연습문제
1. Student 라는 클래스를 만들고, name, address, phone, email 이라는 인스턴스 변수를 String 타입으로 선언하자
2. 학생의 정보에 이름은 반드시 입력되어야 하므로, name을 받아서 인스턴스 변수에 할당해 주는 Student 클래스의 생성자를 만들자.
3. 모든 학생의 정보를 생성하면서 할당하는 name, address, phone, email을 매개 변수로 받아 인스턴스 변수에 할당하는 Student 클래스의 생성자를 만들자.
4. 다음과 같이 학생의 정보들을 String으로 리턴하는 toString() 이라는 메소드를 만들자.
```java
public String toString() {
    return name + " " + address + " " + phone + " " + email;
        }
```

```java
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

    public String toString(){
        return name + " " + address + " " + phone + " " + email;
    }
}
```

5. 학생 정보를 담아두는 Student 클래스는 다 작성했으니, 학생들을 관리하는 ManageStudent라는 클래스를 만들자
6. ManageStudent 클래스에 main() 메소드를 만들자
7. 다음과 같이 배열을 매개 변수로 받아 학생의 정보를 담은 후 리턴하는 메소드를 만들자.
```java
public Student[] addStudent() {
    Student[] student = new Student[3];
    student[0] = new Student("Lim");
    student[1] = new Student("Min");
    student[2] = new Student("Sook", "Seoul", "01011112222", "ask@godofjava.com");
    return student;
        }
```   
8. main() 메소드에서 student라는 이름을 갖는 Student 배열을 만들고, 별도의 초기화는 하지 말고, null로 할당하자.
9. main() 메소드에서 addStudent() 메소드를 호출하고, 그 결과를 student 객체로 받자.
10. student 객체의 내용을 출력할 printStudent()라는 메소드를 만들고, 매개 변수로는 student 객체를 받을 수 있도록 하자.
11. printStudents() 메소드에서 for 문을 사용하여 student 배열의 각각의 내용을 출력하자.
12. main() 메소드에서 printStudents() 메소드를 호출하자.
13. ManageStudent 클래스를 컴파일한 후 실행해보자. 결과는 다음과 같이 출력되어야 한다.
```shell
Lim null null null
Min null null null
Sook Seoul 01011112222 ask@godofjava.com
```

```java
public class ManageStudent {
    public static void main(String[] args) {
        Student student[] = null;
        ManageStudent manageStudent = new ManageStudent();
        student = manageStudent.addStudent();
        manageStudent.printStudent(student);
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
}
```


--- 
1. 생성자는 반드시 만들어야 하나요?  
아니요. 매개변수가 없으면 자동 생성
2. 만양 매개 변수가 있는 생성자를 만들고, 매개 변수가 없는 기본 생성자를 호출항면 어떻게 될까요?  
컴파일 오류 발생
3. 생성자의 개수는 제한이 있나요?
없어요
4. 인스턴스의 변수와 매개 변수나 메소드 내에서 생성한 변수와 구분하기 위해서 사용하는 키워드는 무엇인가요?  
this
5. 메소드 선언시 리턴 타입으로 지정한 데이터를 넘겨줄 때 필요한 키워드는 무엇인가요?  
자료형(int, String ..)
6. 메소드 선언시 아무 데이터도 리턴 타입으로 넘겨주지 않겠다는 것을 지정하는 키워드는 무엇인가요?  
void
7. 메소드 선언에 static이 있는 것과 없는 것의 차이는 무엇인가요?  
객체를 생성하지 않아도 메소드를 호출할 수 있다.
8. 필자가 엄청나게 중요하다고 한 것 중 메소드의 이름은 같으나 매개 변수를 다르게 하는 것의 명칭은 무엇인가요?  
오버로딩
9. 기본 자료형을 매개 변수로 넘겨 줄 때 Pass by value 인가요?? 아니면 Pass by reference 인가요?  
Pass by Value
10. 참조 자료형을 매개 변수로 넘겨 줄 때 Pass by value 인가요?? 아니면 Pass by reference 인가요?  
Pass by reference
11. 매개 변수의 수가 가변적일 때 메소드 선언시 타입과 변수 이름 사이에 어떤 것을 적어줘야 하나요?  
...