package Tugas_Harian_PBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends user {
    private Scanner scanner;
//    static ArrayList<Restaurant> restaurants;

    public Admin(String username, String password) {
        super(username, password);
        scanner = new Scanner(System.in);
//        restaurants = new ArrayList<>();
    }

    @Override
    public void showMenu() {
        System.out.println("\nMenu Admin OOF:");
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
//                    restaurants.get(0);
                    Restaurant.showRestaurants();
                    showMenu();
                    validChoice = true;
                    break;
                case "2":
                    Restaurant.createRestaurant();
//                    restaurants.add(restaurant);
                    System.out.println("Data Restaurant berhasil ditambahkan!");
                    showMenu();
                    validChoice = true;
                    break;
                case "3":
                    System.out.print("Masukkan ID Restaurant yang ingin dihapus: ");

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