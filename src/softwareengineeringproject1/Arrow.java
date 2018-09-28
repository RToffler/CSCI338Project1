/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject1;

import java.util.ArrayList;

/**
 *
 * @author mille
 */
public class Arrow extends Shape{
    
    int x, y, length;
    String orientation;
    
    public Arrow(int x, int y, int length, String orientation){
        super.points = new ArrayList();
        
        this.x = x;
        this.y = y;
        this.length = length;
        this.orientation = orientation;
        
        definePoints();
    }
    
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
    
    private void defineLine(int x1, int y1, int x2, int y2){
        Line line = new Line(x1, y1, x2, y2);
        for(int i = 0; i < line.points.size(); i ++){
            super.points.add(line.points.get(i));
        }
    }
    
    private void defineTriangle(int x1, int y1, int height, String orientation){
        Triangle triangle = new Triangle(x1, y1, height, orientation);
        for(int i = 0; i < triangle.points.size(); i++){
            super.points.add(triangle.points.get(i));
        }
    }
    
    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getShapeType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
