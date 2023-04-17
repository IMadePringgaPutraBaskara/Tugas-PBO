package Tugas_Harian_PBO;

import java.util.Scanner;

public class Customer extends User {
    private Scanner scanner;


    public Customer(String username, String password) {
        super(username, password);
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("\nMenu Customer:");
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
                    System.out.println("List Restaurant ");
                    validChoice = true;
                    break;
                case "2":
                    System.out.println("Mohon menginput data dengan sesuai");
                    validChoice = true;
                    break;
                case "3":
                    System.out.println("Pastikan pesanan anda benar");
                    validChoice = true;
                    break;
                case "4":
                    Login_Page menuLogin = new Login_Page();
                    menuLogin.show();
                    validChoice = true;
                    break;
                default:
                    System.out.println("Mohon Maaf, Pilihan anda tidak sesuai");
                    System.out.print("Masukan Pilihan Anda: ");
                    choice = scanner.nextLine();
                    break;
            }
        }
    }
}