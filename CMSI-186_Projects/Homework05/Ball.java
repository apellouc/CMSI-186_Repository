/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  A Ball class defining methods
 *  @author       :  Amy Pellouchoud
 *  Date written  :  2017-03-21
 *  Description   :
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-03-21  A. Pellouchoud  Initial writing and release
 *  @version 1.1.0  2017-03-23  A. Pellouchoud  Werked on it
 *  @version 1.1.0  2017-03-28  A. Pellouchoud  Fixed toString method and changed Ball constructor params
 *  @version 1.2.0  2017-03-30  A. Pellouchoud  Wrote some test methods
 *  @version 1.3.0  2017-03-31  A. Pellouchoud
 *  @version 1.4.0  2017-04-03  A. Pellouchoud  Cleaned up program, finished test methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.lang.Math;
import java.text.DecimalFormat;

public class Ball {

   /**
    *  Class field definintions
    */
    private double xpos;
    private double ypos;
    private double dx;
    private double dy;
    private static double INCHES_IN_A_FOOT = 12;
    private static double FRICTION_CUT = 0.99;

    /**
     *  Constructor
     */
     public Ball( double x, double y, double a, double b ) {

        xpos = x;
        ypos = y;
        dx = a;
        dy = b;

     }

    /**
     *  Method to get the ball's x position
     *  @return double-precision value of the ball's xpos
     */
     public double getBallXPOS() { return xpos; }

     /**
      *  Method to get the ball's y position
      *  @return double-precision value of the ball's ypos
      */
      public double getBallYPOS() { return ypos; }

     /**
      *  Method to get the ball's dx value
      *  @return double-precision value of the ball's dx value
      */
     public double getBallDX() { return dx; }

     /**
      *  Method to get the ball's dy value
      *  @return double-precision value of the ball's dy value
      */
     public double getBallDY() { return dy; }

     /**
     *  Method to set move the Ball
     *  @param v inputted velocity
     *  @return double-precision array of the ball's new position values
     *  @throws
     */
     public void moveBall() {

        xpos += dx;
        ypos += dy;

        dx *= FRICTION_CUT;
        dy *= FRICTION_CUT;

     }

     /**
      *  Method to print ball information to a string
      *  @return string containing ball's position and velocity
      */
     public String toString() {

        DecimalFormat df = new DecimalFormat( "#0.00" );

       // if dx is moving less than 1 in/sec then it is at rest
        if ( Math.abs( dx ) < ( 1 / INCHES_IN_A_FOOT ) ) {
           dx = 0;
        }

       // if dy is moving less than 1 in/sec then it is at rest
        if ( Math.abs( dy ) < ( 1 / INCHES_IN_A_FOOT ) ) {
           dy = 0;
        }

       return "position: (" + df.format(xpos) + ", " + df.format(ypos) + ")" + "          velocity: (" + df.format(dx) + ", " + df.format(dy) + ")";
     }

     //Main program for testing
     public static void main( String args[] ) {

       Ball b1 = new Ball( 1, 2, 3, 4 );
       System.out.println( b1.toString() );

       //Test getBallXPOS()
       System.out.println( "Testing getBallXPOS() :");
       System.out.println( "Expecting 1.0: " + b1.getBallXPOS() );

       //Test getBallYPOS
       System.out.println( "\nTesting getBallYPOS() :");
       System.out.println( "Expecting 2.0: " + b1.getBallYPOS() );

       //Test getBallDX
       System.out.println( "\nTesting getBallDX() :");
       System.out.println( "Expecting 3.0: " + b1.getBallDX() );

       //Test getBallDY
       System.out.println( "\nTesting getBallDY() :");
       System.out.println( "Expecting 4.0: " + b1.getBallDY() );

       //Test moveBall
       System.out.println( "\nMoving the ball using moveBall()");
       b1.moveBall();
       System.out.println( "New ball info: " + b1.toString() );

     }

}
