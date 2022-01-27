# 13장 연습문제
1. c.impl.list 패키지를 만들자
2. 1에서 만든 패키지에 List라는 이름의 인터페이스를 만들자.
3. List 인터페이스에 데이터 하나를 추가하기 위한 public void add() 라는 메소드를 만들자
4. List 인터페이스에 특정 위치에 있는 값을 수정하는 public void update(int index, Object value)라는 메소드를 만들자
5. List 인터페이스에 특정 위치에 있는 값읋 삭제하는 public void remove(int index)라는 메소드를 만들자.
6. List 인터페이스에 지금까지 만든 3개의 메소드 이외에 어떤 메소드를 더 만들어야 하는지 생각해보자.
7. 같은 패키지에 AbstractList 라는 abstract 클래스를 만들자
8. AbstractList 가 List 인터페이스를 구현하도록 클래스 선언문을 수정하자
9. AbstractList 에 clear() 라는 이름의 abstract 메소드를 만들자
```java
package c.impl.list;

public interface List {

    public void add();
    public void update(int index, Object value);
    public void remove(int index);
}
```
```java
package c.impl.list;

public abstract class AbstractList implements List {
    public abstract void clear();

}
```
---
1. HealthInsurance라는 이름의 enum 클래스를 선언하자
2. HealthInsurance enum 클래스에 해당 등금의 최대 연봉과 고엦 비율을 매개 변수로 갖는 생성자를 만들자.  
참고로 갱성자의 매개 변수로 넘겨주는 변수의 이름은 정수 타입의 maxSalary 와 소수 타입의 ratio 를 사용하고, enum 의 변수로도 선언해 놓자.
3. LEVEL_ONE ~ LEVEL_SIX 까지의 상수를 앞의 표와 2에서 만든 생성자를 이용하여 선언하자
4. HealthInsurance enum 클래스에 공제비율을 리턴하는 getRatio() 메소드를 만들자
5. public static HealthInsurance getHealthInsurance(int salary) 라는 static 메소드를 만들고,  
연봉을 매개 변수로 받으면 그 연봉에 해당하는 enum 객체를 리턴하도록 하자
6. HealthInsurance enum 클래스에 5에서 만든 메소드가 제대로 동작하는지 확인하기 위해 main() 메소드를 만들자.
```java
package c.enums;

public enum HealthInsurance {
    LEVEL_ONE(1000, 0.01),
    LEVEL_TWO(2000, 0.02),
    LEVEL_THREE(3000, 0.032),
    LEVEL_FOUR(4000, 0.045),
    LEVEL_FIVE(5000, 0.056),
    LEVEL_SIX(6000, 0.071);

    private final int maxSalary;
    private final double ratio;

    HealthInsurance(int maxSalary, double ratio) {
        this.maxSalary = maxSalary;
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }

    public static HealthInsurance getHealthInsurance(int salary) {
        if (salary < 1000) {
           return LEVEL_ONE;
        }
        else if (salary < 2000) {
            return LEVEL_TWO;
        }
        else if (salary < 3000) {
            return LEVEL_THREE;
        }
        else if (salary < 4000) {
            return LEVEL_FOUR;
        }
        else if (salary < 5000) {
            return LEVEL_FIVE;
        }
        else {
            return LEVEL_SIX;
        }
    }

    public static void main(String[] args) {
        int salaryArray[] = new int[]{1500, 5500, 8000};
        HealthInsurance [] healthInsurance = new HealthInsurance[3];
        healthInsurance[0] = HealthInsurance.getHealthInsurance(salaryArray[0]);
        healthInsurance[1] = HealthInsurance.getHealthInsurance(salaryArray[1]);
        healthInsurance[2] = HealthInsurance.getHealthInsurance(salaryArray[2]);

        for (int loop = 0; loop < 3 ; loop ++) {
            System.out.println(salaryArray[loop] + "=" + healthInsurance[loop] + ", " + healthInsurance[loop].getRatio());
        }
    }
}
```
---
1. 인터페이스에 선언되어 있는 메소드는 body가 있어도 되나요?  
아니요
2. 인터페이스를 구현하는 클래스의 선언시 사용하는 예약어는 무엇인가요?  
implements
3. 일부만 완성되어 있는 클래스를 무엇이라고 하나요  
abstract class
4. 3번의 답에 있는 클래스에 body가 없는 메소드를 추가하여면 어떤 예약어를 추가해야 하나요  
abstract
5. 클래스를 final로 선언하면 어떤 제얃이 발생하나요  
더 이상 상속할 수 없다
6. 메소들르 final로 선언하면 어떤 제약이 발생하나요  
오버라이딩이 불가하다
7. 번수를 final로 선언하면 어떤 제약이 발생하나요  
상수, 더 이상 변경이 불가
8. enum 클래스 안에 정의하는 여러 개의 상수들을 나열하기 위해서 상수 사이에 사용하는 기호는 무엇인가요  
,
9. enum으로 선언한 클래스는 어떤 클래스의 상속을 자동으로 받게 되나요  
Enum
10. enum 클래스에 언언되어 있지는 않지만 컴파일시 자동으로 추가되는 상수의 목록을 배열로 리턴하는 메소드는 무엇인가요?  
values()