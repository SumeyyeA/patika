package MaasHesaplayici;

import java.time.Year;

public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (salary < 1000) {
            return 0;
        } else {
            return salary * 0.03;
        }
    }

    public double bonus() {
        int extraHours = Math.max(workHours - 40, 0);
        return extraHours * 30;
    }

    public double raiseSalary() {
        int yearsOfWork = Year.now().getValue() - hireYear;

        if (yearsOfWork < 10) {
            return salary * 0.05;
        } else if (yearsOfWork < 20) {
            return salary * 0.1;
        } else {
            return salary * 0.15;
        }
    }

    public double getSalaryWithTaxAndBonus() {
        return salary - tax() + bonus();
    }

    public double getTotalSalary() {
        return salary + raiseSalary();
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nSalary: " + salary +
                "\nWork Hours: " + workHours +
                "\nHire Year: " + hireYear +
                "\nTax: " + tax() +
                "\nBonus: " + bonus() +
                "\nSalary Increase: " + raiseSalary() +
                "\nSalary with Tax and Bonus: " + getSalaryWithTaxAndBonus() +
                "\nTotal Salary: " + getTotalSalary();
    }
}
