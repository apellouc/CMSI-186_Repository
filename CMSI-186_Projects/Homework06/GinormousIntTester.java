/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  GinormousIntTester.java
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
 *  @version 1.0.0  2017-04-05  B.J. Johnson    Initial writing and release
 *  @version 1.1.0  2017-04-06  A. Pellouchoud  Initial Writing and Release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


 public class GinormousIntTester {

    public GinormousIntTester() {
       super();
    }

    public static void main( String[] args ) {
       GinormousIntTester git = new GinormousIntTester();

       System.out.println( "\n  Hello from the GinormousIntTester program!!" );

       System.out.println( "\n    =============================================\n" );

       System.out.println( "    ~~~ Tests for constructor & toString() ~~~ \n");
       System.out.println( "    Making a new GinormousInt g1: " );
       GinormousInt g1 = new GinormousInt( "144127909719710664015092431502440849849506284148982076191826176553" );
       System.out.println( "      expecting: 144127909719710664015092431502440849849506284148982076191826176553\n" +
                           "        and got: " + g1.toString() );

       System.out.println( "\n    Making a second new GinormousInt g2 [same as first]: " );
       GinormousInt g2 = new GinormousInt( "144127909719710664015092431502440849849506284148982076191826176553" );
       System.out.println( "      expecting: 144127909719710664015092431502440849849506284148982076191826176553\n" +
                           "        and got: " + g2.toString() );

       System.out.println( "\n    Making a third new GinormousInt g3 [differs at position 47    |]: " +
                           "\n                                                               v   " );
       GinormousInt g3 = new GinormousInt( "144127909719710664015092431502440849849506284108982076191826176553" );
       System.out.println( "      expecting: 144127909719710664015092431502440849849506284108982076191826176553\n" +
                                               "        and got: " + g3.toString() );

       System.out.println( "\n    Making a fourth new GinormousInt g4 [same as g3 but truncated]: "  );
       GinormousInt g4 = new GinormousInt( "144127909719710664015092431502440849849506284" );
       System.out.println( "      expecting: 144127909719710664015092431502440849849506284\n" +
                           "        and got: " + g4.toString() );

       System.out.println( "\n    Making a fifth new GinormousInt g5 [same as g1 but negative]: "  );
       GinormousInt g5 = new GinormousInt( "-144127909719710664015092431502440849849506284148982076191826176553" );
       System.out.println( "      expecting: -144127909719710664015092431502440849849506284148982076191826176553\n" +
                           "        and got: " + g5.toString() );

       System.out.println( "\n    Making a sixth new GinormousInt, checking GinormousInt.ZERO: "  );
       GinormousInt g6 = new GinormousInt( "0" );
       System.out.println( "      expecting: " + GinormousInt.ZERO + "\n" +
                           "        and got: " + g6.toString() );

       System.out.println( "\n    Making a seventh new GinormousInt, checking GinormousInt.ONE: "  );
       GinormousInt g7 = new GinormousInt( "1" );
       System.out.println( "      expecting: " + GinormousInt.ONE + "\n" +
                           "        and got: " + g7.toString() );

       System.out.println( "\n    Making a eighth new GinormousInt, checking GinormousInt.TEN: "  );
       GinormousInt g8 = new GinormousInt( "10" );
       System.out.println( "      expecting: " + GinormousInt.TEN + "\n" +
                           "        and got: " + g8.toString() );

       System.out.println( "\n    =============================================\n" );

       System.out.println( "      ~~~ Tests for equals() ~~~ ");
       System.out.println( "\n    Comparing equality of g1 and g2: " );
       System.out.println( "      expecting: true\n" + "        and got: " + g1.equals( g2 ) );

       System.out.println( "\n    Comparing equality of g1 and g3 [detect different digit]: " );
       System.out.println( "      expecting: false\n" + "        and got: " + g1.equals( g3 ) );

       System.out.println( "\n    Comparing equality of g3 and g4 [detect different length prior to detecting different digit]: " );
       System.out.println( "      expecting: false\n" + "        and got: " + g3.equals( g4 ) );

       System.out.println( "\n    Comparing equality of g1 and g5 [detect that negative is not equal]: " );
       System.out.println( "      expecting: false\n" + "        and got: " + g1.equals( g5 ) );

       System.out.println( "\n    =============================================\n" );

       System.out.println( "\n    ~~~ Tests for addInt() method ~~~ ");

      //  GinormousInt g9  = new GinormousInt( "20" );
      //  GinormousInt g10 = new GinormousInt( "234567" );
      //  System.out.println( "\n    Adding 20 and 234567 [Add positives of different lengths]: " );
      //  System.out.println( "      expecting: 234587\n" +
      //                      "        and got: " + g9.addInt( g10 ) );

       System.out.println( "\n    Adding g1 and g2 [Add 2 positives]: " );
       System.out.println( "      expecting: 288255819439421328030184863004881699699012568297964152383652353106\n" +
                           "        and got: " + g1.addInt( g2 ) );

       System.out.println( "\n    Adding g1 and g4 [Add positives for different lengths]: " );
       System.out.println( "      expecting: 144127909719710664015236559412160560513521376580484517041675682837\n" +
                           "        and got: " + g1.addInt( g4 ) );

       System.out.println( "\n    Adding g5 and g5 [Test adding 2 negatives]: " );
       System.out.println( "      expecting: -288255819439421328030184863004881699699012568297964152383652353106\n" +
                           "        and got: " + g5.addInt( g5 ) );

       GinormousInt g9 = new GinormousInt( "999" );
       System.out.println( "\n    New GinormousInt g9 = 999" );
       System.out.println( "    Adding g9 with itself [Test for extra carry at the end]: " );
       System.out.println( "      expecting: 1998\n" +
                           "        and got: " + g9.addInt( g9 ) );


       System.out.println( "\n    =============================================\n" );

      //  System.out.println( "\n    Subtracting g1 and g4 [Subtract 2 positives]: " );
      //  System.out.println( "      expecting: 0\n" +
      //                      "        and got: " + g1.subtractInt( g4 ) );

      //  System.out.println( "\n    ~~~ Tests for subtractInt() method ~~~ ");
      //
      //  System.out.println( "\n    Subtracting g1 and g2 [Subtract same number]: " );
      //  System.out.println( "      expecting: 0\n" +
      //                      "        and got: " + g1.subtractInt( g2 ) );

       System.exit( 0 );

    }
}
