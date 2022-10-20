/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MAIN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nguyenthanhdat
 */
public class ManagerProduct {

    private List<Product> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // LoadFile 
    public void LoadFile() {
        try {
            FileReader fr = new FileReader("product.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(", ");
                String ID = txt[0];
                String ProductName = txt[1];
                float UnitPrice = Float.parseFloat(txt[2]);
                int Quantity = Integer.parseInt(txt[3]);
                String Status = txt[4];
                Product p = new Product(ID, ProductName, UnitPrice, Quantity, Status);
                list.add(p);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Function 1 Print
    public void print() {
        if (list.isEmpty()) {
            System.out.println("Have no any data!, pls insert product!");
        } else {
            System.out.println("List of Product: ");
            for (Product o : list) {
                o.display();
            }
        }
    }

    // Function 2: Create a Product - 50 LOC
    public void CreateProduct() {
        boolean check = false;
        Product p = new Product();
        p.add(sc);
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getProductName().equalsIgnoreCase(p.getProductName())) || (list.get(i).getProductID().equalsIgnoreCase(p.getProductID()))) {
                check = true;
                break;
            }
        }
        if (check == true) {
            System.out.println("A Product Name is not allowed to duplicate!");
        } else {
            list.add(p);
            System.out.println("Added!");
        }
    }

    // Function 3: Check to exist Product– 50 LOC
    public void CheckExistProduct() {
        System.out.print("Enter the ProductName you wanna check stored in file: ");
        String check_name = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductName().equalsIgnoreCase(check_name)) {
                System.out.println("Exist Product");
                System.out.println("[ProductID ,ProductName, UnitPrice, Quantity, Status]");
                list.get(i).display();
                break;
            }
        }
        if (check == false) {
            System.out.println("No Product Found!");
        }
    }

    // Function 4: Search Product information by name – 50 LOC
    public void SearchByName() {
        int count = 0;
        System.out.println("Enter a part of ProductName you wanna to search: ");
        String search_name = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductName().contains(search_name)) {
                list.get(i).display();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Have no any Product!");
        }
    }

    // Function 5: Update Product
    public void UpdatebyID() {
        int check = 0;
        System.out.print("Enter the ID you wanna to update: ");
        String ID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductID().equals(ID)) {
                Product p = new Product();
                p.add_update(sc);
                if (p.getProductName().isBlank() == true) {
                    System.out.println("The inputted information is blank, old information will not be changed.");
                    check = 2;
                    break;
                } else {
                    list.get(i).setProductName(p.getProductName());
                    list.get(i).setUnitPrice(p.getUnitPrice());
                    list.get(i).setQuantity(p.getQuantity());
                    list.get(i).setStatus(p.getStatus());
                    check = 3;
                    break;
                }
            } else {
                check = 1;
            }
        }
        if (check == 1 || check == 2) {
            System.out.println("Update failure!");
        } else if (check == 3) {
            System.out.println("Update success!");
        }
    }

    // Function 6: Delete Product information – 50 LOC
    public void DeleteID() {
        boolean check = false;
        System.out.print("Enter the ID you wanna to delete: ");
        String ID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductID().equals(ID)) {
                System.out.print("Are you want delete this product[Yes or No]: ");
                String check_agree = sc.nextLine();
                if(check_agree.equalsIgnoreCase("Yes")) {
                    list.remove(i);
                    check = true;
                    break;
                } else {
                    break;
                }
            }
        }
        if (check == false) {
            System.out.println("Delete fail!");
        } else {
            System.out.println("Delete success!");
        }
    }

    // Function 7: Save to file - 50 LOC
    public void saveToFile() {
        if (!list.isEmpty()) {
            try {
                FileWriter fw = new FileWriter("product.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                for (Product o : list) {
                    bw.write(o.toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (IOException ex) {
            }
            System.out.println("product.txt has been saved!");
        } else {
            System.out.println("List Product is empty!");
        }
    }

    // Function 8: Print all lists from file – 50 LOC
    // Vì phải làm theo yêu cầu nên có thể để phần này ở lại 
    // Do chương trình đã tối ưu code nên function 8 có thể xóa
    public void PrintallfromFile() {
        list.removeAll(list);
        try {
            FileReader fr = new FileReader("product.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(", ");
                String ID = txt[0];
                String ProductName = txt[1];
                float UnitPrice = Float.parseFloat(txt[2]);
                int Quantity = Integer.parseInt(txt[3]);
                String Status = txt[4];
                Product p = new Product(ID, ProductName, UnitPrice, Quantity, Status);
                list.add(p);
            }
        } catch (IOException | NumberFormatException e) {
        }
        Collections.sort(list);
        for (Product o : list) {
            o.display();
        }
    }
}
