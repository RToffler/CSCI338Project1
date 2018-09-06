
package softwareengineeringproject1;

import csci338.drawings.SimpleDrawing;
/**
 *This class is instantiated when the user inputs
 * the "box" command.  To be implemented.
 */
public class Box {
    
    private int height, length;
    private int xcoord, ycoord;
    private SimpleDrawing drawing;
    
    /**
     * Constructor for a box.
     * @param xcoord the x coordinate for the upper left hand corner of the box
     * @param ycoord the y coordinate for the upper left hand corner of the box
     * @param length the length of the box in pixels.
     * @param height the height of the box in pixels.
     * @param drawing the Simple Drawing object from main.
     */
    public Box(int xcoord, int ycoord, int length, int height, SimpleDrawing drawing){
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.length = length;
        this.height = height;
        this.drawing = drawing;
        
        draw();
    }
    
    /**
     * Draws boxes by iterating through the length and height
     * and adding the iterator to the x and y coordinates to 
     * draw the sides of a box.
     */
    public void draw(){
        for(int i = 0; i < length; i ++){
            drawing.showPoint(xcoord+i, ycoord);
            drawing.showPoint(xcoord+i, ycoord+height);
        }
        for(int i = 0; i <= height; i++){
            drawing.showPoint(xcoord, ycoord+i);
            drawing.showPoint(xcoord+length, ycoord+i);
        }
    }
}
