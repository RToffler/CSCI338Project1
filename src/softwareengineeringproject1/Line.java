
package softwareengineeringproject1;

import csci338.drawings.SimpleDrawing;
/**
 * Instantiated when the user uses the "line" command.
 * Draws a line in the simple drawing window.
 */
public class Line {
    
    private int x1, y1, x2, y2;
    SimpleDrawing drawing;
    
    public Line(int startX, int startY, int endX, int endY, SimpleDrawing drawing){
        
        x1 = startX;
        y1 = startY;
        x2 = endX;
        y2 = endY;
        
        this.drawing = drawing;
        
        draw();
    }
    
    /**
     * This method currently draws a line pixel by pixel
     * with respect to the x-axis.  To be implemented is a
     * check to see if the line would be drawn with greater
     * definition in respect to the y-axis, and separate
     * methods drawing from respect to the y and x axes.
     */
    public void draw (){
        
        float yslope = (((float)y2 - y1) / ((float)x2 - x1));
        
        if (x1 > x2){
            yslope = yslope * -1;
        }
        
        int drawX = x1;
        int drawY = y1;
        
        for (int i = 0; i < Math.abs(x1-x2); i++){
            
            drawing.showPoint(drawX, drawY);
            drawY = Math.round(y1 + yslope*i);
            
            if(x1 < x2 ){
                drawX++;
            }else if (x1 > x2){
                drawX--;
            }
            
        }
    }
    
    /**
     * Method to draw with respect to the X axis.
     */
    public void drawByX(){
        
    }
    
    /**
     * Method to draw with respect to the Y axis.
     */
    public void drawByY(){
        
    }
}
