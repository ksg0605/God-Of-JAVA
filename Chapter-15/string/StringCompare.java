package c.string;

public class StringCompare {

    public static void main(String[] args) {
        StringCompare stringCompare = new StringCompare();
        System.out.println("checkString");
        stringCompare.checkString();
        System.out.println("checkCompare");
        stringCompare.checkCompare();
        System.out.println("checkCompareTo");
        stringCompare.checkCompareTo();
    }

    public void checkString() {
        String text = "You must know String class.";
        System.out.println("text.length() = " + text.length());
        System.out.println("text.isEmpty() = " + text.isEmpty());
    }

    public void checkCompare() {
        String text1 = "Check value";
        String text2 = "Check value";
        if (text1 == text2) {
            System.out.println("text1 == text2 result is same.");
        }
        else {
            System.out.println("text1 == text2 result is different.");
        }
        if (text1.equals("Check value")) {
            System.out.println("text.equals(text2) result is same");
        }
        String text3 = "check value";
        if (text1.equalsIgnoreCase(text3)) {
            System.out.println("text.equalsIgnoreCase(text3) result is same");
        }
    }

    public void checkCompareTo() {
        String text1 = "a";
        String text2 = "b";
        String text3 = "c";
        System.out.println(text2.compareTo(text1));
        System.out.println(text2.compareTo(text3));
        System.out.println(text1.compareTo(text3));
    }
}