
package softwareengineeringproject1;

import java.util.ArrayList;

/**
 *Contains methods for generating the points of a 
 * circle with user provided dimensions.
 * @author Richard Miller
 */
public class Circle extends Shape{

    private int radius, x, y;
    /**
     * Sets class fields and invokes definePoints();
     * @param x
     * @param y
     * @param radius 
     */
    public Circle(int x, int y, int radius){
        super.points = new ArrayList();
        
        this.x = x;
        this.y = y;
        this.radius = radius;
        
        definePoints();
    }
    
    /**
     * Uses a radian iterator to define the points of a circle
     * with sin and cosine results of that iterator. Adds points
     * to superclass point structure.
     */
    private void definePoints(){
        //Division of iterator scales with circle size for consistent resolution.
        double theta = Math.PI / (radius*3);
        for(double i = 0; i < 2*Math.PI; i = i + theta){
            
            int radialX = x + (int)(Math.round(Math.cos(i) * radius));
            int radialY = y + (int)(Math.round(Math.sin(i) * radius));
            
            Point p = new Point(radialX, radialY);
            super.points.add(p);
        }
    }
    
}
