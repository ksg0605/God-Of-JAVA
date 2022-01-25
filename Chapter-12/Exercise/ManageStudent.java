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