
import java.util.*;

public class LinkedDeque<T> implements Deque<T> {

  private Node<T> left;
  private Node<T> right;
  private int N;

  public LinkedDeque() {

    this.left = null;
    this.right = null;
    this.N = 0;

  }

  class Node<T>{
    private Node<T> prev;
    private Node<T> next;
    private T item;


    private Node(T item){

    this.item = item;
    this.prev = null;
    this.next = null;

  }
}
  public int size() { return this.N;  }

  public boolean isEmpty() { return this.N == 0; }

  public String toString(){
    String returnstr = "";

    for (Node i = this.left; i != null; i = i.next){
      returnstr += i.item.toString() + " ";
    }
    return returnstr;

  }


  public void pushLeft( T item) {
    if (this.isEmpty()) {
      Node<T> firstleft = new Node<T>(item);
      this.left = firstleft;
      this.right = firstleft;
      this.N = 1;
    }
    else{
      Node<T> newleft = new Node<T>(item);
      Node<T> oldleft = this.left;
      oldleft.prev = newleft;
      newleft.next =oldleft;
      this.N ++ ;
      this.left = newleft;
        }
      }




  public void pushRight( T item){
    if (this.isEmpty()){
      Node<T> firstright = new Node<T>(item);
      this.right = firstright;
      this.left = firstright;
      this.N= 1;

    }
    else {
    Node<T> newright = new Node<T>(item);
    Node<T> oldright = this.right;
    oldright.next = newright;
    newright.prev = oldright;
    this.N ++;
    this.right = newright;
  }

  }

  public T popLeft() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("Underflow");
    }

    else {
    T itempop = this.left.item;
    this.left = this.left.next;
    this.N --;
    return itempop;
      }
  }

  public T popRight() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("Underflow");
    }
  else {
    T itempop = this.right.item;
    this.right = this.right.prev;
    this.N --;
    return itempop;
    }
  }

  public static void main(String[] args) {
    LinkedDeque<String> myLink = new LinkedDeque<String>();

    myLink.pushLeft("27");
    myLink.pushLeft("AA");
    myLink.pushRight("BB");
    System.out.println(myLink.popRight());

  }

//final one

}
