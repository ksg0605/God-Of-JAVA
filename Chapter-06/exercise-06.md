# 6장 연습문제
1. InterestManager라는 클래스를 만들고, main() 메소드도 만들자.
```java
class InterestManager {
   public static void main(String[] args) {
      
   }
} 
```
2. 일자(int day)를 매개 변수로 받아서, double 타입의 이율(%)이 얼마나 되는지를 리턴하는 public double getInterestRate(int day)라는 메소드를 만들자.
```java
class InterestManager {
   public static void main(String[] args) {
      
   }
   public double getInterestRate(int day) {
       double rate;
       return rate;
   }
} 
```
3. getInterestRate() 메소드에서는 거치 기간이 90일 이내일 경우에는 0.5%, 91~180일 경우에는 1%, 181~364일 경우에는 2%, 265일에는 5.6의 이율을 제공한다.  
이러한 이율을 제공 받을 수 있도록 메소드 내용을 채우자 (if를 사용해서 이율을 얻어내자)    

|예치 기간|이율|    
|---|----|
|1일 ~ 90일|0.5%|
|91일 ~ 180일|1%|
|181일 ~ 364일|2%|
|365일 ~ |5.6%|

```java
class InterestManager {
   public static void main(String[] args) {
      
   }
   public double getInterestRate(int day) {
       double rate;
       if(day > 0 && day <= 90) {
           rate = (0.5 / 100);
       } 
       else if(day > 90 && day <= 180) {
           rate = (1 / 100);
       }
       else if(day > 180 && day <= 364) {
           rate = (2 / 100);
       }
       else {
           rate = (5.6/100);
       }
       return rate;
   }
} 
```
4. public double calculateAmount(int day, long amount) 라는 메소드를 만들자.  
이 메소드는 예금 거치 기간 (int day)과 예치 금액 (long amount)를 매개 변수로 받는다. double 타입의 계산 금액을 리턴한다.  
   (메소드 선언부만 일단 만들자.)
```java
class InterestManager {
   public static void main(String[] args) {
      
   }
   public double getInterestRate(int day) {
       double rate;
       if(day > 0 && day <= 90) {
           rate = (0.5 / 100);
       } 
       else if(day > 90 && day <= 180) {
           rate = (1 / 100);
       }
       else if(day > 180 && day <= 364) {
           rate = (2 / 100);
       }
       else {
           rate = (5.6/100);
       }
       return rate;
   }
   public double calculateAmount(int day, long amount) {
       double rate = getInterestRate(day);
       double calculatedAmount = rate * amount;
       return calculatedAmount;
   }
} 
```

5. 2~3에서 만든 getInterestRate() 메소드를 calculateAmount() 메소드에서 호출하여 이자를 얻어내고, double 타입의 계산된 금액(예치금 + 이자)을 리턴할 수 있도록 메소드 내용을 채우자.
```java
class InterestManager {
   public static void main(String[] args) {
      
   }
   public double getInterestRate(int day) {
       double rate;
       if(day > 0 && day <= 90) {
           rate = (0.5 / 100);
       } 
       else if(day > 90 && day <= 180) {
           rate = (1 / 100);
       }
       else if(day > 180 && day <= 364) {
           rate = (2 / 100);
       }
       else {
           rate = (5.6/100);
       }
       return rate;
   }
   public double calculateAmount(int day, long amount) {
       double rate = getInterestRate(day);
       double calculatedAmount = rate * amount;
       return calculatedAmount;
   }
} 
```
6. 1일 ~ 365일까지 하루씩 증가하면서 100만원을 예금했을 때 이자를 얼마나 받을 수 있는지 화면에 출력할 수 있도록 main() 메소드에서 getInterestRate() 메소드를 호출하자.
```java
class InterestManager {
   public static void main(String[] args) {
      InterestManager interestManager = new InterestManager();
      for(int day=1;day<=365;day++) {
         int amount = 1000000;
         double calculatedAmount = interestManager.calculateAmount(day, amount);
         System.out.println(day + "일의 예금이자는" + calculatedAmount + "입니다.");
      }
   }
   public double getInterestRate(int day) {
      double rate = 0;
      if(day <= 90) {
         return rate = (0.5 / 100);
      }
      else if(day <= 180) {
         return rate = 0.01;
      }
      else if(day <= 364) {
         return rate = 0.02;
      }
      else {
         return rate = 0.0056;
      }
   }
   public double calculateAmount(int day, long amount) {
      double calculatedAmount = 0.00;
      double rate = 0.00;
      rate = getInterestRate(day);
      calculatedAmount = amount * rate;
      return calculatedAmount;
   }
}
```
7. 6에서 만든 main() 메소드를 약간 수정하여 1일 단위가 아닌 10일 간격으로 결과를 호출하자.
```java
class InterestManager {
   public static void main(String[] args) {
      InterestManager interestManager = new InterestManager();
      for(int day=1;day<=365;day+=10) {
         int amount = 1000000;
         double calculatedAmount = interestManager.calculateAmount(day, amount);
         System.out.println(day + "일의 예금이자는" + calculatedAmount + "입니다.");
      }
   }
   public double getInterestRate(int day) {
      double rate = 0;
      if(day <= 90) {
         return rate = (0.5 / 100);
      }
      else if(day <= 180) {
         return rate = 0.01;
      }
      else if(day <= 364) {
         return rate = 0.02;
      }
      else {
         return rate = 0.0056;
      }
   }
   public double calculateAmount(int day, long amount) {
      double calculatedAmount = 0.00;
      double rate = 0.00;
      rate = getInterestRate(day);
      calculatedAmount = amount * rate;
      return calculatedAmount;
   }
}
```
---
1. if 문장의 소괄호 안에는 어떤 형태의 결과가 제공되어야 하나요?  
true 조건이 와야 한다.
2. if 조건에 맞지 않는 모든 경우를 처리할 때 사용하는 예약어는 뭔가요?  
else
3. switch를 사용할 수 있는 기본 자료형의 타입에는 어떤 것들이 있나요?  
long을 제외한 정수형 타입, Enum, String
4. switch 블록 안에서 비교 대상값 앞에 사용하는 예약어는 무엇인가요?  
case
5. switch 조건을 빠져나가도록 하는 예약어는 무엇인가요?  
break
6. switch 조건들에 맞지 않을 때 기본 처리를 하기 위한 예약어는 무엇인가요?  
default
7. while 문의 소괄호 안에는 어떤 형태의 결과가 제공되여야 하나요?  
boolean
8. while 문을 무조건 한번은 실행하게 하려먼 어떻게 해야 하나요?  
do-while
9. while 문을 마음대로 빠져나가게 하려면 어떤 예약어를 사용하면 되나요?  
break
10. while 문의 중간에 while 문의 소괄호 점검 구문으로 건너뛰도록 할 때 사용하는 예약어는 무엇인가요?  
continue
11. for 루프의 소괋호안의 가장 첫 구문(첫 세미 콜론 앞의 문장)은 for 루프가 수행되는 동안 몇 번 수행되나요?  
한 번
12. for 루프의 소괄호 안의 중간에 있는 구문은 어떤 타입의 결과가 제공되어야 하나요?  
boolean
13. for 루프의 소괄호 안의 마지막에 있는 구문에서는 어떤 작업을 수행하나요?  
조건 값 증가