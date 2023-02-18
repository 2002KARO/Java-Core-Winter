package homework.employee;

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
        for (int i = 0; i < size; i++) {
            System.arraycopy(employees, 0, tmp, 0, size);
            employees = tmp;
        }

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);

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

    public void searchByCompanyName(String companyName) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if ((employee.getCompany().contains(companyName))) {
                System.out.println(employee);
            }


        }
    }


}
