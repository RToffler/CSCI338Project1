/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject1;

import csci338.drawings.SimpleDrawing;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author mille
 */
public class InteractiveDrawing extends SimpleDrawing{
    
    private ArrayList<Shape> shapes = new ArrayList();
    
    public InteractiveDrawing(){
        super();
    }
    
    @Override
    public void mouseClicked(MouseEvent e){        
        ArrayList<Shape> shapesToDelete = getShapesAtPos(e.getX(), e.getY());
        deleteShapes(shapesToDelete);
    }
    
    public void draw(Shape shape){
        for(int i = 0; i < shape.points.size(); i++){
            showPoint(shape.points.get(i).getX(), shape.points.get(i).getY());
        }
    }
    
    public void addShape(Shape shape){
        shapes.add(shape);
    }
    
    public void deleteShapes(ArrayList<Shape> shapesToDelete){
        for(int i = shapesToDelete.size()-1; i >= 0; i--){
            Shape shapeToDelete = shapesToDelete.get(i);
            shapesToDelete.remove(i);
            for(int j = 0; j < shapeToDelete.points.size(); j++){
                int x = shapeToDelete.points.get(j).getX();
                int y = shapeToDelete.points.get(j).getY();
                hidePoint(x, y);
            }
        }
    }
    
    public ArrayList<Shape> getShapesAtPos(int x, int y){
        ArrayList<Shape> shapesToDelete = new ArrayList();
        
        for(int i = 0; i < shapes.size(); i ++){
            
            for(int j = 0; j < shapes.get(i).points.size(); j++){
                
                int shapeX = shapes.get(i).points.get(j).getX();
                int shapeY = shapes.get(i).points.get(j).getY();
                if(x == shapeX && y == shapeY){
                    shapesToDelete.add(shapes.get(i));
                    //Remove that shape from class list.
                    shapes.remove(i);
                    //Adjust iterator for removal of shape.
                    i--;
                    break;
                }
            }
        }
        return shapesToDelete;
    }
}
