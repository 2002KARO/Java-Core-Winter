package homework.homework10.employee.storage;
import homework.homework10.employee.model.Company;
public class CompanyStorage {

// Storage
private Company[] array = new Company[10];
private int size = 0;

// Method for add companies in storage
public void add(Company value) {
        if (size == array.length) {
        extend();
        }
        array[size++] = value;
        }

// Method for not running out of storage space
private void extend() {
        Company[] newArr = new Company[array.length + 10];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
        }

// Method for print all companies
public void print() {
        for (int i = 0; i < size; i++) {
        System.out.println(array[i]);
        }
        }

// Get company by id
public Company getCompanyById(String id) {
        for (int i = 0; i < size; i++) {
        Company cmp = array[i];
        if (cmp.getId().equals(id)) {
        return cmp;
        }
        }
        return null;
        }

// Get size of storage
public int getSize() {
        return size;
        }

        }
