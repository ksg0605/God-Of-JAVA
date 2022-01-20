# 7장 여러 데이터를 하나에 넣을 수는 없을까요?
## 하나에 많은 것을 담을 수 있는 배열이라는 게 있다는데...
- int 나 long을 하나만 만들어서 여러 개의 값을 넣어 둘 수 있다.
- 한 변수에 여러 개의 값을 넣을 수 있는 것
- 한 가지 타입에 대해서, 하나의 변수에 여러 개의 데이터를 넣을 수 있다. 
```java
// 기본 자료형의 배열 선언
int [] lottoNumbers;
int lottoNumbers[];
```
- 배열 변수를 정의할 때 대괄호 안에는 아무것도 써주면 안 된다.
- 보통은 첫 번째 방법을 사용

```java
//배열의 개수 정의
int [] lottoNumbers = new int[7];

//꼭 한 줄로 선언해야하는 것은 아님
int [] lottoNumbers;
lottoNumbers = new int[7];
```
- int는 기본 자료형이지만 
- int []와 같이 lottoNumbers는 int를 배열로 만든 참조 자료형
- 참조 자료형 선언에서는 반드시 new 사용

```java
public class ArrayLotto {
    public static void main(String[] args) {
        ArrayLotto arrayLotto = new ArrayLotto();
        arrayLotto.inti();
    }
    public void inti() {
        int [] lottoNumbers = new int[7];
        lottoNumbers[0] = 5;
        lottoNumbers[1] = 12;
        lottoNumbers[2] = 23;
        lottoNumbers[3] = 25;
        lottoNumbers[4] = 38;
        lottoNumbers[5] = 41;
        lottoNumbers[6] = 2;
    }
} 
```

## 배열의 기본값
- 기본 자료형 배열의 기본값은 각 자료형의 기본값과 동일
- 지역 변수의 경우에는 초기화를 하지 않으면 사용이 불가능하지만 배열에서는 지역 변수라도 배열의 크기만 정해주면 문제가 발생하지 않음
- 참조 자료형에서 초기화를 하지 않으면 null을 출력 -> 초기화 해 주어야 함
- String의 경우 생성자를 사용화지 않고 쌍따옴표만으로 정의가 가능
- null이 출력된다고 null이 저장되는것이 아닌 무소유의 개념
- null을 명시적으로 선언힐수도 있음

```java
public class ArrayInitValue {
    public static void main(String[] args) {
        ArrayInitValue arrayInitValue = new ArrayInitValue();
        arrayInitValue.primitiveTypes();
        arrayInitValue.referenceTypes();
    }
    public void primitiveTypes() {
        byte []byteArray = new byte[1];
        short []shortArray = new short[1];
        int []intArray = new int[1];
        long []longArray = new long[1];
        float []floatArray = new float[1];
        double []doubleArray = new double[1];
        char []charArray = new char[1];
        boolean []booleanArray = new boolean[1];
        System.out.println("byteArray[0] = " + byteArray[0]);
        System.out.println("shortArray[0] = " + shortArray[0]);
        System.out.println("intArray[0] = " + intArray[0]);
        System.out.println("longArray[0] = " + longArray[0]);
        System.out.println("floatArray[0] = " + floatArray[0]);
        System.out.println("doubleArray[0] = " + doubleArray[0]);
        System.out.println("charArray[0] = " + charArray[0]);
        System.out.println("booleanArray[0] = " + booleanArray[0]);
    }
    public void referenceTypes() {
        String [] strings = new String[2];
        ArrayInitValue [] arrayInitValues = new ArrayInitValue[2];
        strings[0] = "Please visit www.GodOfJava.com";
        arrayInitValues[0] = new ArrayInitValue();
        System.out.println("Strings[0] = " + strings[0]);
        System.out.println("Strings[1] = " + strings[1]);
        System.out.println("arrayInitValues[0] = " + arrayInitValues[0]);
    }
}
```

> 왜 ArrayInitValue 객체를 출력한 결과는 타입의 입름과 함께 이상한 골뱅이@ 가 붙은 것이 출력되는 것일까?  
> 참조 자료형은 public String toString() 이라는 메소드를 만들어 주지 않으면 "타입이름@고유번호" 순으로 내용이 출력된다.


## 배열을 그냥 출력해보면 어떻게 나올까?
- 모든 배열은 참조 자료형이다.

```java
public class ArrayPrint {
    public static void main(String[] args) {
        ArrayPrint arrayPrint = new ArrayPrint();
        arrayPrint.printString();
        arrayPrint.printPrimitiveArray();
    }
    public void printString() {
        System.out.println("Strings = " + new String[0]);
        System.out.println("arrayPrint = " + new ArrayPrint[0]);
    }
    public void printPrimitiveArray() {
        System.out.println("byteArray = " = new byte[1]);
        System.out.println("shortArray[1] = " + new short[1]);
        System.out.println("intArray[1] = " + new int[1]);
        System.out.println("longArray[1] = " + new long[1]);
        System.out.println("floatArray[1] = " + new float[1]);
        System.out.println("doubleArray[1] = " + new double[1]);
        System.out.println("charArray[1] = " + new char[1]);
        System.out.println("booleanArray[1] = " + new boolean[1]);
    }
}
```

## 배열을 선언하는 또 다른 방법
- 지금까지는 new int[1]; 과 같이 new라는 예약어를 사용하고, 타입과 크기를 지정해서 배열을 선언
- 중괄호를 사용하면 한번에 배열을 선언할 수 있다.
- 절대 변경되지 않는 값을 지정할 때 중괄호로 선언하여 사용

