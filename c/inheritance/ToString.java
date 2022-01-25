package c.inheritance;

public class ToString {
    public static void main(String[] args) {
        ToString toString = new ToString();
        toString.toStringMethod(toString);
    }
    public void toStringMethod(Object object) {
        System.out.println(object);
        System.out.println(object.toString());
        System.out.println("plus " + object);
    }
}