import Employee;

package observation_programs;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee joe = new Employee("Joe", "Rogan", 9696);
        Employee tod = new Employee("Tod", "Howard", 8595);
        System.out.println(joe.getFirstName() + "'s monthly salary is " + joe.getMonthlySalary());
        System.out.println(tod.getFirstName() + "'s monthly salary is " + tod.getMonthlySalary());

        joe.applyRaise(10);
        tod.applyRaise(10);

        System.out.println("Salary after 10% boost");
        System.out.println(joe.getFirstName() + "'s monthly salary is " + joe.getMonthlySalary());
        System.out.println(tod.getFirstName() + "'s monthly salary is " + tod.getMonthlySalary());
    }
}