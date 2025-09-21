import java.util.*;

class Point {
    private double x, y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double distance(Point p1, Point p2) {
        return p1.distance(p2);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class duongtronngoaitiep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            double x1 = sc.nextDouble(), y1 = sc.nextDouble();
            double x2 = sc.nextDouble(), y2 = sc.nextDouble();
            double x3 = sc.nextDouble(), y3 = sc.nextDouble();

            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Point p3 = new Point(x3, y3);

            double a = Point.distance(p1, p2);
            double b = Point.distance(p2, p3);
            double c = Point.distance(p1, p3);

            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("INVALID");
                continue;
            }

            double p = (a + b + c) / 2.0;
            double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

            double r = (a * b * c) / (4.0 * s);
            double area = Math.PI * r * r;

            System.out.printf("%.3f\n", area);
        }
    }
}