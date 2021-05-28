import javax.swing.*;
import java.awt.event.*;

/*
 * Creates projectile screen object
 * @author Henry Christiansen
 */

public class ProjectilePanel extends Panel {
  GraphPanel graph = new GraphPanel();
  Calculator calc = new Calculator();
  JButton calculate, calculateParameters;
  JTextField time, iVelocity, angle, h, totalTime, range, maxH;
  // Used JLabels for text because the text quality is much better than Graphics2D strings
  JLabel mainTitle;
  JLabel em1,em2,paramTimeText, parametersTitle ,graphTitle, results, errorMessage, inputMess, iVMess, aMess, hMess, tTMess, rMess,mHMess, iVRes, aRes, hRes, tRes, rRes, hmRes, paramV, paramH, paramVX, paramVY, paramR;

  // Constructor for the projectile screen
  ProjectilePanel () {
    setLayout(null);
    setBackground(black);
    components();
    drawScreenText();
  }
  /*
  @param none
  @return none
  */
  private void drawScreenText() {
    // Section Titles
    mainTitle = new JLabel("Projectile Motion Calculator");
    mainTitle.setForeground(white);
    mainTitle.setBounds(185,8,700,55);
    mainTitle.setFont(bigFont);
    graphTitle = new JLabel("Graph of Motion: ");
    graphTitle.setForeground(white);
    graphTitle.setFont(titleFont);
    graphTitle.setBounds(10, 370, 200, 30);
    results = new JLabel("Results: ");
    results.setForeground(white);
    results.setFont(titleFont);
    results.setBounds(390,65,130,30);
    parametersTitle = new JLabel ("Parameters at given time: ");
    parametersTitle.setBounds(690,65, 300, 30);
    parametersTitle.setFont(titleFont);
    parametersTitle.setForeground(white);
    paramTimeText = new JLabel ("Time (s): ");
    paramTimeText.setBounds(710,110,80,30);
    paramTimeText.setFont(normalFont);
    paramTimeText.setForeground(white);

    // Result Section Text
    iVRes = new JLabel();
    iVRes.setVisible(false);
    iVRes.setForeground(white);
    iVRes.setFont(normalFont);
    iVRes.setBounds(410, 100, 300,25);
    aRes = new JLabel();
    aRes.setVisible(false);
    aRes.setForeground(white);
    aRes.setFont(normalFont);
    aRes.setBounds(410, 135, 300,25);
    hRes = new JLabel();
    hRes.setVisible(false);
    hRes.setForeground(white);
    hRes.setFont(normalFont);
    hRes.setBounds(410, 170, 300,25);
    tRes = new JLabel();
    tRes.setVisible(false);
    tRes.setForeground(white);
    tRes.setFont(normalFont);
    tRes.setBounds(410, 205, 300,25);
    rRes = new JLabel();
    rRes.setVisible(false);
    rRes.setForeground(white);
    rRes.setFont(normalFont);
    rRes.setBounds(410, 240, 300,25);
    hmRes = new JLabel();
    hmRes.setVisible(false);
    hmRes.setForeground(white);
    hmRes.setFont(normalFont);
    hmRes.setBounds(410, 275, 300,25);

    // Input section text
    inputMess = new JLabel("Input the information you know:");
    inputMess.setBounds(10,65,320,30);
    inputMess.setFont(titleFont);
    inputMess.setForeground(white);
    iVMess = new JLabel("Initial Velocity (m/s): ");
    iVMess.setForeground(white);
    iVMess.setBounds(30, 100, 230,25);
    iVMess.setFont(normalFont);
    aMess = new JLabel("Angle of Launch (degrees):");
    aMess.setForeground(white);
    aMess.setBounds(30,135, 230,25);
    aMess.setFont(normalFont);
    hMess = new JLabel("Height of launch (m):");
    hMess.setForeground(white);
    hMess.setBounds(30,170, 230,25);
    hMess.setFont(normalFont);
    tTMess = new JLabel("Time in air (s):");
    tTMess.setForeground(white);
    tTMess.setBounds(30,205, 230,25);
    tTMess.setFont(normalFont);
    rMess = new JLabel("Range of Projectile (m):");
    rMess.setForeground(white);
    rMess.setBounds(30,240, 230,25);
    rMess.setFont(normalFont);
    mHMess = new JLabel("Maximun Height Reached (m):");
    mHMess.setForeground(white);
    mHMess.setBounds(30,275, 230,25);
    mHMess.setFont(normalFont);

    // Parameters Section Text
    paramV = new JLabel();
    paramV.setFont(normalFont);
    paramV.setForeground(white);
    paramV.setBounds(740,155, 200,30);
    paramV.setVisible(false);
    paramVX = new JLabel();
    paramVX.setFont(normalFont);
    paramVX.setForeground(white);
    paramVX.setBounds(740,180, 200,30);
    paramVX.setVisible(false);
    paramVY = new JLabel();
    paramVY.setFont(normalFont);
    paramVY.setForeground(white);
    paramVY.setBounds(740,205, 200,30);
    paramVY.setVisible(false);
    paramH = new JLabel();
    paramH.setFont(normalFont);
    paramH.setForeground(white);
    paramH.setBounds(740,230, 200,30);
    paramH.setVisible(false);
    paramR = new JLabel();
    paramR.setFont(normalFont);
    paramR.setForeground(white);
    paramR.setBounds(740,255, 200,30);
    paramR.setVisible(false);
    errorMessage = new JLabel("Error");
    errorMessage.setVisible(false);
    errorMessage.setBounds(475, 68, 300, 25);
    errorMessage.setForeground(red);
    errorMessage.setFont(titleFont);
    em1 = new JLabel("Error, input initial values");
    em1.setForeground(red);
    em1.setBounds(740,155, 200,30);
    em1.setVisible(false);
    em1.setFont(normalFont);
    em2 = new JLabel("Error, invalid time");
    em2.setForeground(red);
    em2.setVisible(false);
    em2.setFont(normalFont);
    em2.setBounds(740,155, 200,30);
    add(mainTitle); add(errorMessage); add(inputMess); add(iVMess); add(aMess); add(hMess); add(tTMess); add(rMess); add(mHMess); add(results);
    add(em1); add(em2); add(paramV); add(paramVX); add(paramVY); add(paramH); add(paramR); add(paramTimeText); add(parametersTitle); add(iVRes); add(aRes); add(hRes); add(tRes); add(rRes); add(hmRes); add(graphTitle);
  }

