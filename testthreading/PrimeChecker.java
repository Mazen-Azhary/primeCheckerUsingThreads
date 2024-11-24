package testthreading;

public class PrimeChecker extends Thread {

    SharedNumber shared;

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

    public PrimeChecker(SharedNumber s) {
        this.shared=s;
        start();
    }

    public void run() {
        while(true){
        if(shared.getNum()==-1){
        break;
        }
        if(isPrime(shared.getNum()))
                System.out.println(shared.getNum());
        }
    }

    /*
    public void toggleGenerated() {
        this.generated = !this.generated;
    }
*/
}
