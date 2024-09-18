public class BankAccountExercise {

  public static void main(String[] args) {

    BankAccount bankAccount = new BankAccount();
    Depositor depositor = new Depositor(bankAccount);
    Withdrawal withdrawal = new Withdrawal(bankAccount);

    depositor.start();
    while (depositor.isAlive()) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    withdrawal.start();

    try {
      // depositor.join();
      withdrawal.join();
      System.out.println("App exiting, " + bankAccount);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
