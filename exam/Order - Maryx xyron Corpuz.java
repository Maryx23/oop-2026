import java.util.ArrayList;

class Order {
    private String orderId;
    private ArrayList<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Added " + p.getName() + " to order " + orderId);
    }

    public double getTotalCost() {
        double total = 0.0;
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            total = total + p.getPrice();
        }
        return total;
    }

    public void displayOrderDetails() {
        System.out.println("\nOrder details: " + orderId);
        if (products.size() == 0) {
            System.out.println("No products in this order");
        } else {
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                p.displayProductInfo();
            }
            System.out.println("Total Cost: " + getTotalCost());
        }
    }
}