class InterestManager {
    public static void main(String[] args) {
        InterestManager interestManager = new InterestManager();
        for(int day=1;day<=365;day+=10) {
            int amount = 1000000;
            double calculatedAmount = interestManager.calculateAmount(day, amount);
            System.out.println(day + "일의 예금이자는" + calculatedAmount + "입니다.");
        }
    }
    public double getInterestRate(int day) {
        double rate = 0;
        if(day <= 90) {
            return rate = (0.5 / 100);
        }
        else if(day <= 180) {
            return rate = 0.01;
        }
        else if(day <= 364) {
            return rate = 0.02;
        }
        else {
            return rate = 0.0056;
        }
    }
    public double calculateAmount(int day, long amount) {
        double calculatedAmount = 0.00;
        double rate = 0.00;
        rate = getInterestRate(day);
        calculatedAmount = amount * rate;
        return calculatedAmount;
    }
}