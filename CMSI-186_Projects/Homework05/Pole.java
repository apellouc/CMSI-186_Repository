/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Pole.Java
 *  Purpose       :  A class defining the Pole class for use with SoccerSim.java
 *  @author       :  Amy Pellouchoud
 *  Date written  :  2017-03-23
 *  Description   :  Defines a pole with an x position and a y position
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-03-23  A. Pellouchoud  Initial writing and release
 *  @version 1.1.0  2017-03-28  A. Pellouchoud  Wrote constructor and get/set pole position methods
 *  @version 1.2.0  2017-03-30  A. Pellouchoud  Added a toString method, wrote tests
 *  @version 1.3.0  2017-04-03  A. Pellouchoud  Cleaned up program, finished test methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.text.DecimalFormat;

public class Pole {

   /**
    *  Class field definintions
    */
    private double xpos;
    private double ypos;

    /**
    *  Constructor
    */
    public Pole( double x, double y ) {

      xpos = x;
      ypos = y;
   }

   /**
   *  Method to get the pole's x position
   *  @return double-precision value of the pole's xpos
   */
   public double getPoleXPOS() { return xpos; }

   /**
   *  Method to get the pole's y position
   *  @return double-precision value of the pole's ypos
   */
   public double getPoleYPOS() { return ypos; }

   /**
    *  Method to print the pole's information to a string
    *  @return string containing pole's position (x, y)
    */
   public String toString() {

      DecimalFormat df = new DecimalFormat( "#0.00" );

     return "Position: (" + df.format(xpos) + ", " + df.format(ypos) + ")";
   }

   //Main program for testing
   public static void main( String args[] ) {

      Pole p1 = new Pole( 1, 2 );
      System.out.println( "Pole initialized, expecting (1, 2): " + p1.toString() );

      //Test getBallXPOS()
      System.out.println( "Testing getPoleXPOS() :");
      System.out.println( "Expecting 1.0: " + p1.getPoleXPOS() );

      //Test getBallYPOS
      System.out.println( "\nTesting getPoleYPOS() :");
      System.out.println( "Expecting 2.0: " + p1.getPoleYPOS() );
   }

}
