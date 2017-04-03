/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Field.Java
 *  Purpose       :  A class defining the field class for use with SoccerSim.java
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
 *  @version 1.1.0  2017-03-28  A. Pellouchoud  Wrote Field constructor and organized plan
 *  @version 1.2.0  2017-03-30  A. Pellouchoud  Created ballCollide() and ballDistance()
 *  @version 1.3.0  2017-03-31  A. Pellouchoud  Werked on it
 *  @version 1.4.0  2017-04-01  A. Pellouchoud  Fixed distance methods, attempted to make
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Field {

   /**
    *  Class field definintions
    */
    private static final double FIELD_LENGTH = 300;
    private static final double FIELD_WIDTH = 300;
    private Ball[] ballArray;

    /**
     * constructor //ballcount determined by args.length math! Set args array values into each new ball.
     */
    public Field( int ballCount ) {

      ballArray = new Ball[ballCount];

      for ( int i = 0; i < ballCount; i++ ) {
         ballArray[i] = new Ball( 0, 0, 0, 0 );
      }

   }

//Make a method to get each ball values FROM this array!

    /**
     *  Method to return a specific ball from the ball array
     *  @param i Specifies which ball in the array to return
     *  @return
     *  @throws
     */
     public Ball retrieveBall( int i ) {

       return ballArray[ i - 1 ];
     }


     //new approach
     public Ball[] retrieveBallArray() {

      return ballArray;
     }


    /**
     *  Method to calculate and return the length & width of the field
     *  @param
     *  @return double-precision array of the field's dimensions
     *  @throws
     */
    public double[] getFieldValues() {

      double[] field = new double [2];
      field[0] = FIELD_LENGTH;
      field[1] = FIELD_WIDTH;

      return field;
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

      if ( ballDistance( b1, b2 ) <= 8.9 ) {
          return true;
      } else return false;

    }

    /**
    *  Method to calculate distance between two balls
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


}
