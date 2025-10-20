package src;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author molly
 */
public class BankApp {
    private Bank bank;
    private List<String> adminList;

    public BankApp() {
        this.bank = new Bank();
        adminList = new ArrayList<>();
        adminList.add("ms04317");
    }

    public static void main(String[] args) {
        BankApp app = new BankApp();
        app.menu();
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println(" *** Welcome to Moll & Co Bank *** \n");
            System.out.println(" What would you like to do?\n(1) Add Account (2) Remove Account (3) Log In (4) Admin Mode");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addAccountLogic();
                case 2 -> removeAccountLogic();
                case 3 -> loginAccountLogic();
                case 4 -> adminLogic();
                default -> System.out.println(" *** Please enter a valid choice! *** ");
            }
        }
    }

    private void addAccountLogic() {
         Scanner accLogic = new Scanner(System.in);
         System.out.println(" Enter your account number: ");
         int accNum = accLogic.nextInt();
         accLogic.nextLine();
         System.out.println(" Enter your account name: ");
         String accName = accLogic.nextLine();
         System.out.println(" Enter any intial account balance: ");
         float accBalance = accLogic.nextFloat();
         BankAccount newAccount = new BankAccount(accNum, accName, accBalance);
         bank.addAccount(newAccount);
    }

    private void removeAccountLogic() {
         Scanner accLogic = new Scanner(System.in);
         System.out.println(" Enter your account number: ");
         int accNum = accLogic.nextInt();
         boolean isRemoved = bank.removeAccount(accNum);
         if (isRemoved) {
            System.out.println(" *** Account Removed *** ");
         } else {
            System.out.println(" *** Account not found *** ");
         }
    }

    private void loginAccountLogic() {
         Scanner accLogic = new Scanner(System.in);
         System.out.println(" Enter your account number: ");
         int accNum = accLogic.nextInt();
         BankAccount currentAccount = bank.findAccount(accNum);
         if (currentAccount != null) {
            System.out.println(currentAccount.toString());
            accountOptions(currentAccount);
         } else {
            System.out.println(" *** Account not found *** ");
         }
    }

    private void accountOptions(BankAccount account) {
        Scanner accLogic = new Scanner(System.in);
         System.out.println(" Would you like to (1) Deposit or (2) Withdraw: ");
         int choice = accLogic.nextInt();
         switch(choice) {
            case 1:
                System.out.println("How much would you like to deposit? ");
                float deposit = accLogic.nextFloat();
                account.deposit(deposit);
                break;
            case 2:
                System.out.println("How much would you like to withdraw? ");
                float withdraw = accLogic.nextFloat();
                account.withdraw(withdraw);
                break;
         }
    }

    private void adminLogic() {
        Scanner accLogic = new Scanner(System.in);
        System.out.println(" Enter your admin username: ");
        String accNum = accLogic.nextLine();
        for (String temp: adminList) {
            if (temp.matches(accNum)) {
                bank.displayAccounts();
            } else {
                System.out.println(" *** No admin found *** ");
            }
        }
    }
}
