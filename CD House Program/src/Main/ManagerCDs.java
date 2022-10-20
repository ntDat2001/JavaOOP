/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nguyenthanhdat
 */
public class ManagerCDs {

    private List<CDs> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Load File
    public void LoadFile() throws FileNotFoundException, IOException {
        FileReader fd = new FileReader("CD.dat");
        BufferedReader br = new BufferedReader(fd);
        String line = "";
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            String txt[] = line.split(", ");
            String Collection = txt[0];
            String CD_type = txt[1];
            String CD_ID = txt[2];
            String title = txt[3];
            float Unit_Price = Float.parseFloat(txt[4]);

            // Cach xu li DATE
            String str1 = txt[5];
            String str2[] = str1.split("/");
            int dd = Integer.parseInt(str2[0]);
            int MM = Integer.parseInt(str2[1]);
            int yyyy = Integer.parseInt(str2[2]);
            Calendar calendar = Calendar.getInstance();
            calendar.set(yyyy, MM - 1 , dd);
            Date Publishing_year = calendar.getTime();

            CDs cs = new CDs(Collection, CD_type, CD_ID, title, Unit_Price, Publishing_year);
            list.add(cs);
        }
        br.close();
        fd.close();
    }

    // Function 1: Add CD to the catalog - 100 LOC
    public void Add() {
        CDs cd = new CDs();
        cd.add(sc);
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCD_ID().equalsIgnoreCase(cd.getCD_ID()) || list.get(i).getTitle().equalsIgnoreCase(cd.getTitle())) {
                check = true;
                break;
            }
        }
        if (check == true) {
            System.out.println("CD ID is duplicated and CD Titile is duplicated!");
        } else {
            list.add(cd);
            System.out.println("Added!");
        }
    }

    // Function 2: Search CD by CD title - 50 LOC
    public void Search() {
        System.out.print("Enter the CD Title you wanna to search: ");
        String search_title = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equalsIgnoreCase(search_title)) {
                list.get(i).display();
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Not Found!");
        }
    }

    // Function 3: Display the catalog - 50 LOC
    public void Display() {
        System.out.println("The number of CDs is: " + list.size());
        System.out.println("List of CDs"
                + "       \n+---------------------------------------------------------+");
        for (CDs o : list) {
            o.display();
        }
    }

    // Function 4.1: Update CD
    public void Update() {
        System.out.print("Enter CD ID you wanna to update: ");
        String update_id = sc.nextLine();
        boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCD_ID().equalsIgnoreCase(update_id)) {
                CDs update_cds = new CDs();
                update_cds.add_update(sc);
                if (list.get(i).getTitle().equalsIgnoreCase(update_cds.getTitle())) {
                    check = false;
                    break;
                }
                SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
                String str1 = spd.format(update_cds.getPublishing_year());
                String txt[] = str1.split("/");
                int dd = Integer.parseInt(txt[0]);
                int MM = Integer.parseInt(txt[1]);
                int yyyy = Integer.parseInt(txt[2]);
                list.get(i).setCD_Collection_name(update_cds.getCD_Collection_name());
                list.get(i).setCD_type(update_cds.getCD_type());
                list.get(i).setTitle(update_cds.getTitle());
                list.get(i).setUnit_price(update_cds.getUnit_price());
                list.get(i).setPublishing_year(yyyy, MM, dd);
                check = true;
                break;
            }
        }
        if (check == true) {
            System.out.println("Updated!");
        } else {
            System.out.println("Failed!");
        }
    }

    // Function 4.2: Delete CD information – 50 LOC
    public void Delete() {
        System.out.print("Enter CD ID you wanna to delete: ");
        String detele_id = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCD_ID().equalsIgnoreCase(detele_id)) {
                list.remove(i);
                check = true;
                break;
            }
        }
        if (check == true) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Failed!");
        }
    }

    // Function 5: Save to file - 50 LOC
    public void SavetoFile() throws IOException {
        if (!list.isEmpty()) {
            try {
                FileWriter fw = new FileWriter("CD.dat");
                BufferedWriter bw = new BufferedWriter(fw);
                for (CDs o : list) {
                    bw.write(o.toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();

            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("CD.dat has saved!");
        } else {
            System.out.println("List is empty!");
        }
    }

    // Function 6: Print list CDs from file.
    // Vì đã có funtion loadfile nên có thể không cần function này cũng được, vì theo yêu cầu bài toán chúng ta nên làm theo 
    public void PrintlistCDs() {
        if (!list.isEmpty()) {
            try {
                FileReader fd = new FileReader("CD.dat");
                BufferedReader br = new BufferedReader(fd);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String txt[] = line.split(", ");
                    String Collection = txt[0];
                    String CD_type = txt[1];
                    String CD_ID = txt[2];
                    String title = txt[3];
                    float Unit_Price = Float.parseFloat(txt[4]);

                    // Cach xu li DATE
                    String str1 = txt[5];
                    String str2[] = str1.split("/");
                    int dd = Integer.parseInt(str2[0]);
                    int MM = Integer.parseInt(str2[1]);
                    int yyyy = Integer.parseInt(str2[2]);
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(yyyy, MM - 1, dd);
                    Date Publishing_year = calendar.getTime();

                    CDs cs = new CDs(Collection, CD_type, CD_ID, title, Unit_Price, Publishing_year);
                    cs.display();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
