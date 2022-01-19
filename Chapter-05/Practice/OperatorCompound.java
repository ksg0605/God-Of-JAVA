public class OperatorCompound {
    public static void main(String[] args) {
        OperatorCompound sample = new OperatorCompound();
        sample.compound();
    }
    public void compound() {
        int intValue = 10;
        System.out.println(intValue += 5);
        System.out.println(intValue -= 5);
        System.out.println(intValue *= 5);
        System.out.println(intValue /= 5);
        System.out.println(intValue %= 5);
    }
}