package homework.homework10.employee;
import homework.homework10.Commands;
import homework.homework10.employee.model.Company;
import homework.homework10.employee.model.Employee;
import homework.homework10.employee.storage.CompanyStorage;
import homework.homework10.employee.storage.EmployeeStorage;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class EmployeeDemo implements Commands {

    // -OBJECTS: Scanner; Employee Storage; Company Storage; Date; Simple Date Format
    static Scanner sc = new Scanner(System.in);
    static EmployeeStorage es = new EmployeeStorage();
    static CompanyStorage cs = new CompanyStorage();
    static Date birthdayDate = new Date();
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {

        // boolean for inf run OR if input 0 -> end program
        boolean isRun = true;

        // inf while
        while (isRun) {

            // print commands
            Commands.printCommands();

            // input command number
            String command = sc.nextLine();

            // check command number
            switch (command) {

                // end program
                case EXIT:
                    isRun = false;
                    break;

                // adding new employee
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;

                // adding new employee
                case ADD_COMPANY:
                    addCompany();
                    break;

                // print all employees
                case PRINT_EMPLOYEES:
                    es.print();
                    break;

                // search employee by ID
                case SEARCH_EMPLOYEE_BY_ID:
                    System.out.print("please input employee's ID: ");
                    String id = sc.nextLine();
                    es.searchById(id);
                    break;

                // search employee by company name
                case SEARCH_EMPLOYEE_BY_COMPANY:
                    cs.print();
                    System.out.print("please input company id: ");
                    String cmpId = sc.nextLine();
                    Company companyByID = cs.getCompanyById(cmpId);
                    if (companyByID != null) {
                        System.out.println(es.searchByCompany(cmpId));
                    } else {
                        System.out.println("Company with id (" + cmpId + ") not exist");
                    }
                    break;

                // search employee by salary range
                case SEARCH_EMPLOYEE_BY_SALARY_RANGE:
                    System.out.print("\nfrom: ");
                    String fromNum = sc.nextLine();
                    System.out.print("to: ");
                    String toNum = sc.nextLine();
                    es.searchBySalaryRange(Double.parseDouble(fromNum), Double.parseDouble(toNum));
                    break;

                // change employee position by id
                case CHANGE_EMPLOYEE_POSITION:
                    System.out.print("please input employee's id: ");
                    String empId = sc.nextLine();
                    System.out.print("please input new position: ");
                    String newPosition = sc.nextLine();

                    es.positionChangeById(empId, newPosition);
                    break;

                // print all active employees
                case PRINT_ONLY_ACTIVE_EMPLOYEES:
                    es.getActiveEmp();
                    break;

                // inactivate employee
                case INACTIVATE_EMPLOYEES:
                    System.out.print("please input employee's id: ");
                    String eId = sc.nextLine();
                    es.inactiveEmp(eId);
                    break;

                // activate employee
                case ACTIVATE_EMPLOYEES:
                    System.out.print("please input employee's id: ");
                    String emId = sc.nextLine();
                    es.activateEmp(emId);
                    break;

                // print all companies
                case PRINT_ALL_COMPANIES:
                    cs.print();
                    break;

                // if inputted command wrong
                default:
                    System.out.println("wrong command please try again!");
            }
        }

    }

    // Method for adding new company
    private static void addCompany() {
        System.out.print("please input company id: ");
        String cmpID = sc.nextLine();
        System.out.print("please input company name: ");
        String cmpName = sc.nextLine();
        System.out.print("please input company address: ");
        String cmpAddress = sc.nextLine();
        System.out.print("please input company phone number: ");
        String cmpPhoneNumber = sc.nextLine();
        Company newCompany = new Company(cmpID, cmpName, cmpAddress, cmpPhoneNumber);
        cs.add(newCompany);
    }

    // CountOfEmployees++ if added an employee
    private static void addCountOfEmployeesOfCompany(String ID){
        Company cmp = cs.getCompanyById(ID);
        if(cmp != null){
            cmp.setCountOfEmployees(cmp.getCountOfEmployees() + 1);
        }
    }

    // Method for adding new employee
    private static void addEmployee() throws ParseException {
        if (cs.getSize() == 0) { // if Company Storage is empty
            System.out.println("Error: No companies");
            System.out.println("Please create at least one company first!");
            addCompany();
            System.out.println("Nice, now you can add an employee");
            addEmployee();
        } else {
            cs.print(); // print all companies
            System.out.print("Please choose company id: ");
            String chooseId = sc.nextLine();
            Company company = cs.getCompanyById(chooseId);
            if (company == null) { // if inputted id is wrong
                System.out.println("Wrong company id, please try again!");
                addEmployee();
            } else {
                System.out.print("\ninput name: ");
                String name = sc.nextLine();
                System.out.print("input surname: ");
                String surname = sc.nextLine();
                System.out.print("input employee ID: ");
                String empId = sc.nextLine();
                System.out.print("input salary: ");
                String salary = sc.nextLine();
                System.out.print("input position: ");
                String position = sc.nextLine();
                System.out.print("input birthday date (dd/MM/yyyy): ");
                String dateOfBirthday = sc.nextLine();

                birthdayDate = sdf.parse(dateOfBirthday);
                Date regDate = new Date();

                // if the input id is already in use
                while (es.idChecker(empId)) {
                    System.out.println("\nThis ID already exist! Try Another!");
                    System.out.print("input ID: ");
                    empId = sc.nextLine();
                }

                // Add employee
                Employee employee = new Employee(name, surname, empId, Double.parseDouble(salary), company, position, birthdayDate, regDate);
                es.add(employee);
                addCountOfEmployeesOfCompany(company.getId());

                System.out.println("\nEmployee was added");
            }
        }

    }

}
