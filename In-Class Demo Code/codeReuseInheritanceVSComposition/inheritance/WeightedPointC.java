// file: WeightedPointC.java
// author: Bob Muller
// date: February 1, 2014
//
// This file contains some sample code illustrating the basic ideas
// for code reuse that were the animating idea behind "object-oriented"
// programming. For the most part, these ideas have been largely
// discredited so the code presented here is explanatory/historical
// rather than prescriptive. In particular:
//
// WE DON'T ENDORSE THE METHODOLOGY OR IDIOMS OF OO-PROGRAMMING.
//
// See the accompanying notes for additional commentary and explanation
// of some of the terminology/jargon associated with OO. You're probably
// going to run into object-oriented programmers so you ought to understand
// what they're talking about.
//
// Remember that since the interface WeightedPoint is defined as an  
// extension of the interface Point, values of type WeightedPoint are 
// also of type Point. In java, values can have a compile-time type 
// and possibly a more specific run-time type.
//
// Since the class WeightedPointC is defined as an extension of the class 
// PointC, WeightedPointC automatically -inherits- all of the public (or 
// protected) definitions in PointC.  WeightedPointC is said to be a
// -subclass- of PointC and PointC is said to be the -superclass- of 
// WeightedPointC.
//
public class WeightedPointC extends PointC implements WeightedPoint {

    // Instance var
    //
    private double weight;

    public WeightedPointC(double x, double y, double weight) {

        // The following call of -super- invokes the constructor 
        // for the superclass.
        //
        super(x, y);
        this.weight = weight;
    }

    public double getWeight() { return this.weight; }

    // The implementation of this class will now -override- PointC's 
    // implementation of the toString function.
    //
    @Override
    public String toString() { 
        return "{point=" + super.toString() + ", weight=" + this.weight +"}";
    }
    
    public static void main(String[] args) {
        
        Point p = new WeightedPointC(.2, .4, .5);
               
        // The java compiler understands variable p to be of type Point. 
        // But the value of the expression:
        //
        //   new WeightedPointC(.2, .4, .5)
        //
        // is of type WeightedPoint. Since everything of type WeightedPoint
        // is also of type Point, it's OK to assign this value to p. But
        // it raises the question: which toString function is called in
        //
        //   p.toString()
        //
        // The toString defined in PointC or the toString defined in
        // WeightedPointC?
        //
        // The answer is the latter. That is, the toString associated with
        // the more specific (smaller) type. This is sometimes called the 
        // -run-time type- and the process of determining which to call is 
        // sometimes called -dynamic dispatch-. Another common OO slogan is 
        // -late binding-, this means that the code that is executed when 
        // the toString function is called is determined (or "bound" to it) 
        // as late as possible: i.e., at run-time.
        //
        System.out.println(p.toString());
    }
}