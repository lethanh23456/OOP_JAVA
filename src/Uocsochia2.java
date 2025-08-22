import java.util.Scanner;

public class Uocsochia2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            long n = sc.nextLong();
            long dem = 0 ;
            for(long i = 1 ; i <= Math.sqrt(n) ; i++){
                if(n % i == 0 ){
                    if (n / i == i) {
                        if(i % 2 == 0) dem++;
                    }
                    else {
                        if ((n/i) % 2 == 0) dem++;
                        if(i % 2 == 0) dem++;
                    }
                }
            }
            System.out.println(dem);
        }
    }
}
