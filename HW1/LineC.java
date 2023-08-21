//
// This file contains the implementation of the Line ADT.
//
public class LineC implements Line{

// Instance variables, record the state.
//
private Point left;
private Point right;

public LineC(Point left, Point right){

  if (left.getX() <= right.getX()){
    this.left = left;
    this.right = right;
  }
  else{
    this.left = right;
    this.right = left;
  }
}

public Point getLeft(){
  if (this.left == left)
    return this.left;
  else
    return this.right;
  }

public Point getRight(){
  if (this.right == right)
    return this.right;
  else
    return this.left;
  }

public double length(){
  double xdist = this.right.getX() - this.left.getX();
  double ydist = this.right.getY() - this.left.getY();
  return Math.sqrt(Math.pow(xdist,2) + Math.pow(ydist,2));

}

public Point midPoint(){
  double xsum = this.right.getX() + this.left.getX();
  double ysum = this.right.getY() + this.left.getY();
  return new PointC((xsum/2.0), (ysum/2.0));
}

public Line move(double dx, double dy){
  Point newleft = new PointC(this.left.getX() + dx, this.left.getY() + dy);
  Point newright = new PointC(this.right.getX() + dx, this.right.getY() + dy);
  return new LineC(newleft, newright);
}

public String toString(){
  return "Left Point: " + this.left + " Right Point: " + this.right;
}

public boolean equals(Line other){
  return this.getLeft().equals(other.getLeft()) && this.getRight().equals(other.getRight());
}

public static void main(String[] args){
  Point p1 = new PointC(2.0, 3.0);
  Point p2 = new PointC(1.5, 2.0);
  Line l = new LineC(p1, p2);
  Point p3 = new PointC(1.5, 2.0);
  Point p4 = new PointC(2.0, 3.0);
  Line ll = new LineC(p3, p4);

  double length = l.length();
  Point midpoint = l.midPoint();
  Line newline = l.move(1, 1);
  System.out.println("The length of the line is " + length);
  System.out.println("The midpoint of the line is " + midpoint);
  System.out.println("The new line is " + newline.toString());

  if (l.equals(ll))
    System.out.println("The two lines were equal.");
  else
    System.out.println("The two lines were not equal.");
}

}
