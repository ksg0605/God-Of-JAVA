# 15장 String
## 자바에서 가장 많이 사용하는 String 클래스
- String 클래스가 어떻게 선언되어 있는가
```java
public final class String extends Object
    implements Serializable, Comparable<String>, CharSequence
```
- public final 로 선언
- 오버라이드 불가
- 자식 클래스 양산 불가
- Serializable, Comparable<String>, CharSequence 인터페이스 구현

## String의 생성자에는 이런 것들이 있다.
- String의 생성자는 매우 많다
- 캐릭터 셋은 문자의 집합을 의미한다
- 특정 나라의 글자를 말함
- 디코딩은 일반적으로 암호화되어 있거나 컴퓨터가 이해할 수 있는 값들을 알아보기 쉽게 변환하는 것을 말한다.  

| 생성자 | 설명 |
|------|-----|
| String() | 비어있는 String 객체를 생성한다. 그런데 이렇게 생성하는 것은 전혀 의미가 없다. 차라리 다음과 같이 선언하는 것이 더 효율적이다. String name = null; |
| String(byte[] bytes) | 현재 사용중인 플랫폼의 캐릭터 셋을 사용하여 제공된 byte 배열을 디코딩한 String 객체를 생성한다. |
| String(byte[] bytes, Charset charset) | 지정한 이름을 갖는 캐릭터 셋을 사용하여 지정한 byte 배열을 디코딩한 String 객체를 생성한다. |
| String(byte[] bytes, String charsetName) | 현재 사용중인 플랫폼의 기본 캐릭터 셋을 사용하여 지정한 byte 배열의 일부를 디코딩한 String 객체를 생성한다. |
| String(byte[] bytes, int offset, int length) | 지정된 캐릭터 셋을 사용하여 byte 배열의 일부를 디코딩한 String 객체를 생성한다. |
| String(byte[] bytes, int offset, int length, Charset charset) | 지정한 이름을 갖는 캐릭터 셋을 사용하여 byte 배열의 일부를 디코딩한 String 객체를 생성한다. |
| String(byte[] bytes, int offset, int length, String charsetName) | char 배열의 내용들을 붙여 String 객체를 생성한다. |
| String(char[] value) | char 배열의 내용들을 붙어 String 객체를 생성한다. |
| String(char[] value, int offset, int count) | char 배열의 일부 내용들을 붙여 String 객체를 생성한다. |
| String(int[] codePoints, int offset, int count) | 유니코드 코드 위치(Unicode code point) 로 구성되어 있는 배열의 일부를 새로운 String 객체를 생성한다. |
| String(String original) | 매개 변수로 넘어온 String과 동일한 값을 갖는 String 객체를 생성한다. 복제본을 생성한다. |
| String(StringBuffer buffer) | 매개 변수로 넘어온 StringBuffer 클래스에 정의되어 있는 문자열의 값과 동일한 String 객체를 생성한다. |
| String(StringBuilder builder) | 매개 변수로 넘어온 StringBuilder 클래스에 정의되어 있는 문자열의 값과 도일한 String 객체를 생성한다. |

## String 문자열을 byte로 변환하기
- 메소드들 활용  


| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
|---------|---------|------|
| byte[] | getBytes() | 기본 캐릭터 셋의 바이트 배열을 생성한다 |
| byte[] | getBytes(Charset charset) | 지정한 캐릭터 셋 객체 타입으로 바이트 배열을 생성한다. |
| byte[] | getBytes(String charsetName) | 지정한 이름의 캐릭터 셋을 갖는 바이트 배열을 생성한다. |

- 보통 같은 프로그램에서 문자열을 byte 배열로 만들 때에는 가장 위에 있는 getBytes() 메소드를 사용하면 도니다.
- 다른 시스템에서 전달받은 문자열을 byte 배열로 변환할 때에는 두번쨰나 세번째 에 있는 메소드를 ㅏ숑ㅇ한다
- 한글이 꺠지는 이유는 브라우저에서 생각하는 캐릭터 셋과 웹 페이지에 지정된 캐릭터 셋이 다르기 때문이다.
- java.nio.Charset 클래스 API 에는 표준 캐릭터 셋이 정해져 있다.
- 한글을 처리하기 위해서 자바에서 많이 사용하는 캐릭터 셋은 UTF-16
```java
package c.string;

public class StringSample {

    public static void main(String[] args) {
        StringSample stringSample = new StringSample();
        stringSample.convert();
    }

    public void convert() {
        try {
            String korean = "한글";

            byte[] array1 = korean.getBytes();
            for (byte data : array1) {
                System.out.println(data + " ");
            }
            System.out.println();
            String korean2 = new String(array1);
            System.out.println(korean2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
```

