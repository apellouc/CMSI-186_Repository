/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Main Program for use with Ball.java
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
 *  @version 1.0.0  2017-03-23  A. Pellouchoud  Initial Writing and Release
 *  @version 1.1.0  2017-03-28  A. Pellouchoud  Made field
 *  @version 1.2.0  2017-03-30  A. Pellouchoud  Made clock with optional timeSlice input
 *  @version 1.3.0  2017-03-31  A. Pellouchoud  Worked on it
 *  @version 1.4.0  2017-04-01  A. Pellouchoud  Worked on it
 *  @version 1.5.0  2017-04-03  A. Pellouchoud  Worked on it
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;

public class SoccerSim {

   /**
    *  Class field definintions
    */
    private static double timeSlice;
    private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 10.0;

   /**
    *  Main program starts here
    */
   public static void main( String args[] ) {

      //Check validity of args
      if ( ( ( args.length % 4 ) != 0 ) && ( ( args.length % 4 ) != 1 ) )  {
         throw new ArrayIndexOutOfBoundsException( "Send 4 arguments for each ball, and include timeSlice (optional) at the end" );
      }


      //New Field initiated
      int ballCount = ( ( args.length - 1 ) / 4 );
      Field f1 = new Field( ballCount );

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

      //balls
      Ball b1 = f1.ballArray[0];
      Ball b2 = f1.ballArray[1];
      Ball b3 = f1.ballArray[2];
      Ball b4 = f1.ballArray[3];
      Ball b5 = f1.ballArray[4];
      Ball b6 = f1.ballArray[5];
      Ball b7 = f1.ballArray[6];
      Ball b8 = f1.ballArray[7];
      Ball b9 = f1.ballArray[8];
      Ball b10 = f1.ballArray[9];


      System.out.println( "\nWelcome to Soccer Sim!" );
      System.out.println( "--------------------------" );
      System.out.println( "Inputted Args: " + Arrays.toString(args) );
      System.out.println( "Flag Pole Position [randomized]: " + p1.toString() );




      while (true) {

         System.out.println( "Time: " + c1.toString() );

         //Print all the balls toString
         for ( int i = 0; i < ballCount; i++ ) {
            f1.ballArray[i].toString();
         }

         //Check for collisions between balls
         if ( f1.ballCollide( b1, b2 ) ) {
            System.out.println( "Collision at: " + c1.toString() );
            System.exit(0);
         } else if ( f1.ballCollide ( b2, b3 ) ) {
            System.out.println( "Collision at: " + c1.toString() );
            System.exit(0);
         } else if ( f1.ballCollide ( b1, b3 ) ) {
            System.out.println( "Collision at: " + c1.toString() );
            System.exit(0);
         } else continue;

         //Check for collisions with Pole

         //If all balls out of Bounds, print out no collisions and end the program

         //If no collisions, tick the clock, move the balls, and try again
         c1.tick();

         }

      }


   }

