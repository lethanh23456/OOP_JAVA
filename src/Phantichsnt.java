import java.util.Scanner;

public class Phantichsnt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 1 ; j <= t ; j++){
            int n = sc.nextInt();
            System.out.print("Test "+j+": ");
            for(int i = 2 ; i <= Math.sqrt(n) ; i++){
                int tmp = 0 ;
                while (n % i == 0) {
                    tmp++;
                    n = n /i ;
                }
                if (tmp != 0 ) System.out.print(i + "(" +tmp+ ")"+" ");
            }
            if (n > 1) System.out.print(n + "(1)");
            System.out.println();
        }
    }
}
