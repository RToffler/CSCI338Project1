
package softwareengineeringproject1;

import java.util.Scanner;

/**
 * CSCI 338 Project 2, Shaeffer
 * 
 * @author Richard Miller
 * This program allows users to draw various shapes and lines
 * via the command line. Users are also able to delete shapes
 * by clicking on them.  
 * 
 * Known Issues: 
 *  Some lines may have awkward or jagged edges because of
 *  the thinness of pixel lines and integer rounding in draw
 *  methods.
 * 
 *  It is difficult for the user to click on an exact pixel
 *  of a shape for deletion.  Implementing some sort of
 *  tolerance in the point checking deletion methods is a
 *  potential fix.
 * 
 *  If a point is shared by multiple shapes and one is deleted,
 *  it is deleted on all other shapes as well.  Adding a list
 *  of shared points to be ignored during deletion is a possible
 *  fix for this.
 * 
 *  Error handling for user input should be improved with use
 *  of exception catching.
 * 
 */
public class DiagramDrawer {


    Scanner scanner = new Scanner(System.in);
    public InteractiveDrawing drawing = new InteractiveDrawing();

    /**
     * The main method simply calls the shell method which then accepts and
     * handles user inputs.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DiagramDrawer dg = new DiagramDrawer();

        System.out.println("Please enter command, or type help.");
        dg.shell();
    }

    /**
     * This method is the shell that accepts and responds to user input using a
     * break statement for the valid inputs and calling each input's
     * respective method.
     */
    public void shell() {

        while (true) {

            System.out.print(">");
            String input = scanner.nextLine();
            String[] keywords = input.split(" ");

            switch (keywords[0]) {

                case "help":
                    help();
                    break;

                case "quit":

                    return;

                case "line":
                    handleLine(keywords);
                    break;

                case "dottedline":
                    handleDottedLine(keywords);
                    break;

                case "box":
                    handleBox(keywords);
                    break;

                case "triangle":
                    handleTriangle(keywords);
                    break;

                case "circle":
                    handleCircle(keywords);
                    break;

                case "pgram":
                    handlePgram(keywords);
                    break;

                case "diamond":
                    handleDiamond(keywords);
                    break;

                case "arrow":
                    handleArrow(keywords);
                    break;

                default:
                    System.out.println("Unrecognized command, '" + input
                            + "', type 'help' for list of commands.");
                    break;
            }
        }
    }
    
    /**
     * Assigns input parameters to local variables which are
     * past to the shape constructor.  The shape is then added
     * to the InteractiveDrawing objects Shape list and drawn.
     * @param keywords parsed user inputs.
     */
    public void handleLine(String[] keywords) {
        //Check for proper input
        if (keywords.length != 5) {
            System.out.println("Error: Improper number of arguments.");
            return;
        }

        int x1 = Integer.parseInt(keywords[1]);
        int y1 = Integer.parseInt(keywords[2]);
        int x2 = Integer.parseInt(keywords[3]);
        int y2 = Integer.parseInt(keywords[4]);

        Line line = new Line(x1, y1, x2, y2);

        drawing.addShape(line);
        drawing.draw(line);

    }

    /**
     * Assigns input parameters to local variables which are
     * past to the shape constructor.  The shape is then added
     * to the InteractiveDrawing objects Shape list and drawn.
     * @param keywords parsed user inputs.
     */
    public void handleDottedLine(String[] keywords) {
        if (keywords.length != 6) {
            System.out.println("Error: incorrect number of arguments.");
            return;
        }

        int x1 = Integer.parseInt(keywords[1]);
        int y1 = Integer.parseInt(keywords[2]);
        int x2 = Integer.parseInt(keywords[3]);
        int y2 = Integer.parseInt(keywords[4]);
        int rate = Integer.parseInt(keywords[5]);

        DottedLine dottedLine = new DottedLine(x1, y1, x2, y2, rate);

        drawing.addShape(dottedLine);
        drawing.draw(dottedLine);

    }

    /**
     * Assigns input parameters to local variables which are
     * past to the shape constructor.  The shape is then added
     * to the InteractiveDrawing objects Shape list and drawn.
     * @param keywords parsed user inputs.
     */
    public void handleBox(String[] keywords) {
        if (keywords.length != 5) {
            System.out.println("Error: Improper number of arguments.");
            return;
        }

        int xcoord = Integer.parseInt(keywords[1]);
        int ycoord = Integer.parseInt(keywords[2]);
        int length = Integer.parseInt(keywords[3]);
        int height = Integer.parseInt(keywords[4]);

        Box box = new Box(xcoord, ycoord, length, height);

        drawing.addShape(box);
        drawing.draw(box);

    }

