/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Field.Java
 *  Purpose       :  A class defining the field class for use with SoccerSim.java
 *  @author       :  Amy Pellouchoud
 *  Date written  :  2017-03-23
 *  Description   :  Defines a field 300 x 300 ft, places an inputted numer of balls on the field and
 *                   assigns them values based on inputted args from SoccerSim.java. Contains methods
 *                   to check distance between two balls, a ball and a pole, and collisions between any
 *                   objects on the field.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-03-23  A. Pellouchoud  Initial writing and release
 *  @version 1.1.0  2017-03-28  A. Pellouchoud  Wrote Field constructor and organized plan
 *  @version 1.2.0  2017-03-30  A. Pellouchoud  Created ballCollide() and ballDistance()
 *  @version 1.3.0  2017-03-31  A. Pellouchoud  Werked on it
 *  @version 1.4.0  2017-04-01  A. Pellouchoud  Fixed distance methods, attempted to make loop work
 *  @version 1.5.0  2017-04-02  A. Pellouchoud  Further attempts to fix the loop with help from prof.
 *  @version 1.6.0  2017-04-03  A. Pellouchoud  Fixed Field Constructor and cleaned up program
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Field {

   /**
    *  Class field definintions
    */
    private static final double FIELD_LENGTH = 300;
    private static final double FIELD_WIDTH = 300;
    private static double INCHES_IN_A_FOOT = 12;
    public Ball[] ballArray;

    /**
     * constructor
     */
    public Field( int ballCount, String[] args ) {

      this.ballArray = new Ball[ballCount];
      double xPos = 0.0;
      double yPos = 0.0;
      double dX   = 0.0;
      double dY   = 0.0;

      for ( int i = 0, j = 0; j < ballArray.length; i += 4, j++ ) {

         xPos = Double.parseDouble( args[i] );
         yPos = Double.parseDouble( args[i + 1] );
         dX   = Double.parseDouble( args[i + 2] );
         dY   = Double.parseDouble( args[i + 3] );

         ballArray[j] = new Ball( xPos, yPos, dX, dY );
      }

   }

    /**
     *  Method to calculate and return the length & width of the field
     *  @param
     *  @return double-precision array of the field's dimensions
     *  @throws
     */
    public String getFieldValues() {

      return "The field is " + FIELD_LENGTH + " by " + FIELD_WIDTH ;
    }

    /**
     *  Method to check if a ball is at rest
     *  @param b1 Ball
     *  @return boolean value true if at rest, false if still moving
     */
    public boolean ballAtRest( Ball b1 ) {

      if ( ( b1.getBallDX() == 0 ) && ( b1.getBallDY() == 0 ) ) {
          return true;
      } else return false;
    }

    /**
     *  Method to check if a ball is out of bounds in the field
     *  @param b1 Ball
     *  @return boolean value true if out of the field, false if still in field
     */
    public boolean ballOutOfBounds( Ball b1 ) {

      if ( ( b1.getBallXPOS() > ( FIELD_WIDTH / 2 ) ) ||
           ( b1.getBallXPOS() < ( -150 ) ) ) {
         return true;
      } else if ( ( b1.getBallYPOS() > ( FIELD_LENGTH / 2 ) ) ||
                  ( b1.getBallYPOS() < ( -150 ) ) ) {
         return true;
      } else return false;

    }

    /**
     *  Method to calculate distance between two balls
     *  @param b1 First ball
     *  @param b2 Second ball
     *  @return double-precision value of distance between two balls
     */
    public double ballDistance( Ball b1, Ball b2 ) {

      double yDistance = b2.getBallYPOS() - b1.getBallYPOS();
      double xDistance = b2.getBallXPOS() - b1.getBallXPOS();

      //distance formula
      double retVal = Math.sqrt( Math.pow( yDistance , 2 ) + Math.pow( xDistance , 2 ) ) ;

      return retVal;
    }

    /**
     *  Method to check if two balls collide
     *  @param b1 First ball
     *  @param b2 Second ball
     *  @return boolean value true if collision, false if no collision
     */
    public boolean ballCollide( Ball b1, Ball b2 ) {

      if ( ballDistance( b1, b2 ) <= ( 8.9 / INCHES_IN_A_FOOT ) ) {
          return true;
      } else return false;

    }

    /**
     *  Method to calculate distance between the pole and an inputted ball
     *  @param b1 First ball
     *  @param b2 Second ball
     *  @return double-precision value of distance between two balls
     */
    public double poleDistance( Ball b1, Pole p1 ) {

      double yDistance = p1.getPoleYPOS() - b1.getBallYPOS();
      double xDistance = p1.getPoleXPOS() - b1.getBallXPOS();

      //distance formula
      double retVal = Math.sqrt( Math.pow( yDistance , 2 ) + Math.pow( xDistance , 2 ) ) ;

      return retVal;
    }

    /**
     *  Method to check if a ball and the pole collide
     *  @param b1 Ball
     *  @param p1 Pole
     *  @return boolean value true if collision, false if no collision
     */
    public boolean poleCollide( Ball b1, Pole p1) {

      if ( poleDistance( b1, p1 ) <= ( 4.45 / INCHES_IN_A_FOOT ) ) {
          return true;
      } else return false;

    }

}

