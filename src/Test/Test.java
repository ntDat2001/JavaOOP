/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Main.ManagerCDs;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nguyenthanhdat
 */
public class Test {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
//        File file = new File("/Users/nguyenthanhdat/NetBeansProjects/CD House Program/CD.dat");
//        try {
//            file.createNewFile();
//        } catch (Exception e) {
//        }
        Scanner sc = new Scanner(System.in);
        ManagerCDs mc = new ManagerCDs();
        mc.LoadFile();
        int choice = 0;
        do {
            System.out.print(""
                    + "\n+---------------------------Application ManagerCDs---------------------------+\n"
                    + "|                           Enter1. Add CD to the catalog.                   |\n"
                    + "|                           Enter2. Search CD by CD title.                   |\n"
                    + "|                           Enter3. Display the catalog.                     |\n"
                    + "|                           Enter4. Update CD.                               |\n"
                    + "|                           Enter5. Delate CD.                               |\n"
                    + "|                           Enter6. Save account to file.                    |\n"
                    + "|                           Enter7. Print list CDs from file.                |\n"
                    + "|                           Enter0. To exit.                                 |\n"
                    + "+----------------------------------------------------------------------------+\n"
                    + "Enter ur choice: ...");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    mc.Add();
                    break;
                }
                case 2: {
                    mc.Search();
                    break;
                }
                case 3: {
                    mc.Display();
                    break;
                }
                case 4: {
                    mc.Update();
                    break;
                }
                case 5: {
                    mc.Delete();
                    break;
                }
                case 6: {
                    mc.SavetoFile();
                    break;
                }
                case 7: {
                    mc.PrintlistCDs();
                    break;
                }
            }
        } while (choice != 0);
    }
}
