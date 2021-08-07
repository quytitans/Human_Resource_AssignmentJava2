package Human_Resource;

import Human_Resource.Controller.EmployeeController;

import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----------HUMAN RESOURCE----------");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");
            System.out.println("----------------------------------");
            System.out.println("Please select from 1 to 3 for you: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    EmployeeController.registerController();
                    scanner.nextLine();
                    break;
                case 2:
                    EmployeeController.loginController();
                    scanner.nextLine();
                    break;
                default:
                    break;
            }
            if (choice == 3) {
                System.out.println("bye bye !!");
                break;
            }
        }

    }
}
