// file: WeightedPoint.java
// author: Bob Muller
// date: February 1, 2014
//
// This file contains some sample code illustrating the basic ideas
// for code reuse that were the animating idea behind "object-oriented"
// programming. For the most part, these ideas have been largely
// DISCREDITED so the code presented here is very definitely explanatory
// or historical rather than prescriptive. In particular:
//
// WE DO NOT ENDORSE THE METHODOLOGY OR IDIOMS OF OO-PROGRAMMING.
//
// See the accompanying notes for additional commentary and explanation
// of some of the terminology/jargon associated with OO. You're probably
// going to run into object-oriented programmers so you ought to understand
// what they're talking about.
//
// Since the interface WeightedPoint is defined as an extension of the
// interface Point, values of type WeightedPoint are also of type Point.
//
// In java, values can have a compile-time type and possibly a more specific
// run-time type.
//
// Any class implementing this interface is required to have implementations
// of everything in Point as well as getWeight.
//
public interface WeightedPoint extends Point {
    public double getWeight();
}
