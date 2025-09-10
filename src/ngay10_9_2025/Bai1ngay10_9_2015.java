package ngay10_9_2025;

import java.util.*;

class HinhChuNhat {
    private int chieudai;
    private int chieurong;
    public HinhChuNhat (int chieudai , int chieurong){
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }
    public  int chuvi () {
        return (chieudai+chieurong)*2;
    }
    public  int dientich () {
        return chieudai*chieurong;
    }
    public void in () {
        System.out.println(chuvi()+".............."+dientich());
    }
}
public class Bai1ngay10_9_2015 {
    public static void main(String[] args) {
        HinhChuNhat hinhChuNhatBien= new HinhChuNhat(45,23);
        HinhChuNhat hinhChuNhatBien1= new HinhChuNhat(42,24);
        hinhChuNhatBien.in();
        hinhChuNhatBien1.in();
    }
}


