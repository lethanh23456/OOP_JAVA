import java.util.Scanner;

public class TongNSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long res = (1 + a) * a / 2;
            System.out.println(res);
        }
        sc.close();
    }
}
