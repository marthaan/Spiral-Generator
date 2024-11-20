// Name: Martha Ann Williams
// USC NetID: marthaan
// CS 455 PA1
// Fall 2023

import java.awt.Point;
import java.awt.geom.Line2D;

/**
 * class SpiralGeneratorTester
 *
 * A console-based (no GUI), non-interactive, unit
 * test program for the SpiralGenerator class.
 *
 * This class tests the functionality of the SpiralGenerator class
 * (what has to be true for the spiral), which does not
 * include testing the drawing functionality of SpiralViewer.
 */
public class SpiralGeneratorTester {
   private static int startPositionX = 0;
   private static int startPositionY = 0;
   private static int unitLength = 0;
   private static int numSegments = 0;

   /**
    * Runs SpiralGenerator tests via test method, changing
    * various parameters for each spiral.
    * @param args
    */
   public static void main(String[] args) {
      System.out.println("----------SPIRAL 1----------");

      startPositionX = 200;
      startPositionY = 300;
      unitLength = 5;
      numSegments = 10;

      Point startPosition1 = new Point(startPositionX, startPositionY);

      SpiralGenerator spiral1 = new SpiralGenerator(startPosition1, unitLength);

      test(spiral1);


      System.out.println("----------SPIRAL 2----------");

      startPositionX = 500;
      startPositionY = 600;
      unitLength = 1;
      numSegments = 5;

      Point startPosition2 = new Point(startPositionX, startPositionY);

      SpiralGenerator spiral2 = new SpiralGenerator(startPosition2, unitLength);

      test(spiral2);


      System.out.println("----------SPIRAL 3----------");

      startPositionX = 0;
      startPositionY = 0;
      unitLength = 30;
      numSegments = 2;

      Point startPosition3 = new Point(startPositionX, startPositionY);

      SpiralGenerator spiral3 = new SpiralGenerator(startPosition3, unitLength);

      test(spiral3);
   }

   /**
    * method test
    *
    * Prints information about spiral being tested.
    *
    * For the given number of segments:
    * Tests if a segment is horizontal or vertical,
    * if the last two segments generated are connected,
    * and if the last two segments generated are perpendicular.
    * Prints out associated segment information for these tests.
    *
    * @param spiralTest the SpiralGenerator object being tested
   */
   public static void test(SpiralGenerator spiralTest) {
      System.out.println("Making a spiral starting from java.awt.Point[x = "
              + startPositionX + ", " + startPositionY + "]");
      System.out.print("with a unit length of " + unitLength + ",");
      System.out.println(" and made up of " + numSegments + " segments:");

      int i = 1;
      Line2D line1 = spiralTest.nextSegment();
      Line2D line2;

      while (i < numSegments) {
         System.out.println("Segment #" + (i) + ": " + line1.getP1() + " " + line1.getP2());

         int x1 = (int) line1.getP1().getX();
         int y1 = (int) line1.getP1().getY();
         int x2 = (int) line1.getP2().getX();
         int y2 = (int) line1.getP2().getY();

         if (y2 - y1 == 0 || x2 - x1 == 0) {
            line2 = spiralTest.nextSegment();
            System.out.println("Segment #" + (i + 1) + ": " + line2.getP1() + " " + line2.getP2());

            System.out.println("PASSED: segment #" + (i) + " is horizontal or vertical");

            int x3 = (int) line2.getP1().getX();
            int y3 = (int) line2.getP1().getY();
            int x4 = (int) line2.getP2().getX();
            int y4 = (int) line2.getP2().getY();

            if (y4 - y3 == 0 || x4 - x3 == 0) {
               System.out.println("PASSED: segment #" + (i + 1) + " is horizontal or vertical");

               if (line1.getP2().equals(line2.getP1())) {
                  System.out.println("PASSED: last two segments are connected");
               }
               else {
                  System.out.println("FAILED: last two segments are not connected");
               }

               int dotProduct = (x2 - x1) * (x4 - x3) + (y2 - y1) * (y4 - y3);
               if (dotProduct == 0) {
                  System.out.println("PASSED: last two segments are perpendicular");
                  System.out.println();
               }
               else {
                  System.out.println("FAILED: last two segments are not perpendicular");
               }
               line1 = line2;
            }
            else {
               System.out.println("FAILED: segment is not horizontal or vertical. Skipping pair tests.");
            }
         }
         else {
            System.out.println("FAILED: segment is not horizontal or vertical. Skipping pair tests.");
         }
         i++;
      }
   }
}