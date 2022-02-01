# 16장 클래스 안에 클래스가 들어갈 수도 있구나
## 클래스 안의 클래스
- Nested 클래스
- 코드를 간단하게 표현하기 위함
  - Static nested 클래스
  - inner 클래스
    - 로컬 내부 클래스
    - 익명 내부 클래스   
    
Nested 클래스를 만드는 이유
- 한 곳에서만 사용되는 클래스를 논리적으로 묶어서 처리할 필요가 있을 떄
- 캡슐화가 필요할 때 (예를 들어 A 라는 클래스에 private 변수가 있다. 이 변수에 접근하고 싶은 B 라는 클래스를 선언하고, B 클래스를 외부에 노출시키고 싶지 않을 경우)
- 소스의 가독성과 유지보수성을 높이고 싶을 때

## Static nested 클래스의 특징
- 내부 클래스는 감싸고 있는 외부 클래스의 어떤 변수도 접근할 수 있다.
- private 로 선언된 변수까지도 접근 가능
- Static은 불가능
- 겉으로 보기에는 유사하지만, 내부적으로 구현이 달라야 할 때 static nested 클래스 사용

## 내부 클래스와 익명 클래스
- 캡술화 때문에 사용
- 하나의 클래스에서 어떤 공통적인 작업을 수행하는 클래스가 필요한데 다른 클래스에서는 그 클래스가 전혀 필요가 없을 때 내부 클래스를 만들어 사용
- GUI 에서 Listener 를 처리할 때

## Nested 클래스의 특징은 꼭 알아야 한다.
- 감싸고 있는 클래스의 static 변수만 참조할 수 있다.
- 클래스가 static으로 선언되어 있기 때문에 부모 클래스에 static 하지 않은 변수를 참조할 수는 없다.
- 내부 클래스와 익명 클래스는 감싸고 있는 클래스의 어떤 변수라도 참조할 수 있다.
