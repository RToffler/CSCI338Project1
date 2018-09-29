
package softwareengineeringproject1;

import java.util.ArrayList;

/**
 *Contains methods to generate the points of a parallelogram
 * with user input.
 * @author Richard Miller
 */
public class PGram extends Shape{
    
    int x1, y1, length, height;
    double theta;
    
    /**
     * Defines class member variables, adjusts user input
     * for mathematical use, and calls definePoints();
     * @param x1 - x coord of the upper left coordinate of parallelogram.
     * @param y1 - y coord of the upper left coordinate of parallelogram.
     * @param length - length of the top and bottom lines of parallelogram.
     * @param height - height of parallelogram.
     * @param theta - angle of upper left vertex.
     */
    public PGram(int x1, int y1, int length, int height,
            double theta){
        
        
        super.points = new ArrayList();
        
        this.x1 = x1;
        this.y1 = y1;
        this.length = length;
        this.height = height;
        //Adjust for easily interpreted input
        this.theta = 90 - theta;
        if (theta == 0){
            this.theta = 180;
        }
        
        definePoints();
    }
    
    /**
     * Defines the start and endpoints for the lines constituting
     * a parallelogram using user provided input and call methods
     * to define those lines.
     */
    private void definePoints(){

        double thetaRad = Math.toRadians(theta);
        
        //Find length shift between top and bottom lines.
        int xshift = Math.round((float)Math.tan(thetaRad) * height);
        
        //Define line endpoints based on calculated shift.
        int x2 = x1 + xshift;
        int y2 = y1 + height;
        int x3 = x2 + length;
        int y3 = y2;
        int x4 = x1 + length;
        int y4 = y1;
        
        defineLinePoints(x1, y1, x2, y2);
        defineLinePoints(x2, y2, x3, y3);
        defineLinePoints(x3, y3, x4, y4);
        defineLinePoints(x4, y4, x1, y1);
    }
    
    /**
     * Defines points of a line and provides them to superclass
     * Points ArrayList.
     * @param x1 - x coord for start point of line.
     * @param y1 - y coord for start point of line.
     * @param x2 - x coord for end point of line.
     * @param y2 - y coord for end point of line.
     */
    private void defineLinePoints(int x1, int y1, int x2, int y2){
        Line line = new Line(x1, y1, x2, y2);
        for(int i = 0; i < line.points.size(); i ++){
            super.points.add(line.points.get(i));
        }
    }
    
    
}
