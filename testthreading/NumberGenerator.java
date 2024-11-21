package testthreading;

import java.util.Scanner;

public class NumberGenerator extends Thread {
    private int n;
    private boolean sent;

    public NumberGenerator(int n) {
        this.setN(n);
        sent=false;
        start();
    }


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = s.nextInt();
        NumberGenerator numberGenerator = new NumberGenerator(n);
        numberGenerator.join();
        s.close();
        System.out.println("Time:"+(System.currentTimeMillis()-start)+" milliseconds");
    }

    
    

    public void run()  {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i+1;
        }
        PrimeChecker primeChecker = new PrimeChecker(numbers);
        try{
        primeChecker.join();
        }catch(InterruptedException e){}
    }

    public void setN(int n) {
        if (n >= 0)
            this.n = n;
        else
            this.n = 10;
    }

    public int getN() {
        return n;
    }
}
