package view;

import dao.AdminDao;
import service.AdminService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminView {
    AdminDao adminDao = new AdminDao();
    AdminService adminService = new AdminService();

    public void loginAdmin() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter admin username : ");
            String username = scanner.next();
            System.out.println("enter admin password : ");
            String password = scanner.next();
            if (adminDao.passwordValidation(username, password) != null) {
                System.out.print("enter your request: 1 :: for sort Customers with ages \n " +
                        "\t\t\t        2 :: for customer activity in month ");
                int adminInput = scanner.nextInt();
                switch (adminInput) {
                    case 1:
                       adminService.getCustomerAge();
                    case 2:
                        System.out.println("enter start date with pattern \"yyyy-MM-dd\" ");
                        String startDate = scanner.next();
                        adminService.getCustomerActivity(startDate);
                }
            } else {
                System.out.println("invalid Admin ");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("username or password is invalid ");
        }
    }
}
