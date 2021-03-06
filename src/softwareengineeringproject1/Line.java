
package softwareengineeringproject1;

import java.util.ArrayList;
/**
 * Instantiated when the user uses the "line" command.
 * Defines points of of a line based on user provided
 * start and endpoints.
 */
public class Line extends Shape{
    
    /*
    Integers are not final because later features may modify
    the position of lines using transforms.
    */
    private int x1, y1, x2, y2;
    
    /**
     * Define class member variables and call definePoints();
     * @param startX - starting point x coord.
     * @param startY - starting point y coord.
     * @param endX - end point x coord.
     * @param endY - end point y coord.
     */
    public Line(int startX, int startY, int endX, int endY){
        
        super.points = new ArrayList();
        
        x1 = startX;
        y1 = startY;
        x2 = endX;
        y2 = endY;
        
        definePoints();
                
    }
    
    /**
     * This method determines if a line would have a higher
     * definition when drawn with respect to the y or x axis and
     * then calls the respective draw method.
     */
    private void definePoints (){
        
        int xChange = Math.abs(x2 - x1);
        int yChange = Math.abs(y2 - y1);
        
        //find value of opposite angle.
        double angle = Math.toDegrees(Math.atan((float)yChange/xChange));
        
        //If angle is > 45 degrees definition is higher in respect to Y axis.
        if(angle >= 45.0){
            //Number of points in line = yChange, initialize points.
            //points = new Point[yChange];
            definePointsByY(xChange, yChange);
        }else{
            //Number of points in line = xChange, initialize points.
            //points = new Point[xChange];
            definePointsByX(xChange, yChange);
        }
        
    }
    
    /**
     * Method to define points with respect to the X axis and
     * provide them to superclass Points list.
     * @param xChange The change in X value between x1 and x2.
     * @param yChange The change in Y value between y1 and y2.
     */
    public void definePointsByX(int xChange, int yChange){
        
        float ySlope = ((float) yChange / (float)xChange);
        
        if (y1 > y2){
            ySlope = ySlope * -1;
        }
        
        int drawX = x1;
        int drawY = y1;
        
        for (int i = 0; i < xChange ; i++){
            //Store points in array for use in deletion/transforms.
            Point p = new Point(drawX, drawY);
            points.add(p);
            
            drawY = Math.round(y1 + ySlope*i);
            
            if(x1 < x2 ){
                drawX++;
            }else if (x1 > x2){
                drawX--;
            }
            
        }
    }
    
    /**
     * Method to define points with respect to the Y axis and
     * provide them to superclass Points ArrayList.
     * @param xChange The change in X value between x1 and x2.
     * @param yChange The change in Y value between y1 and y2.
     */
    public void definePointsByY(int xChange, int yChange){
        
        float xSlope = ((float)xChange / (float)yChange);
        
        if (x1 > x2){
            xSlope = xSlope * -1;
        }
        
        int drawX = x1;
        int drawY = y1;
        
        for (int i = 0; i < yChange; i++){
            //Store points in array for use in deletion/transforms.
            Point p = new Point(drawX, drawY);
            points.add(p);
            
            drawX = Math.round(x1 + xSlope*i);
            
            if(y1 < y2 ){
                drawY++;
            }else if (y1 > y2){
                drawY--;
            }
            
        }
    }
    
}
