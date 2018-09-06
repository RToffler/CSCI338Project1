
package softwareengineeringproject1;

import csci338.drawings.SimpleDrawing;
/**
 * Instantiated when the user uses the "line" command.
 * Draws a line in the simple drawing window.
 */
public class Line {
    
    private Point[] points;
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
     * This method determines if a line would have a higher
     * definition when drawn with respect to the y or x axis and
     * then calls the respective draw method.
     */
    public void draw (){
        
        int xChange = Math.abs(x2 - x1);
        int yChange = Math.abs(y2 - y1);
        
        //find value of opposite angle.
        double angle = Math.toDegrees(Math.atan((float)yChange/xChange));
        
        //If angle is > 45 degrees definition is higher in respect to Y axis.
        if(angle >= 45.0){
            //Number of points in line = yChange, initialize points.
            points = new Point[yChange];
            drawByY(xChange, yChange);
        }else{
            //Number of points in line = xChange, initialize points.
            points = new Point[xChange];
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
            //Store points in array for use in deletion/transforms.
            points[i] = new Point(drawX, drawY);
            
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
            //Store points in array for use in deletion/transforms.
            points[i] = new Point(drawX, drawY);
            
            drawing.showPoint(drawX, drawY);
            drawX = Math.round(x1 + xSlope*i);
            
            if(y1 < y2 ){
                drawY++;
            }else if (y1 > y2){
                drawY--;
            }
            
        }
    }
    
    /**
     * Hides points by iterating through array containing the
     * x and y values for all points in the line and calling hidePoint();.
     */
    public void delete(){
        for(int i = 0; i < points.length; i++){
            drawing.hidePoint(points[i].getX(), points[i].getY());
        }
    }
    
    public int getX1(){
        return x1;
    }
    
    public int getX2(){
        return x2;
    }
    
    public int getY1(){
        return y1;
    }
    
    public int getY2(){
        return y2;
    }
}
