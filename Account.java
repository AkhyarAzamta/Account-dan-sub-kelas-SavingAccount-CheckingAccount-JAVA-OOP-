public class Account {
    // instance variables
    protected double balance;
 
    // constructor
    public Account(double balance) {
       this.balance = balance;
    }
 
    // methods
    public double getBalance() {
       return balance;
    }
 
    public void deposit(double amt) {
       balance += amt;
    }
 
    public void withdraw(double amt) {
      //  if (amt > balance) {
      //     System.out.println("Amount exceeded balance");
      //  } else {
          balance -= amt;
      //  }
    }
 
    public String toString() {
       return " balance: " + balance;
    }
 }
  class SavingAccount extends Account {
    // instance variable
    private double interestRate;
 
    // constructor
    public SavingAccount(double balance, double interest_rate) {
       super(balance);
       this.interestRate = interest_rate;
    }
 
   //  // method
   //  public double getInterestRate() {
   //     return interestRate;
   //  }
 
   //  public void setInterestRate(double interestRate) {
   //     this.interestRate = interestRate;
   //  }
 
    public void depositInterest() {
       double interest = getBalance() * interestRate / 100;
       deposit(interest);
    }
 
   //  public String toString() {
   //     return super.toString() + ", interest rate: " + interestRate + "%";
   //  }
 }
  class CheckingAccount extends Account {
    // instance variables
    private double overdraftProtection;
 
    // constructor
    public CheckingAccount(double balance, double protect) {
       super(balance);
       this.overdraftProtection = protect;
    }
 
    // method
    public double getOverdraftProtection() {
       return overdraftProtection;
    }
 
    public void setOverdraftProtection(double overdraftProtection) {
       this.overdraftProtection = overdraftProtection;
    }
 
    public void withdraw(double amt) {
       if (amt > getBalance() + overdraftProtection) {
          System.out.println("Amount exceeded balance");
       } else {
          balance -= amt;
       }
    }
 
    public String toString() {
       return super.toString() + ", overdraft protection: " + overdraftProtection;
    }
 }
  class Main {
   public static void main(String[] args) {
      // membuat objek kelas SavingAccount
      SavingAccount sa = new SavingAccount(1000, 5);
      sa.deposit(10000);
      sa.depositInterest();
      System.out.println(sa.toString());

      // membuat objek kelas CheckingAccount
      CheckingAccount ca = new CheckingAccount(1000, 5000);
      ca.withdraw(5000);
      System.out.println(ca.toString());
      // ca.withdraw(500);
      // System.out.println(ca.toString());
   }
}

