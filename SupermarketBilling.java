package Project2;
import java.util.ArrayList;
import java.util.Scanner;

public class SupermarketBilling {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        double total = 0;
        double subTotal = 0;
        double tax = 0;
        double discount = 0;
        double finalTotal = 0;

        System.out.println("Welcome to the Supermarket Billing System");
        System.out.println("Enter the item details:");

        while (true) {
            System.out.print("Enter item name (type 'exit' to finish): ");
            String itemName = sc.next();
            if (itemName.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Enter item quantity: ");
            int itemQuantity = sc.nextInt();
            System.out.print("Enter item price: ");
            double itemPrice = sc.nextDouble();
            Item item = new Item(itemName, itemQuantity, itemPrice);
            items.add(item);
            subTotal += itemQuantity * itemPrice;
            System.out.println("Item: " + itemName + ", Quantity: " + itemQuantity + ", Price: $" + itemPrice);
        }

        System.out.print("Enter the tax rate(%): ");
        double taxRate = sc.nextDouble();
        tax = (taxRate * subTotal) / 100;
        System.out.print("Enter the discount amount($): ");
        discount = sc.nextDouble();

        finalTotal = subTotal + tax - discount;
        System.out.println("Subtotal: $" + String.format("%.2f", subTotal));
        System.out.println("Tax: $" + String.format("%.2f", tax));
        System.out.println("Discount: $" + String.format("%.2f", discount));
        System.out.println("Total: $" + String.format("%.2f", finalTotal));
    }
}

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
