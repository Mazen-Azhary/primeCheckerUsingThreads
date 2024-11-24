package testthreading;

import java.util.Scanner;

public class NumberGenerator extends Thread {

    private int n;
    private boolean generated;
    private int a[];

    public NumberGenerator(int n) {
        a = new int[1];
        this.setN(n);
        generated = false;
        start();
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = s.nextInt();
        s.nextLine();
        NumberGenerator numberGenerator = new NumberGenerator(n);
        numberGenerator.join();
        s.close();
        System.out.println("Time:" + (System.currentTimeMillis() - start) + " milliseconds");
    }

    public synchronized void run() {

        PrimeChecker primeChecker = new PrimeChecker(this, a, n);
        for (int i = 0; i < n; i++) {
            if (generated) {
                try {
                    System.out.println("in wait");
                    wait();
                } catch (InterruptedException ex) {
                }
            } else {
                a[0] = i + 1;
                System.out.println("generated num");
                toggleGenerated();             
                primeChecker.toggleGenerated();
                notifyAll();
            }

        }
    }

    public void setN(int n) {
        if (n >= 0) {
            this.n = n;
        } else {
            this.n = 10;
        }
    }

    public int getN() {
        return n;
    }

    public void toggleGenerated() {
        this.generated = !this.generated;
    }

}
