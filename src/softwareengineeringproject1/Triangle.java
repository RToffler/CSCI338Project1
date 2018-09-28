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
public class Triangle extends Shape{
    
    int x1, y1, x2, y2, x3, y3, height;
    
    public Triangle (int tipX, int tipY, int height, String orientation){
        super.points = new ArrayList();
        x1 = tipX;
        y1 = tipY;
        this.height = height;
        defineVertexes(orientation);
        definePoints();
    }
    
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
    
    private void definePoints(){
       defineLinePoints(x1, y1, x2, y2);
       defineLinePoints(x1,y1, x3, y3);
       defineLinePoints(x2,y2, x3, y3);
    }
    
    private void defineLinePoints(int x1, int y1,int x2,int y2){
        Line line1 = new Line(x1, y1, x2, y2);
        for(int i = 0; i < line1.points.size(); i++){
            super.points.add(line1.points.get(i));
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
