import java.util.Scanner;
public class FixedCapacityStack implements StringStack {

  private String[] a;
  private int N;
  private static final int CAPACITY = 100;

  public FixedCapacityStack(){
    this.a = new String[CAPACITY];
    this.N = 0;
  }

  public void push(String s) {

     if(this.N < CAPACITY) {
       this.a[this.N] = s;
       this.N = this.N + 1;
     }
  }

  public String pop(){
    String ts = "";
    if(this.N > 0){
      ts = this.a[this.N - 1];
      this.a[this.N - 1] = null;
      this.N = this.N - 1;
    }
    return ts;
  }

  public int size(){
    return this.N;
  }

  public boolean isEmpty(){
    return this.N == 0;
  }

  public static void main(String[] args){

    StringStack fs = new FixedCapacityStack();

    Scanner scan = new Scanner(System.in);

    while(scan.hasNext()) {
      String name = scan.next();
      fs.push(name);
    }

    while(!fs.isEmpty()){
      String name = fs.pop();
      System.out.println(name);
    }

    scan.close();


  }

}
