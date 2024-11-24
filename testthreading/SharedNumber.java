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
        if (isSet) {

            try {
                wait();
            } catch (InterruptedException ex) {
            }
            this.number = n;
            isSet = true;
            notify();

        }
    }
    public synchronized int getNum() {
        if (!isSet) {

            try {
                wait();
            } catch (InterruptedException ex) {
            }

        }
        isSet = false;
        notify();
        return number;

    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = s.nextInt();
        s.nextLine();
        SharedNumber myN = new SharedNumber();
        NumberGenerator numberGenerator = new NumberGenerator(n, myN);
        PrimeChecker p = new PrimeChecker(myN);

        numberGenerator.join();
        p.join();

        s.close();
        System.out.println("Time:" + (System.currentTimeMillis() - start) + " milliseconds");
    }


}
