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