import java.util.ArrayList;
public class MenuItem {
    private static int counter = 0;
    String nama;
    double harga;
    int ID;
    private static ArrayList<MenuItem> listMenu = new ArrayList<>();

    static {
        new MenuItem("Nasi Goreng", 15000);
        new MenuItem("Mie Goreng", 12000);
    }

    public MenuItem(String nama, double harga) {
        this.ID = counter++;
        this.nama = nama;
        this.harga = harga;
        listMenu.add(this);
    }

    public static MenuItem getMenuItemById(int id) {
        for (MenuItem item : listMenu) {
            if (item.ID == id) {
                return item;
            }
        }
        return null; // Return null if not found
    }

    public static void printMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < listMenu.size(); i++) {
            MenuItem item = listMenu.get(i);
            System.out.println(item.ID + ": " + item.nama + " - " + item.harga);
        }
    }
}