```java
package c.string;

public class StringSample {

    public static void main(String[] args) {
        StringSample stringSample = new StringSample();
//        stringSample.convert();
        stringSample.convertUTF16();
    }

    public void convert() {
        try {
            String korean = "한글";

            byte[] array1 = korean.getBytes();
            for (byte data : array1) {
                System.out.println(data + " ");
            }
            System.out.println();
            String korean2 = new String(array1);
            System.out.println(korean2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printByteArray(byte[] array) {
        for (byte data : array) {
            System.out.println(data + " ");
        }
        System.out.println();
    }

    public void convertUTF16() {
        try {
            String korean = "한글";
            byte[] array1 = korean.getBytes("UTF-16");
            printByteArray(array1);
            String korean2 = new String(array1, "UTF-16");
            System.out.println(korean2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

왜 try-catch 블록을 사용하여 감싸 놓았을까?  
캐릭터 셋을 지정하는 메소드 및 생성자들 떄문

- byte 배열과 String 타입의 캐릭터 셋을 받는 생성자
- getBytes() 메소드 중에서 String 타입의 캐릭터 셋을 받는 메소드

위의 생성자와 메소드는 UnsupportedEncodingException을 발생시킬 수 있다.  
돈재하지 않는 캐릭터 셋의 이름을 지정할 경우에는 이 예외가 발생하게 되므로 반드시 try-catch 로 감싸주거나 메소드 선언시 throws 구문으로 던져 주어야 한다.  

## 객체의 널 체크는 반드시 필요하답니다.
- 모든 객체를 처리할 때에는 널 체크를 반드시 해야만 한다.
- 어떤 참조 자료형도 널이 될 수 있다.
- 널 체크를 하지 않으면 객체에 사용할 수 있는 메소드들은 모두 예외를 발생시킴

```java
package c.string;

public class StringNull {

    public static void main(String[] args) {
        StringNull stringNull = new StringNull();
        stringNull.nullCheck(null);
    }

    public boolean nullCheck(String text) {
        int textLength = text.length;
        System.out.println(textLength);
        if (text == null) {
            return true;
        }
        else
            return false;
    }
}
```

```java
package c.string;

public class StringNull {

    public static void main(String[] args) {
        StringNull stringNull = new StringNull();
//        stringNull.nullCheck(null);
        stringNull.nullCheck2(null);
    }

    public boolean nullCheck(String text) {
        int textLength = text.length();
        System.out.println(textLength);
        if (text == null) {
            return true;
        }
        else
            return false;
    }

    public boolean nullCheck2(String text) {
        if (text == null) {
            return true;
        }
        else {
            int textLength = text.length();
            System.out.println(textLength);
            return false;
        }
    }
}
```

## String의 내용을 비교하고 검색하는 메소드들도 있어요
String 클래스는 문자열을 나타내서 문자열 내에 특정 위치를 찾거나 값을 비교하는 등의 작업 빈번히 발생
- 문자열의 길이를 확인하는 메소드
- 문자열이 비어 있는지 확인하는 매소드
- 문자열이 같은지 비교하는 메소드
- 특정 조건에 맞는 문자열이 있는지를 확인하는 메소드

```java
package c.string;

public class StringCompare {

    public static void main(String[] args) {
        StringCompare stringCompare = new StringCompare();
    }
}
```

### 문자열의 길이를 확인하는 메소드

| 리턴 타입 | 메소드 이름 및 매개변수 | 설명 |
|----|----|----|
| int | length() | 문자열의 길이를 리턴한다. |

```java
public void checkString() {
        String text = "You must know String class.";
        System.out.println("text.length() = " + text.length());
    }
```

- 공백도 길이에 포함

### 문자열이 비어 있는지 확인하는 메소드
| 리턴 타입 | 메소드 이름 및 매개변수 | 설명 |
|----|----|----|
| boolean | isEmpty() | 문자열이 비어 있는지를 확인한다. 비어 있으면 true를 리턴한다. |

```java
package c.string;

