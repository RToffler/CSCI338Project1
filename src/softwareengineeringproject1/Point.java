
package softwareengineeringproject1;

/**
 * A class used to represent points for storage in instantiated
 * shapes for easy transformation or deletion.
 * @author Richard Miller
 */
public class Point {
    
    private int x;
    private int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
