import java.lang.Math.*;
import java.text.DecimalFormat;
import java.io.*;

/*
 * Contains all math logic and creates calculator object
 * @author Henry Christiansen
 */

public class Calculator {
  final double g = 9.81;
  public double vx,vy;
  public double height;
  public double angle, angleInDegrees;
  public double maxH;
  public double totalTime;
  public double range;
  public double iVelocity;

  public double velocity, time, paramHeight, pVX, pVY, distFromLaunch;

  public boolean errorMessage = false;

  /*
  @param string  six strings representing the six main varibles in projectile motion
  */
  public void calculate (String iV, String a, String h, String t, String r, String mH) {
    errorMessage = false;
    /*
    Try-catch block catches the exception in the case that the strings are not numbers
    The ternary statments assign the varibales a value even if the string is empty
    */
    try {
      iVelocity =  (iV.equals("")) ?  0 : Double.parseDouble(iV);
      angleInDegrees = (a.equals("")) ? 0 : Double.parseDouble(a);
      angle = (a.equals("")) ? 0 : Math.toRadians(angleInDegrees);
      height = (h.equals("")) ? 0 : Double.parseDouble(h);
      totalTime = (t.equals("")) ? 0 : Double.parseDouble(t);
      range = (r.equals("")) ? 0 : Double.parseDouble(r);
      maxH = (mH.equals("")) ? 0 : Double.parseDouble(mH);
    } catch (NumberFormatException exception) {
      System.out.println("Exception Thrown: " + exception);
      errorMessage = true;
    }

    /*
    Complex if-else block that figures out which combo of
    varibles the user knows,and cacluates the rest accordingly
    */
    if (!iV.equals("") && !a.equals("") && !h.equals("") && t.equals("") && r.equals("") && mH.equals("")) {
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      if (height == 0) {
        totalTime = (2*vy)/g;
        range = (Math.pow(iVelocity,2)*Math.sin(2*angle))/g;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        totalTime = (vy + Math.sqrt(Math.pow(vy,2)+2*g*height))/g;
        range = vx*totalTime;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + height;
      }
    } else if (!iV.equals("") && !a.equals("") && !t.equals("") && h.equals("") && r.equals("") && mH.equals("")) {
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      height = (Math.pow((totalTime*g)-vy,2)-Math.pow(vy,2))/(2*g);
      if (height >= -0.1 && height <= 0.1) {
        height = 0;
        range = (Math.pow(iVelocity,2)*Math.sin(2*angle))/g;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        range = vx*totalTime;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + height;
      }
    } else if (!iV.equals("") && !a.equals("") && !r.equals("") && h.equals("") && t.equals("") && mH.equals("")) {
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      height = (Math.pow(((range*g)/vx)-vy,2)-Math.pow(vy,2))/(2*g);
      if (height >= -0.1 && height <= 0.1) {
        height = 0;
        totalTime = range/vx;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        totalTime = range/vx;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + height;
      }
    } else if (!iV.equals("") && !a.equals("") && !mH.equals("") && h.equals("") && t.equals("") && r.equals("")) {
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      height = maxH - ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g));
      if (height >= -0.1 && height <= 0.1) {
        height = 0;
        totalTime = (2*vy)/g;
        range = totalTime*vx;
      } else {
        totalTime = (vy + Math.sqrt(Math.pow(vy,2)+2*g*height))/g;
        range = totalTime*vx;
      }
    } else if (!iV.equals("") && !t.equals("") && !r.equals("") && a.equals("") && h.equals("") && mH.equals("")) {
      angle = Math.acos((range/totalTime)/iVelocity);
      angleInDegrees = Math.toDegrees(angle);
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      height = (Math.pow(((range*g)/vx)-vy,2)-Math.pow(vy,2))/(2*g);
      if (height >= -0.1 && height <= 0.1) {
        height = 0;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + height;
      }
    } else if (!iV.equals("") && !h.equals("") && !t.equals("") && a.equals("") && r.equals("") && mH.equals("")) {
      if (height == 0) {
        angle = Math.asin((totalTime*g)/(2*iVelocity));
        angleInDegrees = Math.toDegrees(angle);
        vy = iVelocity * Math.sin(angle);
        vx = iVelocity * Math.cos(angle);
        range = totalTime*vx;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g));
      } else {
        errorMessage = true;
      }
    } else if (!a.equals("") && !h.equals("") && !t.equals("") && iV.equals("") && r.equals("") && mH.equals("")) {
      if (height == 0) {
        iVelocity = (totalTime*g)/(2*Math.sin(angle));
        vy = iVelocity * Math.sin(angle);
        vx = iVelocity * Math.cos(angle);
        range = totalTime*vx;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g));
      } else {
        errorMessage = true;
      }
    } else if (!a.equals("") && !t.equals("") && !r.equals("") && iV.equals("") && h.equals("") && mH.equals("")) {
      iVelocity = range/(Math.cos(angle)*totalTime);
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      height = (Math.pow(((range*g)/vx)-vy,2)-Math.pow(vy,2))/(2*g);
      if (height >= -0.1 && height <= 0.1) {
        height = 0;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + height;
      }
    } else {
      errorMessage = true;
    }
  }

  /*
  * @param  double  the double to be converted to a string
  * @return string  a string of the double
  */
  public String getString(double a) {
    DecimalFormat df = new DecimalFormat("#.##");
    Double d = a;
    String b = df.format(d);
    return b;
  }

  /*
  * @param  string  string of the time at which to calculate the other variables
  */

  public void calcParametersAtTime (String t) {
    time = Double.parseDouble(t);
    pVX = vx;
    pVY = vy - g*time;
    velocity = Math.sqrt(Math.pow(pVX,2) + Math.pow(pVY,2));
    paramHeight = (vy*time)-(0.5*g*Math.pow(time,2));
    distFromLaunch = vx*time;
  }

  /*
  * @return boolean  the boolean representing if there is an error
  */

  public boolean getErrorMessage() {
    return errorMessage;
  }
}