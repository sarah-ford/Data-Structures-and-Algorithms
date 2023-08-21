public class Arraydemo {

  public  static void main(String[] args) {


    int[] arr;
    arr = new int[8];

    arr[0] = 1;
    arr[1] = 5;
    arr[2] = 8;
    arr[3] = 9;
    arr[4] = 12;
    arr[5] = 17;
    arr[6] = 20;
    arr[7] = 32;

    boolean res;
    //Do binary search with 15 as the key value
    res = binarysearch(arr, 15);

    System.out.println("The searching result is " + res);

    for(int i = 0; i < arr.length; i++)
    {

        System.out.println(arr[i]);
    }

    int sum = 0;
    for(int i = 0; i < arr.length; i++)
    {
        sum = sum + arr[i];
    }

    System.out.println("The average is " + sum/arr.length);

  }

  public static boolean binarysearch(int[] a, int key)
  {

    int low = 0;
    int high = a.length - 1;
    while(low <= high){
      int mid = (low + high)/2;
      if(a[mid] == key) return true;
      else if(a[mid] < key) low = mid + 1;
      else high = mid - 1;
    }

    return false;

  }


}
