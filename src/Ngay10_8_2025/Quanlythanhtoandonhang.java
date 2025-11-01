package Ngay10_8_2025;

import java.util.*;



/*  ┌───────────────────────┐
                    │     <<abstract>>      │
                    │        Product        │
                    ├───────────────────────┤
                    │- productId: String    │
                    │- name: String         │
                    │- price: double        │
                    │- category: String     │
                    ├───────────────────────┤
                    │+ getPrice(): double   │
                    │+ getInfo(): String*   │
                    └──────────┬────────────┘
                               │
          ┌────────────────────┴───────────────────┐
          │                                        │
┌────────────────────────┐              ┌──────────────────────┐
│   ElectronicProduct     │              │     FoodProduct      │
├────────────────────────┤              ├──────────────────────┤
│- imei: String          │              │- expiryDate: String  │
│- warrantyMonths: int   │              └──────────────────────┘
└────────────────────────┘

                    (composition) ▲
                                  │
┌──────────────────────────────────────────────┐
│                   Order                      │
├──────────────────────────────────────────────┤
│- customerName: String                        │
│- products: List<Product>                     │
│- paymentMethod: PaymentMethod                │
├──────────────────────────────────────────────┤
│+ addProduct(p: Product)                      │
│+ calculateTotal(): double                    │
│+ checkout(): void                            │
└──────────────────────────────────────────────┘
                         │
                         │ uses
                         ▼
              ┌──────────────────────────┐
              │   <<interface>>          │
              │    PaymentMethod         │
              ├──────────────────────────┤
              │+ pay(amount, name): void │
              └──────────┬───────────────┘
                         │
     ┌───────────────────┼───────────────────────────┐
     │                   │                           │
┌──────────────┐   ┌────────────────┐        ┌────────────────┐
│ CashPayment   │  │CreditCardPayment│       │ MomoPayment    │
└──────────────┘   └────────────────┘        └────────────────┘

 */
abstract class Product {
    protected String productId;
    protected String name;
    protected double price;
    protected String category;

    public Product(String productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getInfo();
}



class ElectronicProduct extends Product {
    private String imei;
    private int warrantyMonths;

    public ElectronicProduct(String productId, String name, double price, String imei, int warrantyMonths) {
        super(productId, name, price, "Electronic");
        this.imei = imei;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getInfo() {
        return String.format("[%s] %s - %.0f VND | IMEI: %s | Bảo hành: %d tháng",
                category, name, price, imei, warrantyMonths);
    }
}



class FoodProduct extends Product {
    private String expiryDate;

    public FoodProduct(String productId, String name, double price, String expiryDate) {
        super(productId, name, price, "Food");
        this.expiryDate = expiryDate;
    }

    @Override
    public String getInfo() {
        return String.format("[%s] %s - %.0f VND | HSD: %s",
                category, name, price, expiryDate);
    }
}



interface PaymentMethod {
    void pay(double amount, String customerName);
}



class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount, String customerName) {
        System.out.printf("Khách hàng: %s. Tổng tiền: %.0f. Thanh toán tiền mặt thành công.%n",
                customerName, amount);
    }
}



class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount, String customerName) {
        System.out.printf("Khách hàng: %s. Tổng tiền: %.0f. Thanh toán bằng thẻ tín dụng thành công.%n",
                customerName, amount);
    }
}



class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount, String customerName) {
        System.out.printf("Khách hàng: %s. Tổng tiền: %.0f. Thanh toán qua ví Momo thành công.%n",
                customerName, amount);
    }
}





class Order {
    private String customerName;
    private List<Product> products;
    private PaymentMethod paymentMethod;

