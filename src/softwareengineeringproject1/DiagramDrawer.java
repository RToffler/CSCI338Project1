/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject1;

import java.util.Scanner;
import java.util.ArrayList;
import csci338.drawings.SimpleDrawing;

/**
 *
 * @author Richard Miller This program utilizes the provided point-drawing API
 * in an application that allows users to draw rectangles and lines, or the
 * basis of UML diagrams.
 */
public class DiagramDrawer {

    /*
        Data structures containing lines and boxes for future 
        implemented features, I.E transformation/deletion.
     */
    ArrayList<Shape> shapes = new ArrayList();

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
     * break statement for the valid inputs.
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
                    //Check for proper input.
                    if (keywords.length != 5) {
                        System.out.println("Error: Improper number of arguments.");
                        break;
                    }

                    int xcoord = Integer.parseInt(keywords[1]);
                    int ycoord = Integer.parseInt(keywords[2]);
                    int length = Integer.parseInt(keywords[3]);
                    int height = Integer.parseInt(keywords[4]);

                    Box box = new Box(xcoord, ycoord, length, height);

                    drawing.draw(box);
                    shapes.add(box);
                    break;

                case "triangle":
                    //Check for proper input.
                    if (keywords.length != 5) {
                        System.out.println("Error: Improper number of arguments.");
                        break;
                    }

                    int triangleX = Integer.parseInt(keywords[1]);
                    int triangleY = Integer.parseInt(keywords[2]);
                    int triangleHeight = Integer.parseInt(keywords[3]);

                    Triangle triangle = new Triangle(triangleX, triangleY,
                            triangleHeight, keywords[4]);

                    drawing.draw(triangle);
                    shapes.add(triangle);
                    break;

                case "circle":

                    if (keywords.length != 4) {
                        System.out.println("Error: Improper number of arguments.");
                        break;
                    }

                    int circleX = Integer.parseInt(keywords[1]);
                    int circleY = Integer.parseInt(keywords[2]);
                    int radius = Integer.parseInt(keywords[3]);

                    Circle circle = new Circle(circleX, circleY, radius);

                    drawing.draw(circle);
                    shapes.add(circle);
                    break;

                case "pgram":

                    if (keywords.length != 6) {
                        System.out.println("Error: Improper number of arguments.");
                        break;
                    }

                    int pgramX = Integer.parseInt(keywords[1]);
                    int pgramY = Integer.parseInt(keywords[2]);
                    int pLength = Integer.parseInt(keywords[3]);
                    int pHeight = Integer.parseInt(keywords[4]);
                    double theta = Double.parseDouble(keywords[5]);

                    PGram pgram = new PGram(pgramX, pgramY, pLength, pHeight,
                            theta);

                    drawing.draw(pgram);
                    shapes.add(pgram);
                    break;

                case "diamond":
                    if (keywords.length != 5) {
                        System.out.println("Error: Improper number of arguments.");
                        break;
                    }
                    int diamondX = Integer.parseInt(keywords[1]);
                    int diamondY = Integer.parseInt(keywords[2]);
                    int dWidth = Integer.parseInt(keywords[3]);
                    int dHeight = Integer.parseInt(keywords[4]);

                    Diamond diamond = new Diamond(diamondX, diamondY, dWidth,
                            dHeight);

                    drawing.draw(diamond);
                    shapes.add(diamond);
                    break;

                case "arrow":
                    if (keywords.length != 5) {
                        System.out.println("Error: Improper number of arguments.");
                        break;
                    }
                    int arrowX = Integer.parseInt(keywords[1]);
                    int arrowY = Integer.parseInt(keywords[2]);
                    int arrowLength = Integer.parseInt(keywords[3]);
                    String aOrientation = (keywords[4]);

                    Arrow arrow = new Arrow(arrowX, arrowY, arrowLength,
                            aOrientation);

                    drawing.draw(arrow);
                    shapes.add(arrow);
                    break;

                case "delete":
                    //Implement
                    break;
                default:
                    System.out.println("Unrecognized command, '" + input
                            + "', type 'help' for list of commands.");
                    break;
            }
        }
    }

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
        drawing.draw(line);
        shapes.add(line);
    }

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

        drawing.draw(dottedLine);
        shapes.add(dottedLine);

    }

    public void handleTriangle(String[] keywords) {

    }

    public void handleCircle(String[] keywords) {

    }

    public void handleArrow(String[] keywords) {

    }

    public void handleDiamond(String[] keywords) {

    }

    /**
     * this method will print out a list of valid commands and their effects.
     */
    public void help() {
        System.out.println("List of valid commands:\n");

        System.out.println("'line x1 y1 x2 y2' - Draws a line from point(x1, y1)"
                + " to point (x2, y2).\n");

        System.out.println("'box x y length height' - Draws a rectangle with"
                + " its upper-left corner at\n" + "(x,y) and with the given"
                + " length and height.\n");

        System.out.println("'delete box x y length height' - Deletes any rectangle"
                + " that exists with the provided charcteristics.\n");

        System.out.println("'delete line x1 y1 x2 y2' - Deletes any line"
                + " that exists with the provided charcteristics.\n");

        System.out.println("'quit' - Terminate application.");
    }

}
