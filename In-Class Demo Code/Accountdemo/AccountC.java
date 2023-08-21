public class AccountC implements Account{

  private String id;
  private double balance;

  public AccountC(String i, double b){
    this.id = i;
    this.balance = b;
  }

  public void deposit(double d){
    this.balance = this.balance + d;

  }

  public void withdraw(double d){
    this.balance = this.balance - d;
  }

  public double checkbalance(){
    return this.balance;
  }

}
