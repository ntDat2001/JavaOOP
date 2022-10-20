/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MAIN;

import java.util.Scanner;

/**
 *
 * @author nguyenthanhdat
 */
public class Product implements Comparable<Product> {

    private String ProductID;
    private String ProductName;
    private float UnitPrice;
    private int Quantity;
    private String Status;

    Scanner sc = new Scanner(System.in);

    public Product() {
    }

    public Product(String ProductID, String ProductName, float UnitPrice, int Quantity, String Status) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
        this.Status = Status;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        boolean check = true;
        do {
            try {
                if (ProductName.isEmpty() || ProductName.length() < 5) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.print("Productname isn't empty && length >= 5: ");
                ProductName = sc.nextLine();
                check = true;
            }
        } while (check);
        this.ProductName = ProductName;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        boolean check = true;
        do {
            try {
                if (UnitPrice < 0 || UnitPrice > 10000) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.print("UnitPrice >= 0 & UnitPrice <= 10000: ");
                UnitPrice = Float.parseFloat(sc.nextLine());
                check = true;
            }
        } while (check);
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        boolean check = true;
        do {
            try {
                if (Quantity < 0 || Quantity > 1000) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.print("Quantity >= 0 & Quantity <= 1000: ");
                Quantity = Integer.parseInt(sc.nextLine());
                check = true;
            }
        } while (check);
        this.Quantity = Quantity;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        boolean check = true;
        do {
            try {
                if (Status.isEmpty() || Status.equalsIgnoreCase("Available") == false) {
                    if(Status.equalsIgnoreCase("Not Available") == false) {
                        throw new Exception();
                    }
                }
                check = false;
            } catch (Exception e) {
                System.out.print("[Available or Not Available]: ");
                Status = sc.nextLine();
                check = true;
            }
        } while (check);
        this.Status = Status;
    }

//    public boolean isStatus() {
//        return Status;
//    }
//
//    public void setStatus(boolean Status) {
//        this.Status = Status;
//    }
    // Dùng để nhập phần tử trong class ManagerProduct
    public void add(Scanner sc) {
        System.out.print("Enter the ProductID: ");
        this.setProductID(sc.nextLine());
        System.out.print("Enter the ProductName: ");
        this.setProductName(sc.nextLine());
        System.out.print("Enter the Unique: ");
        this.setUnitPrice(Float.parseFloat(sc.nextLine()));
        System.out.print("Enter the Quantity: ");
        this.setQuantity(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter the Status [Available or Not Available]: ");
        this.setStatus(sc.nextLine());
    }

    // Dùng để nhập dữ liệu update trong class ManagerProduct
    public void add_update(Scanner sc) {
        System.out.print("Enter the ProductName: ");
        this.setProductName(sc.nextLine());
        System.out.print("Enter the Unique: ");
        this.setUnitPrice(Float.parseFloat(sc.nextLine()));
        System.out.print("Enter the Quantity: ");
        this.setQuantity(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter the Status: ");
        this.setStatus(sc.nextLine());
    }

    // Hiển thi thông tin danh sách
    public void display() {
        System.out.printf("%s | %s | %.2f | %d | %s", ProductID, ProductName, UnitPrice, Quantity, Status);
        System.out.println();
    }

    @Override
    public String toString() {
        return ProductID + " | " + ProductName + " | " + UnitPrice + " | " + Quantity + " | " + Status;
    }

    // So sánh bằng trường quantity
    @Override
    public int compareTo(Product o) {
        return o.Quantity - this.Quantity;
    }
}
