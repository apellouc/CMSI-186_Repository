/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Pole.Java
 *  Purpose       :  A class defining the Pole class for use with SoccerSim.java
 *  @author       :  Amy Pellouchoud
 *  Date written  :  2017-03-23
 *  Description   :
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
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

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
   *  @throws
   */
   public double getPoleXPOS() { return xpos; }

   /**
   *  Method to get the pole's y position
   *  @return double-precision value of the pole's ypos
   *  @throws
   */
   public double getPoleYPOS() { return ypos; }

   /**
   *  Method to set the pole position
   *  @param x new xpos
   *  @param y new ypos
   *  @throws
   */
   public void setPolePosition( double x, double y ) {

      xpos = x;
      ypos = y;
   }

   /**
    *  Method to print the pole's information to a string
    *  @return string containing pole's position (x, y)
    */
   public String toString() {

     return "Position: (" + xpos + "," + ypos + ")";
   }


   public static void main( String args[] ) {

      Pole p1 = new Pole( 0, 0 );
      System.out.println( p1.toString() );

      System.out.println( "\n  Testing setPolePosition()....");
      p1.setPolePosition( 1, 2 );
      System.out.println( "Expecting new pole position (1, 2): " + p1.toString() );

   }

}
