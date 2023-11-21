public class EmployeeTest {
    public static void main(String[] args) {
        Employee visagan = new Employee("Visagan", "S", 150000);
        // Employee tamil = new Employee("Tamil", "Arasan", 120000);

        System.out.println("Visagan Yearly Salary: " + visagan.getMonthlySalary());
    }
}