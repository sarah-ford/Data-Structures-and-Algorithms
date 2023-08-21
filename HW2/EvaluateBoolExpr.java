//This is a template for homework 2
//You can complete the evaluator for fully parenthesized
//boolean expression in main method.

import java.util.Scanner;
public class EvaluateBoolExpr
{
  public static boolean isBoolean(String token)
  {
    return (!token.equals("&&") && !token.equals("||")
    && !token.equals("!") && !token.equals("(") &&
    !token.equals(")"));


  }

  public static void main(String[] args)
  {
     StringStack ops = new FixedCapacityStack();
     StringStack vals = new FixedCapacityStack();


     Scanner scan = new Scanner(System.in); // takes in some input and "reads" it

     while(scan.hasNext()) // hasNext() method returns true if scanner has another token
     // in its input
     {
        String token = scan.next();//StdIn.readString();

        //Please, complete the evaluation of full parethesized boolean expression.
        if (isBoolean(token)) vals.push(token);
        else {
          if (token.equals("("))                ;
          else if(token.equals("&&")) ops.push(token);
          else if(token.equals("||")) ops.push(token);
          else if(token.equals("!")) ops.push(token);
          else if(token.equals(")"))
        {
          boolean u = Boolean.parseBoolean(vals.pop());

          boolean result = false;

          String op = ops.pop();

          if(op.equals("&&")){
            boolean v = Boolean.parseBoolean(vals.pop());
            result = u && v;
          }
          else if(op.equals("||")){
            boolean v = Boolean.parseBoolean(vals.pop());
            result = u || v;
          }
          else if(op.equals("!")) result = !u;

          vals.push(Boolean.toString(result));



        }
      }
     }
     System.out.println("The result of evaluation is: " + vals.pop());
     scan.close();
  }
}
