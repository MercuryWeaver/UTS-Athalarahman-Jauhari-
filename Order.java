public class Order {
    MenuItem item;
    int quantity;

    public Order(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public void printOrder(){
        System.out.println(item.nama + " x " + quantity + " = " + (item.harga * quantity));
    }
}
