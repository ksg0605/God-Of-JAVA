public class SalaryManager {
    public double calculateHealthInsurance(double monthSalary) {
        double healthInsurance = monthSalary * (13.5/100);
        System.out.println("건강보험료 :" + healthInsurance);
        return healthInsurance;
    }
    public double calculateNationalPension(double monthSalary) {
        double nationalPension = monthSalary * (8.1/100);
        System.out.println("국민연금 :" + nationalPension);
        return nationalPension;
    }
    public double calculateTax(double monthSalary) {
        double tax = monthSalary * (12.5/100);
        System.out.println("근로소득세 :" + tax);
        return tax;
    }
    public double getMonthlySalary(int yearlySalary) {
        System.out.println("연봉 :" + yearlySalary);
        double monthlySalary = yearlySalary / 12.0;
        System.out.println("세전월급 :" + monthlySalary);
        double tax = calculateTax(monthlySalary);
        double nationalPension = calculateNationalPension(monthlySalary);
        double healthInsurance = calculateHealthInsurance(monthlySalary);
        double totalTax =  tax + nationalPension + healthInsurance;
        monthlySalary -= totalTax;
        return monthlySalary;
    }
    public static void main(String[] args) {
        SalaryManager salaryManager = new SalaryManager();
        double monthlySalary = salaryManager.getMonthlySalary(20000000);
        System.out.println("한달 실수령액은 " + monthlySalary + "원 입니다.");
    }
}