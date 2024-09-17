## Exercise: Thread synchronization

#### Objective:

The objective of this exercise is to create a program that simulates a simple bank account with multiple account holders making deposits and withdrawals concurrently using threads.

#### Instructions:

1.	Create a Java class named BankAccountExercise with a main method.
2.	Create a class named BankAccount to represent a bank account. This class should have the following attributes:
    -	An integer variable named balance to store the account balance.
    -	Methods named deposit and withdraw to deposit and withdraw money, respectively. These methods should update the balance.
3.	Create two classes, Depositor and Withdrawal, both extending the Thread class. These classes should have the following responsibilities:
    -	Depositor:
        -	Simulate making multiple deposits (e.g., 5 deposits of $100 each) into the BankAccount.
    -	Withdrawal:
        -	Simulate making multiple withdrawals (e.g., 5 withdrawals of $50 each) from the BankAccount.
4.	In the main method of the BankAccountExercise class, create one instance of BankAccount, one Depositor, and one Withdrawal.
5.	Start both the Depositor and Withdrawal threads.
6.	Print the final balance in the BankAccount after both threads have finished their operations.