  /*
  @param none
  @return none
  */
  private void components() {
    // Add graphing JPanel
    graph.setBounds(0, 402 ,965, 255);
    add(graph);
    // JTextFields
    iVelocity = new JTextField("");
    angle = new JTextField("");
    h = new JTextField("");
    totalTime = new JTextField("");
    range = new JTextField("");
    maxH = new JTextField("");
    time = new JTextField("");
    time.setBounds(785, 114, 50,25);
    time.setFont(normalFont);
    iVelocity.setBounds(280,100, 50, 25);
    angle.setBounds(280,135, 50, 25);
    h.setBounds(280,170, 50, 25);
    totalTime.setBounds(280,205, 50, 25);
    range.setBounds(280,240, 50, 25);
    maxH.setBounds(280,275, 50, 25);
    iVelocity.setFont(normalFont);
    angle.setFont(normalFont);
    h.setFont(normalFont);
    totalTime.setFont(normalFont);
    range.setFont(normalFont);
    maxH.setFont(normalFont);
    add(time); add(iVelocity); add(angle); add(h); add(totalTime); add(range); add(maxH);

    // Buttons
    calculate = new JButton("Calculate");
    calculate.setFont(buttonFont);
    calculate.setBounds(260, 320, 90, 37);
    calculate.addActionListener(new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        calc.calculate(iVelocity.getText(), angle.getText(), h.getText(), totalTime.getText(), range.getText(), maxH.getText());
        errorMessage.setVisible(calc.getErrorMessage());
        if (calc.getErrorMessage()) {
          iVRes.setVisible(false);
          aRes.setVisible(false);
          hRes.setVisible(false);
          tRes.setVisible(false);
          rRes.setVisible(false);
          hmRes.setVisible(false);
          paramV.setVisible(false);
          paramVX.setVisible(false);
          paramVY.setVisible(false);
          paramH.setVisible(false);
          paramR.setVisible(false);
          time.setText("");
        } else {
          iVRes.setText("Initial Velocity = " + calc.getString(calc.iVelocity) + " m/s");
          iVRes.setVisible(true);
          aRes.setText("Angle of Launch = " + calc.getString(calc.angleInDegrees) + " degrees");
          aRes.setVisible(true);
          hRes.setText("Height of Launch = " + calc.getString(calc.height) + "m");
          hRes.setVisible(true);
          tRes.setText("Time of flight = " + calc.getString(calc.totalTime) + "s");
          tRes.setVisible(true);
          rRes.setText("Range of Projectile = " + calc.getString(calc.range) + "m");
          rRes.setVisible(true);
          hmRes.setText("Maximum Height Reached = " + calc.getString(calc.maxH) + "m");
          hmRes.setVisible(true);
          graph.update(calc.iVelocity, calc.angle, calc.height, calc.range, calc.maxH);
          graph.repaint();
          paramV.setVisible(false);
          paramVX.setVisible(false);
          paramVY.setVisible(false);
          paramH.setVisible(false);
          paramR.setVisible(false);
          time.setText("");
        }
      }
    });
    calculateParameters = new JButton("Calculate");
    calculateParameters.setFont(buttonFont);
    calculateParameters.setBounds(855,108,90,37);
    calculateParameters.addActionListener(new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        calc.calcParametersAtTime(time.getText());
        if (calc.time > 0 && calc.time < calc.totalTime) {
          paramV.setText("Velocity = " + calc.getString(calc.velocity) + " m/s");
          paramV.setVisible(true);
          paramVX.setText("X-Velocity = " + calc.getString(calc.pVX)+ " m/s");
          paramVX.setVisible(true);
          paramVY.setText("Y-Velocity = " + calc.getString(calc.pVY)+ " m/s");
          paramVY.setVisible(true);
          paramH.setText("Height = " + calc.getString(calc.height) + "m");
          paramH.setVisible(true);
          paramR.setText("Distance = " + calc.getString(calc.distFromLaunch) + "m");
          paramR.setVisible(true);
          em1.setVisible(false);
          em2.setVisible(false);
        } else if (calc.getErrorMessage()) {
          paramV.setVisible(false);
          paramVX.setVisible(false);
          paramVY.setVisible(false);
          paramH.setVisible(false);
          paramR.setVisible(false);
          em1.setVisible(true);
          em2.setVisible(false);
        } else {
          paramV.setVisible(false);
          paramVX.setVisible(false);
          paramVY.setVisible(false);
          paramH.setVisible(false);
          paramR.setVisible(false);
          em2.setVisible(true);
          em1.setVisible(false);
        }
      }
    });
    add(calculateParameters); add(calculate);
  }
}