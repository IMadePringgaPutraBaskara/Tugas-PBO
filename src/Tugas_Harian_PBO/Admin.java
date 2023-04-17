package Tugas_Harian_PBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends user {
    private Scanner scanner;
    private List<Restaurant> restaurants;

    public Admin(String username, String password) {
        super(username, password);
        scanner = new Scanner(System.in);
        restaurants = new ArrayList<>();
    }

    private void showRestaurants() {
        System.out.println("\nData Restaurant:");
        for (Restaurant restaurant : restaurants) {
            System.out.println("ID: " + restaurant.getId());
            System.out.println("Nama: " + restaurant.getName());
            System.out.println("Alamat: " + restaurant.getAlamat());
            System.out.println("Menu: ");
            for (Menu menu : restaurant.getMenus()) {
                System.out.println("ID: " + menu.getId() + " - " + menu.getName() + " - Rp " + menu.getPrice());
            }
            System.out.println("=========================");
        }
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
                    showRestaurants();
                    showMenu();
                    validChoice = true;
                    break;
                case "2":
                    Restaurant restaurant = Restaurant.createRestaurant();
                    restaurants.add(restaurant);
                    System.out.println("Data Restaurant berhasil ditambahkan!");
                    showMenu();
                    validChoice = true;
                    break;
                case "3":
                    System.out.print("Masukkan ID Restaurant yang ingin dihapus: ");
                    String idToDelete = scanner.nextLine();

                    boolean isFound = false;
                    for (int i = 0; i < restaurants.size(); i++) {
                        if (restaurants.get(i).getId().equals(idToDelete)) {
                            restaurants.remove(i);
                            System.out.println("Restoran dengan ID " + idToDelete + " telah dihapus.");
                            isFound = true;
                            break;
                        }
                    }

                    if (!isFound) {
                        System.out.println("Restoran dengan ID " + idToDelete + " tidak ditemukan.");
                    }

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

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}