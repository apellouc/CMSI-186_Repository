/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Fibonacci.java
 *  Purpose       :
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
 *  @version 1.0.0  2017-04-06  A. Pellouchoud  Initial Writing and Release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 // 0, 1, 1, 2, 3, 5, 8, 13, 21, etc

public class Fibonacci {

   /**
    *  Class field definintions
    */
    private static String storedValue = "";
    private static GinormousInt[] gintArray = null;
    private static int i1 = 0;
    private GinormousInt n1 = new GinormousInt( "0" );
    private GinormousInt n2 = new GinormousInt( "1" );
    private GinormousInt n3 = n1.addInt( n2 );

    /**
     *  Constructor validates arg, takes input number, creates array of size needed
     *  @param value the number fibonacci number the user wants returned.
     *  @return the (value)th fibonacci number in the sequence
     *  @throws IllegalArgumentException
     */
     public Fibonacci( String value ) {

        if ( GinormousInt.checkIfDigits( value ) == false ) {
           throw new IllegalArgumentException( "Input must be a number - the nth number to be returned" );
        }

        storedValue = value;

        i1 = Integer.parseInt( storedValue );

        gintArray = new GinormousInt[ i1 ];

        gintArray[0] = n1;
        gintArray[1] = n2;

        for ( int i = 2; i <= i1; i++) {

           gintArray[i] = n3;

           n1 = n2;
           n2 = n3;

        }

     }

     /**
      *  Main program starts here
      */
     public static void main( String[] args ) {

        if ( args.length != 1 ) {
           throw new IllegalArgumentException( "Send 1 argument - the nth Fibonacci number to return" );
        }

        Fibonacci f1 = new Fibonacci( args[0] );

        GinormousInt result = gintArray[ i1 ];
        String s = result.toString();

        System.out.println( "Starting from zero, the " + storedValue +
                            "th Fibonacci number is " + s );
     }

}
