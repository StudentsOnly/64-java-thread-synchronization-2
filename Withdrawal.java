public class Withdrawal extends Thread {
    final BankAccount account;

    public Withdrawal(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(50);
        }
    }
}
