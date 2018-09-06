
package softwareengineeringproject1;

import csci338.drawings.SimpleDrawing;
/**
 * Instantiated when the user uses the "line" command.
 * Draws a line in the simple drawing window.
 */
public class Line {
    
    /*
    Integers are not final because later features may modify
    the position of lines using transforms.
    */
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
        
        int xChange = Math.abs(x2 - x1);
        int yChange = Math.abs(y2 - y1);
        double angle = Math.toDegrees(Math.atan((float)yChange/xChange));
        
        if(angle >= 45.0){
            drawByY(xChange, yChange);
        }else{
            drawByX(xChange, yChange);
        }
        
    }
    
    /**
     * Method to draw with respect to the X axis.
     * @param xChange The change in X value between x1 and x2.
     * @param yChange The change in Y value between y1 and y2.
     */
    public void drawByX(int xChange, int yChange){
        
        float ySlope = ((float) yChange / (float)xChange);
        
        if (y1 > y2){
            ySlope = ySlope * -1;
        }
        
        int drawX = x1;
        int drawY = y1;
        
        for (int i = 0; i < xChange ; i++){
            
            drawing.showPoint(drawX, drawY);
            drawY = Math.round(y1 + ySlope*i);
            
            if(x1 < x2 ){
                drawX++;
            }else if (x1 > x2){
                drawX--;
            }
            
        }
    }
    
    /**
     * Method to draw with respect to the Y axis.
     * @param xChange The change in X value between x1 and x2.
     * @param yChange The change in Y value between y1 and y2.
     */
    public void drawByY(int xChange, int yChange){
        
        float xSlope = ((float)xChange / (float)yChange);
        
        if (x1 > x2){
            xSlope = xSlope * -1;
        }
        
        int drawX = x1;
        int drawY = y1;
        
        for (int i = 0; i < yChange; i++){
            
            drawing.showPoint(drawX, drawY);
            drawX = Math.round(x1 + xSlope*i);
            
            if(y1 < y2 ){
                drawY++;
            }else if (y1 > y2){
                drawY--;
            }
            
        }
    }
}
