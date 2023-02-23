// Written by Grant Oie,  oiexx032
import java.awt.Color;

public class Rectangle {
    /**

    * Variables:
    * xPos: The x position of the upper left corner of the rectangle.
    * yPos: The y position of the upper left corner of the rectangle.
    * width: The width of the rectangle.
    * height: The height of the rectangle.
    * col: The color of the rectangle.
    * 
    * Constructor:
    * Rectangle(x, y, w, h): Creates a new Rectangle object with the specified x and y positions, width, and height.
    * 
    * Methods:
    * calculatePerimeter(): Calculates the perimeter of the rectangle.
    * calculateArea(): Calculates the area of the rectangle.
    * setColor(setColorTo): Sets the color of the rectangle to the specified color.
    * setPos(x, y): Sets the x and y position of the rectangle.
    * setHeight(h): Sets the height of the rectangle.
    * setWidth(w): Sets the width of the rectangle.
    * getColor(): Gets the color of the rectangle.
    * getXPos(): Gets the x position of the upper left corner of the rectangle.
    * getYPos(): Gets the y position of the upper left corner of the rectangle.
    * getHeight(): Gets the height of the rectangle.
    * getWidth(): Gets the width of the rectangle.
    */
    private double xPos;
    private double yPos;
    private double width;
    private double height;
    private Color col;
   
    public Rectangle(double x, double y, double w, double h){
    xPos = x;
    yPos = y;
    width = w;
    height =h;
    }

    public double calculatePerimeter(){
        return ( (2*width)+(2*height) );
    }

    public double calculateArea(){
        return ((height * width));
    }

    public void setColor(Color setColorTo){
        col = setColorTo;
    }

    public void setPos(double x, double y){
        xPos = x;
        yPos = y;
    }

    public void setHeight(double h){
        height = h;
    }

    public void setWidth(double w){
        width = w;
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
    
    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

    
}
