import javax.swing.*;
import java.lang.Math.*;
import java.io.*;
import java.awt.*;
/*
 * Creates graph object that graphs projectile motion
 * @author Henry Christiansen
 */

class GraphPanel extends Panel {
    int range, iVelocity, angle, height, maxH;

    GraphPanel () {
      this.iVelocity = 0;
      this.angle = 0;
      this.height = 0;
      this.range = 0;
      this.maxH = 0;
      setBackground(black);
    }

    /*
    @param double  doubles of the six variables
    */

    public void update(double iV, double a, double h, double r, double mH) {
      iVelocity = (int) iV;
      angle = (int) a;
      height = (int) h;
      range = (int) r;
      maxH = (int) mH;
    }

    /*
    @param Graphics graphics components
    */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setColor(white);
      g2.setFont(smallFont);
      // Draw Axis Titles, because they will be flipped if drawn after plane translation
      g2.drawString("X-Displacement", 810, 235);
      g2.drawString("Y-Displacement", 20, 50);

      // Translate and flip plane to have origin at graph origin
      g2.translate(10.0, 249.0);
      g2.scale(1.0,-1.0);

      // Draw Axis arrows
      g2.drawLine(0,0,920,0);
      g2.drawLine(920,0,910,5);
      g2.drawLine(920,0,910,-5);
      g2.drawLine(0,0,0,230);
      g2.drawLine(0,230,-5,220);
      g2.drawLine(0,230,5,220);

      // Draw Graph
      g2.setColor(red);
      try {
        int[] graphFunction = new int [range];
        for (int i = 1; i < range; i++) {
          graphFunction[i] = (int) (height + (i*Math.tan(angle)) - (9.81*i*i/(2*iVelocity*iVelocity*Math.cos(angle)*Math.cos(angle))));
        }
        for (int i = 1; i < range; i++) {
          int y = (int) (graphFunction[i]);
          g2.drawOval(i,y,1,1);
        }
      } catch (NegativeArraySizeException exception) {
        System.out.println("Exception Thrown: " + exception);
      }
    }
}