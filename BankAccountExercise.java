public class BankAccountExercise {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();

        Depositor depositor = new Depositor(bankAccount);
        Withdrawal withdrawal = new Withdrawal(bankAccount);

        System.out.println("Start balance amount: €" + bankAccount.getBalance());

        depositor.start();
        withdrawal.start();

        try {
            depositor.join();
            withdrawal.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Final balance: €" + bankAccount.getBalance());
    }

}
