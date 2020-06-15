/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp50;


/**
 *
 * @author I'mTrung
 */
public class menu {
    Validate v = new Validate();
    int getChoice() {
        System.out.println("========= Equation Program ========="
                + "\n1. Calculate Superlative Equation"
                + "\n2. Calculate QuadraticEquation"
                + "\n3. Exit"
                + "\nPlease choose an option: ");
        
        int choice = v.checkLimit(1, 3);
        return choice;

    }

}
