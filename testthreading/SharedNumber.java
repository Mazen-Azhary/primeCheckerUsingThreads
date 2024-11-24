/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testthreading;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mazen
 */
public class SharedNumber {

    private int number;
    private boolean isSet;

    public synchronized void setNum(int n) {
        //System.out.println("in set");
        if (isSet) {

            try {
                wait();
            } catch (InterruptedException ex) {
            }

        }
            this.number = n;
            isSet = true;
            notifyAll();
    }
    public synchronized int getNum() {
      //  System.out.println("in get");
        if (!isSet) {

            try {
                wait();
            } catch (InterruptedException ex) {
            }

        }
        isSet = false;
        notifyAll();
        return number;

    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = s.nextInt();
        s.nextLine();
        SharedNumber myN = new SharedNumber();
        NumberGenerator numbergenerator = new NumberGenerator(n, myN);
        PrimeChecker p = new PrimeChecker(myN);

        numbergenerator.join();
        p.join();

        s.close();
        System.out.println("Time:" + (System.currentTimeMillis() - start) + " milliseconds");
    }


}
