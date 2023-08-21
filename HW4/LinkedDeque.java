
import java.util.*;
public class LinkedDeque<T> implements Deque<T>{

    private Node front;
    private Node back;
    private int N;

    public LinkedDeque(){
      this.front = null;
      this.back = null;
      this.N = 0;
    }

      private class Node{
        private Node prev;
        private Node next;
        private T value;

        private Node(T value){
          this.value = value;
          this.prev = null;
          this.next = null;
      }
    }
    public void pushLeft(T item){
      Node temp = new Node(item);
      if (this.isEmpty()){
        this.front = temp;
        this.back = temp;
      }
      else
        this.front.prev = temp;
        temp.next = this.front;
        this.front = temp;
        this.N++;
    }

    public void pushRight(T item){
      Node temp = new Node(item);
      if (this.isEmpty()){
        this.front = temp;
        this.back = temp;
      }
      else
        this.back.next = temp;
        temp.prev = this.back;
      this.back = temp;
      this.N++;
    }

    public T popLeft(){
      if (this.isEmpty())
        throw new NoSuchElementException();
      T frontValue = this.front.value;
      this.front = this.front.next;
      this.N--;
      if (this.isEmpty())
        this.back = null;
      return frontValue;
    }

    public T popRight(){
      if (this.isEmpty())
        throw new NoSuchElementException();
      T backValue = this.back.value;
      this.back = this.back.prev;
      this.N--;
      if (this.isEmpty())
        this.front = null;
      return backValue;
    }

    public boolean isEmpty() { return this.N == 0; }
    public int size() { return this.N; }

    public String toString(){
      String values = "";
      for (Node x = this.front; x != null; x = x.next)
          values = values + x.value + " ";
      return values;
    }



    public static void main(String[] args){

      Deque<String> qs = new LinkedDeque<String>();

      qs.pushRight("I");
      qs.pushLeft("Do");
      qs.pushRight("admire");
      qs.pushLeft("Kant");


      System.out.println(qs.toString());

      System.out.println("The size of the Deque is " + qs.size());

      System.out.println(qs.popLeft());
      System.out.println(qs.popRight());
      System.out.println(qs.popLeft());
      System.out.println(qs.popRight());

    }
}
