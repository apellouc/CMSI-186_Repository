/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  A file containing the class for the "High Roll" game.
 *  Author        :  Amy Pellouchoud
 *  Date          :  2017-02-20
 *  Description   :  There is only one rule to this game, which is to get the highest
 *                   score you can on all five dice.  You can re-roll as many times
 *                   as you like with no limit, either individual dice or all dice in the
 *                   set collectively.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:      Reason for change/modification
 *           -----  ----------  ------------      -----------------------------------------------------------
 *  @version 1.0.0  2017-02-20  A. Pellouchoud    Initial writing and release
 *  @version 1.1.0  2017-02-21  A. Pellouchoud    Attempted to use Scanner, nah.
 *  @version 1.2.0  2017-02-23  A. Pellouchoud    Implemented BufferedReader and finished program
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class HighRoll {

   /**
    * private instance data
    */
   private static StringBuffer sb = null;
   private static int HIGHSCORE = 0;

   /**
    * Main Program - High Roll Game
    */
   public static void main (String[] args) {

      System.out.println( "\n-------------------------------------------------------" );
      System.out.println( "\nWelcome to the High Roll Game!" +
                          "\nYour Mission: To get the highest score on all five die." +
                          "\nYou can reroll with no limit, either individual dice or all dice at once." );

      //Input stream reader
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

      //Creates 5 die with 6 sides each
      DiceSet ds = new DiceSet( 5, 6 );

      //A "good" infinite while loop.
      //Loop breaks by quitting the program.
      while( true ) {

         System.out.println( "\nCurrent die values: " + ds.toString() );

         System.out.println( "\nOPTIONS: " +
                           "\nEnter 1 to ROLL ALL THE DICE" +
                           "\nEnter 2 to ROLL A SINGLE DIE" +
                           "\nEnter 3 to CALCULATE SCORE" +
                           "\nEnter 4 to SAVE HIGH SCORE" +
                           "\nEnter 5 to DISPLAY HIGH SCORE" +
                           "\nEnter Q to QUIT THE PROGRAM"
                           );

         System.out.println( "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
         System.out.print( "\n>>" );
         String inputLine = null;

         try {

            inputLine = input.readLine();

            if (inputLine.charAt(0) == '1') {
               ds.roll();

            } else if (inputLine.charAt(0) == '2') {

               System.out.println( "\nWhich die? (Enter 1 2 3 4 or 5)" );
               System.out.print(   "\n>>" );
               String inputLine2 = null;
               inputLine2 = input.readLine();

               if (inputLine2.charAt(0) == '1') {
                  ds.rollIndividual(0);
               } else if (inputLine2.charAt(0) == '2') {
                  ds.rollIndividual(1);
               } else if (inputLine2.charAt(0) == '3') {
                  ds.rollIndividual(2);
               } else if (inputLine2.charAt(0) == '4') {
                  ds.rollIndividual(3);
               } else if (inputLine2.charAt(0) == '5') {
                  ds.rollIndividual(4);
               } else System.out.println( "\nMust enter dice number 1-5. Try again!" );
                  continue;

            } else if (inputLine.charAt(0) == '3') {
               System.out.println("\nCurrent score: " + ds.sum() );

            } else if (inputLine.charAt(0) == '4') {

               HIGHSCORE = ds.sum();
               System.out.println( "\nHighscore saved.");

            } else if (inputLine.charAt(0) == '5') {
               System.out.println( "\nHighscore is: " + HIGHSCORE );

            } else if ( (inputLine.charAt(0) == 'Q') || (inputLine.charAt(0) == 'q') ) {
               System.out.println( "\nThanks for playing!\n" );
               break;

            } else System.out.println( "\nMust enter 1 2 3 4 5 or Q. Try again!");
               continue;
         }
         catch( IOException ioe ) {
            System.out.println( "IOException" );
         }
      }
   }
}
