package Human_Resource.Controller;

import Human_Resource.Model.EmployeeModel;
import Human_Resource.Unity.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    static Scanner scanner = new Scanner(System.in);

    public static void registerController() {
        System.out.println("Regist new account !!!");
        System.out.println("New account: ");
        String account = scanner.nextLine();
        //kiem tra account ton tai hay chua
        if (EmployeeModel.checkExistAccount(account)) {
            System.out.println("This account already exists, pls try again !!!");
            return;
        }
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your address: ");
        String address = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        Employee employee = new Employee(name, address, email, account, password);
        System.out.println("Please confirm new account creation, Y = Yes N = No: ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("N")) {
            System.out.println("Thanks, goodbye !!!");
            return;
        } else if (choice.equalsIgnoreCase("Y")) {
            EmployeeModel.register(employee);
            System.out.println("Sign Up Success !!!");
        }
    }

    public static void loginController() {
        List<Employee> employeeList = EmployeeModel.selectEmployeeList();
        if (employeeList == null) {
            return;
        }
        System.out.println("Account: ");
        String account = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        Employee employeeResult = null;
        for (Employee employee : employeeList
        ) {
            if (employee.getAccount().equals(account) && employee.getPassword().equals(password)) {
                employeeResult = employee;
                break;
            }
        }
        if (employeeResult != null) {
            System.out.println("Logged in successfully !!!!\nWellcomeback !!!\nYour information: ");
            System.out.println(String.format("|%5s%15s%5s|%5s%20s%5s|%5s%25s%5s|%5s%20s%5s|%5s%15s%10s|%5s%20s%5s|",
                    "", "account", "",
                    "", "name", "",
                    "", "address", "",
                    "", "Created At", "",
                    "", "Updated At", "",
                    "", "Status", ""
            ));
            System.out.println(employeeResult.toString());
        } else {
            System.out.println("Login failed !!!!");
        }
    }
}
