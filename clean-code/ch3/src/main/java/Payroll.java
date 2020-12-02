import java.util.Date;

public class Payroll {
    public Money calculatePay(Employee e) {
        switch (e.type) {
            case COMMISSIONED:
                return calculateCommissionedPay(e);
            case SALARIED:
                return calculateSalariedPay(e);
            case HOURLY:
                return calculateHourlyPay(e);
            default:
                throw new InvalidEmployeeType();
        }
    }

    public boolean isPayday(Employee e, Date date) {
        return false;
    }

    public Date deliverPay(Employee e, Money m) {
        return null;
    }

    public static class Employee {
        public EmployeeType type;

        enum EmployeeType {
            // 委托
            COMMISSIONED,
            // 小时
            HOURLY,
            // 薪水
            SALARIED
        }
    }

    static class Money {
    }

    Money calculateCommissionedPay(Employee e) {
        return null;
    }

    Money calculateSalariedPay(Employee e) {
        return null;
    }

    Money calculateHourlyPay(Employee e) {
        return null;
    }

    static class InvalidEmployeeType extends RuntimeException {

    }
}
