package c.api;

public class APICheck {
    public static void main(String[] args) {
        APICheck apiCheck = new APICheck();
        apiCheck.useDeprecated();
    }

    public void useDeprecated() {
        String str = "abcde";
        byte [] strBytes = str.getBytes();
        String convertedStr = new String(strBytes, 0);
    }
}