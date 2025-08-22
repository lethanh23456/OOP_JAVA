import java.util.Scanner;

public class Sochinhphuong {
    public  static  boolean Scp(long n){
        long k = (long)Math.sqrt(n);
        if (k * k == n ) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if(Scp(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
