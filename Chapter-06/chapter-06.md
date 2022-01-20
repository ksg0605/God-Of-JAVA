# 제가 조건을 좀 따져요
이 장에서는 조건에 따라 처리하는 문장들을 배우고, 반복적으로 작업을 수행하는 방법을 알아본다.
## 도대체 얼마나 조건을 따지길래...
```java
if(boolean값) 처리문장;
```
if 다음에는 반드시 소괄호를 열고 닫아야 하며, 이 소괄호 안에는 boolean 형태의 결과가 있어야 한다.  
그 다음에  해당 조건에 맞을 때, 정확히는 소괄호 안의 결과가 true일 때 처리하는 "처리문장"과 세미콜론이 온다.  
```java
public class ControlIf {
    public static void main(String[] args) {
        ControlIf control = new ControlIf();
    }
}
```
```java
public class ControlIf {
    public static void main(String[] args) {
    }
    public void ifStatement() {
        if(true);
        if(true) System.out.println("It's true");
        if(true)
            System.out.println("It's also true");
        if(false) System.out.println("It's false");
    }
}
```
- 자바 컴파일러는 세미콜론이 나올 때까지 계속 찾는다.
- if문 안에 false가 들어갈 수 없기 떄문에 출력되지 않는다.
```java
if(boolean값) 처리문당1;
else 처리문장2;
```
## if를 조금 더 다양하게 사용해보자
- if 다음에는 문장이 하나밖에 올 수 없나?
- if의 조건이 하나만 있지는 않을 텐데 말이지... 여러 개일 떄에는 어떻게 하지?
- 값의 범위에 따라서 결과를 다르게 할 때도 있을 텐데, 그럴 때는 어떻게 해야 하지?

1. if 다음에는 문장이 하나밖에 올 수 없나?
```java
if(boolean) {
    처리문장1;
    처리문장2;
        }
```

else도 사용법이 같다.
```java
if(boolean) {
    처리문장1;
    처리문장2;
        } else {
    처리문장3;
    처리문장4;
        }
```

2. if의 조건이 하나만 있지는 않을 텐데 말이지.. 여러 개일 떄에는 어떻게 하지?
- if문의 조건문 안에 &&와 ||을 사용하면 여러가지 조건을 한 번에 따질 수 있다. 
- 두 개 이상의 비교도 가능

3. 값의 범위에 따라서 결과를 다르게 할 때도 있을 텐데, 그럴 때는 어떻게 해야 하지?
- if, else 이외에 else if 사용 
- 깔끔한 코드 작성 가능

## 자바의 switch와 불켜는 스위치는 별 상관 없다
- 하나의 값이 여러 범위에 걸쳐서 비교될 때에 사용
```java
switch(비교대상변수) {
    case 점검값1:
        처리문장1;
        ...
        break;
    case 점검값2:
        처리문장2;
        ...
        break;
    default:
        기본처리문장;
        ...
        break;
        }
```
- default는 무조건 실행되는 것은 아님
- case를 마무리하려면 break; 추가
- 적은 숫자부터 증가시켜 주는것이 좋다.

## 반복문이라구요?
말 그대로 지정한 횟수만큼 반복하거나, 조건에 맞을 때까지 반복하는 문장을 말한다.
- for
- while
- do-while문은 적어도 한 번은 반복문장이 실행된다.
- 문장을 빠져 나오고 싶으면 break
- 문장을 건너 뛰고 boolean으로 다시 가려면 continue

## 가장 확실한 for 루프
- while문은 잘못 사용하면 무한루프가 발생한다.
- 그래서 for문을 주로 사용

## 많이 사용안하는 label
- 두 개 이상의 for나 while 루프가 있을 때 사용도니다.


