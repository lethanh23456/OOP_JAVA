import java.util.Scanner;

public class Hinhvuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1a = sc.nextInt();
        int y1a = sc.nextInt();
        int x2a = sc.nextInt();
        int y2a = sc.nextInt();

        int x1b = sc.nextInt();
        int y1b = sc.nextInt();
        int x2b = sc.nextInt();
        int y2b = sc.nextInt();

        int xmin = Math.min(x1a, x1b);
        int ymin = Math.min(y1a, y1b);
        int xmax = Math.max(x2a, x2b);
        int ymax = Math.max(y2a, y2b);

        long width = (long) xmax - xmin;
        long height = (long) ymax - ymin;
        long side = Math.max(width, height);
        long area = side * side;

        System.out.println(area);
        sc.close();
    }
}
