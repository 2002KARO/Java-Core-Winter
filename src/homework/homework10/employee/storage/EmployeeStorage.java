package homework.homework10.employee.storage;

import homework.homework10.employee.model.Company;
import homework.homework10.employee.model.Employee;

public class EmployeeStorage {

    private Employee[] employees = new Employee[10];
    private int size = 0;

    public void add(Employee employee) {
        if (employees.length == size) {
            extend();
        }
        employees[size++] = employee;
    }

    private void extend() {
        Employee[] tmp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, tmp, 0, size);
        employees = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);

        }
    }

    public void printByStatus(boolean active) {
        for (int i = 0; i < size; i++) {
            if (employees[i].isActive() == active) {
                System.out.println(employees[i]);
            }
        }
    }

    public Employee getEmployeeById(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                return employees[i];
            }

        }
        return null;
    }

    public void searchByCompany(Company company) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getCompany().equals(company)) {
                System.out.println(employee);

            }

        }
    }


    public void searchBySalaryRange(double minSalary, double maxSalary) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() >= minSalary
                    && employee.getSalary() <= maxSalary) {
                System.out.println(employee);
            }
        }
    }
}
