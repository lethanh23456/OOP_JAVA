import java.util.Scanner;

public class Chuso47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        String str = String.valueOf(s);

        int dem4 = 0;
        int dem7 = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '4') dem4++;
            else if (c == '7') dem7++;
        }

        if ((dem4 + dem7) == 4 || (dem4 + dem7) == 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
