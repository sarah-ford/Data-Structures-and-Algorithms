// file: LinkedQueue.java
// author: Ziyuan Meng
// date: September 25, 2017
//
// A linked implement for a simple Queue ADT. See the file Queue.java
// for the API.
//
import java.util.*;
public class LinkedQueue implements Queue {

    // Instance variables
    //
    private Node front;
    private Node back;
    private int N;

    public LinkedQueue() {
        this.front = null;
        this.back = null;
        this.N = 0;
    }

    private static class Node {
        private String info;
        private Node next;

        private Node(String info) {
            this.info = info;
            this.next = null;
        }

    }

    public void enqueue(String info) {
        Node temp = new Node(info);
        if(this.isEmpty())
            this.front = temp;
        else
            this.back.next = temp;
        this.back = temp;
        this.N++;
    }

    public String dequeue() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        String frontValue = this.front.info;
        this.front = this.front.next;
        this.N--;
        if(this.isEmpty())
            this.back = null;
        return frontValue;
    }

    public boolean isEmpty() { return this.N == 0; }
    public int size()        { return this.N; }


    public Queue reverse()
    {
      Stack RStack = new LStack();
      Queue qs2 = new LinkedQueue();

      if (this.isEmpty())
        throw new NoSuchElementException();

      for(Node x = this.front; x != null; x = x.next)
      {
        String str = x.info;
        RStack.push(str);
      }
      while(!RStack.isEmpty()){
        String str = RStack.pop();
        qs2.enqueue(str);
      }

      return qs2;
    }



    public static void main(T[] args) {

        Queue qs1 = new LinkedQueue();

        qs1.enqueue("I");
        qs1.enqueue("admire");
        qs1.enqueue("Kant");

        Queue qs2 = qs1.reverse();

        System.out.println(qs1.dequeue());
        System.out.println(qs1.dequeue());
        System.out.println(qs1.dequeue());

        System.out.println();

        System.out.println(qs2.dequeue());
        System.out.println(qs2.dequeue());
        System.out.println(qs2.dequeue());


    }
}
