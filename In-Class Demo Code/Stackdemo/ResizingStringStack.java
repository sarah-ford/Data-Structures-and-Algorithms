//author: Ziyuan Meng
//date: September 18, 2017
//An implementation of a simple stack ADT with resizing capacity.


import java.util.Scanner;

public class ResizingStringStack implements StringStack {
    private String[] a;         // array of items
    private int N;            // number of elements on stack


    /**
     * Initializes an empty stack.
     */
    public ResizingStringStack() {
        a = new String[2];
    }

    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() {
        return N;
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {

        String[] temp = new String[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = this.a[i];
        }
        this.a = temp;

    }

    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(String item) {
        if (N == a.length) resize(2 * a.length);    // double size of array if necessary
        a[N++] = item;                              // add item
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public String pop() {
        String item = "";
        if(N > 0) {
          item = a[N-1];
          a[N-1] = null;
          N--;

          // shrink size of array if necessary
          if (N > 0 && N == a.length/4) resize(a.length/2);
        }
        return item;
    }


    /**
     * Unit tests the <tt>Stack</tt> data type.
     */
    public static void main(String[] args) {
        StringStack fs = new ResizingStringStack();
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()) {
          String name = scan.next();
          fs.push(name);
        }

        while(!fs.isEmpty()) {
          String name = fs.pop();
          System.out.println(name);
        }
        scan.close();


    }
}
