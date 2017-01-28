/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Complete the CountTheDays.java program (Step five of Homework 01)
 *  Author        :  Amy Pellouchoud
 *  Date          :  2017-01-24
 *  Author        :  Amy Pellouchoud
 *  Date          :  2017-01-24
 *  Description   :  This file will calculate the number of days between two dates.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-01-25  A. Pellouchoud  Initial writing and release
 *  @version 1.0.1  2017-01-26  A. Pellouchoud  Worked on program
 *  @version 1.0.2  2017-01-28  A. Pellouchoud  Fixed problems and finished program
 */

public class CountTheDays {
   public static void main (String [] args) {

      if (args.length != 6) {
         System.out.print ("Invalid input");
         System.exit(-1);
       }

      long month1 = Long.parseLong(args[0]);
      long day1 = Long.parseLong(args [1]);
      long year1 = Long.parseLong(args[2]);
      long month2 = Long.parseLong(args[3]);
      long day2 = Long.parseLong(args[4]);
      long year2 = Long.parseLong(args[5]);

      if (CalendarStuff.isValidDate( month1, day1, year1 ) && CalendarStuff.isValidDate( month2, day2, year2 )) {
         System.out.print( "Days Between " + month1 + "/" + day1 + "/" + year1 + " and " + month2 + "/" + day2 + "/" + year2 + ":" );
         System.out.println( CalendarStuff.daysBetween( month1, day1, year1, month2, day2, year2 ) ) ;
       }
   }
}
