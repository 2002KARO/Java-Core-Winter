package homework.homework10.employee.model;

public class Company {

    // Company Data
    private String id; // Company ID
    private String name; // Company NAME
    private String address; // Company ADDRESS
    private String phoneNumber; // Company PHONE NUMBER
    private int countOfEmployees; // COUNT OF EMPLOYEES in Company

    // Constructor
    public Company(String id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // if Empty Constructor
    public Company(){};

    // Get/Set ID
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    // Get/Set Name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Get/Set Address
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    // Get/Set Phone Number
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // Get/Set Count Of Employees
    public int getCountOfEmployees() { return countOfEmployees; }
    public void setCountOfEmployees(int countOfEmployees) { this.countOfEmployees = countOfEmployees; }

    // Override toString;
    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", countOfEmployees='" + countOfEmployees + '\'' +
                '}';
    }
}
