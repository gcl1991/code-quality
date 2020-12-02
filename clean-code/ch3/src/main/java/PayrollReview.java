import java.util.Date;

public class PayrollReview {
    public class EmployeeFactoryImpl implements EmployeeFactory {
        public Employee makeEmployee(EmployeeRecord r) {
            switch (r.type){
                case COMMISSIONED:
                    return new CommissionedEmployee(r);
                case SALARIED:
                    return new SalariedEmployee(r);
                case HOURLY:
                    return new HourlyEmployee(r);
                default:
                    throw new InvalidEmployeeType();
            }
        }
    }

    public abstract class  Employee{
        public abstract boolean isPayday();
        public abstract Money calculatePay();
        public abstract void deliverPay();
    }

    public class CommissionedEmployee extends Employee{
        CommissionedEmployee(EmployeeRecord e){
        }

        public boolean isPayday() {
            return false;
        }

        public Money calculatePay() {
            return null;
        }

        public void deliverPay() {

        }
    }

    public class SalariedEmployee extends Employee{
        SalariedEmployee(EmployeeRecord e){
        }

        public boolean isPayday() {
            return false;
        }

        public Money calculatePay() {
            return null;
        }

        public void deliverPay() {

        }
    }
    public class HourlyEmployee extends Employee{
        HourlyEmployee(EmployeeRecord e){
        }

        public boolean isPayday() {
            return false;
        }

        public Money calculatePay() {
            return null;
        }

        public void deliverPay() {

        }
    }

    public static class EmployeeRecord{
        Payroll.Employee.EmployeeType type;
    }

    static class Money{
    }

    public interface EmployeeFactory{
        public Employee makeEmployee(EmployeeRecord r);
    }

    static class InvalidEmployeeType extends RuntimeException{

    }
}
