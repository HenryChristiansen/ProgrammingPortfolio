import java.util.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.Color.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Component extends JPanel implements MouseListener{
        boolean drawPoint = false;
        boolean drawLine = false;
        boolean drawTriangle = false;

    public Component(){
        super();
        pointX = 0;
        pointY = 0;
        lineX = 0;
        lineY = 0;
        thirdX = 0;
        thirdY = 0;
        addMouseListener(this);
    }

    int pointX, pointY, lineX,lineY, thirdX, thirdY;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Click at 3 different points to create a triangle.", 100,20);
        g.drawString("(Make sure mouse is not moving when you click)", 90,35);
        if (drawTriangle) {
          g.drawLine(pointX, pointY, lineX, lineY);
          g.drawLine(pointX, pointY, thirdX, thirdY);
          g.drawLine(lineX, lineY, thirdX, thirdY);
          drawPoint = false;
          drawLine = false;
          drawTriangle = false;
        }
        else if(drawLine){
            g.drawLine(pointX, pointY, lineX, lineY);
        }
        else if(drawPoint){
            g.setColor(Color.black);
            g.fillOval(pointX-5,pointY-5,10,10);
        }

    }

    public void mouseClicked(MouseEvent mouse){ }
    public void mouseEntered(MouseEvent mouse){ }
    public void mouseExited(MouseEvent mouse){ }
    public void mousePressed(MouseEvent mouse) {
      if(!drawPoint) {
        pointX = mouse.getX();
        pointY = mouse.getY();
        drawPoint = true;
      }
      else if (!drawLine) {
        lineX = mouse.getX();
        lineY = mouse.getY();
        drawLine = true;
      } else if (!drawTriangle) {
        thirdX = mouse.getX();
        thirdY = mouse.getY();
        drawTriangle = true;
      }
      repaint();
     }
    public void mouseReleased(MouseEvent mouse){  }
}
