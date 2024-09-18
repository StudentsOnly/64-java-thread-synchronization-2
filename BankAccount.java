public class BankAccount {

  private int balance;

  public void deposit(int amount) {

    balance += amount;
    System.out.println(Thread.currentThread().getName() + " balance $" + balance +
      " after depositing $" + amount);
  }

  public void withdraw(int amount) {

    if (amount > balance) {
      System.out.println(Thread.currentThread().getName() + " balance $" + balance +
        " can not withdraw $" + amount);
      return;
    }
    balance -= amount;
    System.out.println(Thread.currentThread().getName() + " balance $" + balance +
      " after withdrawing $" + amount);
  }

  @Override
  public String toString() {
    return "Balance $" + balance;
  }
}
