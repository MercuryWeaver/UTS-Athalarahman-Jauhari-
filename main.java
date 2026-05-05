import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("Enter customer name: ");
            String CustomerName = scanner.nextLine();
            System.err.println("Enter table number: ");
            String tableNumber = scanner.nextLine();
            Customer customer = new Customer(CustomerName, tableNumber);

            boolean TakeOrder = true;
            MenuItem.printMenu();
            
            while (TakeOrder) {
                System.out.println("Enter the ID of the menu item you want to order: ");
                customer.placeOrder(0, 0);
            }

        }
    }
}
