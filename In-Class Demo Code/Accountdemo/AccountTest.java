public class AccountTest{

  public static void main(String[] args){

    AccountC acc1;
    acc1 = new AccountC("SD87766", 100.0);

    AccountC acc2 = new AccountC("SD88876", 50.0);

    acc1.deposit(50.0);
    

    System.out.println("The balance of acc1 is " + acc1.checkbalance());



  }

}
