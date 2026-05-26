import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        App app = new App();
        Scanner scanner = new Scanner(System.in);

        BankAccount defaultAccount = new BankAccount("1001", "Jane Doe", 500.0f, "1234");
        app.accounts.add(defaultAccount);

        System.out.println("Welcome, " + defaultAccount.getFullName());
        app.beginTransaction(defaultAccount, scanner);
        
        scanner.close();
    }

    public void beginTransaction(BankAccount account, Scanner scanner) {
        int choice = -1;
        
        do {
            System.out.println("\n--- Transaction Menu ---");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid entry. Please enter a valid menu number.");
                scanner.next(); 
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    if (scanner.hasNextFloat()) {
                        float depositAmount = scanner.nextFloat();
                        if (depositAmount > 0) {
                            account.deposit(depositAmount);
                            System.out.println("Deposit successful. New balance: $" + account.getBalance());
                        } else {
                            System.out.println("Invalid amount. Deposit must be greater than 0.");
                        }
                    } else {
                        System.out.println("Invalid numerical value.");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    if (scanner.hasNextFloat()) {
                        float withdrawAmount = scanner.nextFloat();
                        if (withdrawAmount > 0) {
                            boolean success = account.withdraw(withdrawAmount);
                            if (success) {
                                System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
                            } else {
                                System.out.println("Transaction failed. Insufficient funds.");
                            }
                        } else {
                            System.out.println("Invalid amount. Withdrawal must be greater than 0.");
                        }
                    } else {
                        System.out.println("Invalid numerical value.");
                        scanner.next();
                    }
                    break;

                case 0:
                    System.out.println("Exiting transaction menu...");
                    saveAccounts(accounts);
                    break;

                default:
                    System.out.println("Invalid option selected. Please choose again.");
            }
        } while (choice != 0);
    }

    public void saveAccounts(ArrayList<BankAccount> accounts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("accounts.csv"))) {
            writer.println("Account No,Full Name,Balance,PIN");
            for (BankAccount account : accounts) {
                writer.println(account.getAccountNo() + "," +
                               account.getFullName() + "," +
                               account.getBalance() + "," +
                               account.getPin());
            }
            System.out.println("Account changes saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving account changes: " + e.getMessage());
        }
    }
}