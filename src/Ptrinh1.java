import java.util.Scanner;

public class Ptrinh1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("VSN");
            } else {
                System.out.println("VN");
            }
        } else {
            double x = -b / a;
            System.out.printf("%.2f", x);
        }

        sc.close();
    }
}
