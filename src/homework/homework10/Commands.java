package homework.homework10;


    public interface Commands {

        String EXIT = "0";
        String ADD_EMPLOYEE = "1";
        String ADD_COMPANY = "2";
        String PRINT_EMPLOYEES = "3";
        String SEARCH_EMPLOYEE_BY_ID = "4";
        String SEARCH_EMPLOYEE_BY_COMPANY = "5";
        String SEARCH_EMPLOYEE_BY_SALARY_RANGE = "6";
        String CHANGE_EMPLOYEE_POSITION = "7";
        String PRINT_ONLY_ACTIVE_EMPLOYEES = "8";
        String INACTIVATE_EMPLOYEES = "9";
        String ACTIVATE_EMPLOYEES = "10";
        String PRINT_ALL_COMPANIES = "11";

        static void printCommands() {
            System.out.println("input: " + EXIT + ") for exit");
            System.out.println("       " + ADD_EMPLOYEE + ") for add employee");
            System.out.println("       " + ADD_COMPANY + ") for add company");
            System.out.println("       " + PRINT_EMPLOYEES + ") for print all employee");
            System.out.println("       " + SEARCH_EMPLOYEE_BY_ID + ") search employee by employee ID");
            System.out.println("       " + SEARCH_EMPLOYEE_BY_COMPANY + ") search employee by company name employee ID");
            System.out.println("       " + SEARCH_EMPLOYEE_BY_SALARY_RANGE + ") for search employee by salary range");
            System.out.println("       " + CHANGE_EMPLOYEE_POSITION + ") for change employee position by id");
            System.out.println("       " + PRINT_ONLY_ACTIVE_EMPLOYEES + ") for print only active employees");
            System.out.println("       " + INACTIVATE_EMPLOYEES + ") for inactive employee by id");
            System.out.println("       " + ACTIVATE_EMPLOYEES + ") for activate employee by id");
            System.out.println("       " + PRINT_ALL_COMPANIES + ") for print all companies");
        }

    }

