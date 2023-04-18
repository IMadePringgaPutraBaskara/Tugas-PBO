package Tugas_Harian_PBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private Restaurant restaurant;
    static ArrayList<Order> orders = new ArrayList<>();
    private List<OrderItem> orderItems;
    private int distance;
    private int AdminCharge = 2000;


    public Order(Restaurant restaurant, List<OrderItem> orderItems, int distance) {
        this.restaurant = restaurant;
        this.orderItems = orderItems;
        this.distance = distance;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public int getDistance() {
        return distance;
    }

    public int getDeliveryCost() {
        int costPerKm = 5000;
        return distance * costPerKm;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getSubtotal();
        }
        int deliveryCost = getDeliveryCost();
        int totalAdminCharge = AdminCharge;
        totalPrice += deliveryCost + totalAdminCharge;
        return totalPrice;
    }

    public static void addOrder(Order order){
        orders.add(order);
    }

    public static void createOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID Restaurant: ");
        String restaurantId = scanner.nextLine();
        Restaurant restaurant = null;
        for (Restaurant r : Restaurant.restaurants) {
            if (r.getId().equals(restaurantId)) {
                restaurant = r;
                break;
            }
        }
        if (restaurant == null) {
            System.out.println("ID " + restaurantId + " tidak dapat ditemukan.");
            return;
        }

        List<OrderItem> orderItems = new ArrayList<>();
        boolean addMoreItem = true;
        while (addMoreItem) {
            System.out.print("Masukkan ID Menu: ");
            String menuId = scanner.nextLine();
            Menu menu = null;
            for (Menu m : restaurant.getMenus()) {
                if (m.getId().equals(menuId)) {
                    menu = m;
                    break;
                }
            }
            if (menu == null) {
                System.out.println("ID " + menuId + " tidak dapat ditemukan.");
                continue;
            }

            System.out.print("Masukkan Total Pembelian: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            orderItems.add(new OrderItem(menu, quantity));

            System.out.print("Tambah Item Lagi? (y/n): ");
            String addMore = scanner.nextLine();
            if (!addMore.equalsIgnoreCase("y")) {
                addMoreItem = false;
            }
        }

        System.out.print("Masukkan Jarak Antar (dalam kilometer): ");
        int distance = scanner.nextInt();
        scanner.nextLine();

        Order order = new Order(restaurant, orderItems, distance);

        System.out.println("\nDetail Pesanan:");
        System.out.println("Restaurant:");
        System.out.println("ID: " + order.getRestaurant().getId());
        System.out.println("Nama: " + order.getRestaurant().getName());
        System.out.println("Alamat: " + order.getRestaurant().getAlamat());
        System.out.println("Menu: ");
        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.println(orderItem.getMenu().getName() + " - " + orderItem.getQuantity() + "x - Rp " + orderItem.getMenu().getPrice());
        }
        System.out.println("Jarak Antar: " + order.getDistance() + " km");
        System.out.println("Biaya Antar: " + order.getDeliveryCost());
        System.out.println("Biaya Admin: Rp. 2000");
        System.out.println("Total Harga: Rp. " + order.getTotalPrice());
        addOrder(order);
    }

    public static void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("\nBelum ada data pesanan yang tersimpan.");
        } else {
            for (Order order : orders) {
                System.out.println("\nDetail Pesanan:");
                System.out.println("Restaurant:");
                System.out.println("ID: " + order.getRestaurant().getId());
                System.out.println("Nama: " + order.getRestaurant().getName());
                System.out.println("Alamat: " + order.getRestaurant().getAlamat());
                System.out.println("Menu: ");
                for (OrderItem orderItem : order.getOrderItems()) {
                    System.out.println(orderItem.getMenu().getName() + " - " + orderItem.getQuantity() + "x - Rp " + orderItem.getMenu().getPrice());
                }
                System.out.println("Jarak Antar: " + order.getDistance() + " km");
                System.out.println("Biaya Antar: " + order.getDeliveryCost());
                System.out.println("Biaya Admin: Rp. 2000");
                System.out.println("Total Harga: Rp. " + order.getTotalPrice());
            }
        }
    }
}

class OrderItem {
    private Menu menu;
    private int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSubtotal() {
        return menu.getPrice() * quantity;
    }
}