
package softwareengineeringproject1;

import csci338.drawings.SimpleDrawing;
import java.util.ArrayList;
/**
 *This class is instantiated when the user inputs
 * the "box" command.
 */
public class Box extends Shape{
    
    private int height, length;
    private int xcoord, ycoord;
    
    /**
     * Constructor for a box.
     * @param xcoord the x coordinate for the upper left hand corner of the box
     * @param ycoord the y coordinate for the upper left hand corner of the box
     * @param length the length of the box in pixels.
     * @param height the height of the box in pixels.
     * @param drawing the Simple Drawing object from main.
     */
    public Box(int xcoord, int ycoord, int length, int height){
        
        super.points = new ArrayList();
        
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.length = length;
        this.height = height;
        
        definePoints();
    }
    
    /**
     * Fills ArrayList of points with point values which can
     * be passed to drawing to draw image.
     */
    private void definePoints(){
        for(int i = 0; i < length; i ++){
            Point p1 = new Point(xcoord+i, ycoord);
            Point p2 = new Point(xcoord+i, ycoord+height);
            
            super.points.add(p1);
            super.points.add(p2);
            
        }
        for(int i = 0; i <= height; i++){
            Point p1 = new Point(xcoord, ycoord+i);
            Point p2 = new Point (xcoord+length, ycoord+i);
            
            super.points.add(p1);
            super.points.add(p2);

        }
    }
    
    /**
     * Hides all points of the box using same iterative pattern
     * of draw().
     */
    public void delete(){
        
    }
    
    @Override
    public String getShapeType(){
        return "box";
    }
    
    public int getxCoord(){
        return xcoord;
    }
    
    public int getyCoord(){
        return ycoord;
    }
    
    public int getLength(){
        return length;
    }
    
    public int getHeight(){
        return height;
    }
}
