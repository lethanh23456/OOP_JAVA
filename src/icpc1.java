import java.util.*;
public class icpc1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String chuoi = sc.next();
        List<String> listCanXet = new ArrayList<>();
        int soLuongTrunglap = 0;
        int dem = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(chuoi.charAt(i));
            String chuoiMoi = chuoi.replaceFirst(String.valueOf(chuoi.charAt(i)),"");
            System.out.println(chuoiMoi);
            listCanXet.add(chuoiMoi);
        }

//        for (String kytu : listCanXet) {
//            System.out.println(kytu);
//        }
        for (int i = 1; i < listCanXet.size(); i++) {
            if (!listCanXet.get(i).equals(listCanXet.get(i-1))) {
                res += dem*(dem-1)/2f;
            } else {
                dem++;
            }
        }
        System.out.print(res);
    }
}
