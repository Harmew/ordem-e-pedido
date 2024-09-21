package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;

    private final Product product;

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double subTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return this.product
                + ", Quantity: "
                + this.quantity
                + ", Subtotal: $"
                + String.format("%.2f", this.subTotal());
    }

}
