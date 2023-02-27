package homework.homework10.employee;

import homework.homework10.employee.model.Company;
import homework.homework10.employee.model.Employee;
import homework.homework10.employee.storage.CompanyStorage;
import homework.homework10.employee.storage.EmployeeStorage;
import homework.homework10.employee.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class EmployeeDemo implements Commands {
    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employeeStorage = new EmployeeStorage();
    static CompanyStorage companyStorage = new CompanyStorage();

    public static void main(String[] args) throws ParseException {

        boolean isRun = true;
        Company company = new Company("c001", "Tony", "New York", "093371335");
        company.setCountOfEmployees(3);
        companyStorage.add(company);
        employeeStorage.add(new Employee("Jack", "Braun", "A1", 100, company, "junior manager", true, new Date(), DateUtil.stringToDate("12/02/2022")));
        employeeStorage.add(new Employee("Daniel", "Ball", "A2", 200, company, " middle manager", true, new Date(), DateUtil.stringToDate("08/13/2018")));
        employeeStorage.add(new Employee("Bobby", "Barber", "A3", 300, company, " senior manager", true, new Date(), DateUtil.stringToDate("01/04/2012")));

        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case ADD_COMPANY:
                    addCompany();
                    break;
                case PRINT_EMPLOYEES:
                    employeeStorage.print();
                    break;
                case SEARCH_EMPLOYEE_BY_ID:
                    getEmployeeById();
                    System.out.println("Please input employee id");
                    String inputId = scanner.nextLine();
                    System.out.println(employeeStorage.getEmployeeById(inputId));
                    break;
                case SEARCH_EMPLOYEE_BY_COMPANY:
                    companyStorage.print();
                    System.out.println("Please input company id ");
                    String companyId = scanner.nextLine();
                    Company companyById = companyStorage.getCompanyById(companyId);
                    if (companyById != null) {
                        employeeStorage.searchByCompany(companyById);
                    } else {
                        System.out.println("Company does not exists!");
                    }
                    break;
                case CHANGE_EMPLOYEE_BY_SALARY_RANGE:
                    searchEmployeesBySalaryRange();
                    break;
                case CHANGE_EMPLOYEE_POSITION:
                    changeEmployeePositionById();
                    break;
                case PRINT_ONLY_ACTIVE_EMPLOYEES:
                    employeeStorage.printByStatus(true);
                    break;
                case INACTIVATE_EMPLOYEES:
                    inactivateEmployeeById();
                    break;
                case ACTIVATE_EMPLOYEES:
                    activateEmployeeById();
                    break;
                case PRINT_ALL_COMPANIES:
                    companyStorage.print();
                    break;
                default:
                    System.out.println("wrong command, try again!");
            }
        }

    }

    private static void addCompany() {
        System.out.println("Please input company id,name,address,phone");
        String companyDataStr = scanner.nextLine();
        String[] companyData = companyDataStr.split(",");
        String companyId = companyData[0];
        Company companyById = companyStorage.getCompanyById(companyId);
        if (companyById == null) {
            Company company = new Company(companyId, companyData[1], companyData[2], companyData[3]);
            companyStorage.add(company);
            System.out.println("Company added!");
        } else {
            System.out.println("Company with" + companyId + "already exists");

        }
    }


    private static void inactivateEmployeeById() {
        employeeStorage.printByStatus(true);
        System.out.println("Please choose employee id");
        String employeeId = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee != null) {
            employee.setActive(false);
            employee.getCompany().setCountOfEmployees(employee.getCompany().getCountOfEmployees() - 1);
            System.out.println("Employee inactivated");
        } else {
            System.out.println("Employee does not exists,please try again.");
        }

    }

    private static void activateEmployeeById() {
        employeeStorage.printByStatus(false);
        System.out.println("Please choose employee id");
        String employeeId = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee != null && !employee.isActive()) {
            employee.setActive(true);
            System.out.println("Employee activated");
        } else {
            System.out.println("Employee does not exists, or employee already active,please try again.");
        }

    }

    private static void changeEmployeePositionById() {
        employeeStorage.print();
        System.out.println("Please choose employee id");
        String employeeId = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee != null) {
            System.out.println("Please input new position");
            String newPosition = scanner.nextLine();
            employee.setPosition(newPosition);
            System.out.println("Position changed");
        } else {
            System.out.println("Employee does not exists,please try again.");
        }

    }

    private static void searchEmployeesBySalaryRange() {
        System.out.println("Please input min,max");
        String salaryRangeStr = scanner.nextLine();
        String[] salaryRange = salaryRangeStr.split(",");
        try {
            double minSalary = Double.parseDouble(salaryRange[0]);
            double maxSalary = Double.parseDouble(salaryRange[1]);
            if (maxSalary < minSalary) {
                System.out.println("min salary should be less then max salary");
                return;
            }
            employeeStorage.searchBySalaryRange(minSalary, maxSalary);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect number values please try again");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please input min and max salary");
        }
    }


    private static void getEmployeeById() {
        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Employee with" + employeeId + " does not exists");
        } else {
            System.out.println(employee);
        }
    }
    private static void addEmployee() throws ParseException {
        if (companyStorage.getSize() == 0) {
            System.out.println("Please add company first!! ");
            return;
        }
        companyStorage.print();
        System.out.println("Please choose company id");
        String companyId = scanner.nextLine();
        Company companyById = companyStorage.getCompanyById(companyId);
        if (companyById != null) {
            System.out.println("Please input name, surname, employeeId, salary,  position,dateOfBirthday(15/04/1994");
            String employeeDataStr = scanner.nextLine();
            String[] employeeData = employeeDataStr.split(",");
            String employeeId = employeeData[2];
            Employee employee = employeeStorage.getEmployeeById(employeeId);
            if (employee == null) {
                Date registerDate = new Date();
                Date dateOfBirthday = DateUtil.stringToDate(employeeData[5]);
                Employee newEmployee = new Employee(employeeData[0], employeeData[1], employeeId,
                        Double.parseDouble(employeeData[3]), companyById,
                        employeeData[4], true, registerDate, dateOfBirthday);
                employeeStorage.add(newEmployee);
                companyById.setCountOfEmployees(companyById.getCountOfEmployees() + 1);
                System.out.println("Employee was added");
            } else {
                System.out.println("employee with" + employeeId + "already exists!!!");
            }


        }
    }
}



