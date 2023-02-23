package homework.homework10.employee.storage;
import homework.homework10.employee.model.Employee;


public class EmployeeStorage {

    // Storage
    private Employee[] array = new Employee[10];
    private int size = 0;

    // Method for add employee in storage
    public void add(Employee value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    // Method for not running out of storage space
    private void extend() {
        Employee[] newArr = new Employee[array.length + 10];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }

    // Method for print all employees
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    // Search By Employee's id
    public void searchById(String id) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Employee employee = array[i];
            if (employee.getEmployeeID().equals(id)) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Error: Employ with id (" + id + ") not found");
        }
    }

    // Search employee by company ID
    public Employee searchByCompany(String companyId) {
        for (int i = 0; i < size; i++) {
            Employee employee = array[i];
            if (employee.getCompany().getId().equals(companyId)) {
                return employee;
            }
        }
        return null;
    }

    // true/false: is there such an id in storage?
    public boolean idChecker(String newId) {
        for (int i = 0; i < size; i++) {
            Employee employee = array[i];
            if (employee.getEmployeeID().equals(newId)) {
                return true;
            }
        }
        return false;
    }

    // Search employee by salary range
    public void searchBySalaryRange(double from, double to) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Employee emp = array[i];
            if (emp.getSalary() >= from && emp.getSalary() <= to) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("employee with earnings from " + from + " to " + to + " was not found");
        }
    }

    // Change employee position by id
    public void positionChangeById(String empId, String pos) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Employee emp = array[i];
            if (emp.getEmployeeID().equals(empId)) {
                emp.setPosition(pos);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employee with id (" + empId + ") not found");
        }
    }

    // Get and print all active employees
    public void getActiveEmp() {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Employee emp = array[i];
            if (emp.isActive()) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found active employee");
        }
    }

    // inactive employee by id
    public void inactiveEmp(String eId) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Employee emp = array[i];
            if (emp.getEmployeeID().equals(eId)) {
                found = true;
                emp.setActive(false);
            }
        }
        if (!found) {
            System.out.println("Employee with id (" + eId + ") not found");
        }
    }

    // activate employee by id
    public void activateEmp(String eId) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Employee emp = array[i];
            if (emp.getEmployeeID().equals(eId)) {
                found = true;
                emp.setActive(true);
            }
        }
        if (!found) {
            System.out.println("Employee with id (" + eId + ") not found");
        }
    }

}
