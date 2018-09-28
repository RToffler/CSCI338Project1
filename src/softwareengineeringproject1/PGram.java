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
public class PGram extends Shape{
    
    int x1, y1, length, height;
    double theta;
    
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
    
    private void definePoints(){

        double thetaRad = Math.toRadians(theta);
        
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
    
    private void defineLinePoints(int x1, int y1, int x2, int y2){
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
