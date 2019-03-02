/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemoworking;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jamesK
 */
public class HibernateDemoWorking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data d = Data.getInstance();

        Scanner reader = new Scanner(System.in);
        System.out.println("Choose an Option: ");
        System.out.println("1: View All Swords in Database");
        System.out.println("2: Add Sword to the Database");
        System.out.println("3: Search for Swords by Name");
        System.out.println("4: Quit Program");

        int input = reader.nextInt();

        switch (input) {
            case 1:
                // get all swords
                List<Sword> s = d.getSwords();
                s.forEach((i) -> {
                    System.out.println(i);
                });
                break;
            case 2:
                Scanner case2input = new Scanner(System.in);
                // get user input
                System.out.println("Sword Name: ");
                String name = case2input.nextLine();
           
                System.out.println("Sword Culture: ");
                String culture = case2input.nextLine();
       
                System.out.println("Blade Shape: ");
                String shape = case2input.nextLine();
   
                // add sword to database
                try {
                    d.addSword(name, culture, shape);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                case2input.close();
                break;
            case 3:
                // functionality not complete yet
                Scanner case3input = new Scanner(System.in);
                System.out.println("Sword Name Search: ");
                String searchname = case3input.nextLine();
                System.out.println(d.getSwordByName(searchname));
                break;
                
            case 4: 
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input. Try Again");
                break;
        }     

        // d.getSwordsById(1);
        System.out.println(d);
    }

}
