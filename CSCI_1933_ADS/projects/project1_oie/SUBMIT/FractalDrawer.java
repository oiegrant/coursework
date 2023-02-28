// Written by Grant Oie,  oiexx032

// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.text.RuleBasedCollator;
import java.util.Scanner;
import java.util.Random;

public class FractalDrawer {
    /**
    * 
    * The FractalDrawer class allows drawing fractals of different shapes.

    * Variables:
    * totalArea: a double to keep track of the total area.
    * iter: an integer to set the number of recursive loops.

    * Constructor:
    * FractalDrawer(): Creates a new FractalDrawer object.

    * Methods:
    * drawFractal(String type): Draws a fractal of the specified type using recursive techniques.
    * drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level):
    * Draws a triangle fractal using recursive techniques.
    *
    * drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level):
    * Draws a circle fractal using recursive techniques.
    *
    * drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level):
    * Draws a rectangle fractal using recursive techniques.
    * randomColor(): Generates a random color.
    * */
    private double totalArea=0;  // member variable for tracking the total area
    private int iter = 8; // Sets number of recursive loops

    public FractalDrawer() {}

    public double drawFractal(String type) {
        int frameHeight = 4000;
        int frameWidth = 4000; 

        Canvas canvas = new Canvas(frameHeight,frameWidth);

        switch(type){
            case "Circle":{
                drawCircleFractal(100, 1000,500 , randomColor(), canvas, iter);
                break;
            }
            case "Triangle":{
                drawTriangleFractal(200,200, 1000,500,randomColor(), canvas, iter);
                break;
            }
            case "Rectangle":{
                double w=200;
                double h=100;
                drawRectangleFractal(w,h, 1000, 500,randomColor(), canvas, iter);
                break;
            }
        }
        return totalArea;
    }

    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        
        Triangle myTri = new Triangle(x,y,width,height);
        myTri.setColor(c);
        can.drawShape(myTri);
        totalArea += myTri.calculateArea();

        if (level == 0){
            return;
        }
        else{
            c =randomColor();
            drawTriangleFractal(width/2, height/2, x+(width/4.0), y-height, c, can, level-1); // top
            drawTriangleFractal(width/2, height/2, x+width, y, c, can, level-1); // right
            drawTriangleFractal(width/2, height/2, x-(width/2.0), y, c, can, level-1); // left
            drawTriangleFractal(width/2, height/2, x+(width/4.0), y+height, c, can, level-1); // bottom
        }


    }


    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        
        Circle myCircle = new Circle(x,y,radius);
        myCircle.setColor(c);
        can.drawShape(myCircle);
        totalArea += myCircle.calculateArea();

        if (level == 0){
            return;
        }
        else{
            c =randomColor();
            drawCircleFractal(radius/2.0, x+(1.5*radius), y, c, can, level-1);
            drawCircleFractal(radius/2.0, x-(1.5*radius), y, c, can, level-1);
            drawCircleFractal(radius/2.0, x, y+(1.5*radius), c, can, level-1);
            drawCircleFractal(radius/2.0, x, y-(1.5*radius), c, can, level-1);
        }
    }


    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {

        Rectangle myRec = new Rectangle(x,y,width,height);
        myRec.setColor(c);
        can.drawShape(myRec);
        totalArea += myRec.calculateArea();

        if(level==0){
            return;
        }
        else{
            c =randomColor();
            drawRectangleFractal(width/2, height/2, x-(width/2), y-(height/2),c, can, level-1);//top left
            drawRectangleFractal(width/2, height/2, x+width, y-(height/2), c, can, level-1);//top right
            drawRectangleFractal(width/2, height/2, x-(width/2), y+height, c, can, level-1);//bottom left
            drawRectangleFractal(width/2, height/2, x+width, y+height, c, can, level-1);//bottom right
        }

    }

    public Color randomColor(){
        Random random = new Random();
        final float hue = random.nextFloat();
        final float saturation = (random.nextInt(2000) + 1000) / 10000f;
        final float luminance = 0.9f;
        final Color color = Color.getHSBColor(hue, saturation, luminance);
        return color;
    }

    public double getArea(){
        return totalArea;
    }

    // main asks user for shape input, and then draws the corresponding fractal.
    // prints area of fractal
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        FractalDrawer FracDraw = new FractalDrawer();
        int option = 1;
        System.out.println("Please select an option 1, 2, or 3:\n(1) Circle Fractal\n(2) Triangle Fractal\n(3) Rectangle Fractal\nAny other key to exit");
        option = s.nextInt(); // reintroduce before submission
        
        switch(option){
            case 1: {
                FracDraw.drawFractal("Circle");
                break;
            }
            case 2: {
                FracDraw.drawFractal("Triangle");
                break;
            }
            case 3: {
                FracDraw.drawFractal("Rectangle");
                break;
            }
            default: {System.out.println("Exiting Program...");}
        };

        System.out.println("Total Area of Fractal: " + FracDraw.getArea());
        
    }
}
