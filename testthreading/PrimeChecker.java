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
        int num;
        while(true){
            num = shared.getNum();
        if(num==-1){
        break;
        }
        if(isPrime(num))
                System.out.println(num);
        }
    }

    /*
    public void toggleGenerated() {
        this.generated = !this.generated;
    }
*/
}