    public Order(String customerName, PaymentMethod paymentMethod) {
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void checkout() {
        double total = calculateTotal();
        paymentMethod.pay(total, customerName);
    }
}



public class Quanlythanhtoandonhang {
    public static void main(String[] args) {
        // Tạo sản phẩm
        Product p1 = new ElectronicProduct("E01", "iPhone 15", 20000000, "IMEI12345", 12);
        Product p2 = new FoodProduct("F01", "Bánh quy", 50000, "20/12/2025");


        System.out.println(p1.getInfo());
        System.out.println(p2.getInfo());

        System.out.println();


        Order order1 = new Order("A", new CashPayment());
        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.checkout();

        System.out.println();


        Order order2 = new Order("B", new CreditCardPayment());
        order2.addProduct(p1);
        order2.checkout();

        System.out.println();


        Order order3 = new Order("C", new MomoPayment());
        order3.addProduct(p2);
        order3.checkout();
    }
}






//🧠 1️⃣ TÍNH TRỪU TƯỢNG (Abstraction)
//
//        Ẩn đi chi tiết cài đặt, chỉ cho thấy những gì cần thiết.
//
//        💡 Trong code:
//        abstract class Product {
//            public abstract String getInfo();
//        }
//
//        interface PaymentMethod {
//            void pay(double amount, String customerName);
//        }
//
//
//👉 Product và PaymentMethod là hai thành phần trừu tượng:
//
//        Product chỉ nói rằng “mọi sản phẩm đều có thể lấy thông tin (getInfo)”,
//        nhưng không nói cách hiển thị thông tin cụ thể.
//        → ElectronicProduct, FoodProduct sẽ tự định nghĩa chi tiết riêng.
//
//        PaymentMethod chỉ nói rằng “mọi phương thức thanh toán đều có thể pay()”,
//        còn cụ thể trả tiền mặt, quẹt thẻ, hay Momo thì do lớp con quyết định.
//
//        🎯 Lợi ích:
//        Giúp code tổng quát, dễ mở rộng — ví dụ bạn có thể thêm ZaloPayPayment mà không cần sửa lớp Order.
//
//🧬 2️⃣ TÍNH KẾ THỪA (Inheritance)
//
//        Lớp con kế thừa thuộc tính và hành vi của lớp cha, có thể mở rộng hoặc ghi đè.
//
//        💡 Trong code:
//        class ElectronicProduct extends Product { ... }
//        class FoodProduct extends Product { ... }
//
//
//        Cả hai lớp con kế thừa thuộc tính: productId, name, price, category từ Product.
//
//        Đồng thời ghi đè lại phương thức getInfo() để hiển thị theo cách riêng.
//
//        ➡ Ví dụ:
//
//        @Override
//        public String getInfo() {
//            return String.format("[%s] %s - %.0f VND | IMEI: %s | Bảo hành: %d tháng", ...);
//        }
//
//
//🎯 Lợi ích:
//        Giúp tái sử dụng code — không cần viết lại các trường cơ bản cho từng loại sản phẩm.
//        Chỉ cần kế thừa và mở rộng.
//
//🌀 3️⃣ TÍNH ĐA HÌNH (Polymorphism)
//
//        Cùng một lời gọi (phương thức), nhưng hành vi khác nhau tùy đối tượng thực tế.
//
//        💡 Trong code:
//        Product p1 = new ElectronicProduct(...);
//        Product p2 = new FoodProduct(...);
//
//        System.out.println(p1.getInfo());
//        System.out.println(p2.getInfo());
//
//
//        Cả hai biến p1, p2 đều có kiểu Product,
//        nhưng khi gọi getInfo():
//
//        p1 → chạy getInfo() của ElectronicProduct
//
//        p2 → chạy getInfo() của FoodProduct
//
//        Tương tự:
//
//        Order order1 = new Order("A", new CashPayment());
//        Order order2 = new Order("B", new CreditCardPayment());
//        Order order3 = new Order("C", new MomoPayment());
//
//order1.checkout(); // gọi pay() của CashPayment
//order2.checkout(); // gọi pay() của CreditCardPayment
//order3.checkout(); // gọi pay() của MomoPayment
//
//
//🎯 Lợi ích:
//        Giúp chương trình linh hoạt và mở rộng dễ dàng,
//        Order không cần biết kiểu thanh toán cụ thể nào, chỉ cần gọi pay() là được.
//
//        🔒 4️⃣ TÍNH ĐÓNG GÓI (Encapsulation)
//
//        Giấu dữ liệu bên trong lớp, chỉ cho phép truy cập thông qua phương thức.
//
//        💡 Trong code:
//        class Order {
//            private String customerName;
//            private List<Product> products;
//            private PaymentMethod paymentMethod;
//        }
//
//
//        Các thuộc tính customerName, products, paymentMethod đều là private → không thể truy cập trực tiếp từ bên ngoài.
//
//        Thay vào đó, ta tương tác gián tiếp qua phương thức:
//
//        public void addProduct(Product p) { ... }
//        public double calculateTotal() { ... }
//        public void checkout() { ... }
//
//
//🎯 Lợi ích:
//        Bảo vệ dữ liệu nội bộ của đối tượng,
//        ngăn can thiệp sai (ví dụ không cho người ngoài tự sửa products hay paymentMethod).