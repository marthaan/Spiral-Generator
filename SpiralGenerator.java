// Name: Martha Ann Williams
// USC NetID: marthaan
// CS 455 PA1
// Fall 2023

import java.awt.geom.Line2D;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
   class SpiralGenerator
   
   Generates a "rectangular" spiral, using Java display coordinate system, moving 
   outward from the center of the spiral in a counter-clockwise direction.
   That is, it will head rightward on screen, then, upward, then left, then down, etc.
  
   Length of initial line is unitLength.
   Padding between "layers" of the spiral is also unitLength.
   
   NOTE: we have provided the public interface for this class.  Do not change
   the public interface.  You can add private instance variables, constants, 
   and private methods to the class.  You will also be completing the 
   implementation of the methods given. 
   
 */
public class SpiralGenerator {

   private Point2D start;
   private Point2D end;
   private int length = 0;
   private Line2D line;
   private String direction = "";
   private int l = 0;         // l determines when segment length changes

   /**
      Creates a SpiralGenerator starting at startPosition, with length of first segment and
      distance between "layers" both given as unitLength.  Both values are assuming the Java
      graphics coordinate system.
      @param startPosition starting point of the first segment in the spiral
      @param unitLength in pixels, must be > 0
   */
   public SpiralGenerator(Point startPosition, int unitLength) {
      if (unitLength > 0) {
         this.start = startPosition;
         this.end = startPosition;
         this.length = unitLength;
         this.line = new Line2D.Double(start, end);
         this.direction = "Right";
         l = 1;
      }
      else {
         System.out.println("ERROR: unit length must be > 0.");
      }
   }

   /**
      Return the coordinates of the next line segment in the spiral.
    */
   public Line2D nextSegment() {
      if (direction == "Right") {
         start = end;
         Point2D.Double newEnd = new Point2D.Double(start.getX() + l*length, start.getY());
         end = newEnd;
         line = new Line2D.Double(start, end);
         direction = "Up";
      }
      else if (direction == "Up") {
         start = end;
         Point2D.Double newEnd = new Point2D.Double(start.getX(), start.getY() - l*length);
         end = newEnd;
         line = new Line2D.Double(start, end);
         direction = "Left";
         l++;
      }
      else if (direction == "Left") {
         start = end;
         Point2D.Double newEnd = new Point2D.Double(start.getX() - l*length, start.getY());
         end = newEnd;
         line = new Line2D.Double(start,end);
         direction = "Down";
      }
      else if (direction == "Down") {
         start = end;
         Point2D.Double newEnd = new Point2D.Double(start.getX(), start.getY() + l*length);
         end = newEnd;
         line = new Line2D.Double(start, end);
         direction = "Right";
         l++;
      }
      else {
         System.out.println("ERROR: next segment is not horizontal or vertical");
      }
      return line;
   }
}
