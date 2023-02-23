package homework.homework10.employee.model;
import java.util.Objects;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Employee {

    // Date format objects
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdfFull = new SimpleDateFormat("dd/MM/yyyy HH:m:ss");

    // Employee Data
    private String name;
    private String surname;
    private String employeeID;
    private double salary;
    private Company company;
    private String position;
    private boolean active = true;
    private Date registerDate;
    private Date dateOfBirthday;

    // Employee Full Constructor
    public Employee(String name, String surname, String employeeID, double salary, Company company, String position, Date dateOfBirthday, Date registerDate) {
        this.name = name;
        this.surname = surname;
        this.employeeID = employeeID;
        this.salary = salary;
        this.company = company;
        this.position = position;
        this.dateOfBirthday = dateOfBirthday;
        this.registerDate = registerDate;
    }

    // If Empty Constructor
    public Employee() {
    }

    // GETTERS:
    public String getPosition() { return position; }
    public boolean isActive() { return active; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getEmployeeID() { return employeeID; }
    public double getSalary() { return salary; }
    public Company getCompany() { return company; }
    public Date getDateOfBirthday() { return dateOfBirthday; }
    public Date getRegisterDate() { return registerDate; }

    // SETTERS:
    public void setPosition(String position) { this.position = position; }
    public void setActive(boolean active) { this.active = active; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setEmployeeID(String employeeID) { this.employeeID = employeeID; }
    public void setSalary(double salary) { this.salary = salary;}
    public void setCompany(Company company) { this.company = company;}
    public void setDateOfBirthday(Date dateOfBirthday) { this.dateOfBirthday = dateOfBirthday; }
    public void setRegisterDate(Date registerDate) { this.registerDate = registerDate; }

    // OVERRIDES:
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", active=" + active +
                ", registerDate='" + sdfFull.format(registerDate) + '\'' +
                ", dateOfBirthday='" + sdf.format(dateOfBirthday) + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && active == employee.active && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(employeeID, employee.employeeID) && Objects.equals(company, employee.company) && Objects.equals(position, employee.position) && Objects.equals(registerDate, employee.registerDate) && Objects.equals(dateOfBirthday, employee.dateOfBirthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, employeeID, salary, company, position, active, registerDate, dateOfBirthday);
    }

}
