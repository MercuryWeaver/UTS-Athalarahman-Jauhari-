import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String nama;
    String meja;
    private ArrayList<Orderlist> Orders;

    public void placeOrder(int MenuId, int quantity){
        Scanner scanner = new Scanner(System.in);
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
                localOrderList.orders.add(new Order(MenuItem.getMenuItemById(MenuId), quantity));
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
    }

    public void printOrder(){
        for (int i = 0; i < Orders.size(); i++) {
            Orderlist orderlist = Orders.get(i);
            System.out.println("Order " + (i + 1) + ":");
            for (Order order : orderlist.orders) {
                order.printOrder();
            }
        }
    }

    public void Checkout(){

    }


}
