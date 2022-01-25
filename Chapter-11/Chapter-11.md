#11장 매번 만들기 귀찮은데 누가 만들어 놓은 거 쓸 수 없나요?
## 미리 만들어 놓은 클래스들은 아주 많아요
- API : 많은 클래스를 사용할 때 참조하는 문서
- 애플리케이션에 선언되어 있는 클래스와 메소드에 대한 상세한 설명이 포함된 문서
- 소스 내에 클래스 및 메소드를 선언하기 전이나 후에 API에 명시되도록 하기 위한 주석만 상세하게 달면 된다.
- javadoc 명령어 실행하면 자동으로 문서 생성

## API를 열어보자
## 클래스 및 인터페이스의 상세 정보 화면을 살펴보자
### 패키지와 클래스 / 인터페이스 이름
### 클래스 상속 관계 다이어그램
### 직속 자식 클래스
### 알려진 모든 하위 인터페이스 목록(All Known Subinterfaces) : 인터페이스에만 존재함
### 알려진 모든 구현한 클래스 목록(All Known Implementing Classes) : 인터페이스에만 존재함
### 클래스 / 인터페이스의 선언 상태
### 클래스 / 인터페이스의 설명
### 내부 클래스 종합
### 상수 필드 종합
### 생성자 종합
### 메소드 종합
### 부모 클래스로부터 상속받은 메소드들
### 상수 필드 상세 설명
### 생성자 상세 설명
### 메소드 상세 설명

## Deprecated라고 표시되어 있는 것은 뭐야?
- 이제 이건 안 쓰는거야
```java
package c.api;

public class APICheck {
    public static void main(String[] args) {
        APICheck apiCheck = new APICheck();
        apiCheck.useDeprecated();
    }
    
    public void useDeprecated() {
        String str = "abcde";
        byte [] strBytes = str.getBytes();
        String convertedStr = new String(strBytes, 0);
    }
}
```

## Header와 Footer에 있는 링크들은 뭘까?
전체에서 세부적인 설명들을 볼 수 있다.
