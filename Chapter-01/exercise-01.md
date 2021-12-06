# 1장 연습문제

1. Calculator라는 이름을 갖는 클래스를 텍스트 파일에 만들어 보자.  
실제 코드를 여러분들이 만들어 실행하는 방법은 다음 장에서 배우니, 원하는 파일에 Calculator 클래스를 만들자.
```java
public class Calculator {
    // 이하 생략
}
```

2. 본문에서 사류ㅕ본 더하기 외에 빼기, 곱하기, 나누기를 하고 그 결과를 리턴해주는 메소드를 만들어 보자.
```java
public class Calculator {
    
    public int subtract(int num1, int num2) {
        int subtract;
        if(num1 >= num2) {
            subtract = num1 - num2;
        }
        else {
            subtract = num2 - num1;
        }
        return subtract;
    }
    
    public int multiply(int num1, int num2) {
        int multiply;
        multiply = num1 * num2;
        return multiply;
    }
    
    public int divide(int num1, int num2) {
        int divide;
        divide = num1 / num2;
        return divide;
    }
}
```

1. 클래스가 뭔가요?
   - 자바의 가장 작은 단위
   - 클래스는 상태와 행동이 있어야만 한다.
2. 메소드가 뭔가요?
   - 어떤 값을 주고 결과를 넘겨주는 것
3. 메소드의 매개 변수는 어디에 적어주나요?
   - 메소드 이름 뒤에 있는 괄호 안에 적어준다.
4. 메소드 이름 앞에 꼭 적어 줘야 하는 건 뭐죠?
   - 메소드의 자료형
5. 클래스가 갖고 있어야 한다고 한 두 가지가 뭐죠?
   - 상태와 행동
6. 메소드에서 결과를 돌려주려면 어떤 예약어를 사용해야 하나요?
   - return