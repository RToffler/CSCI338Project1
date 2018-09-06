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
 * @author Richard Miller
 * This program utilizes the provided point-drawing API
 * in an application that allows users to draw rectangles
 * and lines, or the basis of UML diagrams.
 */
public class DiagramDrawer {

    Scanner scanner = new Scanner(System.in);
    public SimpleDrawing drawing = new SimpleDrawing();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DiagramDrawer dg = new DiagramDrawer();
        
        System.out.println("Please enter command, or type help.");
        dg.shell();
    }

    /**
     * This method is the shell that accepts and
     * responds to user input using a break statement
     * for the valid inputs.
     */
    public void shell() {
        
        /*
        Data structures containing lines and boxes for future 
        implemented features, I.E transformation/deletion.
        */
        ArrayList<Line> lines = new ArrayList<Line>();
        ArrayList<Box> boxes = new ArrayList<Box>();
        
        while (true) {
                       
            
            System.out.print(">");
            String input = scanner.nextLine();
            String [] keywords = input.split(" ");
            
            switch(keywords[0]){
                
                case "help": 
                    help();
                    break;
                    
                case "quit":
                    return;               
                
                case "line":
                    
                    int x1 = Integer.parseInt(keywords[1]);
                    int y1 = Integer.parseInt(keywords[2]);
                    int x2 = Integer.parseInt(keywords[3]);
                    int y2 = Integer.parseInt(keywords[4]);
                    
                    Line line = new Line(x1, y1, x2, y2, drawing);
                    
                    lines.add(line);
                    break;
                    
                case "box":
                    
                    int xcoord = Integer.parseInt(keywords[1]);
                    int ycoord = Integer.parseInt(keywords[2]);
                    int length = Integer.parseInt(keywords[3]);
                    int height = Integer.parseInt(keywords[4]);
                    
                    Box box = new Box(xcoord, ycoord, length, height, drawing);
                    
                    boxes.add(box);
                    break;
                    
                default: 
                    System.out.println("Unrecognized command, '" + input
                            + "', type 'help' for list of commands.");
                    break;
            }
        }
    }

    /**
     * this method will print out a list of valid commands
     * and their effects.
     */
    public void help() {
        System.out.println("List of valid commands:\n");
        
        System.out.println("'line x1 y1 x2 y2' - Draws a line from point(x1, y1)"
                + " to point (x2, y2).\n");
        
        System.out.println("'box x y length height' - Draws a rectangle with"
                + " its upper-left corner at\n" + "(x,y) and with the given"
                + " length and height.\n");
        
        System.out.println("'quit' - Terminate application.");
    }
}
