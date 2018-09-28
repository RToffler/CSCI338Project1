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
public class Circle extends Shape{

    int radius, x, y;
    public Circle(int x, int y, int radius){
        super.points = new ArrayList();
        
        this.x = x;
        this.y = y;
        this.radius = radius;
        
        definePoints();
    }
    
    private void definePoints(){
        double theta = Math.PI / (radius*3);
        for(double i = 0; i < 2*Math.PI; i = i + theta){
            
            int radialX = x + (int)(Math.round(Math.cos(i) * radius));
            int radialY = y + (int)(Math.round(Math.sin(i) * radius));
            
            Point p = new Point(radialX, radialY);
            super.points.add(p);
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
