package prodcut_store;

public class Product {
    private String SKU;
    private String name;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(String SKU, String name, double price, int quantity) {
        this.SKU = SKU;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getSKU() {
        return SKU;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
