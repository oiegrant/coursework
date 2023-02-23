// Written by Grant Oie,  oiexx032
import java.awt.Color;

public class Circle { 
    /**
    *
    * Variables:
    * xPos: The x position of the center of the circle.
    * yPos: The y position of the center of the circle.
    * radius: The radius of the circle.
    * col: The color of the circle.
    * Constructor:
    * Circle(x, y, rad): Creates a new Circle object with the specified x and y positions, and radius.
    * Methods:
    * calculatePerimeter(): Calculates the perimeter of the circle.
    * calculateArea(): Calculates the area of the circle.
    * setColor(setColorTo): Sets the color of the circle to the specified color.
    * setPos(x, y): Sets the x and y position of the circle.
    * setRadius(rad): Sets the radius of the circle.
    * getColor(): Gets the color of the circle.
    * getXPos(): Gets the x position of the center of the circle.
    * getYPos(): Gets the y position of the center of the circle.
    * getRadius(): Gets the radius of the circle.
    * */

    private double xPos;
    private double yPos;
    private double radius;
    private Color col;
   
    public Circle(double x, double y, double rad){
    xPos = x;
    yPos = y;
    radius = rad;
    } 

    public double calculatePerimeter(){
        return (Math.PI * 2.0 * radius);
    }

    public double calculateArea(){
        return (Math.PI * Math.pow(radius,2));
    }

    public void setColor(Color setColorTo){
        col = setColorTo;
    }

    public void setPos(double x, double y){
        xPos = x;
        yPos = y;
    }

    public void setRadius(double rad){
        radius = rad;
    }

    public Color getColor(){
        return col;
    }

    public double getXPos(){
        return xPos;
    }

    public double getYPos(){
        return yPos;
    }
    
    public double getRadius(){
        return radius;
    }

    
}
