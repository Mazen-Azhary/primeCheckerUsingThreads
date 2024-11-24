package testthreading;

import java.util.Scanner;

public class NumberGenerator extends Thread {

    private int n;
    SharedNumber shared;

    public NumberGenerator(int n,SharedNumber shared) {
       this.n=n;
       this.shared=shared;
        start();
    }

    

    public void run() {

       for (int i = 1; i <= n; i++) {
            shared.setNum(i);
        }
        shared.setNum(-1);

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

}
