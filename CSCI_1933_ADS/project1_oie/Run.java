
import java.awt.Color;

public class Run {
    public static void main(String[] args){
        Canvas drawing = new Canvas(800,800);
        Circle myCircle = new Circle(400,400,100);
    
        myCircle.setColor(Color.BLUE);
        
        drawing.drawShape(myCircle);
    }
}
