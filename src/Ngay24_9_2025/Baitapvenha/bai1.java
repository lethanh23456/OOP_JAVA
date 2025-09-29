package Ngay24_9_2025.Baitapvenha;


class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }


    public double calculateSalary() {
        return 0;
    }

    public void displayInfo() {
        System.out.println("Tên: " + getName());
        System.out.println("Tuổi: " + getAge());
        System.out.println("Lương: " + calculateSalary());
        System.out.println("--------------------------");
    }
}


class OfficeEmployee extends Employee {
    private int workingDays;
    private static final int SALARY_PER_DAY = 100;

    public OfficeEmployee(String name, int age, int workingDays) {
        super(name, age);
        this.workingDays = workingDays;
    }

    @Override
    public double calculateSalary() {
        return workingDays * SALARY_PER_DAY;
    }
}


class TechnicalEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public TechnicalEmployee(String name, int age, int workingHours, double hourlyRate) {
        super(name, age);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }
}


public class bai1 {
    public static void main(String[] args) {
        Employee officeEmp = new OfficeEmployee("nv1", 30, 22);
        Employee techEmp = new TechnicalEmployee("nv2", 28, 160, 15.5);

        officeEmp.displayInfo();
        techEmp.displayInfo();
    }
}


