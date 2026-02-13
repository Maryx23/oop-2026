public class Circle {
        double radius;
        static final double pi = 3.1416;

        public Circle(double radius) {
                this.radius = radius;

        }

        public double getArea() {
                return pi * radius * radius;

        }

}
