import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String nama;
    private static ArrayList<Customer> CustomerRecord = new ArrayList<>();
    String meja;
    private ArrayList<Orderlist> Orders;

    public void placeOrder(int MenuId, int quantity){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to create a new order (1) or add to an existing order (2)?");
        int choice = scanner.nextInt();
        Orderlist localOrderList;
        switch (choice) {
            case 1:
                localOrderList = new Orderlist();
                Orders.add(localOrderList);
                localOrderList.orders.add(new Order(MenuItem.getMenuItemById(MenuId), quantity));
                break;
            case 2:
                if (Orders.isEmpty()) {
                    System.out.println("No orders to add to. Please create an order first.");
                    return;
                }
                printOrder();
                System.out.println("Please pick the ID of the order you want to add to:");
                int orderId = scanner.nextInt();
                localOrderList = Orders.get(orderId);

                if (localOrderList == null) {
                    System.out.println("Invalid order ID.");
                    return;
                }

                for (Order order : localOrderList.orders) {
                    if (order.item.ID == MenuId) {
                        order.quantity += quantity;
                        return;
                    }
                }
                Order NewOrder = new Order(MenuItem.getMenuItemById(MenuId), quantity);
                localOrderList.orders.add(NewOrder);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }


        new Order(MenuItem.getMenuItemById(MenuId), quantity);
    }

    public Customer(String nama, String meja) {
        this.nama = nama;
        this.meja = meja;
        this.Orders = new ArrayList<>();
        CustomerRecord.add(this);
    }

    public void printOrder(){
        System.out.println("Customer: " + nama + ", Table: " + meja);
        for (int i = 0; i < Orders.size(); i++) {
            Orderlist orderlist = Orders.get(i);
            System.out.println("Order " + (i + 1) + ":");
            for (Order order : orderlist.orders) {
                order.printOrder();
            }
            System.out.println("Total: " + orderlist.getTotal());
        }
    }

    public void Checkout(){
        double total = 0;
        for (Orderlist orderlist : Orders) {
            total += orderlist.getTotal();
        }
        System.out.println("Total: " + total);
        //simpen customernya di rekor transaksi dah
    }


}
