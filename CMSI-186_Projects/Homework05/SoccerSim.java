/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Main Program for use with Ball.java, Clock.java, Pole.java, and Field.java
 *  @author       :  Amy Pellouchoud
 *  Date written  :  2017-03-21
 *  Description   :  Soccer simulation that calculates collisions between balls and a pole on a field
 *                   with dimensions 300x300.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-03-23  A. Pellouchoud  Initial Writing and Release
 *  @version 1.1.0  2017-03-28  A. Pellouchoud  Made field
 *  @version 1.2.0  2017-03-30  A. Pellouchoud  Made clock with optional timeSlice input
 *  @version 1.3.0  2017-03-31  A. Pellouchoud  Worked on it
 *  @version 1.4.0  2017-04-01  A. Pellouchoud  Worked on it
 *  @version 1.5.0  2017-04-02  A. Pellouchoud  Worked on it
 *  @version 1.6.0  2017-04-03  A. Pellouchoud  Fixed whole main project loop w/ prof and did lots of work
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;

public class SoccerSim {

   /**
    *  Class field definintions
    */
    private static double timeSlice;
    private static int ballCount;
    private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;

   /**
    *  Main program starts here
    */
   public static void main( String args[] ) {

      //Check validity of args
      if ( ( ( args.length % 4 ) != 0 ) && ( ( args.length % 4 ) != 1 ) )  {
         throw new ArrayIndexOutOfBoundsException( "Send 4 arguments for each ball, and include timeSlice (optional) at the end" );
      }

      //New Field initiated
      if ( ( args.length % 4 ) == 0 ) {
         ballCount = ( args.length / 4 );
      } else if ( ( args.length % 4 ) == 1 ) {
         ballCount = ( ( args.length - 1 ) / 4 );
      }

      Field f1 = new Field( ballCount, args );

      //Initializes clock with inputted timeSlice OR default timeSlice of 10 seconds
      if ( ( args.length % 4 ) == 1 ) {
         timeSlice = Double.parseDouble( args[ ( args.length - 1 ) ]);
      } else if ( ( args.length % 4 ) == 0 ) {
         timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
      }

      Clock c1 = new Clock( timeSlice );

      //New pole initialized at random location
      double randomVal1 = Math.random() * 300;
      double randomVal2 = Math.random() * 300;
      Pole p1 = new Pole( randomVal1, randomVal2 );

      //Print out program info for the user
      System.out.println( "\nWelcome to Soccer Sim!" );
      System.out.println( "--------------------------" );
      System.out.println( "Inputted Args: " + Arrays.toString(args) );
      System.out.println( f1.getFieldValues() );
      System.out.println( "Ballcount: " + ballCount );
      System.out.println( "Flag Pole Position [randomized]: " + p1.toString() );

      //Main loop
      while ( true ) {

         //Print all the balls toString
         System.out.println( "\nList of each ball's position and velocity at time " + c1.toString() + "--" );
         for ( int i = 0; i < ballCount; i++ ) {
            System.out.println( ( i + 1 ) + "-- " + f1.ballArray[i].toString());
         }

         //Check for collisions between balls
         for ( int i = 0; i < ballCount - 1 ; i++ ) {
            for ( int j = i + 1; j < ballCount; j++ ) {

               if ( f1.ballCollide( f1.ballArray[i], f1.ballArray[j] ) ) {
                  System.out.println( "\nBall collision: Ball " + ( i + 1 ) + " and Ball " + ( j + 1 ) );
                  System.out.println( "Time: " + c1.toString() );
                  System.exit(0);
               }
            }
         }

         //Check for collisions with Pole
         for ( int i = 0; i < ballCount; i++ ) {

            if ( f1.poleCollide( f1.ballArray[i], p1 ) ) {
               System.out.println( "Pole collision: Ball " + ( i + 1 ) );
               System.out.println( "Time: " + c1.toString() );
               System.exit(0);
            }
         }

         //If all balls out of Bounds, print out no collisions and end the program
         int outOfBoundsCount = 0;

         for ( int i = 0; i < ballCount; i++ ) {

            if ( f1.ballOutOfBounds( f1.ballArray[i] ) ) {
               outofBoundsCount += 1;
            }
         }

         if ( outOfBoundsCount == ballCount ) {
            System.out.println( "Balls out of bounds: No collisions" );
            System.exit(0);
         }

         //If all balls at rest, print out no collisions and end the programs
         int atRestCount = 0;

         for ( int i = 0; i < ballCount; i++ ) {

            if ( f1.ballAtRest( f1.ballArray[i] ) ) {
               atRestCount += 1;
            }
         }

         if ( atRestCount == ballCount ) {
            System.out.println( "Balls at rest: No collisions" );
            System.exit(0);
         }


         //If no collisions, tick the clock, move the balls, and try again
         c1.tick();

         for ( int i = 0; i < ballCount; i++ ) {
            f1.ballArray[i].moveBall();
         }

      }
   }
}
