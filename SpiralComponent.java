// Name: Martha Ann Williams
// USC NetID: marthaan
// CS 455 PA1
// Fall 2023

/*
Overrides paintComponent to draw the spiral, using a SpiralGenerator object to generate the spiral segments to draw.
 */

import javax.swing.JComponent;
import java.awt.*;

/**
 * class SpiralComponent comment
 *
 * This component draws a spiral.
 */
public class SpiralComponent extends JComponent {

   private int unitLength = 0;
   private int numSegments = 0;

   public SpiralComponent() {
      unitLength = SpiralViewer.initialSegmentLength;
      numSegments = SpiralViewer.numberOfSegments;
   }

   public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;

      Point start = new Point(getWidth() / 2, getHeight() / 2);
      SpiralGenerator spiral = new SpiralGenerator(start, unitLength);

      int i = 0;

      while (i < numSegments) {
         g2.draw(spiral.nextSegment());
         i++;
      }
   }
}