/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testthreading;

/**
 *
 * @author Mazen
 */
public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }
    
    synchronized public void deposit(double balnce){
    
        setBalance(getBalance()+balnce);
       // System.out.println("deposited succesfuly");
    }
    
    synchronized public boolean withdraw(double amount){
    
        if(amount<=getBalance()){
            setBalance(balance-amount);
           // System.out.println("succesful withdraw");
            return true;           
        }
            
        return false;
    }
    
    
    public static void main(String args[]) throws InterruptedException{
    BankAccount acc = new BankAccount(0);
    DepositThread d = new DepositThread(acc);
    WithdrawThread w = new WithdrawThread(acc);
    d.join();
    w.join();
        System.out.println("final balance:"+acc.getBalance());
    }
    
    public void setBalance(double balance){
    if(balance>=0)
        this.balance=balance;
    else
            System.out.println("please enter a valid balance");
    
    }

    public double getBalance() {
        return balance;
    }
    
    
}
