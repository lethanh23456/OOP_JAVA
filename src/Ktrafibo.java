import java.util.Scanner;

public class Ktrafibo {
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
            long x = sc.nextLong();
            boolean isFibo = false;
            for (int i = 0; i < f.length; i++) {
                if (f[i] == x) {
                    isFibo = true;
                    break;
                }
            }
            if(isFibo) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
