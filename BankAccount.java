public class BankAccount {
    private int balance;

    public BankAccount() {
        this.balance = 0;
    }

    public synchronized void deposit(int amount) {
        System.out.println("Balance before deposit is " + balance);
        balance += amount;
        System.out.println("Balance after deposit is " + balance);
        notify();
    }

    public synchronized void withdraw(int amount) {
        System.out.println("Balance before withdraw is " + balance);
        if (balance < amount) {
            System.out.println("Not enough money. Waiting for deposit");
            try {
                wait();
                System.out.println("Deposit detected. Continuing withdraw");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        balance -= amount;
        System.out.println("Balance after withdraw is " + balance);
    }

    public int getBalance() {
        return balance;
    }
}
