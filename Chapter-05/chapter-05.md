# 5장 계산을 하고 싶어요
## 연산자라는게 뭐지? 벌써 조금 배웠다고?
- 연산자는 영어로 Operator
- 대부분의 연산자는 앞장에서 배운 기본 자료형을 더하거나 뺴는 등의 계산을 하기 위해서 사용
- 기본 자료형을 제외한 참조 자료형은 지금 배울 연산자를 사용할 수 없지만 String 은 유일하게 + 연산이 가능하다

### =
- 등호
- a=3과 같이 왼쪽의 변수에 오른쪽에 있는 값을 대입할 때 사용한다.
- 이름도 대입 연산자
- assignment operator

### +와 -
- 기본적인 더하기와 빼기

```java
public class OperatorPlusMinus {
    public static void main(String[] args) {
        OperatorPlusMinus sample = new OperatorPlusMinus();
        sample.additive();
    }
    public void additive() {
        int intValue1 = 5;
        int intValue2 = 10;
        int result = intValue1 + intValue2;
        System.out.println(result);
        result = intValue2 - intValue1;
        System.out.println(result);
    }
}
```

- 위 메소드에서 intValue1과 intValue2는
- 두 개의 값을 더한다.
- intValue2에서 intValue1을 뺐다.

### *와 /
- 위 코드에 곱하기와 나누기 계산을 하는 multiplicative()라는 메소드를 추가
- intValue1과 intValue2는 앞과 동일하게 사용

```java
public class OperatorPlusMinus {
    public static void main(String[] args) {
        OperatorPlusMinus sample = new OperatorPlusMinus();
        sample.additive();
        sample.multiplicative();
    }
    public void additive() {
        int intValue1 = 5;
        int intValue2 = 10;
        int result = intValue1 + intValue2;
        System.out.println(result);
        result = intValue2 - intValue1;
        System.out.println(result);
    }
    public void multiplicative() {
        int intValue1 = 5;
        int intValue2 = 10;
        int result = intValue1 * intValue2;
        System.out.println(result);
        result = intValue2 / intValue1;
        System.out.println(result);
    }
}
```

### %
- 나머지 연산자
- remainder operator

```java
public class OperatorRemainder {
    public static void main(String[] args) {
        OperatorRemainder sample = new OperatorRemainder();
        sample.remainder();
    }
    public void remainder() {
        int intValue1 = 53;
        int intValue2 = 10;
        int result = intValue1 % intValue2;
        System.out.println(result);
    }
}
```

- 배수인지 확인하기가 쉽다.

## 간단하게 계산하는 복합 대입 연산자들
- Compound Assignment Operator
- += : 기존 값에 우측 항의 값을 더함
- -= : 기존 값에 우측 항의 값을 뺌
- *= : 기존 값에 우측 항의 값을 곱함
- /= : 기존 값을 우측 항의 값으로 나눔
- %= : 기존 값을 우측 항의 값으로 나눈 나머지

### compound() 메소드 만들기
1. 정수형인 intValue를 선언하여 10을 할당
2. 이 값에 5를 더하고 결과를 출력
3. 2의 결과에서 5를 빼고 결과를 출력
4. 3의 결과에 5를 곱하고 결과를 출력
5. 4의 결과에 5를 나누고 결과를 출력
6. 5의 결과에 4로 나눈 나머지 값을 출력
7. compound() 메소드를 수행한 결과를 확인

```java
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
```
## 피연산자가 하나인 것도 있어요. 이걸 단항 연산자라고 하죠
- +, -, *, /, % 모두 두 개의 피연산자를 사용
- 피연산자가 하나만 있는 연산자를 단항 연산자라고 함
  - +: 단항 플러스 연산자, Unary plus operator
  - -: 단항 마이너스 연산자, Unary minus operator
  - ++: 증가 연산자, Increment operator
  - --: 감소 연산자, Decrement operator
  - !: 논리 부정 연산자, Logical complement operator

### +와 -
- +는 "변수 * (1)"을 의미하고,
- -는 "변수 * (-1)"을 의미한다.

### ++와 --
- ++는 1을 더한다
- --는 1을 뺀다

### !
- boolean 타입에만 사용 가능
- 연산자를 boolean 앞에 붙여두면, 결과가 반대가 됨

## 자바에서 계산하는 순서를 알아두면 좋다
- *나 /를 먼저 계산
- 괄호를 먼저 계산

|구분|연산자|우선순위|
|---|----|-----|
|단항 연산자|++, --, +, -, !, ~|1|
|산술 연산자|*. /, %| 2|
| |+, -|3|

- ~(틸드): 2진수로 되어 있는 비트값을 전부 거꾸로 바꾸는 데 사용

## 뭔가를 비교할 때는 어떻게 하지?
- ==: 같음
- !=: 같지 않음
- '>: 왼쪽 값이 큼
- '>=: 왼쪽 값이 같거나 큼
- <: 왼쪽 값이 작음
- <=: 왼쪽 값이 같거나 작음   
__"모든 비교 연산자의 결과는 반드시 boolean"__

### ==과 !=
- 등가 비교 연산자
- 두개의 값이 같은지 다른지를 확인할 때 사용

### <, >, <=, >=
- 대소 비교 연산자
- 숫자에서만 사용 가능   

|식|true 조건|
|---|--------|
|a < b|a가 b보다 작을 때|
|a > b|a가 b보다 클 때|
|a <= b|a가 b와 같거나, b보다 작을 때|
|a >= b|a가 b와 같거나, b보다 클 때|

|연산자|사용 가능한 타입|
|---|---|
|--, !=|모든 기본 자료형과 참조 자료형 -> 즉 모든 타입|
|>, <, >=, <=| boolean을 제외한 기본 자료형|

## 논리 연산자들을 알아보자
- 논리 연산자
- &&: AND결합, Conditional AND
- ||: OR결합, Conditional OR

|값|-|결과|-|
|---|---|---|----|
|x|y|x&&y| x // y |
|true|true|true|true|
|true|false|false|true|
|false|true|false|true|
|false|false|false|false|

## 아주 특이한 ?: 연산자
- 삼항 연산자
- 변수 = (boolean 조건식) ? true일때값 : false일때값 ;
- 삼항 연산자는 = 왼쪽에 있는 변수에 값을 할당할 때 사용

## 기본 자료형의 형 변환을 이용한 변신
- 캐스팅(Casting)
- 서로 다른 타입 사이에 변환하는 작업
- boolean 자료형은 형 변환이 되지 않는다
- 기본 자료형 -> 참조 자료형 , 참조 자료형 -> 기본 자료형 사이의 형 변환은 불가
