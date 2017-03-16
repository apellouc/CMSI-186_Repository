/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:   Reason for change/modification
 *           -----  ----------  ------------   -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson   Initial writing and release
 *  @version 1.1.0  2017-03-02  A. Pellouchoud Wrote constructor, tick, and validateAngleArg, added definitions
 *  @version 1.2.0  2017-03-14  A. Pellouchoud Wrote tests, wrote all methods besides getHandAngle()
 *  @version 1.3.0  2017-03-15  A. Pellouchoud Wrote getHandAngle(), Polished & finished program
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock {
  /**
   *  Class field definintions go here
   *  note: DEGREE_CHANGE_PER_MINUTE refers to the change in angle between
   *        the minute and hour hand every minute (+ 5.5 degrees)
   */
   private double seconds;
   private int minutes;
   private int hours;
   private double timeslice;
   private static final double SECONDS_IN_MINUTE = 60;
   private static final int MINUTES_IN_HOUR = 60;
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double MAXIMUM_SLICE = 1800;
   private static final double DEGREE_CHANGE_PER_MINUTE = 5.5;

  /**
   *  Constructor goes here
   */
   public Clock() {

      this.seconds = 0;
      this.minutes = 0;
      this.hours = 0;
      this.timeslice = DEFAULT_TIME_SLICE_IN_SECONDS;

   }

  /**
   *  Second constructor for Clock with inputted timeSlice instead of default
   */
   public Clock( double timeSlice ) {

      this.seconds = 0;
      this.minutes = 0;
      this.hours = 0;
      this.timeslice = timeSlice;

   }

  /**
   *  Methods go here
   *  @param   timeslice  Timeslice
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double[] tick() {

      this.seconds += this.timeslice;

      if ( this.seconds >= SECONDS_IN_MINUTE ) {
         this.minutes += ( this.seconds / SECONDS_IN_MINUTE );
         this.seconds = ( this.seconds % SECONDS_IN_MINUTE );
      }

      if ( this.minutes >= MINUTES_IN_HOUR ) {
         this.hours += ( this.minutes / MINUTES_IN_HOUR );
         this.minutes = ( this.minutes % MINUTES_IN_HOUR );
      }

      double[] retVal = new double [3];
      retVal[0] = this.hours;
      retVal[1] = this.minutes;
      retVal[2] = this.seconds;

      return retVal;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public static double validateAngleArg( String argValue ) throws NumberFormatException {

      double retVal = Double.parseDouble( argValue );

      if (( retVal > MAXIMUM_DEGREE_VALUE ) || ( retVal < 0 )) {
         throw new NumberFormatException( "Input must be a NUMBER between 0 and 360 degrees" );
      }

      return retVal;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public static double validateTimeSliceArg( String argValue ) {

      double retVal = Double.parseDouble( argValue );

      if (( retVal > MAXIMUM_SLICE ) || ( retVal < 0 )) {
         throw new NumberFormatException( "Input must be a NUMBER between 0 and 1800 seconds" );
         // return INVALID_ARGUMENT_VALUE; -- unreachable
      }

      return retVal;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHand() {

      double retValHours = (double) this.hours;
      return retValHours;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHand() {

      double retValMinutes = (double) this.minutes;
      return retValMinutes;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {

      double retValHours = (double) this.hours;
      double retValMinutes = (double) this.minutes;

      //variable to calculate angle between hour hand and minute hand.
      double handAngle = ( ( retValHours * MINUTES_IN_HOUR ) + retValMinutes ) * DEGREE_CHANGE_PER_MINUTE;

      return handAngle;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {

      return this.hours + ":" + this.minutes + ":" + this.seconds;
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );

      //Tests for validateAngleArg()

      System.out.println( "\n  Testing validateAngleArg()....");

      System.out.print( "    Sending '0 degrees', expecting double value 0.0:" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '90.56 degrees', expecting double value 90.56:" );
      try { System.out.println( (90.56 == clock.validateAngleArg( "90.56" )) ? " - got 90.56" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '360 degrees', expecting double value 360.0:" );
      try { System.out.println( (360.0 == clock.validateAngleArg( "360" )) ? " - got 360.0" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '-1 degrees', expecting NumberFormatException:" );
      try { System.out.println( (-1.0 == clock.validateAngleArg( "-1" )) ? " - got -1.0" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '100000 degrees', expecting NumberFormatException:" );
      try { System.out.println( (100000.0 == clock.validateAngleArg( "100000" )) ? " - got 100000.0" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending 'Hello World', expecting NumberFormatException:" );
      try { System.out.println( clock.validateAngleArg( "Hello World" ) ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      //Tests for validateTimeSliceArg()

      System.out.println( "\n  Testing validateTimeSliceArg()....");

      System.out.print( "    Sending '0 seconds', expecting double value 0.0:" );
      try { System.out.println( (0.0 == clock.validateTimeSliceArg( "0.0" )) ? " - got 0.0" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '1800 seconds', expecting double value 1800.0:" );
      try { System.out.println( (1800.0 == clock.validateTimeSliceArg( "1800" )) ? " - got 1800.0" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '0 seconds', expecting double value 0.0:" );
      try { System.out.println( (0.0 == clock.validateTimeSliceArg( "0.0" )) ? " - got 0.0" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '-10 seconds', expecting NumberFormatException:" );
      try { System.out.println( (-10 == clock.validateTimeSliceArg( "-10" )) ? " - got -10.0" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending '100000 seconds', expecting NumberFormatException:" );
      try { System.out.println( (100000.0 == clock.validateTimeSliceArg( "100000" )) ? " - got 100000.0" : " - No luck" ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      System.out.print( "    Sending 'Hello World', expecting NumberFormatException:" );
      try { System.out.println( clock.validateTimeSliceArg( "Hello World" ) ); }
      catch( Exception e ) { System.out.println ( "\n    - Exception thrown: " + e.toString() ); }

      //Tick the clock for further testing

      System.out.println( "\n  Ticking the clock twice for further testing...." );
      System.out.println( "    *NOTE* Timeslice of the tick is defaulted at 60 seconds. Should return 0:2:0.0");
      clock.tick();
      clock.tick();
      System.out.println( "    The clock now reads: " + clock.toString() );

      //Test for getHourHand()

      System.out.println( "\n  Testing getHourHand....");
      System.out.println( "    Expecting returned hour hand 0.0: " + clock.getHourHand() );

      //Test for getMinuteHand()

      System.out.println( "\n  Testing getMinuteHand....");
      System.out.println( "    Expecting returned minute hand 2.0: " + clock.getMinuteHand() );

      //Test for getHandAngle()

      System.out.println( "\n  Testing getHandAngle....");
      System.out.println( "    Expecting returned Angle 11: " + clock.getHandAngle() );

      //Tick clock to test new reading for getHandAngle()

      System.out.println( "    Ticking the clock 23 more times" );
      for (int i = 0; i < 23; i++) {
         clock.tick();
      }
      System.out.println( "    The clock now reads: " + clock );
      System.out.println( "    Expecting returned Angle 137.5: " + clock.getHandAngle() );

   }
}
