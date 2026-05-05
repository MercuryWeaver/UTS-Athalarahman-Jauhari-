import java.util.ArrayList;

public class Orderlist {
    ArrayList<Order> orders;

    public Orderlist() {
        this.orders = new ArrayList<>();
    }

    public double getTotal(){
        double total = 0;
        for (Order order : orders) {
            total += order.item.harga * order.quantity;
        }
        return total;
    }
}
