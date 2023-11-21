import java.io.Serializable;

public class EmployeeSerial implements Serializable {
    private static final long serialVersionUID = 1L;

    private int empId;
    private String empName;
    private String empDesignation;
    private int empSalary;

    public EmployeeSerial(int empId, String empName, String empDesignation, int empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDesignation='" + empDesignation + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}
