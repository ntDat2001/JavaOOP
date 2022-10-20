/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

import MAIN.ManagerProduct;
import java.util.Scanner;

/**
 *
 * @author nguyenthanhdat
 */
public class Test {

    public static void main(String[] args) {
//        File file1 = new File("/Users/nguyenthanhdat/NetBeansProjects/Product Management/product.txt");
//		try
//		{
//			file1.createNewFile();
//		}
//		catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//                System.out.println("File: "+file1.exists());
        Scanner sc = new Scanner(System.in);
        ManagerProduct mp = new ManagerProduct();
        mp.LoadFile();
        // Vì sẽ tối ưu code, nên mình sẽ load trước file để cho nó lưu data vào list trước
        // Khi thực hiện sẽ đồng bộ hơn
        int choice;
        do {
            System.out.println(""
                    + "|--------------------Application ManagerProduct--------------------|\n"
                    + "|                    1. Print.                                     |\n"
                    + "|                    2. Create a Product.                          |\n"
                    + "|                    3. Check exits Product.                       |\n"
                    + "|                    4. Search Product’ information by Name.       |\n"
                    + "|                    5. Update Product.                            |\n"
                    + "|                    6. Delete Product.                            |\n"
                    + "|                    7. Save Products to file.                     |\n"
                    + "|                    8. Print list Products from the file.         |\n"
                    + "|                    0. To Exit.                                   |\n"
                    + "|*Note: Status is true -> is Available, is false -> Not Available  |\n"
                    + "|------------------------------------------------------------------|\n");
            System.out.print("Enter ur choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice) {
                case 1:{
                    mp.print();
                    break;
                }
                case 2: {
                    mp.CreateProduct();
                    break;
                }
                case 3: {
                    mp.CheckExistProduct();
                    break;
                }
                case 4: {
                    mp.SearchByName();
                    break;
                }
                case 5: {
                    mp.UpdatebyID();
                    break;
                }
                case 6: {
                    mp.DeleteID();
                    break;
                }
                case 7: {
                    mp.saveToFile();
                    break;
                }
                case 8: {
                    mp.PrintallfromFile();
                    break;
                }
            }
        } while (choice != 0);
    }

}
