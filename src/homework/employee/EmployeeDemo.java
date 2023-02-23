package homework.employee;

import homework.employee.model.Employee;
import homework.employee.storage.EmployeeStorage;
import homework.employee.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class EmployeeDemo {
    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;

        employeeStorage.add(new Employee("Jack", "Daniels", "a001", 100, "company 1", "manager",true,new Date(),DateUtil.StringToDate("02/01/2022")));
        employeeStorage.add(new Employee("Daniel", "Time", "a002", 200, "company 1", "manager middle",true,new Date(),DateUtil.StringToDate("03/02/2011")));
        employeeStorage.add(new Employee("Mike", "Smart", "a003", 300, "company 1", "manager senior",true,new Date(),DateUtil.StringToDate("04/07/2009")));
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
                case "5":
                    searchEmployeesBySalaryRange();
                case "6":
                    changeEmployeePositionById();
                    break;
                case "7":
                    employeeStorage.printByStatus(true);
                    break;
                case "8":
                    inactivateEmployeeById();
                    break;
                case "9":
                    activateEmployeeById();
                    break;
                default:
                    System.out.println("wrong command try again");


            }

        }
    }

    private static void inactivateEmployeeById() {
        employeeStorage.printByStatus(true);
        System.out.println("Please choose employee id ");
        String employeeId = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee != null) {
            employee.setActive(false);
            System.out.println("Employee inactivated");
        } else {
            System.out.println("Employee does not exists,please try again.");
        }
    }

    private static void activateEmployeeById() {
        employeeStorage.printByStatus(false);
        System.out.println("Please choose employee id ");
        String employeeId = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee != null && !employee.isActive()) {
            employee.setActive(true);
            System.out.println("Employee activated");
        } else {
            System.out.println("Employee does not exists,or employee active, please try again.");
        }
    }

    private static void changeEmployeePositionById() {
        employeeStorage.print();
        System.out.println("please choose employee id");
        String employeeId = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee != null) {
            System.out.println("Please input new position");
            String newPosition = scanner.nextLine();
            employee.setPosition(newPosition);
            System.out.println("Position changed!");
        } else {
            System.out.println("Employee does not exists,please try again.");
        }


    }

    private static void searchEmployeesBySalaryRange() {
        System.out.println("Please input min, max");
        String salaryRangeStr = scanner.nextLine();
        String[] salaryRange = salaryRangeStr.split(",");
        double minSalary = Double.parseDouble(salaryRange[0]);
        double maxSalary = Double.parseDouble(salaryRange[1]);
        if (maxSalary > maxSalary) {
            System.out.println("min salary should be less then max salary");

        } else {
            employeeStorage.searchBySalaryRange(minSalary, maxSalary);

        }

    }


    private static void printCommands() {
        System.out.println("Please input 0 for exit ");
        System.out.println("Please input 1 for add employee");
        System.out.println("Please input 2 for print employees");
        System.out.println("Please input 3 for search employee by id");
        System.out.println("Please input 4 for search employees by company");
        System.out.println("Please input 5 for search employees by salary range");
        System.out.println("Please input 6 for change employee position by id");
        System.out.println("Please input 7 for print only active employees");
        System.out.println("Please input 8 for inactivate employees by id ");
        System.out.println("Please input 9 for activate employee by id");


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

    public static void addEmployee() throws ParseException {
        System.out.println("Please input name, surname,employeeId,salary,company,position,DateOfBirthday(15/04/1994)");
        String employeeDataStr = scanner.nextLine();
        String[] employeeData = employeeDataStr.split(",");
        String employeeId = employeeData[2];
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee == null) {
            Date registerDate = new Date();
            Date dateOfBirthday = DateUtil.StringToDate(employeeData[6]);
            employee = new Employee(employeeData[0], employeeData[1],
                    employeeId, Double.parseDouble(employeeData[3]), employeeData[4], employeeData[5],true, registerDate,dateOfBirthday);
            employeeStorage.add(employee);
            System.out.println("Employee was added");
        } else System.out.println("Employee with" + employeeId + "already exists!");
    }
}
