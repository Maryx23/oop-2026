public class BankAccount {
    private String accountNo;
    private String fullName;
    private float balance;
    private String pin;

    public BankAccount(String accountNo, String fullName, float balance, String pin) {
        this.accountNo = accountNo;
        this.fullName = fullName;
        this.balance = balance;
        this.pin = pin;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getFullName() {
        return fullName;
    }

    public float getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(float amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}