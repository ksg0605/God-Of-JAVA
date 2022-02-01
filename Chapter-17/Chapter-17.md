# 17장 어노테이션이라는 것도 알아야 한다.
## 어노테이션이란?
- 클래스나 메소드 등의 선언시에 @를 사용하는 것을 말한다.
- 메타데이터   

어노테이션은
- 컴파일러에게 정보를 알려주거나
- 컴파일할 때와 설치시의 작업을 지정하거나
- 실행할 때 별도의 처리가 필요할 때 샤용

## 미리 정해져 있는 어노테이션들은 딱 3개뿐
- @Override
- @Deprecated
- @SuppressWarnings

### @Override
- 해당 메소드가 부모 클래스에 있는 메소드를 Override 했다는 것을 명시적으로 선언

### @Deprecated
- 미리 만들어져 있는 클래스나 메소드가 더 이상 사용되지 않는 경우

### @SuppressWarnings
- 내가 일부러 이렇게 코딩한 거니까 니가 경고를 해 줄 필요가 없어

```java
package c.inheritance;

public class Parent {
    
    public Parent() {
        System.out.println("Parent Constructor");
    }
    
    public Parent(String name) {
        System.out.println("Parent(String) Constructor");
    }
    
    public void printName() {
        System.out.println("printName() - Parent");
    }
}
```

```java
package c.annotation;

import c.inheritance.Parent;

public class AnnotationOverride extends Parent {
    @Override
    public void printName() {
        System.out.println("AnnotationOverride");
    }
}
```

## 어노테이션을 선언하기 위한 메타 어노테이션
- @Target
- @Retention
- @Documented
- @Inherited

### @Target
- 어노테이션을 어떤 것에 적용할지를 선언할 때 사용
```java
@Target(ElementType.METHOD)
```
- 괄호 안에 적용 대상을 지정  

| 요소 타입 | 대상 |
|----|---|
| CONSTRUCTOR | 생성자 선언시 |
| FIELD | enum 상수를 포함한 필드(field) 값 선언시 |
| LOCAL_VARIABLE | 지역 변수 선언시 |
| METHOD | 메소드 선언시 |
| PACKAGE | 패키지 선언시 |
| PARAMETER | 매개 변수 선언시 |
| TYPE | 클랫, 인터페이스, enum 등 선언시 |

### @Retention
- 얼마나 오래 어노테이샨 정보가 유지되는지를 선언  

| | 대상 |
|---|---|
| SOURCE | 어노테이션 정보가 컴파일시 사라짐 |
 CLASS | 클래스 파일에 있는 어노테이션 정보가 컴파일러에 의해서 참조 가능함. 하지만, 가상 버신에서는 사라짐 |
| RUNTIME | 실행시 어노테이션 정보가 가상 머신에 의해서 참조 가능 |

### @Documented
- 어노테이션에 대한 정보가 Javadocs(API) 문서에 포함된다는 것을 선언

### @Inherited
- 모든 자식 클래스에서 부모 클래스의 어노테이션을 사용 가능하다는 것을 선언

## 어노테이션을 선언해 보자
```java
package c.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnotation {
    public int number();
    public String text() default "This is first annotation";
}

```

## 어노테이션에 선언한 값은 어떻게 확인하지?
- 리플렉션 API 사용

## 어노테이션도 상속이 안 돼요

