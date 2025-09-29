package Ngay24_9_2025.Baitapvenha;


interface EmailSender {
    void sendEmail(String message);
}


interface Programmer {
    void code();
}


interface Salesperson {
    void sell();
}


class OfficeEmployee2 implements EmailSender {
    private String name;

    public OfficeEmployee2(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail(String message) {
        System.out.println(name + " gửi email: " + message);
    }
}


class TechnicalEmployee2 implements EmailSender, Programmer {
    private String name;

    public TechnicalEmployee2(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail(String message) {
        System.out.println(name + " gửi email: " + message);
    }

    @Override
    public void code() {
        System.out.println(name + " đang viết code...");
    }
}


class SalesEmployee implements EmailSender, Salesperson {
    private String name;

    public SalesEmployee(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail(String message) {
        System.out.println(name + " gửi email: " + message);
    }

    @Override
    public void sell() {
        System.out.println(name + " đang bán hàng...");
    }
}


public class bai2 {
    public static void main(String[] args) {
        OfficeEmployee2 officeEmp = new OfficeEmployee2("A");
        TechnicalEmployee2 techEmp = new TechnicalEmployee2("B");
        SalesEmployee salesEmp = new SalesEmployee("C");

        officeEmp.sendEmail("Báo cáo tuần");

        techEmp.sendEmail("Lịch họp dự án");
        techEmp.code();

        salesEmp.sendEmail("Khuyến mãi sản phẩm");
        salesEmp.sell();
    }
}

