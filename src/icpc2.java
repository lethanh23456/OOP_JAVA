import java.util.*;

public class icpc2 {
    static long MOD = 1000000007;
    public long tinhSoUoc(long n) {
        long res = 1 ;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            int tmp = 0 ;
            while (n % i == 0) {
                tmp++;
                n = n /i ;
            }
            res *= (tmp+1);
        }
        if (n > 1) res *= 2;
        return res;
    }

    public long tinhLuyThua(long a, long b) {
        if(b==0) return 1;
        long tmp=tinhLuyThua(a,b/2);
        if(b % 2 == 0) return tmp*tmp % MOD;
        return tmp*tmp % MOD * a % MOD;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        icpc2 icpc2 = new icpc2();
        long i = 1;
        while ((long)Math.pow(i,icpc2.tinhSoUoc(i))<X) {
            i++;
        }
        if ((long)Math.pow(i,icpc2.tinhSoUoc(i)) == X) System.out.println(i);
        else System.out.println(-1);
    }

}
