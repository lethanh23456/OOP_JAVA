package Ngay17_9_2025;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}

class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Order {
    private Customer customer;
    private List<Product> productList;
    public static int orderCount = 0;

    public Order(Customer customer) {
        this.customer = customer;
        this.productList = new ArrayList<>();
        orderCount++;
    }

    public void addProduct(Product p) {
        productList.add(p);
    }

    public float calculateTotal() {
        float total = 0;
        for (Product p : productList) {
            total += p.getPrice();
        }
        return total;
    }

    public void printOrder() {
        System.out.println("Khách hàng: " + customer.getName() + " (" + customer.getEmail() + ")");
        System.out.println("Danh sách sản phẩm:");
        for (Product p : productList) {
            System.out.println("- " + p.getName() + " : " + p.getPrice() + " VND");
        }
        System.out.println("Tổng tiền: " + calculateTotal() + " VND");
    }
}

public class Quanlycuahang {
    public static void main(String[] args) {

        Product p1 = new Product("sp1", 15000000);
        Product p2 = new Product("sp2", 300000);



        Customer c1 = new Customer("Lê Đình Thành", "123@gmail.com");


        Order order1 = new Order(c1);
        order1.addProduct(p1);
        order1.addProduct(p2);


        order1.printOrder();


        System.out.println("Số lượng đơn hàng đã tạo: " + Order.orderCount);
    }
}
