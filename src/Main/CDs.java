/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author nguyenthanhdat
 */
public class CDs {

    private String CD_Collection_name;
    private String CD_type;
    private String CD_ID;
    private String title;
    private float Unit_price;
    private Date Publishing_year;

    Scanner sc = new Scanner(System.in);

    public CDs() {
    }

    public CDs(String CD_Collection_name, String CD_type, String CD_ID, String title, float Unit_price, Date Publishing_year) {
        this.CD_Collection_name = CD_Collection_name;
        this.CD_type = CD_type;
        this.CD_ID = CD_ID;
        this.title = title;
        this.Unit_price = Unit_price;
        this.Publishing_year = Publishing_year;
    }

    public String getCD_Collection_name() {
        return CD_Collection_name;
    }

    public void setCD_Collection_name(String CD_Collection_name) {
        boolean check = true;
        do {
            try {
                if (CD_Collection_name.equals("game") || CD_Collection_name.equals("movie") || CD_Collection_name.equals("music")) {
                    check = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("CD collection name (game/movie/music): ");
                CD_Collection_name = sc.nextLine();
                check = true;
            }
        } while (check);
        this.CD_Collection_name = CD_Collection_name;
    }

    public String getCD_type() {
        return CD_type;
    }

    public void setCD_type(String CD_type) {
        boolean check = true;
        do {
            try {
                if (CD_type.equals("audio") || CD_type.equals("video")) {
                    check = false;
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.print("CD type (audio/video): ");
                CD_type = sc.nextLine();
                check = true;
            }
        } while (check);
        this.CD_type = CD_type;
    }

    public String getCD_ID() {
        return CD_ID;
    }

    public void setCD_ID(String CD_ID) {
        boolean check = true;
        do {
            try {
                if (CD_ID.isEmpty() || CD_ID.length() < 5) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.print("CD ID has length greater than 5 and not empty: ");
                CD_ID = sc.nextLine();
                check = true;
            }
        } while (check);
        this.CD_ID = CD_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        boolean check = true;
        do {
            try {
                if (title.isEmpty() || title.length() < 5) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.print("Title has length greater than 5 and not empty: ");
                title = sc.nextLine();
                check = true;
            }
        } while (check);
        this.title = title;
    }

    public float getUnit_price() {
        return Unit_price;
    }

    public void setUnit_price(float Unit_price) {
        boolean check = true;
        do {
            try {
                if (Unit_price < 0 || Unit_price > 200000) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.print("Amount must be greater than 0 and less than 200000: ");
                Unit_price = Float.parseFloat(sc.nextLine());
                check = true;
            }
        } while (check);
        this.Unit_price = Unit_price;
    }

    public Date getPublishing_year() {
        return Publishing_year;
    }

    public void setPublishing_year(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        boolean check = true;
        this.Publishing_year = calendar.getTime();

    }

    // ADD 
    public void add(Scanner sc) {
        System.out.print("Enter CD collection name (game/movie/music): ");
        this.setCD_Collection_name(sc.nextLine());
        System.out.print("Enter CD type (audio/video): ");
        this.setCD_type(sc.nextLine());
        System.out.print("Enter CD ID: ");
        this.setCD_ID(sc.nextLine());
        System.out.print("Enter Title: ");
        this.setTitle(sc.nextLine());
        System.out.print("Enter Unir Price: ");
        this.setUnit_price(Float.parseFloat(sc.nextLine()));
        System.out.print("Enter Publishing Year [Year/Month/Day]: ");
        this.setPublishing_year(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
    }

    // ADD UPDATE
    public void add_update(Scanner sc) {
        System.out.print("Enter CD collection name (game/movie/music): ");
        this.setCD_Collection_name(sc.nextLine());
        System.out.print("Enter CD type (audio/video): ");
        this.setCD_type(sc.nextLine());
        System.out.print("Enter Title: ");
        this.setTitle(sc.nextLine());
        System.out.print("Enter Unir Price: ");
        this.setUnit_price(Float.parseFloat(sc.nextLine()));
        System.out.println("Enter Publishing Year [Year/Month/Day]: ");
        this.setPublishing_year(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
    }

    // Display
    public void display() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String str1 = date.format(Publishing_year);
        System.out.printf("%s, %s, %s, %s, %.2f, %s", CD_Collection_name, CD_type, CD_ID, title, Unit_price, str1);
        System.out.println("\n+---------------------------------------------------------+");
    }

    // ToString
    @Override
    public String toString() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String str1 = date.format(Publishing_year);
        return CD_Collection_name + ", " + CD_type + ", " + CD_ID + ", " + title + ", " + Unit_price + ", " + str1;
    }

}
