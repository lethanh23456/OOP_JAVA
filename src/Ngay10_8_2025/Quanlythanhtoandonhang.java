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
