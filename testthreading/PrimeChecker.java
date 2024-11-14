package testthreading;

public class PrimeChecker extends Thread{
    
    public boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private int[] numbers;
    public PrimeChecker(int[] numbers) {
        this.numbers = numbers;
        start();
    }


    public void run() {
        for (int i = 0; i < numbers.length; i++) {
            if (isPrime(numbers[i]))
                System.out.println(numbers[i]);
        }
    }


}
