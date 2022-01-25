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