public class StringCompare {

    public static void main(String[] args) {
        StringCompare stringCompare = new StringCompare();
        stringCompare.checkString();
    }

    public void checkString() {
        String text = "You must know String class.";
        System.out.println("text.length() = " + text.length());
        System.out.println("text.isEmpty() = " + text.isEmpty());
    }
}
```

- 공백 하나로만 문자열이 구성되어 있어도 false 리턴

### 문자열이 같은지 비교하는 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수 |
| boolean | equals(Object anObject) |
| boolean | equalsIgnoreCase(String anotherStr) |
| int | compareTo(String anotherStr) |
| int | compareToIgnoreCase(String str) |
| boolean | contentEquals(CharSequence cs) |
| boolean | contentEquals(StringBuffer sb) |

- 세 가지 메소드로 분류 가능
- 매개 변수로 넘어온 값과 String 객체가 같은지를 비교하기 위한 메소드
- IgnoreCase 가 붙은 메소드들은 대소문자 구분을 할지 안할지 여부만 다르다

```java
package c.string;

public class StringCompare {

    public static void main(String[] args) {
        StringCompare stringCompare = new StringCompare();
        System.out.println("checkString");
        stringCompare.checkString();
        System.out.println("checkCompare");
        stringCompare.checkCompare();
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
    }
}
```

- == 비교가 아닌 equals() 메소드를 사용하여 비교
- Constant Pool 이라는 것 떄문
- String 의 경우 동일한 값을 갖는 객체가 있으면, 이미 만든 객체를 재사용

```java
package c.string;

public class StringCompare {

    public static void main(String[] args) {
        StringCompare stringCompare = new StringCompare();
        System.out.println("checkString");
        stringCompare.checkString();
        System.out.println("checkCompare");
        stringCompare.checkCompare();
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
        if (text.equalsIgnoreCase(text3)) {
            System.out.println("text.equalsIgnoreCase(text3) result is same");
        }
    }
}
```

```java
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
```

### 특정 조건에 맞는 문자열이 있는지를 확인하는 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수 |
|---|----|
| boolean | startsWith(String prefix) |
| boolean | startsWith(String prefix, int toffset) |
| boolean | endsWith(String suffix) |
| boolean | contains(CharSequence s) |
| boolean | matches(String regex) |
| boolean | regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) | 
| boolean | regionMatches(int toffset, String other, int ooffset, int len) |

- startsWith() 메소드를 가장 많이 사용
- 이름 그대로 매개 변수로 넘겨준 값으로 시작하는지를 확인
- indexOf() 메소드의 단점은 문자열의 모든 내용을 다 확인해 봐야 한다는 단점
- endsWith() 메소드는 매개 변수로 넘어온 값으로 해당 문자열이 끝나는지를 확인하느 메소드

```java
package c.string;

public class StringCheck {

    public static void main(String[] args) {
        StringCheck stringCheck = new StringCheck();

        String addresses[] = new String[] {
                "서울시 구로구 신도림동",
                "경기도 성남시 분당구 정자동 개발 공장",
                "서울시 구로구 개봉동",
        };

        stringCheck.checkAddress(addresses);
    }

    public void checkAddress(String[] addresses) {
        int startCount = 0;
        int endCount = 0;
        String startText = "서울시";
        String endText = "동";
        for (String address : addresses) {
            if (address.startsWith(startText)) {
                startCount ++;
            }
            if (address.endsWith(endText)) {
                endCount ++;
            }
        }
        System.out.println("Starts with " + startText + " count is " + startCount);
        System.out.println("Ends with " + endText + " count is " + endCount);
    }
}
```
- 중간에 있는 값을 사용할 떄 contains() 사용
```java
package c.string;

public class StringCheck {

    public static void main(String[] args) {
        StringCheck stringCheck = new StringCheck();

        String addresses[] = new String[] {
                "서울시 구로구 신도림동",
                "경기도 성남시 분당구 정자동 개발 공장",
                "서울시 구로구 개봉동",
        };

        System.out.println("checkAddress");
        stringCheck.checkAddress(addresses);
        System.out.println("containsAddress");
        stringCheck.containsAddress(addresses);
    }

