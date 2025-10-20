/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package src;

/**
 *
 * @author molly
 */

public class BankAccount {
    private int accountNumber = 0;
    private String ownerName = "";
    private float balance;

    public BankAccount(int accountNumber, String ownerName, float initialDeposit) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = Math.max(initialDeposit, 0);
    }

    public void deposit(float amount) {
        if (amount <= 0) {
            System.out.println(" *** Error: Must be positive *** ");
            return;
        }
        balance += amount;
        System.out.println(" *** Added to balance *** ");
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(" *** Withdrawn from balance *** ");
        } else {
            System.out.println(" *** No sufficient funds *** ");
        }
    }

    public float getBalance() {
        return this.balance;
    }

    public int getId() {
        return this.accountNumber;
    }

    @Override
    public String toString() {
        return String.format("Account #%d | Name: %s | Balance: $%.2f",
        accountNumber, ownerName, balance);
    }
}
