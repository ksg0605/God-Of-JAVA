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