    /**
     * Assigns input parameters to local variables which are
     * past to the shape constructor.  The shape is then added
     * to the InteractiveDrawing objects Shape list and drawn.
     * @param keywords parsed user inputs.
     */
    public void handleTriangle(String[] keywords) {
        //Check for proper input.
        if (keywords.length != 5) {
            System.out.println("Error: Improper number of arguments.");
            return;
        }

        int triangleX = Integer.parseInt(keywords[1]);
        int triangleY = Integer.parseInt(keywords[2]);
        int triangleHeight = Integer.parseInt(keywords[3]);

        Triangle triangle = new Triangle(triangleX, triangleY,
                triangleHeight, keywords[4]);

        drawing.addShape(triangle);
        drawing.draw(triangle);
    }

    /**
     * Assigns input parameters to local variables which are
     * past to the shape constructor.  The shape is then added
     * to the InteractiveDrawing objects Shape list and drawn.
     * @param keywords parsed user inputs.
     */
    public void handleCircle(String[] keywords) {
        if (keywords.length != 4) {
            System.out.println("Error: Improper number of arguments.");
            return;
        }

        int circleX = Integer.parseInt(keywords[1]);
        int circleY = Integer.parseInt(keywords[2]);
        int radius = Integer.parseInt(keywords[3]);

        Circle circle = new Circle(circleX, circleY, radius);

        drawing.addShape(circle);
        drawing.draw(circle);

    }

    /**
     * Assigns input parameters to local variables which are
     * past to the shape constructor.  The shape is then added
     * to the InteractiveDrawing objects Shape list and drawn.
     * @param keywords parsed user inputs.
     */
    public void handlePgram(String[] keywords) {
        if (keywords.length != 6) {
            System.out.println("Error: Improper number of arguments.");
            return;
        }

        int pgramX = Integer.parseInt(keywords[1]);
        int pgramY = Integer.parseInt(keywords[2]);
        int pLength = Integer.parseInt(keywords[3]);
        int pHeight = Integer.parseInt(keywords[4]);
        double theta = Double.parseDouble(keywords[5]);

        PGram pgram = new PGram(pgramX, pgramY, pLength, pHeight,
                theta);

        drawing.addShape(pgram);
        drawing.draw(pgram);

    }

    /**
     * Assigns input parameters to local variables which are
     * past to the shape constructor.  The shape is then added
     * to the InteractiveDrawing objects Shape list and drawn.
     * @param keywords parsed user inputs.
     */
    public void handleArrow(String[] keywords) {
        if (keywords.length != 5) {
            System.out.println("Error: Improper number of arguments.");
            return;
        }
        int arrowX = Integer.parseInt(keywords[1]);
        int arrowY = Integer.parseInt(keywords[2]);
        int arrowLength = Integer.parseInt(keywords[3]);
        String aOrientation = (keywords[4]);

        Arrow arrow = new Arrow(arrowX, arrowY, arrowLength,
                aOrientation);

        drawing.addShape(arrow);
        drawing.draw(arrow);

    }

    /**
     * Assigns input parameters to local variables which are
     * past to the shape constructor.  The shape is then added
     * to the InteractiveDrawing objects Shape list and drawn.
     * @param keywords parsed user inputs.
     */
    public void handleDiamond(String[] keywords) {
        if (keywords.length != 5) {
            System.out.println("Error: Improper number of arguments.");
            return;
        }
        int diamondX = Integer.parseInt(keywords[1]);
        int diamondY = Integer.parseInt(keywords[2]);
        int dWidth = Integer.parseInt(keywords[3]);
        int dHeight = Integer.parseInt(keywords[4]);

        Diamond diamond = new Diamond(diamondX, diamondY, dWidth,
                dHeight);

        drawing.addShape(diamond);
        drawing.draw(diamond);

    }

    /**
     * Prints out a list of valid commands and their effects.
     */
    public void help() {
        System.out.println("List of valid commands:\n");

        System.out.println("'line x1 y1 x2 y2' - Draws a line from point(x1, y1)"
                + " to point (x2, y2).\n");

        System.out.println("'dottedline x1 y1 x2 y2 rate' - Draws a dotted or"
                + " dashed line from point (x1, y1) to point (x2, y2) where"
                + " the dashes are of length rate in pixels.\n");
        
        System.out.println("'box x y length height' - Draws a rectangle with"
                + " its upper-left corner at\n" + "(x,y) and with the given"
                + " length and height.\n");

        System.out.println("'triangle x y height orientation' - Draws a triangle"
                + " in the direction of the provided orientation ('up','down',"
                + " 'left',right') with tip at point (x,y).\n");
        
        System.out.println("'circle x y radius' - Draws a circle centered"
                + " at point (x,y) with the provided radius.\n");
        
        System.out.println("'pgram x y length height theta' - Draws a"
                + " parallelogram with upper left corner at (x, y). Theta"
                + " is the angle of the upper left corner vertex.");
        
        System.out.println("'diamond x y width height' - Draws a diamond "
                + "with the top vertex at (x, y).");
        
        System.out.println("'arrow x y length orientation' - Draws an arrow "
                + "in the direction of orientation ('left', 'right', 'up',"
                + " 'down) starting at point (x, y).");

        System.out.println("'quit' - Terminate application.");
    }

}
