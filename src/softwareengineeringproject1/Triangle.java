
package softwareengineeringproject1;

import java.util.ArrayList;

/**
 *Contains methods to define the points of a triangle
 * with user provided parameters.
 * @author Richard Miller
 */
public class Triangle extends Shape{
    
    int x1, y1, x2, y2, x3, y3, height;
    
    /**
     * Assigns class member variables, calls defineVertexes and
     * definePoints();
     * @param tipX - x coordinate of triangle tip.
     * @param tipY - y coordinate of triangle tip.
     * @param height - height of triangle.
     * @param orientation - direction of triangle, string "up", "down",
     * "left", or "right".
     */
    public Triangle (int tipX, int tipY, int height, String orientation){
        super.points = new ArrayList();
        x1 = tipX;
        y1 = tipY;
        this.height = height;
        defineVertexes(orientation);
        definePoints();
    }
    
    /**
     * Defines points of the two other triangle vertexes.
     * @param orientation - direction of the triangle.
     */
    private void defineVertexes(String orientation){
        if("down".equals(orientation)){
           y2 = y1-height;
           y3 = y1-height;
           
           x2 = x1 - height/2;
           x3 = x1 + height/2;
        }else if(orientation.equals("up")){
            y2 = y1+height;
            y3 = y1+height;
            x2 = x1 - height/2;
            x3 = x1 + height/2;
        }else if(orientation.equals("left")){
            x2 = x1-height;
            y2 = y1+height/2;
            x3 = x1;
            y3 = y1+height;
        }else if(orientation.equals("right")){
            x2 = x1+height;
            y2 = y1+height/2;
            x3 = x1;
            y3 = y1+height;
        }
    }
    
    /**
     * Calls defineLinePoints with params for the
     * lines constituting the triangle.
     */
    private void definePoints(){
       defineLinePoints(x1, y1, x2, y2);
       defineLinePoints(x1,y1, x3, y3);
       defineLinePoints(x2,y2, x3, y3);
    }
    
    /**
     * Defines the points of a line and provides them to
     * superclass Points ArrayList.
     * @param x1 - x coord of the start point of line.
     * @param y1 - y coord of the start point of line.
     * @param x2 - x coord of the end point of line.
     * @param y2 - y coord of the end point of line.
     */
    private void defineLinePoints(int x1, int y1,int x2,int y2){
        Line line1 = new Line(x1, y1, x2, y2);
        for(int i = 0; i < line1.points.size(); i++){
            super.points.add(line1.points.get(i));
        }
    }

}
