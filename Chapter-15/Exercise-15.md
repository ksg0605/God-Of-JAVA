# 15장 연습문제
1. API 문서에서 String 클래스를 찾아 필요할 때마다 참조할 수 있도록 하자.
2. d.string.practice 패키지에 UseStringMethods 라는 클래스를 만들고, main() 메소드도 만들자
3. public void printWords(String str) 로 선언된 메소드를 만들자. 이 메소드는 str 문장의 단어들을 출려한다. 예제 문장을 str 값으로 전달하여, main() 메소드에서 이 메소드를 호출하여 결과를 확인해 보자
4. public void findString(String str, String findStr) 메소드를 만들자. 이 메소드는 str 중에서 findStr 로 넘겨준 값과 동일한 단어의 첫 번째 위치를 출력한다. 예제 문장을 str 값으로 전달하고 findStr 에는 "string"을 넘겨주자. main() 메소드에서 이 메소드를 호출하여 결과를 확인해보자.
5. public void findAnyCaseString(String str, String findStr) 메소드를 만들자. 이 메소드는 str 중에서 findStr 로 넘겨준 값과 "대소문자 구분 없이" 동일한 단어의 첫 번째 위치를 출력한다. 예제 문장을 str 값으로 전달하고, findStr 에는 "String" 을 넘겨주자. main() 메소드를 호출하여 결과를 확인해 보자
6. public void countChar(String str, char c) 메소드를 만들자. 이 메소드는 str 에서 c 와 동일한 char 의 개수를 출력하낟. 예제 문장을 str 값으로 전달하고, c 는 's' 를 넘겨주자. main() 메소드에서 이 메소드를 호출하여 결과를 확인해 보자.
7. public void printContainWords(String str, String findStr) 메소드를 ㅁ나들자. 이 메소드는 str 문자열에서 findStr 이 포함된 단어를 출력한다. 예제 문장을 str 값으로 전달하고, findStr 는 'ss' 를 넘겨주자. main() 메소드에서 이 메소드를 호출하여 결과를 확인해 보자
```java
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
```
---
1. String 클래스는 final 클래스인가요? 만약 그렇다면, 그 이유는 무엇인가요?  
final 클래스, 더 확장할 수 없도록 하기 위해
2. String 클래스가 구현한 인터페이스에는 어떤 것들이 있나요?  
Serializable, Comparable<String>, CharSequence
3. String 클래스의 생성자 중에서 가장 의미없는 생성자는 무엇인가요?  
String()
4. String 문자열을 byte 배열로 만드는 메소드의 이름은 무엇인가요?  
getBytes()
5. String 문자열의 메소드를 호출하기 전에 반드시 점검해야 하는 사항은 무엇인가요?  
객체가 null 값인지
6. String 문자열의 길이를 알아내는 메소드는 무엇인가요?  
length()
7. String 클래스의 equals() 메소드와 compareTo() 메소드의 공통점과 차이점은 무엇인가요?  
객체가 같은지를 비교하는 것, 결과값이 true / false 로 리턴되는가, 음수 양수로 리턴되는가
8. 문자열이 "서울시"로 시작하는지를 확인하여면 "String"의 어떤 메소드를 사용해야 하나요?  
startsWith()
9. 문자열에 "한국"이라는 단어의 위치를 찾아내려고 할 떄에는 String의 어떤 메소드를 사용해야 하나요?  
contains()
10. 9번 문제의 답에서 "한국"이 문자열에 없을 떄 결과 값은 무엇인가요?  
-1
11. 문자열의 1번째부터 10번째 위치까지의 내용을 String으로 추철하려고 합니다. 어떤 메소드를 사용해야 하나요?  
split()
12. 문자열의 모든 공백을 * 표시로 변환하려고 합니다. 어떤 메소드를 사용하는 것이 좋을까요?  
replace()
13. String 의 단점을 보완하기 위한 두 개의 클래스는 무엇인가요?  
StringBuffer, StringBuilder
14. 13번의 답에서 문자열을 더하기 위한 메소드의 이름은 무엇인가요?  
StringBuilder