import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GeometricObject> list = new ArrayList<>();

        Circle c1 = new Circle(5.0, "red", true);
        Circle c2 = new Circle(5.0, "blue", false);
        Rectangle r1 = new Rectangle(4.0, 6.0, "green", true);
        Rectangle r2 = new Rectangle(5.0, 8.0, "yellow", false);

        list.add(c1);
        list.add(c2);
        list.add(r1);
        list.add(r2);

        for (GeometricObject obj : list) {
            System.out.println(obj.toString());
            System.out.println("Area: " + obj.getArea());
            System.out.println("Perimeter: " + obj.getPerimeter());
            System.out.println();
        }

        System.out.println("Comparing c1 and c2 (same radius): " + c1.equals(c2));
        System.out.println("Comparing r1 and r2 (different dimensions): " + r1.equals(r2));
    }
}