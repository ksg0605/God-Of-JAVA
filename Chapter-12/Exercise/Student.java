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