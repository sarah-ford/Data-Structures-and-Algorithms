import java.util.Scanner;
public class Evaluate{

  public static boolean isNumber(String token){
    return (!token.equals("+") && !token.equals("-") &&
            !token.equals("*") && !token.equals("/") &&
            !token.equals("(") && !token.equals(")"));
  }

  public static void main(String[] args){

    StringStack ops = new FixedCapacityStack();
    StringStack vals = new FixedCapacityStack();

    Scanner scan = new Scanner(System.in);

    while(scan.hasNext()){

      String token = scan.next();
      if(isNumber(token)) vals.push(token);
      else {
           if(token.equals("(")) ;
           else if(token.equals("+")) ops.push(token);
           else if(token.equals("-")) ops.push(token);
           else if(token.equals("*")) ops.push(token);
           else if(token.equals("/")) ops.push(token);
           else if(token.equals(")"))
           {
              double u = Double.parseDouble(vals.pop());
              double v = Double.parseDouble(vals.pop());

              double result = 0.0;

              String op = ops.pop();

              if(op.equals("+")) result = u + v;
              else if(op.equals("-")) result = v - u;
              else if(op.equals("*")) result = u * v;
              else if(op.equals("/")) result = v/u;

              vals.push(Double.toString(result));

           }

      }

    }

    System.out.println("this result is : " + vals.pop());

  }


}
