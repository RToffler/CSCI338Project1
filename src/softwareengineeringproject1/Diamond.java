
package softwareengineeringproject1;

import java.util.ArrayList;

/**
 * Contains methods to generate the points of a diamond
 * with user input.
 * @author Richard Miller
 */
public class Diamond extends Shape{
    
    int x1, y1, height, width;
    
    /**
     * Sets class variables to user provided input and calls
     * definePoints().
     * @param x1 - x coordinate of top vertex.
     * @param y1 - y coordinate of top vertex.
     * @param width - width of the diamond.
     * @param height - height of the diamond.
     */
    public Diamond(int x1, int y1, int width, int height){
        super.points = new ArrayList();
        
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
        
        definePoints();
    }
    
    /**
     * Defines coordinate parameters for the lines that
     * will constitute the diamond and calls defineLine()
     * to define those lines.
     */
    private void definePoints(){
        
        int x2 = x1 - width/2;
        int y2 = y1 - height/2;
        int x3 = x1;
        int y3 = y1 - height;
        int x4 = x1 + width/2;
        int y4 = y1 - height/2;
        
        defineLine(x1, y1, x2, y2);
        defineLine(x2, y2, x3, y3);
        defineLine(x3, y3, x4, y4);
        defineLine(x4, y4, x1, y1);
    }
    
    /**
     * Defines coordinates of the lines constituting a diamond
     * and adds those coordinates to the superclass Point list.
     * @param x1 - x coord for the startpoint of a line.
     * @param y1 - y coord for the startpoint of a line.
     * @param x2 - x coord for the endpoint of a line.
     * @param y2 - y coord for the endpoint of a line.
     */
    public void defineLine(int x1, int y1, int x2, int y2){
        Line line = new Line(x1, y1, x2, y2);
        for(int i = 0; i < line.points.size(); i ++){
            super.points.add(line.points.get(i));
        }
    }
    
}
