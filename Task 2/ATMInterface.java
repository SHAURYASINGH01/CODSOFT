import java.io.*; 
import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
// ATM class
class ATM {
    private BankAccount account;
    private Scanner sc;
    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    // Main menu
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n== ATM Menu ==");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    // Check balance
    private void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f%n", account.getBalance());
    }

    // Deposit Money
    private void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (account.deposit(amount)) {
            System.out.printf("₹%.2f deposited successfully.%n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw
    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("₹%.2f withdrawn successfully.%n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

// Main class - entry point
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(2000.0);
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
