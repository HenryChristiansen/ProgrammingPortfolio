import javax.swing.*;
import java.awt.*;

/*
 * Main Class for the Projectile Motion Calculator.
 * @author Henry Christiansen
 * @version 0.1.1
 * @since 03-25-2020
 */

public class Project extends JFrame {
   ProjectilePanel projectilePanel = new ProjectilePanel();
   // Constructor
   Project() {
     add(projectilePanel);
   }
   /*
    Main method, creates the ProjectileMotionCalculator object
    @param args
    @return nothing
   */
   public static void main(String[] args) {
     Project project = new Project();
     project.setVisible(true);
     project.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     project.setResizable(false);
     project.setSize(1000,700);
   }
}