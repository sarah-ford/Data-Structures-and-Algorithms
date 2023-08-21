
/**
 *  The {@code Merge} class provides static methods for sorting an
 *  array using mergesort.
 *  <p>
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  For an optimized version, see {@link MergeX}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class MergeNonrecursive extends GLStack {


  private class Bounds{
    private int lo, hi;
    private boolean lsorted, rsorted;

    Bounds(int lo, int hi)
    {
      this.lo = lo;
      this.hi = hi;
      if(lo >= hi)
      { this.lsorted = true;
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
    // This class should not be instantiated.




    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

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
   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/

    public void sort(Comparable[] a) {
        Bounds b = new Bounds(0, a.length-1);
        Stack<Bounds> workList = new GLStack<Bounds>();
        workList.push(b);

        while( !workList.isEmpty() ){

          Bounds bound = workList.pop();
          //System.out.println(bound.toString());

          if (bound.getLsorted()==false){
            int mid = bound.lo + (bound.hi-bound.lo)/2;
            workList.push(bound);
            Bounds c = new Bounds(bound.lo, mid);
            workList.push(c);
          }

          else if (bound.getRsorted()==false){
            int mid = bound.lo + (bound.hi-bound.lo)/2;
            workList.push(bound);
            Bounds c = new Bounds(mid+1, bound.hi);
            workList.push(c);
          }

          else {
            int mid = bound.lo + (bound.hi-bound.lo)/2;
            Comparable[] aux = new Comparable[a.length];
            merge(a, aux, bound.getLo(), mid, bound.getHi());

            if (!workList.isEmpty())
            {
              bound = workList.pop();
              if (!bound.getLsorted()) bound.setLsorted(true);
              else if (!bound.getRsorted()) bound.setRsorted(true);
              workList.push(bound);
              }

          }
        }

    }


    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }



    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = {"Plato", "Nietzshche", "Heidegger", "Lacan", "Kant", "Hegel"};

        MergeNonrecursive MergeNonrecursive = new MergeNonrecursive();

        Integer[] b = {1, 3, 87, 90, 13, 17, 5};

        MergeNonrecursive.sort(a);
        show(a);
        
        MergeNonrecursive.sort(b);
        show(b);

    }
}
