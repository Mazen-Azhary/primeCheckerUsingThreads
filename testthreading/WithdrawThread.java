/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testthreading;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Mazen
 */
public class WithdrawThread extends Thread {

    private BankAccount acc;

    public WithdrawThread(BankAccount acc) {
        this.acc = acc;
        start();
    }

    public void run() {
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            double amount = r.nextInt(100) + 10 + r.nextDouble();
            if (acc.withdraw(amount)) {
                System.out.println("succesful withdraw " + (i + 1) + " amount:" + amount);
            } else {

                System.out.println("failed withdraw:" + (i + 1) + " amount:" + amount);
            }
            try {
                
                sleep(1000);
            } catch (InterruptedException ex) {
            }
        }

    }

}
