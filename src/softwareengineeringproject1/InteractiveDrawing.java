/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject1;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import csci338.drawings.SimpleDrawing;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author mille
 */
public class InteractiveDrawing extends SimpleDrawing{
    
    
    public InteractiveDrawing(){
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + " , " + y);
            }
        });
    }
    
    public void draw(Shape shape){
        for(int i = 0; i < shape.points.size(); i++){
            showPoint(shape.points.get(i).getX(), shape.points.get(i).getY());
        }
    }
    
    public void delete(Shape shape){
        
    }
    
}
