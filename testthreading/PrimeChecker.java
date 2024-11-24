package testthreading;

public class PrimeChecker extends Thread {

    private int n;
    private int[] a;
    private boolean generated;
    NumberGenerator parent;

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public PrimeChecker(NumberGenerator parent, int[] a, int n) {
        this.n = n;
        this.a = a;
        this.parent = parent;
        this.generated = true;
        start();
    }

    public synchronized void run() {
        for (int i = 0; i < n; i++) {
            if (!generated) {
                try {
                    System.out.println("in checker wait");
                    wait();
                } catch (InterruptedException ex) {
                }
            } else {
                System.out.println("in checker else");
                toggleGenerated();
                if (isPrime(a[0])) {
                    System.out.println(a[0]);
                }
                parent.toggleGenerated();
                notifyAll();
            }
        }
    }

    public void toggleGenerated() {
        this.generated = !this.generated;
    }

}
