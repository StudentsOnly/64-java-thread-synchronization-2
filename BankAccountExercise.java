public class BankAccountExercise {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Depositor depositor = new Depositor(account);
        Withdrawal withdrawal = new Withdrawal(account);
        System.out.println("Balance before operations: " + account.getBalance());

        depositor.start();
        withdrawal.start();

        try {
            depositor.join();
            withdrawal.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Balance after operations: " + account.getBalance());
    }
}
