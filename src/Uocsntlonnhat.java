import java.util.Scanner;

public class Uocsntlonnhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0){
            long n = sc.nextLong();
            long ln = 2 ;
            for(int i = 2 ; i <= Math.sqrt(n) ; i++){
                while (n % i == 0) {
                    n = n /i ;
                }
                ln = Math.max(ln,i);
            }
            if (n > 1) ln = Math.max(ln,n);
            System.out.println(ln);
        }

    }
}
