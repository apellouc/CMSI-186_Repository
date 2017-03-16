/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  Main Program for use with Clock.java to
 *  @author       :  Amy Pellouchoud
 *  Date written  :  2017-03-02
 *  Description   :  Calculates all times at which an inputted angle between hour and minute hand
 *                   occurs in 24 hours of a clock's rotation. It ticks the clock by the inputted
 *                   timeSlice (in seconds) or uses default 60 second timeSlice.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:   Reason for change/modification
 *           -----  ----------  ------------   -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson   Initial writing and release
 *  @version 1.2.0  2017-03-14  A. Pellouchoud Wrote main program
 *  @version 1.3.0  2017-03-15  A. Pellouchoud Finished program
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

//for every minute, angle changes 5.5 degrees
//0.0083 degrees per second


import java.util.Arrays;

public class ClockSolver {

   /**
    *  Definitions
    */
    private static final double SECONDS_IN_DAY = 86400;
    private static final double SECONDS_IN_MINUTE = 60;
    private static final int MINUTES_IN_HOUR = 60;

   /**
    *  Main program starts here
    */
   public static void main( String args[] ) {

      System.out.println( "\nWelcome to Clock Solver!" );
      System.out.println( "--------------------------" );

      System.out.println( "Args: " + Arrays.toString(args) );

      /**
       *  Check validity of the args
       */
      if ( ( args.length > 2 ) || ( args.length < 1 ) ) {
         throw new ArrayIndexOutOfBoundsException( "You must send either 1 or 2 args." );
      }

      Clock.validateAngleArg( args[0] );

      if ( args.length == 2 ) {
         Clock.validateTimeSliceArg( args[1] );
      }

      /**
       * Convert args[0], the angle, to a double and prints out the input.
       */
      double angle = Double.parseDouble( args[0] );
      System.out.println( "Your inputted Angle: " + angle );

      /**
       *  Converts args[1], the timeSlice, to a double and prints out the input.
       *  note: if there is no args[1] inputted, the program uses a default timeSlice of 60 seconds
       */
      double timeSlice = 60;
      if ( args.length == 2 ) {
         timeSlice = Double.parseDouble( args[1] );
      }
      System.out.println( "Your inputted Timeslice (Default 60): " + timeSlice );

      /**
       *  Defines a new clock and initializes it to 0:0:0.0
       */
      Clock clock = new Clock( timeSlice );
      System.out.println( "New clock initialized: " + clock );

      /**
       *  Increments through the clock by the given timeSlice
       *  If the hand angle of the clock after the tick is equal to the inputted angle, prints the time
       */
       System.out.println( "\nList of values where Hands make angle " + angle + ":" );

       //Main loop
       for ( int i = 0;
             ( ( clock.getMinuteHand() * SECONDS_IN_MINUTE ) + ( clock.getHourHand() * MINUTES_IN_HOUR * SECONDS_IN_MINUTE ) ) < SECONDS_IN_DAY;
             clock.tick() ) {
         if ( angle == clock.getHandAngle() ) {
            System.out.println( clock );
         } else continue;
      }

   }
}
