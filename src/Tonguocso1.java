import java.util.Scanner;

public class Tonguocso1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        long tong = 0 ;
        while (t-- > 0){
            long n = sc.nextLong();
            for(int i = 2 ; i <= Math.sqrt(n) ; i++){
                while (n % i == 0) {
                    n = n /i ;
                    tong += i;
                }
            }
            if (n > 1) tong += n ;
        }
        System.out.println(tong);
    }
}
