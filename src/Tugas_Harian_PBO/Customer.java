package Tugas_Harian_PBO;

import Tugas_Harian_PBO.Login_Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends user {
    private Scanner scanner;
//    private List<Restaurant> restaurants;

    public Customer(String username, String password) {
        super(username, password);
        scanner = new Scanner(System.in);
//        restaurants = new ArrayList<>();
    }

//    private void showRestaurants() {
////        List<Restaurant> restaurants = getRestaurants();
//        System.out.println("\nData Restaurant:");
//        for (Restaurant restaurant : restaurants) {
//            System.out.println("ID: " + restaurant.getId());
//            System.out.println("Nama: " + restaurant.getName());
//            System.out.println("Alamat: " + restaurant.getAlamat());
//            System.out.println("Menu: ");
//            for (Menu menu : restaurant.getMenus()) {
//                System.out.println("ID: " + menu.getId() + " - " + menu.getName() + " - Rp " + menu.getPrice());
//            }
//            System.out.println("=========================");
//        }
//    }

//    public List<Restaurant> getRestaurants() {
//        return restaurants;
//    }

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
                    System.out.println("Pastikan data yang anda masukkan benar");
                    validChoice = true;
                    break;
                case "3":
                    System.out.println("Pastikan data yang anda masukkan benar");
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