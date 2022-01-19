# 5장 연습문제
> 이 장에서는 작은 회사에서 사용할 직원들의 급여를 계산하는 SalaryManager라는 클래스를 만들어 보자
  
1. SalaryManager 클래스를 만들고 main() 메소드도 만들자.
```java
public class SalaryManager {
    public static void main(String[] args) {
        
    }
} 
```
2. public double getMonthlySalary(int yearlySalary)라는 한달 급여를 계산하는 메소드로 만들고,  
매개 변수로는 int로 연봉을 받도록 하자. 이 메소드의 리턴 값은 월 급여이며 타입은 double로 제공 되어야만 한다.  
참고로, 1년은 12달이며, 제대로 된 double을 계산하기 위해서는 12.0으로 나누어야만 한다.
```java
public class SalaryManager {
    public double getMonthlySalary(int yearlySalary) {
        double monthSalary = yearlySalary / 12.0;
        return monthSalary;
    }
    public static void main(String[] args) {
        
    }
} 
```
3. 2에서 제공된 월 급여는 사우디아라비아 같은 부자 나라에서만 통하는 급여다.  
우리 나라에서는 급여에 여러 종류의 세금과 국민 연금, 건강 보험료 등을 떼어야만 한다. 기본적으로 우리나라에서는 돈을 많이 벌수록 세금을 많이 떼는데,  
일단 여기서는 무족건 근로 속득세는 12.5%, 국민 연금은 8.1%, 건강 보험료는 13.5%를 고정적으로 뗀다고 생각하자.   

