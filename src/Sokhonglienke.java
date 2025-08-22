import java.util.Scanner;

public class Sokhonglienke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String n = sc.nextLine();

            int sum = 0;
            boolean ok = true;

            for (int i = 0; i < n.length(); i++) {
                int digit = n.charAt(i) - '0';
                sum += digit;

            }
            for (int i = 1 ; i < n.length() ; i++){
                int a = n.charAt(i) - '0';
                int b = n.charAt(i - 1) - '0';
                if (Math.abs(a - b) != 2) ok = false;

            }
            if (ok && sum % 10 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
