package c.exception;

public class ExceptionSample {

    public static void main(String[] args) {
        ExceptionSample exceptionSample = new ExceptionSample();
        exceptionSample.arrayoutOfBoundsTryCatch();
    }

    public void arrayoutOfBounds() {
        int [] intArray = new int[5];
        System.out.println(intArray[5]);
    }

    public void arrayoutOfBoundsTryCatch() {
        int [] intArray = new int[5];
        try {
            System.out.println(intArray[5]);
            System.out.println("This code should run.");
        } catch (Exception e) {
            System.err.println("Exception occured.");
        }
        System.out.println("This code must run.");
    }
}