```java
public class ArrayInitialize {
    public static void main(String[] args) {
        ArrayInitialize arrayInitialize = new ArrayInitialize();
        arrayInitialize.otherInit();
    }
    public void otherInit() {
        int [] lottoNumbers = {5, 12, 23, 25, 38, 41, 2};
        
    }
    public String getMonth(int monthInt) {
        String [] month = {"January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"};
        return month[monthInt + 1];
    }
}
```
- 보통은 예시에서 사용한 "달" 처럼 변하지 않는 값은 메소드 내에서 선언하여 사용하기보다 클래스의 변수로 선언하여 재활용한다.
- 만약 getMonth() 라는 메소드에서만 배열을 사용한다면 반드시 뺄 필요는 없다. 클래스의 객체를 생성할 때마다 month라는 배열이 생기기 때문이다. 
- 얼마나 자주 사용하는지, 어디에서 사용하는지를 확인하여 메소드에서 선언하여 사용할지, 클래스의 인스턴스 변수로 선언하여 사용할지 결정할것
- 단점을 해결하기 위해서 static 예약어 존재
```java
public class ArrayInitialize {
    static String [] month = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    }; 
}
```
- 이렇게 하면 클래스의 객체를 생성할 때마다 배열을 새로 생성하지 않는다.
- 클래스 변수가 되기 때문
- static은 남용하면 안 된다.


## 별로 사용하지는 않지만, 알고 있어야 하는 2차원 배열
- 2차원 이상의 배열은 웬만하면 사용하지 않는다
- 가독성이 떨어지기 때문  


    
- 2차원 배열은 배열의 배열을 의미한다.
- 1차원 배열은 int로 선언했다면 배열은 int 값이었다. 
- 하지만 2차원 배열에서는 int[]는 int 가 아니라 배열이다. 
- 즉 int[][]가 int인 것이다. 

> 2차원 배열 twoDim[][] 에서
> twoDim[0] = int 배열
> twoDim[0][0] = int 값
  
- 1차원의 크기만 지정하고, 2차원의 크기를 지정하지 않을 수도 있다. 
- 1차원을 공백으로 두고 2차원 배열만 지정하거나, 두 배열 모두 지정하지 않는 것은 안 된다. 

```java
public class ArrayTwoDimension {
    public static void main(String[] args) {
        ArrayTwoDimension arrayTwoDimension = new ArrayTwoDimension();
        arrayTwoDimension.twoDimensionArray();
    }
    public void twoDimensionArray() {
        int [][] twoDim;
        twoDim = new int[2][3];
    }
}
```

## 배열의 길이는 어떻게 알 수 있을까요?
- 배열 이름에 .length
- 기본자료형에서는 불가, 참조 자료형에서만 가능

```java
public class ArrayLength {
    public static void main(String[] args) {
        ArrayLength arrayLength = new ArrayLength();
        arrayLength.printArrayLength();
    }
    public void printArrayLength() {
        int [][] twoDim = new int[4][2];
        System.out.println("twoDim.length = " + twoDim.length);
        System.out.println("twoDim[0].length = " + twoDim[0].length);
        
//        for(int oneLoop = 0; oneLoop<2; oneLoop++) {
//            for(int twoLoop = 0; twoLoop<3; twoLoop++) {
//                System.out.println("twoDim[" + oneLoop + "][" + twoLoop + "] = "
//                                    + twoDim[oneLoop][twoLoop]);
//            }
//        }
        int twoDimLength = twoDim.length;
        for(int oneLoop = 0; oneLoop < twoDimLength; oneLoop++) {
            int twoDimOneLength = twoDim[oneLoop].length;
            for(int twoLoop = 0; twoLoop < twoDimLength; twoLoop++) {
                System.out.println("twoDim[" + oneLoop + "][" + twoLoop + "] = "
                                    + twoDim[oneLoop][twoLoop]);
            }
        }
    }
} 
```

## 배열을 위한 for 루프
- for 루프를 편하게 사용할 수 있도록 다음과 같은 문법이 추가 되었다.
```java
for(타입이름 임시변수명 : 반복대상객체) {
    
        }
```
- 괄호 안에 배열의 각 항목을 처리하기 위한 "타입이름"과 "임시 변수명"을 지정해준다.
- 콜론 뒤에는 반복을 수행할 대상 객체 (여기서는 배열)이 위치

```java
public class ArrayNewFor {
    public static void main(String[] args) {
        ArrayNewFor arrayNewFor = new ArrayNewFor();
        arrayNewFor.newFor();
    }
    public void newFor() {
        int [] oneDim = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int data : oneDim) {
            System.out.println(data);
        }
    }
    public void twoDimFor() {
        int [][] twoDim = {{1, 2, 3}, {4, 5, 6}};
        for(int[] dimArray : twoDim) {
            for(int data : dimArray) {
                System.out.println(data);
            }
        }
    }
}
```
1. 첫 번째 for 루프 안의 소괄호를 살펴보자, twoDim 이라는 배열의 1차원 값은 배열이다.   
그래서, 그냥 int dimArray 가 아니라, int [] dimArray 로 지정해 두었다.  
   (int 의 배열을 앞부분에 쓴 것을 꼭 기억해야 한다.)
2. 안에 있는 for 루프를 보면 dimArray 배열의 1차원 값이 int 타입이기 때문에 int data 라고 지정했다.

## 자바 실행할 때 원하는 값들을 넘겨주자
- 지금까지 main 메소드는 다음과 같이 선언됐다.
```java
public class ArrayMain {
    public static void main(String[] args) {
        
    }
}
```
- 이 코드에서 방금 배운 배열은 main() 메소드의 매개 변수인 args 라는 String 타입의 배열이다.
```java
public class ArrayMain {
    public static void main(String[] args) {
        if(args.length > 0) {
            for(String arg : args) {
                System.out.println(arg);
            }
        }
    }
}
```
