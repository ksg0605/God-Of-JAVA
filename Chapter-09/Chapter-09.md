# 9장 자바를 배우면 패키지와 접근 제어자는 꼭 알아야 해요
- 패키지
- 작성하는 클래스들을 구분 짓는 폴더와 비슷한 개념
```java
// /Users/sunkyu/Documents/God-Of-Java 경로에 작성

package C.JavaPackage;

public class Package {
    public static void main(String[] args) {
        System.out.println("Package class.");
    }
}
```
- 컴파일은 루트 폴더인 /God-Of-Java 에서 진행
- C.JavaPackage는 패키지 선언문
  - 소스의 가장 첫 줄에 있어야만 한다.
  - 소스 하나에 패키지 선언 한번
  - 패키지 이름과 위치한 폴더 이름이 같아야 한다.
  - 패키지 이름을 java로 시작하면 안 된다.

## 패키지 이름은 이렇게 지어요
| 패키지 시작 이름 | 내용 |
|----|----|
| java | 자바 기본 패키지 (Java 벤더에서 개발) |
| javax | 자바 확장 패키지 (Java 벤더에서 개발) | 
| org | 일반적으로 비 영리단체 (오픈 소스)의 패키지 |
| com | 일반적으로 영리단체(회사)의 패키지 |

- 꼭 지켜야 하는 것은 아니지만 대부분의 코드는 이렇게 시작
- 아파치 : org.apache  

### 유의점
상위 패키지 이름
- 패키지 이름은 모두 소문자로 지정해야 한다.
- 자바의 예약어를 사용하면 안 된다.

## import를 이용하여 다른 패키지에 접근하기
```java
import c.javapackage.sub.Sub;
import c.javapackage.sub.*;
```

- import static 추가
- 선언되어 있는 static 변수에 접근하거나 static 메소드를 사용할 때 import static을 사용
- 굳이 클래스 이름을 지정하지 않아도 클래스에 선언된 것처럼 사용할 수 있다.
- 여러 줄로 import하기 귀찮으면 *을 사용해도 된다.   
  

  

- static 메소드나 변수가 중복되는 상황에서는 자신의 클래스에 있는것이 우선이다.

### import를 하지 않아도 되는 패키지
- java.lang 패키지
- 같은 패키지
> String과 System 클래스는 모두 java.lang 패키지에 있어서 import 할 필요가 없다.


- 패키지가 같은지 다른지에 따라서 import 여부가 결정된다.
- 같은 패키지에 있으면 import 할 필요가 없다.

## 자바의 접근 제어자
- 아래 네 가지를 선언할 때 사용
  - 클래스
  - 메소드
  - 인스턴스
  - 클래스 변수  
  

- public
  - 누구나 접근할 수 있도록 할 때 사용
- protected
  - 같은 패키지 내에 있거나 상속받은 경우에만 접근할 수 있다.
- package-private
  - 아무런 접근 제어자를 적어주지 않을 때이며, 같은 패키지 내에 있을 때만 접근할 수 있다.
- private
  - 해당 클래스 내에서만 접근 가능하다.

```java
package c.javapackage.sub;

public class AccessModifier {
    
    public void publicMethod() {
        
    }
    
    protected  void protectedMethod() {
        
    }
    
    void packagePrivateMethod() {
        
    }
    
    private void privateMethod() {
        
    }
}
```

```java
package c.javapackage;

import c.javapackage.sub.AccessModifier;

public class AccessCall {
  public static void main(String[] args) {
    AccessModifier accessModifier = new AccessModifier();
    accessModifier.publicMethod();
    accessModifier.protectedMethod();
    accessModifier.packagePrivateMethod();
    accessModifier.privateMethod();
  }
}
```

| | 해당 클래스 안에서 | 같은 패키지에서 | 상속 받은 클래스에서 | import한 클래스에서 |
|---|----|----|----|----|
| public | O | O | O | O |
| protected | O | O | O | X |
| (package private) | O | O | X | X |
| private | O | X | X | X | 

## 클래스 접근 제어자 선언할 때의 유의점
- 접근 권한은 인스턴스 변수와 클래스 변수에도 동일하게 적용
- 하나의 소스 파일에 여러개의 public 클래스 생성은 불가

