// Name: Martha Ann Williams
// USC NetID: marthaan
// CS 455 PA1
// Fall 2023

import java.util.Scanner;
import javax.swing.JFrame;

/**
 * class SpiralViewer
 *
 * Creates a frame and has a graphical display.
 *
 * Receives input, error-checks that the input is valid,
 * and adds it to SpiralComponent.
 */
public class SpiralViewer {

   public static int initialSegmentLength = 0;
   public static int numberOfSegments = 0;

   /**
    * main runs SpiralViewer
    * @param args
    */
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      System.out.print("Choose the initial segment length: ");
      initialSegmentLength = in.nextInt();

      while (initialSegmentLength <= 0) {
         System.out.println("ERROR: value must be > 0");
         System.out.print("Choose the initial segment length: ");
         initialSegmentLength = in.nextInt();
      }

      System.out.print("Choose the number of segments: ");
      numberOfSegments = in.nextInt();

      while (numberOfSegments <= 0) {
         System.out.println("ERROR: value must be > 0");
         System.out.print("Choose the number of segments: ");
         numberOfSegments = in.nextInt();
      }

      JFrame frame = new JFrame();

      frame.setSize(500, 800);
      frame.setTitle("Spiral Viewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      SpiralComponent component = new SpiralComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}