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
    ArrayList<Line> lines = new ArrayList<Line>();
    ArrayList<Box> boxes = new ArrayList<Box>();

    Scanner scanner = new Scanner(System.in);
    public SimpleDrawing drawing = new SimpleDrawing();

    /**
     * The main method simply calls the shell method which
     * then accepts and handles user inputs.
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
                    //Check for proper input
                    if(keywords.length != 5){
                        System.out.println("Error: Improper number of arguments.");
                        break;
                    }
                    
                    int x1 = Integer.parseInt(keywords[1]);
                    int y1 = Integer.parseInt(keywords[2]);
                    int x2 = Integer.parseInt(keywords[3]);
                    int y2 = Integer.parseInt(keywords[4]);

                    Line line = new Line(x1, y1, x2, y2, drawing);

                    lines.add(line);
                    break;

                case "box":
                    //Check for proper input.
                    if(keywords.length != 5){
                        System.out.println("Error: Improper number of arguments.");
                        break;
                    }
                    
                    int xcoord = Integer.parseInt(keywords[1]);
                    int ycoord = Integer.parseInt(keywords[2]);
                    int length = Integer.parseInt(keywords[3]);
                    int height = Integer.parseInt(keywords[4]);

                    Box box = new Box(xcoord, ycoord, length, height, drawing);

                    boxes.add(box);
                    break;
                
                case "delete":
                    //Check for proper input.
                    if(keywords.length != 6){
                        System.out.println("Error: Improper number of arguments.");
                        break;
                    }
                    
                    if(keywords[1].equals("box")){
                        int deleteXcoord = Integer.parseInt(keywords[2]);
                        int deleteYcoord = Integer.parseInt(keywords[3]);
                        int deleteLength = Integer.parseInt(keywords[4]);
                        int deleteHeight = Integer.parseInt(keywords[5]);
                        
                    deleteBox(deleteXcoord, deleteYcoord, deleteLength, deleteHeight);
                    break;
                    }
                    if(keywords[1].equals("line")){
                        int deleteX1 = Integer.parseInt(keywords[2]);
                        int deleteY1 = Integer.parseInt(keywords[3]);
                        int deleteX2 = Integer.parseInt(keywords[4]);
                        int deleteY2 = Integer.parseInt(keywords[5]);
                        
                    deleteLine(deleteX1, deleteY1, deleteX2, deleteY2);
                    break;
                    }
                default:
                    System.out.println("Unrecognized command, '" + input
                            + "', type 'help' for list of commands.");
                    break;
            }
        }
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

    /**
     * This method searches for Box objects with matching characteristics
     * in the boxes ArrayList, hides their points using their delete() method
     * and removes them from the ArrayList.
     * @param x the x coordinate of the upper left corner of the box to be
     * deleted.
     * @param y the y coordinate of the upper left corner of the box to be
     * deleted.
     * @param length the length of the box to be deleted.
     * @param height the height of the box to be deleted.
     */
    public void deleteBox(int x, int y, int length, int height) {
        for (int i = 0; i < boxes.size(); i++) {
            
            int boxX = boxes.get(i).getxCoord();
            int boxY = boxes.get(i).getyCoord();
            int boxLength = boxes.get(i).getLength();
            int boxHeight = boxes.get(i).getHeight();
            
            if(boxX == x && boxY == y && boxLength == length && boxHeight == height){
                boxes.get(i).delete();
                boxes.remove(i);
            }
        }
    }

    /**
     * This method searches for Line objects with matching characteristics
     * in the lines ArrayList, hides their points using their delete() method
     * and removes them from the ArrayList.
     * @param x1 the x1 coordinate of the line to be deleted.
     * @param y1 the y1 coordinate of the line to be deleted.
     * @param x2 the x2 coordinate of the line to be deleted.
     * @param y2 the y2 coordinate of the line to be deleted.
     */
    
    public void deleteLine(int x1, int y1, int x2, int y2) {
        for (int i = 0; i < lines.size(); i++) {
            
            int linex1 = lines.get(i).getX1();
            int liney1 = lines.get(i).getY1();
            int linex2 = lines.get(i).getX2();
            int liney2 = lines.get(i).getY2();
            
            if(linex1 == x1 && liney1 == y1 && linex2 == x2 && liney2 == y2){
                lines.get(i).delete();
                lines.remove(i);
            }
        }
    }
}
