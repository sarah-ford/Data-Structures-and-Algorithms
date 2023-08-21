import java.util.Scanner;
public class LinkedListStringStack implements StringStack {

  private class Node
  {
    String item;
    Node next;
    
  }

  private Node first;
  private int N;

  public LinkedListStringStack()
  {
    first = null;
    this.N = 0;
  }

  public void push(String s)
  {
    Node oldfirst = this.first;
    this.first = new Node();
    this.first.item = s;
    this.first.next = oldfirst;
    this.N = this.N + 1;
  }

  public String pop()
  {
    String result = first.item;
    this.first = this.first.next;
    this.N = this.N - 1;
    return result;
  }

  public boolean isEmpty()
  {
    return this.first == null;
  }

  public int size() {
    return this.N;
  }

  public static void main(String[] args){

    StringStack fs = new LinkedListStringStack();

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
