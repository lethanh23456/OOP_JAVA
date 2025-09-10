import java.util.Scanner;

public class HinhChuNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a <= 0 || b <= 0 || a > 10000 || b > 10000) {
            System.out.println(0);
        }
        else {
            int cv = 2 * (a + b);
            int dt = a * b ;
            System.out.println(cv + " " + dt);
        }
    }
}



