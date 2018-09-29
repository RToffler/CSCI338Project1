/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject1;

import java.util.ArrayList;

/**
 *Defines the points in superclass Point list which will be 
 * used in the draw method of InteractiveDrawing.
 * @author Richard Miller
 */
public class Arrow extends Shape{
    
    int x, y, length;
    String orientation;
    
    /**
     * Set class member variables and call definePoints()
     * @param x - x coordinate for arrow starting point.
     * @param y - y coordinate for arrow starting point.
     * @param length - length of arrow.
     * @param orientation - direction of arrow, expects string "up",
     * "down", "left", or "right".
     */
    public Arrow(int x, int y, int length, String orientation){
        super.points = new ArrayList();
        
        this.x = x;
        this.y = y;
        this.length = length;
        this.orientation = orientation;
        
        definePoints();
    }
    
    /**
     * Breaks the defining of the points of the arrow into
     * the line and the triangle at the end. Calls method
     * based on orientation parameter.
     */
    private void definePoints(){
        if(orientation.toLowerCase().equals("up")){
            defineLine(x, y, x, y-length+10);
            defineTriangle(x, y-length, 10, "up");
        }else if(orientation.toLowerCase().equals("down")){
            defineLine(x, y, x, y+length-10);
            defineTriangle(x, y+length, 10, "down");
        }else if(orientation.toLowerCase().equals("right")){
            defineLine(x, y, x+length-10, y);
            defineTriangle(x+length-10, y-5, 10, "right");
        }else if(orientation.toLowerCase().equals("left")){
            defineLine(x, y, x-length+10, y);
            defineTriangle(x-length+10, y-5, 10, "left");
        }
    }
    
    /**
     * Creates new line and adds its points to superclass
     * Point list.
     * @param x1 line start x coordinate.
     * @param y1 line start y coordinate.
     * @param x2 line end x coordinate.
     * @param y2 line end y coordinate.
     */
    private void defineLine(int x1, int y1, int x2, int y2){
        Line line = new Line(x1, y1, x2, y2);
        for(int i = 0; i < line.points.size(); i ++){
            super.points.add(line.points.get(i));
        }
    }
    
    /**
     * Creates new triangle and adds its points to superclass
     * Point list.
     * @param x1 line start x coordinate.
     * @param y1 line start y coordinate.
     * @param height triangle height.
     * @param orientation orientation of arrow.
     */
    private void defineTriangle(int x1, int y1, int height, String orientation){
        Triangle triangle = new Triangle(x1, y1, height, orientation);
        for(int i = 0; i < triangle.points.size(); i++){
            super.points.add(triangle.points.get(i));
        }
    }

}
