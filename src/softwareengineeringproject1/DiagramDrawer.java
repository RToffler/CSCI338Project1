/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject1;

import java.util.Scanner;
import java.util.ArrayList;
import csci338.drawings.Drawing;
import csci338.drawings.SimpleDrawing;

/**
 *
 * @author Richard Miller
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

    public void shell() {
        
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
                    
                default: 
                    System.out.println("Unrecognized command, '" + input
                            + "', type 'help' for list of commands.");
                    break;
            }
        }
    }

    public void help() {
        System.out.println("Not Yet Implemented");
    }
}
