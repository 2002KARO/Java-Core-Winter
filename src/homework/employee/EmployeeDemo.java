package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {
    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addEmployee();
                    break;
                case "2":
                    employeeStorage.print();
                    break;
                case "3":
                    System.out.println("Please input employee id");
                    String inputId = scanner.nextLine();
                    System.out.println(employeeStorage.getEmployeeById(inputId));
                    break;
                case "4":
                    System.out.println("Please input company name");
                    String companyName = scanner.nextLine();
                    employeeStorage.searchByCompanyName(companyName);
                    break;
                default:
                    System.out.println("wrong command try again");


            }

        }
    }

    private static void printCommands() {
        System.out.println("Please input 0 for exit ");
        System.out.println("Please input 1 for add employee");
        System.out.println("Please input 2 for print employees");
        System.out.println("Please input 3 for search employee by id");
        System.out.println("Please input 4 for search employees by company");
    }

    private static void getEmployeeById() {
        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Employee with" + employeeId + "does not exists");
        } else {
            System.out.println(employee);
        }
    }

    public static void addEmployee() {
        System.out.println("Please input name, surname,employeeId,salary,company,position");
        String employeeDataStr = scanner.nextLine();
        String[] employeeData = employeeDataStr.split(",");
        String employeeId = employeeData[2];
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee == null) {
            employee = new Employee(employeeData[0], employeeData[1],
                    employeeId, Double.parseDouble(employeeData[3]), employeeData[4], employeeData[5]);
            employeeStorage.add(employee);
            System.out.println("Employee was added");
        } else System.out.println("Employee with" + employeeId + "already exists!");
    }
}
