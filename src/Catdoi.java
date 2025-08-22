import java.util.Objects;
import java.util.Scanner;

public class Catdoi {
    public static String xuli(String n) {

        for (int i = 0; i < n.length(); i++){
            char a = n.charAt(i);
            if (a != '1' && a != '0' && a != '8' && a != '9' ) {
                return "INVALID";
            }
        }
        String res = "";
        for (int i = 0; i < n.length(); i++) {
            char a = n.charAt(i);
            if (a != '1') {
                res += "0";
            }
            else res += "1";
        }
        res = res.toString().replaceFirst("^0+", "");
        if (res.isEmpty()) return "INVALID";
        return res;
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0 ){
            String n = sc.nextLine();
            System.out.println(xuli(n));
        }
    }
}
