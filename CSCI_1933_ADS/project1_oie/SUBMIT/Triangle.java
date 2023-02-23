// Written by Grant Oie,  oiexx032
import java.awt.Color;

public class Triangle {
    /**
     * Variables:
    * xPos: The x position of the lower left corner of the triangle.
    * yPos: The y position of the lower left corner of the triangle.
    * width: The width of the triangle.
    * height: The height of the triangle.
    * col: The color of the triangle.
    * 
    * Constructor:
    * Triangle(x, y, w, h): Creates a new Triangle object with the specified x and y positions, width, and height.
    
    * Methods:
    * calculatePerimeter(): Calculates the perimeter of the triangle, assuming that it is isosceles.
    * calculateArea(): Calculates the area of the triangle.
    * setColor(setColorTo): Sets the color of the triangle to the specified color.
    * setPos(x, y): Sets the x and y position of the triangle.
    * setHeight(h): Sets the height of the triangle.
    * setWidth(w): Sets the width of the triangle.
    * getColor(): Gets the color of the triangle.
    * getXPos(): Gets the x position of the lower left
     */



    private double xPos;
    private double yPos;
    private double width;
    private double height;
    private Color col;
   
    public Triangle(double x, double y, double w, double h){
    xPos = x;
    yPos = y;
    width = w;
    height =h;
    }

    public double calculatePerimeter(){
        // Given the provided assumption that triangles are isosceles, 
        // perimeter calculated by: b + sqrt(b^2 + 4*h^2) 
        return (width + Math.sqrt(Math.pow(width,2) + (4 * Math.pow(height,2))));
    }

    public double calculateArea(){
        return ( (height * width) / 2.0);
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
