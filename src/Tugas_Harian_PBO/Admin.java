package Tugas_Harian_PBO;

import java.util.Scanner;

public class Admin extends User {
    private Scanner scanner;


    public Admin(String username, String password) {
        super(username, password);
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("\nMenu Admin:");
        System.out.println("1. Lihat Restaurant");
        System.out.println("2. Tambah Data Restaurant");
        System.out.println("3. Hapus Data Restaurant");
        System.out.println("4. Kembali ke Menu Login");
        System.out.print("Masukan Pilihan Anda: ");
        String choice = scanner.nextLine();

        boolean validChoice = false;
        while (!validChoice) {
            switch (choice) {
                case "1":
                    System.out.println("List Restaurant");
                    validChoice = true;
                    break;
                case "2":
                    System.out.println("Silahkan menginput data dengan benar");
                    validChoice = true;
                    break;
                case "3":
                    System.out.println("Silahkan menghapus data dengan benar");
                    validChoice = true;
                    break;
                case "4":
                    Login_Page Login_Page = new Login_Page();
                    Login_Page.show();
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