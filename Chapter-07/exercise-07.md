# 7장 연습문제
1. 키를 관리하는 ManageHeight 라는 클래스를 만들고 main() 메소드도 만들자.
2. 각 반별로 학생의 수는 다음과 같다. 이 데이터를 클래스의 인스턴스 변수로 int 타입의 gradeHeights 라는 2차원 배열을 선언하자.  
이 데이터는 public void setData() 메소드에서 지정하자.   

|반|학생수|1번부터의 키|
|---|---|----|
|1|5|17-, 180, 173, 175, 177|
|2|4|160, 165, 167, 186|
|3|4|158, 177, 187, 176|
|4|3|173, 182, 181|
|5|5|170, 180, 165, 177, 172|

3. 반 번호를 매개 변수로 넘겨주면 해당 반 학생들의 키를 번호 순대로 출력하는 public void printHeight(int classNo) 라는 메소드를 만들자.
4. main() 메소드에서 setData() 메소드를 호출하여 데이터를 지정하고, printHeight() 메소드를 for 루프를 사용하여 1반 ~ 5반 까지 호출하자.
5. 각 반별 키의 평균을 계산하여 출력하는 public void printAverage(int classNo) 메소드를 만들자.  
매개 변수인 classNo는 반 번호를 의미한다. 단 여기서, 평균을 구하기 위한 합을 저장하는 변수는 double로 지정한다.  
6. main() 메소드에서 printHeight() 를 호출하는 부분만 주석 처리하고, printAverage() 메소드를 while 루프를 사용하여 1반~5반까지 호출하자.

```java
public class ManageHeight {
    int gradeHeight[][];

    public static void main(String[] args) {
        ManageHeight manageHeight = new ManageHeight();
        manageHeight.setData();
//        manageHeight.printHeight(1);
//        manageHeight.printHeight(2);
//        manageHeight.printHeight(3);
//        manageHeight.printHeight(4);
//        manageHeight.printHeight(5);
        int loops = 0;
        while(loops < 5) {
            loops ++;
            manageHeight.printAverage(loops);
        }
    }

    public void setData() {
        gradeHeight = new int [5][];
        gradeHeight[0] = new int [] { 170, 180, 173, 175, 177 };
        gradeHeight[1] = new int [] { 160, 165, 167, 186 };
        gradeHeight[2] = new int [] { 158, 177, 187, 176 };
        gradeHeight[3] = new int [] { 173, 182, 181 };
        gradeHeight[4] = new int [] { 170, 180, 165, 177, 172 };
    }

    public void printHeight(int classNo) {
        System.out.println("Class No.:" + classNo);
        for(int height : gradeHeight[classNo- 1 ]) {
            System.out.println(height);
        }
    }

    public void printAverage(int classNo) {
        double sum = 0;
        System.out.println("Class No.:" + classNo);
        int studentsNumber = gradeHeight[classNo - 1].length;
        for(int height : gradeHeight[classNo - 1]) {
            sum += height;
        }
        double average = sum / studentsNumber;
        System.out.println("Height average :" + average);
    }
}
```
---
1. 배열을 선언할 때 어떤 키워드를 타입 앞이나 뒤에 사용해야 하나요?  
[]
2. 배열의 첫번째 위치는 0인가요? 1인가요?  
0
3. 배열을 선언할 때 boolean 배열의 크기만 지정했다면 boolean 배열의 [0] 위치에 있는 값은 무엇인가요?  
false
4. ArrayIndexOutOfBoundsException이라는 것은 언제 발생하나요?  
초기화한 배열의 갯수보다 많을 때
5. 중괄호를 이용하여 배열을 초기화할 때 중괄호 끝에 반드시 어떤 것을 입력해 주어야 하나요?  
;
6. 2차원 배열을 정의할 때에는 대괄호를 몇 개 지정해야 하나요?  
[][] 2개
7. 배열을 쉽게 처리해주는 for 문의 문법은 어떻게 되나요?  
for(임시 변수 값 : 탐색할 배열)
8. 자바 프로그램에 데이터를 전달해 주려면 클래스 이름 뒤에 어떻게 구분하여 나열하면 되나요?  
공백
9. 자바 프로그램이 시작할 때 전달 받는 내용은 어떤 타입의 배열인가요?  
String