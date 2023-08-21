/*************************************************************************
 *  Compilation:  javac Merge.java
 *  Execution:    java Merge < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/22mergesort/tiny.txt
 *                http://algs4.cs.princeton.edu/22mergesort/words3.txt
 *
 *  Sorts a sequence of strings from standard input using mergesort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Merge < tiny.txt
 *  S O R T E X A M P L E A               [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Merge < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 *************************************************************************/

import java.util.*;

public class MergeTDNonrecursive {

    private static boolean DEBUG = false;

    // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {



        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }


    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    //
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    // Non-recursive solution, uses 2 stacks.
    //
    public void sort(Comparable[] a) {

        Comparable[] aux = new Comparable[a.length];

        //Deque<Bounds> stack = new ArrayDeque<Bounds>();
        //Deque<Bounds> workList = new ArrayDeque<Bounds>();
        Stack<Bounds> workList = new GLStack<Bounds>();

        int lo, hi;

        Bounds bounds = new Bounds(0, a.length - 1);
        workList.push(bounds);

        while(!workList.isEmpty()) {
            bounds = workList.pop();
            lo = bounds.getLo();
            hi = bounds.getHi();
            if(!bounds.getLsorted()) {

              if(DEBUG)
                  System.out.println("unsorted bounds " + bounds.toString());
              int mid = lo + (hi - lo) / 2;
              workList.push(bounds);
              bounds = new Bounds(lo, mid);
              if(DEBUG)
                  System.out.println("go to left branch: " + bounds.toString());
              workList.push(bounds);

            }
            else if(!bounds.getRsorted()){

              if(DEBUG)
                  System.out.println("unsorted bounds " + bounds.toString());
              int mid = lo + (hi - lo) / 2;
              workList.push(bounds);
              bounds = new Bounds(mid + 1, hi);
              if(DEBUG)
                  System.out.println("go to right branch: " + bounds.toString());
              workList.push(bounds);

            }
            else {

              if(DEBUG)
                  System.out.println("sorted bounds " + bounds.toString());
                  int mid = bounds.getLo() + (bounds.getHi() - bounds.getLo())/2;
                  merge(a, aux, bounds.getLo(), mid, bounds.getHi());


              if(!workList.isEmpty())
              {
                bounds = workList.pop();
                if(!bounds.getLsorted()) bounds.setLsorted(true);
                else if(!bounds.getRsorted()) bounds.setRsorted(true);
                workList.push(bounds);
              }

              //lo = bounds.getLo();
              //hi = bounds.getHi();





            }

        }

    }

    /***********************************************************************
     *  Helper sorting functions
     ***********************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }



    private class Bounds {
        private int lo, hi;
        private boolean lsorted, rsorted;
        Bounds(int lo, int hi)
        {
          this.lo = lo;
          this.hi = hi;
          if(lo >= hi)
          {
            this.lsorted = true;
            this.rsorted = true;
          }
          else {
            this.lsorted = false;
            this.rsorted = false;
          }
        }
        private int getLo() { return lo; }
        private int getHi() { return hi; }
        private boolean getLsorted() { return lsorted; }
        private boolean getRsorted() { return rsorted; }
        private void setLsorted(boolean l) { this.lsorted = l; }
        private void setRsorted(boolean r) { this.rsorted = r; }
        public String toString() { return "[" + lo + ", " + hi + "," + lsorted + "," + rsorted + "]"; }
    }

    // print array to standard output
    private void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // Read strings from standard input, sort them, and print.
    public static void main(String[] args) {
      MergeTDNonrecursive merge3 = new MergeTDNonrecursive();
      String[] a = {"Plato", "Nietzshche", "Heidegger", "Lacan", "Kant", "Hegel", "Aristotle", "Gadamer"};

      merge3.sort(a);

      merge3.show(a);

      Integer[] b = {1, 3, 87, 90, 13, 17, 5};

      merge3.sort(b);
      merge3.show(b);

    }
}
