class Account {
    protected double balance; // atribut balance tipe double, sifat protected
  
    // Constructor Account untuk memberi nilai awal balance
    public Account(double balance) {
      this.balance = balance;
    }
  
    // Method getBalance untuk mendapatkan nilai balance
    public double getBalance() {
      return balance;
    }
  
    // Method deposit untuk menambah nilai balance
    public void deposit(double amt) {
      balance += amt;
    }
  
    // Method withdraw untuk mengambil nilai balance
    public void withdraw(double amt) {
      balance -= amt;
    }

    public String toString() {
        return " balance: " + balance;
     }

  }
  
   class SavingAccount extends Account {
    private double interestRate; // atribut interestRate, tipe double, sifat private
  
    // Constructor SavingAccount dengan parameter balance dan interest_rate
    public SavingAccount(double balance, double interest_rate) {
      super(balance); // passing parameter balance ke parent constructor dengan super(balance)
      this.interestRate = interest_rate; // mengeset nilai variabel interestRate dengan nilai interest_rate
    }
  
    // Method untuk mendapatkan nilai interestRate
    public double getInterestRate() {
      return interestRate;
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
    private double overdraftProtection; // atribut overdraftProtection, tipe double, sifat private
  
    // Constructor dengan dua parameter: balance dan protect
    public CheckingAccount(double balance, double protect) {
      super(balance); // passing parameter balance ke parent constructor dengan super(balance)
      this.overdraftProtection = protect; // mengset nilai overdraftProtection dengan nilai protect
    }
  
    // Method untuk mendapatkan nilai overdraftProtection
    public double getOverdraftProtection() {
      return overdraftProtection;
    }

    public double Saldo() {
        return balance + overdraftProtection;
      }      
  
    // Method untuk mengoverride method withdraw @Override
    public void withdraw(double amt) {
      if (balance - amt >= 0.0) { // jika balance – amount => 0.0
        balance -= amt; // proses pengambilan diperbolehkan
        // return true;
      } else { // jika balance – amount < 0.0
        if (overdraftProtection == -1.0 || overdraftProtection < (amt - balance)) { // jika tidak ada overdraftProtection atau overdraftProtection < overdraftNeeded (amount - balance)
          // tidak melakukan apa-apa
          System.out.println("uang tidak cukup");
          
        //   return false;
        } else { // jika terdapat overdraftProtection atau overdraftProtection > overdraftNeeded (amount - balance)
          balance = 0.0; // proses pengambilan uang berhasil
          overdraftProtection -= (amt - balance); // set balance = 0.0; overdraftProtection = overdraftProtection – overdraftNeeded
        }
      }
    }

    // Constructor dengan satu parameter: balance
    public CheckingAccount(double balance) {
        this(balance, -1.0); // passing parameter balance ke local constructor dengan this. Nilai protect default adalah -1.0
    }

    
     public String toString() {
        return super.toString() + ", overdraft protection: " + overdraftProtection;
     }
  }

  public class MainV2 {
    public static void main(String[] args) {
       // membuat objek kelas SavingAccount
       SavingAccount sa = new SavingAccount(1000, 4.5);
       sa.deposit(1000);
       sa.depositInterest();
       System.out.println(sa.toString());
 
       // membuat objek kelas CheckingAccount
       CheckingAccount ca = new CheckingAccount(1000, 500);
    //    ca.withdraw(1100);

    // Tarik saldo
       sa.withdraw(2091);
       if (sa.getBalance() < 0 || sa.getBalance() < 0) {
        System.out.println("saldo rekening tidak mencukupi untuk melakukan penarikan");
     } else {
        System.out.println(ca.toString());
        System.out.println(sa.toString());
     }
    }
}