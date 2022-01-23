1. godofjava 폴더 아래에 b라는 폴더를 만들자
2. b 폴더 아래에 array, control, operator, variable 이라는 폴더를 만들자
3. ArrayMain.java 파일을 godofjava/b/array 폴더로 옮기자.
4. ArrayMain.java 파일을 열어 b.array 라는 패키지로 선언하자
```java
package b.array;

public class ArrayMain {
    public static void main(String args[]) {
        if(args.length>0) {
            for(String arg:args) {
                System.out.println(arg);
            }
        }
    }
}
```
5. ArrayMain 클래스가 제대로 컴파일되는지 확인해보자
6. b.control 폴더에는 ControlIf, b.operator 폴더에는 OperatorConditional, b.variable 폴더에는 VariableTypes 클래스를 각각 이동하고, 패키지를 선언한 뒤 컴파일해 보자.
```java
package b.control;

public class ControlIf {
    public static void main(String[] args) {
        ControlIf control=new ControlIf();
        control.ifStatement();
    }
    public void ifStatement() {
        if(true);
        if(true) System.out.println("It's true");
        if(true)
            System.out.println("It's also true.");
        if(false) System.out.println("It's false");
    }

}
```
```java
package b.operator;

public class OperatorConditional {
    public static void main(String args[]) {
        int a=4, b=1;
        System.out.println ( (a==3) && (b==1) );
        System.out.println( (a==3) & (b==1) );
    }
}
```
```java
package b.variable;

public class VariableTypes {
    int instanceVariable;
    static int classVariable;
    public void method(int parameter) {
        int localVariable;
    }
}
```

---
1. 패키지를 선언할 때 사용하는 예약어는 무엇인가요?  
package
2. 패키지 선언은 클래스 소스 중 어디에 위치해야 하나요?  
가장 상단
3. 패키지를 선언할 때 가장 상위 패키지의 이름으로 절대 사용하면 안 되는 단어는 무엇인가요?  
java
4. 패키지 이름에 예약어가 포함되어도 되나요?  
안 된다.
5. import는 클래스 내에 선언해도 되나요?  
안 된다.
6. 같은 패키지에 있는 클래스를 사용할 때 import를 해야 하나요?  
안 해도 된다.
7. 특정 패키지에 있는 클래스들을 모두 import 할 때 사용하는 기호는 무엇인가요?  
*
8. 클래스에 선언되어 있는 static한 메소드나 변수를 import하려면 어떻게 선언해야 하나요?  
import static
9. 접근 제어자 중 가장 접근 권한이 넓은 것은 무엇인가요?  
public
10. 접근 제어자 중 가장 접근 권한이 좁은 것은 무엇인가요?  
private
11. 접근 제저자 중 같은 패키지와 상속관계에 있는 클래스만 접근할 수 있도록 제한하는 것은 무엇인가요?  
protected
12. "Calculate.java" 라는 자바 소스가 있을 경우, 그 소스 내에는 Calculate라는 클래스 외에는 ( )으로 선언된 클래스가 있으면 안 된다  
여기서 괄호 안에 들어가야 할 것은 무엇인가요?  
public