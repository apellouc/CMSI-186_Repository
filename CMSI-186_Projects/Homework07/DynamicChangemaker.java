/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DynamicChangemaker.java
 *  Purpose       :  Provides a class to calculate most efficient coin combination to create a desired
 *                   amount.
 *  @author       :  Amy Pellouchoud
 *  Date          :  2017-04-26
 *  Description   :  This class provides the argument checks and algorithm needed to return the most
 *                   efficient combination of inputted coin amounts. To be used with Tuple.java. Test
 *                   harness is DynamicChangemakerTestHarness.java
 *  Notes         :  Args[0] must be a comma-separated list of coin denominations
 *                   Args[1] must be the amount desired
 *                   All arguments must be non-negative integers
 *                   No duplicate coin denominations
 *  Warnings      :  None
 *  Exceptions    :  NumberFormatException when the arguments inputted are not integers
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-04-25  B.J. Johnson    Copied Prof. Johnson's copy from Github
 *  @version 1.1.0  2017-04-26  A. Pellouchoud  Studied all programs, Tuple class, started working
 *  @version 1.2.0  2017-04-27  A. Pellouchoud  Started writing makeChangeWithDynamicProgramming()
 *  @version 1.3.0  2017-04-28  A. Pellouchoud  Wrote loop to return result from table
 *  @version 1.4.0  2017-05-01  A. Pellouchoud  Restructured algorithm with prof's notes
 *  @version 1.5.0  2017-05-02  A. Pellouchoud  Minor fixes to make the program work, still some to fix
 *  @version 1.6.0  2017-05-03  A. Pellouchoud  Completed program (Hopefully)
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Arrays;

/**
 * Calculates most efficient coin combination to create desired amount
 * User inputs comma-separated coin denominations followed by amount desired
 * No duplicate denominations, all args must be integers
 */
 public class DynamicChangemaker {

    /**
     * Main program starts here
     * @param
     * Error-checks the arguments
     * Converts args[0] to an integer array, and args[1] to an integer
     * @throws NumberFormatException when arguments are not integers
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println("\n" + amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("--> "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount) + "\n");
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }


    /**
     *  Method to perform the algorithm
     *  @param denominations integer array of non-negative, non-dupicate coin denominations
     *  @param amount amount desired to create with coins
     *  @return Tuple of most efficient number of each coin denomination
     *  Note: Returned Tuple values correspond to the order of inputted denominations
     */
    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {

      //Make new table of tuples
      Tuple[][] table = new Tuple[ denominations.length ][ amount + 1 ];

      //Set solution values in table
      for ( int i = 0; i < denominations.length; i++ ) {
         for ( int j = 0; j <= amount; j++ ) {

            Tuple t1 = new Tuple( denominations.length );

            if ( j == 0 ) {
               table[i][j] = new Tuple( denominations.length );
            } else {

               if ( ( j / denominations[i] ) >= 1 ) {
                  t1.setElement( i, 1 );
                  if ( table[ i ][ j - denominations[i] ].isImpossible() == false ) {
                     t1 = t1.add( table[ i ][ j - denominations[i] ] );
                  } else {
                     t1 = Tuple.IMPOSSIBLE;
                  }


               } else if ( ( j / denominations[i] ) < 1 ) {
                  t1 = Tuple.IMPOSSIBLE;
               }

               if ( i != 0 ) {
                  if ( t1.isImpossible() == false ) {
                     if ( table[ i - 1 ][ j ].isImpossible() ) {
                        //leave it
                     } else {

                        if ( table[ i - 1 ][ j ].total() < t1.total() ) {
                           t1 = table[ i - 1 ][ j ];
                        }
                     }
                  } else {

                     if ( table[ i - 1 ][ j ].isImpossible() == false ) {
                        t1 = table[ i - 1 ][ j ];
                     }
                  }
               }

               table[i][j] = t1;

            }
         }
      }

      //return most efficient solution to make desired amount
      return table[ denominations.length - 1 ][ amount ];

    }

    /**
     *  Method to print usage instructions for class
     *  Returned when inputted arguments do not match the requirements
     */
    private static void printUsage() {
        System.out.println("Usage: java DynamicChangemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    /**
     *  Method to pluralize "coin" if more than one coin is used
     *  @param count Number of coins total needed to make the amount desired
     *  @return String "s" if more than one coin is needed
     */
    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
