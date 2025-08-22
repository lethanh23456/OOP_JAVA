import java.util.Scanner;

public class Tinhsofibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] f = new long[94];
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            System.out.println(f[x]);
        }
    }
}
