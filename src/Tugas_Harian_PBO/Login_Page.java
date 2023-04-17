package Tugas_Harian_PBO;

import java.util.Scanner;
public class Login_Page {
    private Scanner scanner;
    private Admin admin;
    private Customer customer;

    public Login_Page() {
        scanner = new Scanner(System.in);
        admin = new Admin("Dede", "2708");
        customer = new Customer("customer", "123");
    }

    public void show() {
        System.out.println("Menu Login");
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.print("- Username: ");
            String username = scanner.nextLine();
            System.out.print("- Password: ");
            String password = scanner.nextLine();

            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                admin.showMenu();
                isLoggedIn = true;
            } else if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                customer.showMenu();
                isLoggedIn = true;
            } else {
                System.out.println(" Username / Password anda salah silahkan coba lagi");
            }
        }
        scanner.close();
    }
}