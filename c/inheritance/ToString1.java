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