    public void checkAddress(String[] addresses) {
        int startCount = 0;
        int endCount = 0;
        String startText = "서울시";
        String endText = "동";
        for (String address : addresses) {
            if (address.startsWith(startText)) {
                startCount ++;
            }
            if (address.endsWith(endText)) {
                endCount ++;
            }
        }
        System.out.println("Starts with " + startText + " count is " + startCount);
        System.out.println("Ends with " + endText + " count is " + endCount);
    }

    public void containsAddress(String[] addresses) {
        int containCount = 0;
        String containText = "구로";

        for (String address : addresses) {
            if (address.contains(containText)) {
                containCount ++;
            }
        }

        System.out.println("Contains " + containText + " count is " + containCount);
    }
}
```
- regionMatches() 라는 메소드는 문자열 중에서 특정 영역이 매개 변수로 넘어온 문자열과 동일한지를 확인하는 데 사용  


| 리턴 타입 | 메소드 이름 및 매개 변수 |
| ----|-----|
| boolean | regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) |
| boolean | regionMatches(int toffset, String other, int oofset, int len) |

- 하나는 다소문자를 구분할지 여부를 지정할 수 있고, 다른 하나는 불가

| 매개 변수 | 의미 |
|-----|----|
| ignoreCase | true일 경우 대소문자 구분을 하지 않고, 값을 비교한다. |
| toffset | 비교 대상 문자열의 확인 시작 위치를 지정한다. |
| other | 존재하는지를 확인할 문자열을 의미한다. |
| ooffset | other 객체의 확인 시작 위치를 지정한다. |
| len | 비교할 char의 개수를 지정한다. |

```java
public void checkMatch() {
    String text = "This is a text";
    String compare1 = "is";
    String compare2 = "this";
    System.out.println(text.regionMatches(2, compare1, 0, 1));
    System.out.println(text.regionMatches(5, compare1, 0, 2));
    System.out.println(text.regionMatches(true, 0, compare2, 0, 4));
        }
