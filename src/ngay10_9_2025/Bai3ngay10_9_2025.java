package ngay10_9_2025;

import java.util.*;

class TaiKhoan {
    private int soTaiKhoan;
    private String tenTaiKhoan;
    private double soDu;
    private static float laiSuat = 1f;


    public TaiKhoan(int soTaiKhoan, String tenTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.soDu = soDu;
    }


    public int getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }


    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Nạp " + soTien + " vào tài khoản " + soTaiKhoan);
        } else {
            System.out.println("Số tiền nạp phải > 0");
        }
    }


    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rút " + soTien + " từ tài khoản " + soTaiKhoan);
        } else {
            System.out.println("Không thể rút tiền (số dư không đủ hoặc số tiền không hợp lệ).");
        }
    }


    public void tinhLai1Thang() {
        double tienLai = soDu * (laiSuat / 100) / 12;
        soDu += tienLai;
    }


    public void hienThi() {
        System.out.printf("STK: %d | Chủ TK: %s | Số dư: %.2f\n", soTaiKhoan, tenTaiKhoan, soDu);
    }


    public static void setLaiSuat(float ls) {
        if (ls > 0) {
            laiSuat = ls;
        } else {
            System.out.println("Lãi suất phải > 0");
        }
    }

    public static void hienThiLaiSuat() {
        System.out.println("Lãi suất hiện tại: " + laiSuat + "%/năm");
    }
}

public class Bai3ngay10_9_2025 {
    public static void main(String[] args) {
        List<TaiKhoan> dsTaiKhoan = new ArrayList<>();


        dsTaiKhoan.add(new TaiKhoan(10234014, "tttttttttttt", 5000));
        dsTaiKhoan.add(new TaiKhoan(1003532, "ccccccccc", 10000));
        dsTaiKhoan.add(new TaiKhoan(10363063, "rrrrrrrr", 2000));


        TaiKhoan.hienThiLaiSuat();


        TaiKhoan.setLaiSuat(1.2f);
        TaiKhoan.hienThiLaiSuat();


        dsTaiKhoan.get(0).napTien(2000);
        dsTaiKhoan.get(1).rutTien(3000);


        for (TaiKhoan tk : dsTaiKhoan) {
            tk.tinhLai1Thang();
        }


        System.out.println("\n Danh sách tài khoản sau giao dịch ");
        for (TaiKhoan tk : dsTaiKhoan) {
            tk.hienThi();
        }


        int soCanTim = 1002;
        System.out.println("\n Tìm kiếm tài khoản STK " + soCanTim + "   ");
        TaiKhoan found = timKiemTaiKhoan(dsTaiKhoan, soCanTim);
        if (found != null) {
            found.hienThi();
        } else {
            System.out.println("Không tìm thấy tài khoản.");
        }


        System.out.println("\n Danh sách tài khoản sắp xếp theo số dư giảm dần ");
        dsTaiKhoan.sort((a, b) -> Double.compare(b.getSoDu(), a.getSoDu()));
        for (TaiKhoan tk : dsTaiKhoan) {
            tk.hienThi();
        }
    }


    public static TaiKhoan timKiemTaiKhoan(List<TaiKhoan> ds, int soTK) {
        for (TaiKhoan tk : ds) {
            if (tk.getSoTaiKhoan() == soTK) {
                return tk;
            }
        }
        return null;
    }
}
