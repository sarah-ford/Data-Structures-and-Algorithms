
import java.util.NoSuchElementException;


public class MinPQ  {
    private int[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MinPQ(int initCapacity) {
        pq = new int[initCapacity + 1];
        n = 0;
    }






    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        int[] temp =  new int[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the key to add to this priority queue
     */
    public void insert(int x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);

    }

    /**
     * Removes and returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);

        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);

        return min;
    }

    public void Change(int oldkey, int newkey){
      if (oldkey == newkey) return;
      int index = 1;
      for (int i = 1; i <= n; i++){
        if (pq[i] == oldkey){
          // do comparison between keys
          pq[i] = newkey;
          index = i;
          break;
          }
        }
      if (newkey > oldkey) sink(index);
      else swim(index);

    }

    public boolean isMinHeap(){
      return isMinHeap(1);
      // for each node, key is less than or equal to key of descendants
    }

    private boolean isMinHeap(int k){
      int left = k * 2;
      int right = (k * 2) + 1;
      boolean result;
        if (k > n) return true;
        if (left > n && right > n) return true;
        else{
          if (left <= n && greater(k, left)) return false;
          if (right <= n && greater(k, right)) return false;
          result = isMinHeap(left) && isMinHeap(right);
          return result;
        }
    }

   /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/
/* swim is used if heap's order is violated because node's key is smaller than
parent's key; swim percolates key up to proper place */
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
/* sink is used if heap order is violated because node's key become's larger
than one or both of that node's children's keys; sink weighs key down to proper
place */
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

   /***************************************************************************
    * Helper functions for compares and swaps.
    ***************************************************************************/
    private boolean greater(int i, int j) {

        return pq[i] > pq[j];

    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public void display() {
      for(int i = 1; i <= this.size(); i++)
      {
        System.out.print(pq[i]);
      }

      System.out.println();
    }

    /**
     * Unit tests
     *

     */
    public static void main(String[] args) {
        MinPQ pq = new MinPQ(30);

        pq.insert(9);
        pq.insert(28);
        pq.insert(18);
        pq.insert(23);

        pq.display();
        System.out.println(pq.isMinHeap());

        System.out.println();
        
        pq.Change(23,45);
        pq.display();
        System.out.println(pq.isMinHeap());
        pq.Change(45,23);

        System.out.println();

        pq.Change(23,23);
        pq.display();
        System.out.println(pq.isMinHeap());

        System.out.println();

        pq.Change(23,8);
        pq.display();
        System.out.println(pq.isMinHeap());
        pq.Change(8,23);
    }

}
