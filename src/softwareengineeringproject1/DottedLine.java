
package softwareengineeringproject1;

/**
 * Extends line, uses super constructor with added makeDotted
 * method to make line slashed.
 * @author Richard Miller
 */
public class DottedLine extends Line {
    /**
     * Calls superclass constructor and local method to remove points
     * at intervals of rate parameter.
     * @param startX X coordinate of the starting point of the line.
     * @param startY Y coordinate of the starting point of the line.
     * @param endX X coordinate of the ending point of the line.
     * @param endY Y coordinate of the ending point of the line.
     * @param rate Interval of dotting or dashing.
     */
    public DottedLine(int startX, int startY, int endX, int endY, int rate) {
        super(startX, startY, endX, endY);
        makeDotted(rate);
    }

    private void makeDotted(int rate) {
        boolean hideFlag = true;
        for (int i = 0; i < super.points.size(); i++) {
            if (i % rate == 0)
            {
                hideFlag = !hideFlag;
            }
            if (hideFlag) {
                super.points.remove(i);
            }
        }
    }

}
