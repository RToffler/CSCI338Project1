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
public class Diamond extends Shape{
    
    int x1, y1, height, width;
    
    public Diamond(int x1, int y1, int width, int height){
        super.points = new ArrayList();
        
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
        
        definePoints();
    }
    
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
    
    public void defineLine(int x1, int y1, int x2, int y2){
        Line line = new Line(x1, y1, x2, y2);
        for(int i = 0; i < line.points.size(); i ++){
            super.points.add(line.points.get(i));
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
