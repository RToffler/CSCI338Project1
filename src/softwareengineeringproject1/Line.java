/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject1;

import csci338.drawings.SimpleDrawing;
/**
 *
 * @author mille
 */
public class Line {
    
    private int x1, y1, x2, y2;
    SimpleDrawing drawing;
    
    public Line(int startX, int startY, int endX, int endY, SimpleDrawing drawing){
        
        x1 = startX;
        y1 = startY;
        x2 = endX;
        y2 = endY;
        
        this.drawing = drawing;
        
        draw();
    }
    
    public void draw (){
        
        float yslope = (((float)y2 - y1) / ((float)x2 - x1));
        
        if (x1 > x2){
            yslope = yslope * -1;
        }
        
        int drawX = x1;
        int drawY = y1;
        
        for (int i = 0; i < Math.abs(x1-x2); i++){
            
            drawing.showPoint(drawX, drawY);
            drawY = Math.round(y1 + yslope*i);
            
            if(x1 < x2 ){
                drawX++;
            }else if (x1 > x2){
                drawX--;
            }
            
        }
    }
    
    public void drawByX(){
        
    }
    
    public void drawByY(){
        
    }
}
