package c.string;

public class StringCheck {

    public static void main(String[] args) {
        StringCheck stringCheck = new StringCheck();

        String addresses[] = new String[] {
                "서울시 구로구 신도림동",
                "경기도 성남시 분당구 정자동 개발 공장",
                "서울시 구로구 개봉동",
        };

        System.out.println("checkAddress");
        stringCheck.checkAddress(addresses);
        System.out.println("containsAddress");
        stringCheck.containsAddress(addresses);
    }

    public void checkAddress(String[] addresses) {
        int startCount = 0;
        int endCount = 0;
        String startText = "서울시";
        String endText = "동";
        for (String address : addresses) {
            if (address.startsWith(startText)) {
                startCount ++;
            }
            if (address.endsWith(endText)) {
                endCount ++;
            }
        }
        System.out.println("Starts with " + startText + " count is " + startCount);
        System.out.println("Ends with " + endText + " count is " + endCount);
    }

    public void containsAddress(String[] addresses) {
        int containCount = 0;
        String containText = "구로";

        for (String address : addresses) {
            if (address.contains(containText)) {
                containCount ++;
            }
        }

        System.out.println("Contains " + containText + " count is " + containCount);
    }
}