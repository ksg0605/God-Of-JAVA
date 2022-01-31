# 14장 연습문제
1. 이 클래스를 작성하고 컴파일해 보자. 컴피일이 정상젓으로 되었다면 실행을 해보자. 결과는 다음과 같다.
2. 왜 두번째 결과가 Infinity로 나왔는지 설명해 보자  
1을 0으로 나누었기 때문
3. 만약 두 번째 값이 0 이면  "Second value cant be zero" 라는 메시지를 갖는 예외를 발생시키자. 그리고, 발생시킨 예외를 throw 할 수 있도록 코드를 수정하자
4. main() 메소드에서 printDivide() 메소드를 호출하는 부분을 try-catch 로 묶자
5. main() 메소드의 catch 무장에서 다음과 같은 메시지가 출력되도록 만들자

```java
package c.exception;

public class Calculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.printDivide(1, 2);
            calculator.printDivide(1, 0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printDivide(double d1, double d2) throws Exception {
        if (d2 == 0) {
            throw new Exception("Second value can't be Zero");
        }
        double result = d1 / d2;
        System.out.println(result);
    }
}
```
---
1. 예외를 처리하기 위한 세 가지 블록에는 어떤 것이 있나요?  
try-catch, finally
2. 1의 답 중에서 "여기에서 예외가 발생할 것이니 조심하세요"라고 선언하는 블록은 어떤 블록인가요?  
try
3. 1의 답 중에서 "예외가 발생하든 안하든 얘는 반드시 실행되어야 됩니다."라는 블록은 어떤 블록인가요?  
finally
4. 예외의 종류 세 가지는 각각 무엇인가요??  
checked exception, error, runtime exception
5. 프로세스에 치명적인 영향을 주는 문제가 발생한 것을 무엇이라고 하나요?  
error
6. try나 catch 블록 내에서 예외를 발생시키는 키워드는 무엇인가요?  
try
7. 메소드 건언시 어떤 예외를 던질 수 도 있다고 성넝할 때 사용하는 키워드는 무엇인가요?  
throw
8. 직접 예외를 만들 때 어떤 클래스의 상속을 받아서 만들어야만 하나요?  
Exception