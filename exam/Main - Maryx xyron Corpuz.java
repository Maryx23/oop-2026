public class Main {
    public static void main(String[] args) {
        System.out.println("CREATING PRODUCTS");
        Product p1 = new Product("product01", "Smartphone ", 20000);
        Product p2 = new Product("product02", "Ipad ", 35000);
        Product p3 = new Product("product03", "Laptop ", 63000);
        Product p4 = new Product("product04", "Tablet ", 32000);
        System.out.println("Product 1: " + p1.getName() + p1.getPrice());
        System.out.println("Product 2: " + p2.getName() + p2.getPrice());
        System.out.println("Product 3: " + p3.getName() + p3.getPrice());
        System.out.println("Product 4: " + p4.getName() + p4.getPrice());
        System.out.println("\nAssembling Order");
        Order order1 = new Order("product01");
        Order order2 = new Order("product03");
        System.out.println("\nAdded Smartphone to order");
        order1.addProduct(p1);
        order1.addProduct(p2);
        System.out.println("\nAdded Laptop to order");
        order2.addProduct(p3);
        order2.addProduct(p4);
        order2.addProduct(p2);
        System.out.println("\nDisplaying order details");
        order1.displayOrderDetails();
        order2.displayOrderDetails();
        System.out.println("\nTotal cost");
        System.out.println("Order " + order1.getOrderId() + " total: " + order1.getTotalCost());
        System.out.println("Order " + order2.getOrderId() + " total: " + order2.getTotalCost());
    }
}