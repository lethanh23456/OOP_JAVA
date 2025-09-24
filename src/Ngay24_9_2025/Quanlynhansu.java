package Ngay24_9_2025;


abstract class NhanVien {
    protected String ten;
    protected int tuoi;
    protected double luongCoBan;

    public NhanVien(String ten, int tuoi, double luongCoBan) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.luongCoBan = luongCoBan;
    }


    public abstract double tinhLuong();

    public void hienThiThongTin() {
        System.out.println("Tên: " + ten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Lương: " + tinhLuong());
    }
}


class GiangVien extends NhanVien {
    private int soTietDay;
    private double tienMoiTiet;

    public GiangVien(String ten, int tuoi, double luongCoBan, int soTietDay, double tienMoiTiet) {
        super(ten, tuoi, luongCoBan);
        this.soTietDay = soTietDay;
        this.tienMoiTiet = tienMoiTiet;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + soTietDay * tienMoiTiet;
    }
}


class CanBoHanhChinh extends NhanVien {
    private double heSoPhuCap;

    public CanBoHanhChinh(String ten, int tuoi, double luongCoBan, double heSoPhuCap) {
        super(ten, tuoi, luongCoBan);
        this.heSoPhuCap = heSoPhuCap;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoPhuCap;
    }
}

// Class chạy chương trình
public class Quanlynhansu {
    public static void main(String[] args) {
        NhanVien gv = new GiangVien("Nguyen Van A", 40, 5000000, 120, 50000);
        NhanVien cb = new CanBoHanhChinh("Tran Thi B", 35, 4000000, 1.5);

        gv.hienThiThongTin();
        cb.hienThiThongTin();
    }
}



