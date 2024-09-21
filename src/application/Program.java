package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String [] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Client
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();

        // Order Item
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());

        Order order = new Order(status, new Client(name,email, sdf.parse(birthDate)));

        // Items
        System.out.print("How many items to this order? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("Enter #" + (i + 1) +" item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();

            order.addItem(new OrderItem(productQuantity,productPrice, new Product(productName,productPrice)));
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.print(order);

        sc.close();
    }
}