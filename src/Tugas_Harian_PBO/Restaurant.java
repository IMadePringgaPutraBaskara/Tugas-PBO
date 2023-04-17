package Tugas_Harian_PBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    private String id;
    private String name;
    private String alamat;
    private List<Menu> menus;

    public Restaurant(String id, String name, String alamat, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.alamat = alamat;
        this.menus = menus;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlamat() {
        return alamat;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public static Restaurant createRestaurant() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID Restaurant: ");
        String id = scanner.nextLine();

        System.out.print("Masukkan Nama Restaurant: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan Alamat Restaurant: ");
        String alamat = scanner.nextLine();

        List<Menu> menus = new ArrayList<>();
        boolean addMoreMenu = true;
        while (addMoreMenu) {
            System.out.print("Masukkan ID Menu: ");
            String menuId = scanner.nextLine();

            System.out.print("Masukkan Nama Menu: ");
            String menuName = scanner.nextLine();

            System.out.print("Masukkan Harga Menu: ");
            int menuPrice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            menus.add(new Menu(menuId, menuName, menuPrice));

            System.out.print("Tambah Menu Lagi? (y/n): ");
            String addMore = scanner.nextLine();
            if (!addMore.equalsIgnoreCase("y")) {
                addMoreMenu = false;
            }
        }

        Restaurant restaurant = new Restaurant(id, name, alamat, menus);

        System.out.println("Data Restaurant:");
        System.out.println("ID: " + restaurant.getId());
        System.out.println("Nama: " + restaurant.getName());
        System.out.println("Kode: " + restaurant.getAlamat());
        System.out.println("Menu: ");
        for (Menu menu : restaurant.getMenus()) {
            System.out.println("ID: " + menu.getId() + " - " + menu.getName() + " - Rp " + menu.getPrice());
        }

        return restaurant;
    }
}

class Menu {
    private String id;
    private String name;
    private int price;

    public Menu(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
