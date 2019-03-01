/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemoworking;

import java.util.List;

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
        
        List<Sword> s = d.getSwords();
        s.forEach((i) -> {
            System.out.println(i);
        });

        d.getSwordsById(1);
        System.out.println(d);
    }

}
