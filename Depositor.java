public class Depositor extends Thread {
  BankAccount bankAccount;

  public Depositor(BankAccount bankAccount) {
    this.bankAccount = bankAccount;
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (bankAccount) {
        bankAccount.deposit(100);
      }
    }
    System.out.println(Thread.currentThread().getName() + " is exiting.");
  }
}
