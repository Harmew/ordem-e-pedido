package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private final Date moment;
    private OrderStatus status;

    private Client client;
    private final List<OrderItem> orderItems = new ArrayList<>();

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
        this.moment = new Date();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        this.orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        this.orderItems.remove(item);
    }

    public double total() {
        double total = 0;

        for (OrderItem item: orderItems) {
            total += item.subTotal();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Order moment: ");
        sb.append(sdf.format(this.moment)).append("\n");

        sb.append("Order status: ");
        sb.append(this.status).append("\n");

        sb.append("Client: ");
        sb.append(this.client).append("\n");

        sb.append("Order items: ").append("\n");
        for(OrderItem orderItem: orderItems) {
            sb.append(orderItem).append("\n");
        }

        sb.append("Total price: $");
        sb.append(String.format("%.2f", this.total()));

       return sb.toString();
    }
}