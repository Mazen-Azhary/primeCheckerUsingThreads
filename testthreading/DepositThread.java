/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testthreading;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mazen
 */
public class DepositThread extends Thread {

    private BankAccount acc;

    public DepositThread(BankAccount acc) {
        this.acc = acc;
        start();
    }

    public void run() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            double amount = r.nextInt(100) + 10 + r.nextDouble();
            acc.deposit(amount);
            System.out.println("succesful deposit " + (i + 1) + " amount:" + amount);
            try {
                
                sleep(1000);
            } catch (InterruptedException ex) {
            }
        }

    }

}
