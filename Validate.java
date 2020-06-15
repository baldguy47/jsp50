/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp50;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author I'mTrung
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public boolean valid(String s) {

        if (s.trim().equals("")) {
            System.err.println("Input must not be blank.");
            return false;
        }
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(s);
        if (!m.matches()) {
            System.err.println("Please input number");
            return false;
        }

        return true;
    }

    int checkLimit(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
        
    }

    public double getInput(String msg) {
        String s;

        do {
            System.out.print(msg);
            s = sc.nextLine();
        } while (!valid(s));
        double num = Double.parseDouble(s);
        return num;
    }
}
