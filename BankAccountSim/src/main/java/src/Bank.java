package src;

/**
 *
 * @author molly
 */

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<BankAccount> accountList;

    public Bank() {
        accountList = new ArrayList<>();
    }

    public void addAccount(BankAccount newAcc) {
        
        BankAccount acc = findAccount(newAcc.getId());
        if (acc == null) {
            this.accountList.add(newAcc);
            System.out.println(" *** Acc added to list *** ");;
        } else {
            System.out.println(" *** Account already exists *** ");
        }
    }

    public void displayAccounts() {
        if (accountList.isEmpty()) {
            System.out.println(" *** Account Empty *** ");
            return;
        }
        System.out.println(" *** BANK ACCOUNTS: ");
        for (BankAccount temp: accountList) {
            System.out.println(temp.toString());
        }
        System.out.println(" Total Accounts: " + totalAccounts());
    }

    private int totalAccounts() {
        return accountList.size();
    }

    public BankAccount findAccount(int accId) {
        for (BankAccount temp: accountList) {
            if (temp.getId() == accId) {
                return temp;
            }
        }
        return null;
    }

    public boolean removeAccount(int accId) {
        BankAccount acc = findAccount(accId);
        if (acc != null) {
            accountList.remove(acc);
            //System.out.println(" *** Account Removed *** ");
            return true;
        }
        //System.out.println(" *** Account not found *** ");
        return false;
    }
}

