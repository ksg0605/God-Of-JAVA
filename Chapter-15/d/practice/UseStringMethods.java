package d.practice;

public class UseStringMethods {

    public static void main(String[] args) {
        String stringAPI = "The String class represents character strings.";
        UseStringMethods useStringMethods = new UseStringMethods();
        useStringMethods.printWords(stringAPI);
        useStringMethods.findString(stringAPI, "string");
        useStringMethods.findAnyCaseString(stringAPI, "string");
        useStringMethods.countChar(stringAPI, 's');
        useStringMethods.printContainWords(stringAPI, "ss");
    }
    public void printWords(String str) {
        String[] splitedStr = str.split(" ");

        System.out.println("-----printWords()-----");
        for (String data: splitedStr) {
            System.out.println(data);
        }
    }
    public void findString(String str, String findStr) {
        int number = str.indexOf(findStr);

        System.out.println("-----findString()-----");
        System.out.println(findStr + " is appeared at " + number);
    }
    public void findAnyCaseString(String str, String findStr) {
        String value = str.toLowerCase();
        int number = value.indexOf(findStr);

        System.out.println("-----findAnyCaseString()-----");
        System.out.println(findStr + " is appeared at " + number);
    }
    public void countChar(String str, char c) {
        char[] charArray = str.toCharArray();
        int count = 0;

        for ( char data : charArray) {
            if (data == c) {
                count++;
            }
        }
        System.out.println("-----countChar()-----");
        System.out.println("char '" + c + "' count is " + count);
    }
    public void printContainWords(String str, String findStr) {
        String[] splitedStr = str.split(" ");

        System.out.println("-----printContainWords()-----");
        for (String data : splitedStr) {
            if (data.contains(findStr)) {
                System.out.println(data + " contains " + findStr);
            }
        }
    }
}