import java.util.*;

public class Main {
    static Map<String, List<String[]>> thuVien = new HashMap<>();

    public static void themSach(String sach, String tacgia , String nam ) {
        if (thuVien.containsKey(tacgia)) {
            thuVien.get(tacgia).add(new String[]{sach , nam});
        }
        else {
            List<String[]> sachmoi = new ArrayList<>();
            sachmoi.add(new String[]{sach , nam});
            thuVien.put(tacgia,sachmoi);
        }
    }

    public static void main(String[] args) {
        themSach("1", "thanh","21");
        themSach("2", "thanh","12");

        System.out.println("danh sach :");
        for(String x : thuVien.keySet()) {
            List<String[]> tmp = thuVien.get(x);
            for (int i = 0 ; i < tmp.size() ; i++){
                String[] thongtin = tmp.get(i);
                System.out.println(thongtin[0] + " " + thongtin[1]);
            }
        }
    }
}
