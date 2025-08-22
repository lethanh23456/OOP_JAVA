import java.util.Scanner;

public class Chiatamgiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            double H = sc.nextDouble();
            // chia n phần bằng nhau thì si/smax = i/n (tỉ lệ)
            // lại có công thức tỉ lệ toán học si/smax = (hi/himax)^2 himax là H
            for (int i = 1; i < n; i++) {
                double hi = H * Math.sqrt((double) i / n);
                System.out.printf("%.6f ", hi);
            }
            System.out.println();
        }
        sc.close();
    }
}
