import java.util.Scanner;

public class Solienke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String n = sc.nextLine().trim();
            boolean ok = true;

            for (int i = 0; i < n.length() - 1; i++) {
                int a = n.charAt(i) - '0';
                int b = n.charAt(i + 1) - '0';
                if (Math.abs(a - b) != 1) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
