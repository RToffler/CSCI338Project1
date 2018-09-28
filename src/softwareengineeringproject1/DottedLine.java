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
public class DottedLine extends Line {

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
