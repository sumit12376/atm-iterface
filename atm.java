import java.util.ArrayList;
import java.util.Scanner;

public class atm
{

    private static float balance = 10000.76f;
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void checkPIN(int pin) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your ATM PIN: ");
        int atmPIN = sc.nextInt();

        if (pin == atmPIN) {
            menu(sc);
        } else {
            System.out.println("Invalid ATM PIN");
        }
    }

    public static void menu(Scanner sc) {
        while (true) {
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    transactionHistory();
                    break;
                case 2:
                    withdraw(sc);
                    break;
                case 3:
                    deposit(sc);
                    break;
                case 4:
                    transfer(sc);
                    break;
                case 5:
                    quit();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void transactionHistory() {
        System.out.println("Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions have been made.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public static void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        float amount = sc.nextFloat();

        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful");
            transactionHistory.add("Withdraw: $" + amount);
        }
    }

    public static void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        float dep_amount = sc.nextFloat();
        balance += dep_amount;
        System.out.println("Deposit successful");
        transactionHistory.add("Deposit: $" + dep_amount);
    }

    public static void transfer(Scanner sc) {
        System.out.print("Enter amount to transfer: ");
        float transferAmount = sc.nextFloat();

        if (transferAmount <= 0 || transferAmount > balance) {
            System.out.println("Invalid transfer amount");
            return;
        }

        System.out.print("Enter recipient's account number: ");
        String recipientAccount = sc.next();
        balance -= transferAmount;
        transactionHistory.add("Transfer: $" + transferAmount + " to Account " + recipientAccount);
        System.out.println("Transfer successful");
    }

    public static void quit() {
        System.out.println("Thank you for using this ATM. Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Create an ATM PIN: ");
        int pin = sc.nextInt();

        checkPIN(pin);
    }
}



