package oodemo;

public class Circle {
	/** The radius of this circle */
	double radius = 1;

	/** Construct a circle with radius 1 */
	Circle() {}
	
	/** Construct a circle object */
	Circle(double newRadius) {
		radius = newRadius;
	}
	
	/** Return the area of this circle */
	double getArea() {
		return radius * radius * Math.PI;
	}
	
	/** Return the parimeter of this circle */
	double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	
	/** Set a  new radius for this circle */
	void setRadius(double newRadius) {
		radius = newRadius;
	}
	
	
	
}






