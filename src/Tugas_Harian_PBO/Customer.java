package Tugas_Harian_PBO;

import java.util.Scanner;

public class Customer extends user {
    private Scanner scanner;

    public Customer(String username, String password) {
        super(username, password);
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("\nMenu Customer OOF:");
        System.out.println("1. Lihat Restaurant");
        System.out.println("2. Tambah Pesanan");
        System.out.println("3. Lihat Pesanan");
        System.out.println("4. Kembali ke Menu Login");
        System.out.print("Masukan Pilihan Anda: ");
        String choice = scanner.nextLine();

        boolean validChoice = false;
        while (!validChoice) {
            switch (choice) {
                case "1":
                    Restaurant.showRestaurants();
                    showMenu();
                    validChoice = true;
                    break;
                case "2":
                    Order.createOrder();
                    showMenu();
                    validChoice = true;
                    break;
                case "3":
                    Order.showOrders();
                    showMenu();
                    validChoice = true;
                    break;
                case "4":
                    Login_Page login_page = new Login_Page();
                    login_page.show();
                    validChoice = true;
                    break;
                default:
                    System.out.println("Pilihan tidak sesuai, Coba masukan pilihan kembali!");
                    System.out.print("Masukan Pilihan Anda: ");
                    choice = scanner.nextLine();
                    break;
            }
        }
    }
}