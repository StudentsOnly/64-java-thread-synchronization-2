class Depositor extends Thread {
    private final BankAccount account;

    public Depositor(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Depositor thread interrupted ...");
            }
        }
    }
}

class Withdrawal extends Thread {
    private final BankAccount account;

    public Withdrawal(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(50);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("Withdrawal thread interrupted ...");
            }
        }
    }
}


class BankAccount {
    private double balance = -99.99;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: €" + amount + ", Current balance: €" + balance);
        notify();
    }


    public synchronized void withdraw(double amount) {
        while (balance < amount) {
            try {
                System.out.println("Insufficient balance for withdrawal of €" + amount + ". Waiting for deposit...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        balance -= amount;
        System.out.println("Withdrew: €" + amount + ", Current balance: €" + balance);
        notify();
    }

    public synchronized double getBalance() {
        return balance;
    }
}
