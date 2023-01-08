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
       if (amt > balance) {
          System.out.println("Amount exceededed balance");
       } else {
          balance -= amt;
       }
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
 
    public void setInterestRate(double interestRate) {
       this.interestRate = interestRate;
    }
 
    public void depositInterest() {
       double interest = getBalance() * interestRate / 100;
       deposit(interest);
    }
 
    public String toString() {
       return super.toString() + ", interest rate: " + interestRate + "%";
    }
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
      if (balance - amt >= 0.0) { // jika balance – amount => 0.0
         balance -= amt; // proses pengambilan diperbolehkan
         // return true;
       } else { // jika balance – amount < 0.0
         if (overdraftProtection == -1.0 || overdraftProtection < (amt - balance)) { // jika tidak ada overdraftProtection atau overdraftProtection < overdraftNeeded (amount - balance)
           // tidak melakukan apa-apa
           overdraftProtection -= (amt - balance);
           System.out.println("Amount edeee balance");
         //   return false;
         } else { // jika terdapat overdraftProtection atau overdraftProtection > overdraftNeeded (amount - balance)
           balance = 0.0; // proses pengambilan uang berhasil
           overdraftProtection -= (amt - balance); // set balance = 0.0; overdraftProtection = overdraftProtection – overdraftNeeded
         //   return true;
         }
       }
      
      //  if (amt > getBalance() + overdraftProtection) {
      //     System.out.println("Amount ed balance");
      //  } else {
      //     balance -= amt;
      //  }
    }
 
    public String toString() {
       return super.toString() + ", overdraft protection: " + overdraftProtection;
    }
 }
  class Main {
   public static void main(String[] args) {
      // membuat objek kelas SavingAccount
      SavingAccount sa = new SavingAccount(1000, 0.5);
      sa.deposit(4000);
      sa.depositInterest();
      System.out.println(sa.toString());

      // membuat objek kelas CheckingAccount
      CheckingAccount ca = new CheckingAccount(1000, 5000);
      ca.deposit(4000);
      ca.withdraw(16000);
      sa.withdraw(5000);

      if (ca.getBalance() < 0 || sa.getBalance() < 0) {
         System.out.println("saldo rekening tidak mencukupi untuk melakukan penarikan");
      } else {
         System.out.println(ca.toString());
         System.out.println(sa.toString());
      }
   }
}

