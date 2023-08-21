public class Functiondemo {


  public static void main(String[] args) {

    greeting("Ziyuan");
    greeting("Zeming");

    int y = square(3);

    System.out.println("The value of y is " + y);

  }


  public static void greeting(String name){

    System.out.println("Hello " + name);

  }

  public static int square(int x){
    int result;
    int y;
    y = 100;
    result = x * x;
    return result;
  }

}
