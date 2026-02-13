import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class App {
    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        loadAccounts();

        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO JAVA ATM");
        System.out.print("Enter account number to proceed: ");
        String acctNo = sc.nextLine();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();
        sc.nextLine();

        Optional<BankAccount> newSessionUser = accounts.stream()
                .filter(account -> account.getAcctNo().equals(acctNo))
                .findFirst();

        if (newSessionUser.isPresent()) {
            if (newSessionUser.get().isValidPin(pin)) {
                System.out.println("Welcome...");
                beginTransaction(newSessionUser.get(), sc);
            } else {
                System.out.println("Invalid credentials...");
            }
        } else {
            System.out.println("Account not found...");
        }
        sc.close();
    }

    public static void beginTransaction(BankAccount account, Scanner sc) {
        boolean running = true;

        while (running) {
            System.out.println("\nMenu");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    float depositAmount = sc.nextFloat();
                    sc.nextLine();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    float withdrawAmount = sc.nextFloat();
                    sc.nextLine();
                    account.withdraw(withdrawAmount);
                    break;
                case 0:
                    System.out.println("Thank you for banking with us!");
                    saveAccounts();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void loadAccounts() {
        try (Scanner reader = new Scanner(new File("accounts.csv"))) {
            if (reader.hasNextLine())
                reader.nextLine();
            while (reader.hasNextLine()) {
                String[] cols = reader.nextLine().split(",");
                if (cols.length >= 4) {
                    String acctNo = cols[0];
                    String fullName = cols[1];
                    float balance = Float.parseFloat(cols[2]);
                    int pin = Integer.parseInt(cols[3]);
                    accounts.add(new BankAccount(acctNo, pin, balance, fullName));
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }

    public static void saveAccounts() {
        try (PrintWriter writer = new PrintWriter("accounts.csv")) {
            writer.println("AccountNumber,FullName,Balance,PIN");
            for (BankAccount acc : accounts) {
                writer.println(acc.toString());
            }
            System.out.println("Accounts saved successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }
}