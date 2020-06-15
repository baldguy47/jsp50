/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp50;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author I'mTrung
 */
public class calE {

    Validate v = new Validate();
    NumberFormat myFormat = NumberFormat.getInstance();
    ArrayList<Double> list = new ArrayList<>();
    menu m = new menu();
    Scanner sc = new Scanner(System.in);
    //*******DRIVER*******
    void run(){
        int choice = m.getChoice();
        switch (choice) {
            case 1:
                list = calculateEquation();
                System.out.println(list);
                isOdd(list);
                isEven(list);
                System.out.println();
                isPerfectSquare(list);
                break;
            case 2:
                list = calculateQuadraticEquation();
                isOdd(list);
                isEven(list);
                System.out.println();
                isPerfectSquare(list);
                break;
            case 3:
                System.exit(0);
        }
    }
    ArrayList<Double> calculateEquation() {

        double a = v.getInput("Enter A: ");
        double b = v.getInput("Enter B: ");
        double result = 0;

        if (a != 0) {
            result = -b / a;
        } else {
            return null;
        }
        list.add(a);
        list.add(b);
        list.add(result);
        return list;
    }

    ArrayList<Double> calculateQuadraticEquation() {
        double a = v.getInput("Enter A: ");
        double b = v.getInput("Enter B: ");
        double c = v.getInput("Enter C: ");
        double result1 = 0;
        double result2 = 0;
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta < 0) {
            System.out.println("The Equation has no root.");
        } else if (delta > 0) {
            result1 = (-b - Math.sqrt(delta));
            result2 = (-b + Math.sqrt(delta));
            System.out.print("Solution: "
                    + "x1 = " + result1
                    + "x2 = " + result2);
        } else if (delta == 0) {
            result1 = result2 = -b / (2 * a);
            System.out.println("Solution: " + "x = " + result1);
        }

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(result1);
        list.add(result2);

        return list;
    }

    void isOdd(ArrayList<Double> list) {
        ArrayList<Double> oddList = new ArrayList<>();
        System.out.print("Odd Number(s): ");
        for (double value : list) {
            if (value % 2 != 0) {
                oddList.add(value);
            }
        }
        display(oddList);
    }

    void isEven(ArrayList<Double> list) {
        ArrayList<Double> evenList = new ArrayList<>();
        System.out.print("Number is Even: ");
        for (double value : list) {
            if (value % 2 == 0) {
                evenList.add(value);
            }
        }
        display(evenList);
    }

    void isPerfectSquare(ArrayList<Double> list) {
        ArrayList<Double> squareList = new ArrayList<>();
        System.out.print("Number is Perfect Square: ");
        for (double value : list) {
            double sr = Math.sqrt(value);
            double perfectSquare = sr - Math.floor(sr);
            if (perfectSquare == 0) {
                squareList.add(value);
            }
        }
        display(squareList);
    }

    public void display(ArrayList<Double> list) {

        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.println(list.get(i));
            }
        }
    }
}
