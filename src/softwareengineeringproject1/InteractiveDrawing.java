
package softwareengineeringproject1;

import csci338.drawings.SimpleDrawing;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Contains methods allowing for mouse-click deletion and
 * the drawing of shapes.
 * @author Richard Miller
 */
public class InteractiveDrawing extends SimpleDrawing{
    
    private ArrayList<Shape> shapes = new ArrayList();
    
    public InteractiveDrawing(){
        super();
    }
    
    /**
     * Gets all shapes with points at a clicked location and
     * provides them to deleteShapes method.
     * @param e mouseEvent.
     */
    @Override
    public void mouseClicked(MouseEvent e){        
        ArrayList<Shape> shapesToDelete = getShapesAtPos(e.getX(), e.getY());
        deleteShapes(shapesToDelete);
    }
    
    /**
     * Calls showPoint() on all points of shape.
     * @param shape - shape to be drawn.
     */
    public void draw(Shape shape){
        for(int i = 0; i < shape.points.size(); i++){
            showPoint(shape.points.get(i).getX(), shape.points.get(i).getY());
        }
    }
    
    /**
     * Adds shape to class member Shape list for future
     * reference and deletion.
     * @param shape - shape to be added to shapes.
     */
    public void addShape(Shape shape){
        shapes.add(shape);
    }
    
    /**
     * Calls hidePoint on every point in an ArrayList of shapes.
     * @param shapesToDelete - ArrayList of shapes to be
     * hidden.
     */
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
    
    /**
     * Returns an ArrayList containing all shapes that contain
     * a point at coordinate (x, y).
     * @param x - x coordinate of queried point.
     * @param y - y coordinate of queried point.
     * @return - ArrayList of points that have a point at (x, y).
     */
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