```

## String 내에서 위치를 찾아내는 방법은 여러 가지에요
- indexOf() 해당 객체의 특정 문자열이나 char가 있는 위치를 알 수 있다.
- 없으면 -1을 리턴
  

| 리턴 타입 | 메소드 이름 및 매개 변수 |
|-----|----|
| int | indexOf(int ch) |
| int | indexOf(int ch, int fromIndex) |
| int | indexOf(String str) |
| int | indexOf(String str, int fromIndex) |
| int | lastIndexOf(int ch) |
| int | lastIndexOf(int ch, int fromIndex) |
| int | lastIndexOf(String str) |
| int | lastIndexOf(String str, int fromIndex) |

- 가장 많이 사요오디는 메소드 중 하나
- indexOf()는 앞에서부터 문자열이나 char을 찾으며
- lastIndexOf()는 뒤에서부터 찾는다

## String의 값의 일부를 추출하기 위한 메소드들은 얘네들이다.

- char 단위의 값을 추출하는 메소드
- char 배열의 값을 String으로 변환하는 메소드
- String 값을 char 배열로 변환하는 메소드
- 문자열의 일부 값을 잘라내는 메소드
- 문자열을 여러 개의 String 배열로 나누는 메소드

### char 단위의 값을 추출하는 메소드  

| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
|---|-----|----|
| char | charAt(int index) | 특정 위치의 char 값을 나타낸다. |
| void | getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) | 매개 변수로 넘어온 dst라는 char 배열 내에 srcBegin 에서 srcEnd에 있는 char를 저장한다. 이때, dst 배열의 시작위치는 dstBegin이다. |
| int | codePointAt(int index) | 특정 위치의 유니코드 값을 리턴한다. 리턴 타입은 int지만, 이 값을 char로 형 변환하면 char 값을 출력할 수 있다. |
| int | codePointBefore(int index) | 특정 위치 앞에 있는 char 의 유니코드 값을 리턴한다. 리턴 타입은 int지만, 이 값을 char 로 형 변환하면 char값을 출력할 수 있다. |
| int | codePointCount(int beginIndexm int endIndex) | 지정한 범위에 있는 유니코드 개수를 리턴한다. |
| int | offsetByCodePoints(int index, int codePointOffset) | 지정된 index 부터 오프셋이 설정된 인덱스를 리턴한다. | 

### char 배열의ㅏ 값을 String으로 변환하는 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
| ----|-----|---|
| static String | copyValueOf(char[] data) | char 배열에 있는 값을 문자열로 변환한다. |
| static String | copyValueOf(char[] data, int offset, int count) | char 배열에 있는 값을 문자열로 변환한다. 단, offset 위치부터 count 까지의 개수만큼만 문자열로 변환한다. |

### String의 값을 char 배열로 변환하는 메소드

| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
| ----|-----|---|
| char[] | toCharArray() | 문자열을 char 배열로 변환하는 메소드 |

### 문자열의 일부 값을 잘라내는 메소드

| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
| ----|-----|---|
| String | substring(int beginIndex) | beginIndex부터 끝까지 대상 문자열을 잘라 String으로 리턴한다. |
| String | substring(int beginIndex, int endIndex) | beginIndex 부터 endIndex까지 대상 문자열을 잘라 String으로 리턴한다. |
| CharSequence | subSequence(int beginIndex, int endIndex) | beginIndex부터 endIndex까지 대상 문자열을 잘라 CharSequence 타입으로 리턴한다. |

### 문자열을 여러 개의 String 배열로 나누는 split 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
| ----|-----|---|
| String[] | split(String regex) | regex에 있는 정규 표현식에 맞추어 문자열을 잘라 String의 배열로 리턴한다. |
| String[] | split(String regex, int limit) | regex에 있는 정규 표현식에 맞추어 문자열을 잘라 String의 배열로 리턴한다. 이때 String 배열의 크기는 limit 보다 커서는 안 된다. |

## String 값을 바꾸는 메소드들도 있어요
- 문자열을 합치는 메소드와 공백을 없애는 메소드
- 내용을 교체하는 메소드
- 특정 형식에 맞춰 값을 치환하는 메소드
- 대소문자를 바꾸는 메소드
- 기본 자료형을 문자열로 변환하는 메소드

### 문자열을 합치는 메소드와 공백을 없애는 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
| ----|-----|---|
| String | concat(String str) | 매개 변수로 받은 str을 기본 문자열의 우측에 붙인 새로운 문자열 객체를 생성하여 리턴한다. |
| String | trim() | 문자열의 맨 앞과 맨 뒤에 있는 공백들을 제거한 문자열 객체를 리턴한다. |

### 내용을 교체하는 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
| ----|-----|---|
| String | replace(char oldChar, char newChar) | 해당 문자열에 있는 oldChar의 값을 newChar로 대치한다. |
| String | replace(CharSequence target, CharSequence replacement) | 해당 문자열에 있는 target과 같은 값을 replacement로 대치한다. |
| String | replaceAll(String regex, String replacement) | 해당 문자열의 내용 중 regex에 표현된 정규 표현식에 포함되는 모든 내용을 replacement로 대체한다 |
| String | replaceFirst(String regex, String replacement) |해당 문자열의 내용 중 regex에 표현된 정규 표현식에 포함되는 첫 번째 내용을 replacement로 대치한다 |


### 특정 형식에 맞춰 값을 치환하는 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
| ----|-----|---|
| static String | format(String format, Object... args) | format에 있는 문자열의 내용 중 변환해야 하는 부분을 args의 내용으로 변경한다 |
| static String | format(Locale 1, String format, Object...args) | format에 있는 문자열의 내용 중 변환해야 하는 부분을 args의 내용으로 변경한다. 단 첫 매개 변수인 Locale 타입의 1에 선언된 지역에 맞추어 출력한다. |

- %d 숫자, %s String, %f 소숫점, %% %

### 대소문자를 바꾸는 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
| ----|-----|---|
| String | toLowerCase() | 모든 문자열의 내용을 소문자로 변경한다. |
| String | toLowerCase(Locale locale) | 지정한 지역 정보에 맞추어 모든 문자열의 내용을 소문자로 변경한다. |
| String | toUpperCase() | 모든 문자열의 내용을 대문자로 변경한다. |
| String | toUpperCase(Locale locale) | 지정한 지역 정보에 맞추어 모든 문자열의 내용을 대문자로 변경한다. |


## immutable한 String의 단점을 보완하는 클래스에는 StringBuffer와 StringBuilder가 있다.
- StringBuffer : Thread Safe
- StringBuilder : Not Thread Safe