|구분|세율|   
|---|---|
|근로 소득세|12.5%|
|국민 연금|8.2%|
|건강 보험료|13.5%|
먼저 월 급여를 매개 변수로 받고, 떼어야 할 "근로소득세"를 리턴해주는 public double calculateTax(double monthSalary)라는 메소드를 만들자. 이때 계산된 금액을 화면에 출력하도록 하자.
```java
public class SalaryManager {
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * 12.5;
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        return monthlySalary;
    }
    public static void main(String[] args) {
        
    }
} 
```
4. 3에서 만든 calculateTax()메소드를 getMonthlySalary() 메소드에서 호출하여 세금을 얼마나 공제해야 하는지 얻어 내도록 하자.
```java
public class SalaryManager {
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * 12.5;
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        double tax = calculateTax(monthlySalary);
        return monthlySalary;
    }
    public static void main(String[] args) {

    }
} 
```
5. 3에서 명시된 연금을 계산하는 public double calculateNationalPension(double monthSalary) 메소드를 만들자. 메게 변수는 월 급여이며, 리턴 값은 공제해야 하는 금액이다. 이때 계산된 금액을 화면에 출력하도록 하자.
```java
public class SalaryManager {
    public double calculateNationalPension(double monthSalary) {
        double nationalPension = monthSalary * 8.1;
        System.out.println("국민연금 :" + nationalPension);
        return nationalPension;
    }
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * 12.5;
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        double tax = calculateTax(monthlySalary);
        return monthlySalary;
    }
    public static void main(String[] args) {

    }
} 
```
6. 4에서처럼 getMonthlySalary() 메소드에서 calculateNationalPension() 메소드를 호출하여 연금을 얼마나 공제해야 하는지 얻어 내도록 하자.
```java
public class SalaryManager {
    public double calculateNationalPension(double monthSalary) {
        double nationalPension = monthSalary * 8.1;
        System.out.println("국민연금 :" + nationalPension);
        return nationalPension;
    }
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * 12.5;
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        double tax = calculateTax(monthlySalary);
        double nationalPension = calculateNationalPension(monthlySalary);
        return monthlySalary;
    }
    public static void main(String[] args) {

    }
} 
```
7. 마찬가지로 건강보험료를 계산하는 public double calculateHealthInsurance(double monthSalary) 메소드를 호출하여 건강 보험료를 얼마나 공제해야 하는지 얻어 내도록 하자.
```java
public class SalaryManager {
    public double calculateHealthInsurance(double monthSalary) {
        double healthInsurance = monthSalary * 13.5;
        System.out.println("건강보험료 :" + healthInsurance);
        return healthInsurance;
    }
    public double calculateNationalPension(double monthSalary) {
        double nationalPension = monthSalary * 8.1;
        System.out.println("국민연금 :" + nationalPension);
        return nationalPension;
    }
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * 12.5;
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        double tax = calculateTax(monthlySalary);
        double nationalPension = calculateNationalPension(monthlySalary);
        return monthlySalary;
    }
    public static void main(String[] args) {

    }
} 
```
8. 4에서처럼 getMonthlySalary() 메소드에서 calculateHealthInsurance() 메소드를 호출하여 건강 보험료를 얼마나 공제해야 하는지 얻어 내도록 하자.
```java
public class SalaryManager() {
    public double calculateHealthInsurance(double monthSalary) {
        double healthInsurance = monthSalary * 13.5;
        System.out.println("건강보험료 :" + healthInsurance);
        return healthInsurance;
    }
    public double calculateNationalPension(double monthSalary) {
        double nationalPension = monthSalary * 8.1;
        System.out.println("국민연금 :" + nationalPension);
        return nationalPension;
    }
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * 12.5;
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        double tax = calculateTax(monthlySalary);
        double nationalPension = calculateNationalPension(monthlySalary);
        double healthInsurance = calculateHealthInsurance(monthlySalary);
        return monthlySalary;
    }
    public static void main(String[] args) {

    }
} 
```
9. getMonthlySalary() 메소드에서 4, 6, 8에서 계산된 값을 전부 합치자.
```java
public class SalaryManager {
    public double calculateHealthInsurance(double monthSalary) {
        double healthInsurance = monthSalary * 13.5;
        System.out.println("건강보험료 :" + healthInsurance);
        return healthInsurance;
    }
    public double calculateNationalPension(double monthSalary) {
        double nationalPension = monthSalary * 8.1;
        System.out.println("국민연금 :" + nationalPension);
        return nationalPension;
    }
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * 12.5;
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        double tax = calculateTax(monthlySalary);
        double nationalPension = calculateNationalPension(monthlySalary);
        double healthInsurance = calculateHealthInsurance(monthlySalary);
        double totalTax =  tax + nationalPension + healthInsurance;
        return monthlySalary;
    }
    public static void main(String[] args) {

    }
} 
```
10. -= 연산자를 이용하여 전체 월 급여에서 9에서 계산된 값을 빼자.
```java
public class SalaryManager {
    public double calculateHealthInsurance(double monthSalary) {
        double healthInsurance = monthSalary * 13.5;
        System.out.println("건강보험료 :" + healthInsurance);
        return healthInsurance;
    }
    public double calculateNationalPension(double monthSalary) {
        double nationalPension = monthSalary * 8.1;
        System.out.println("국민연금 :" + nationalPension);
        return nationalPension;
    }
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * 12.5;
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        double tax = calculateTax(monthlySalary);
        double nationalPension = calculateNationalPension(monthlySalary);
        double healthInsurance = calculateHealthInsurance(monthlySalary);
        double totalTax =  tax + nationalPension + healthInsurance;
        double monthlySalary -= totalTax;
        return monthlySalary;
    }
    public static void main(String[] args) {

    }
} 
```
11. 이제 main() 메소드에서 getMonthlySalary() 메소드를 호출할 수 있도록, SalaryManager 클래스의 객체를 생성한 후 연봉이 2000만원인 사람의 연봉을 계산하도록 해 놓고 결과를 확인해보자.
```java
public class SalaryManager {
    public double calculateHealthInsurance(double monthSalary) {
        double healthInsurance = monthSalary * (13.5/100);
        System.out.println("건강보험료 :" + healthInsurance);
        return healthInsurance;
    }
    public double calculateNationalPension(double monthSalary) {
        double nationalPension = monthSalary * (8.1/100);
        System.out.println("국민연금 :" + nationalPension);
        return nationalPension;
    }
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * (12.5/100);
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        double tax = calculateTax(monthlySalary);
        double nationalPension = calculateNationalPension(monthlySalary);
        double healthInsurance = calculateHealthInsurance(monthlySalary);
        double totalTax =  tax + nationalPension + healthInsurance;
        monthlySalary -= totalTax;
        return monthlySalary;
    }
    public static void main(String[] args) {
        SalaryManager salaryManager = new SalaryManager();
        monthlySalarly = salaryManager.getMonthlySalary(20000000);
        System.out.println("한달 실수령액은 " + monthlySalary + "원 입니다.");
    }
} 
```
> 참고로 여러분들이 여기서의 예제에서처럼 실제 돈을 계산하는 부분을 개발할 때에는 double이나 float을 사용하면 절대 안 된다. 이러한 중요한 계산이 필요할 때에는 BigDecimal이라는 클래스를 사용해야만 한다.   
> 이 BigDecimal 클래스는 부록 13에서 알아보자
> 최종 결과는 1098333.333333335가 나와야 한다. 
---
1. 값을 할당할 때 사용하는 연산자의 기호는 무엇인가요?  
=
2. 기본적인 덧셈, 뺄셈, 나눗셈, 나머지를 계산할 때 사용하는 연산자의 기호는 무엇인가요?  
+, -, *, /, %
3. +=는 무엇을 할 때 사용하는 연산자인가요?  
우변의 값을 좌변으로 바로 더할 때
4. 여러분들이 연산의 순서를 모르거나 확실히 하고 싶을 때에는 어떤 기호를 사용해야 하나요?  
   () 소괄호 사용
5. ==와 !=의 차이는 무엇인가요?
==: 서로 같다, !=: 서로 다르다
6. <와 <=의 차이는 무엇인가요?  
<: 우항이 크다, <=: 우항이 크거나 같다.
7. !연산자는 어떤 타입에 사용할 수 있나요?  
불린타입
8. ?:로 표시되는 삼항 연산자의 ?와 :뒤에 명시해 주는 값은 무엇을 의미하나요?  
조건?참:거짓
9. 자바는 형 변환을 한다고 했는데, short의 값을 long에 할당할 때에는 어떤 것을 해 주어야 하나요?  
long()
10. 반대로 long값을 short에 할당할 때에는 어떤 것을 해 주어야 하나요?  
short()
11. 9와 10의 경우 어떤 경우가 기존 값이 사라지고, 엉뚱한 값으로 바뀔 수 있나요?  
10의 경우가 엉뚱한 값으로 바뀔 수 있다.