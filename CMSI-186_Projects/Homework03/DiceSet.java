/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Amy Pellouchoud
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:   Reason for change/modification
 *           -----  ----------  ------------   -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson   Initial writing and release
 *  @version 1.1.0  2017-02-16  A. Pellouchoud Wrote constuctor and toString stuff
 *  @version 1.2.0  2017-02-20  A. Pellouchoud More werk, almost finished
 *  @version 1.3.0  2017-02-21  A. Pellouchoud Finished program
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private Die[] dieArray;
   private static final int MINIMUM_SIDES = 4;
   private static final int MINIMUM_COUNT = 1;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {

      if ( ( count < MINIMUM_COUNT ) || ( sides < MINIMUM_SIDES ) ) {
         throw new IllegalArgumentException( "You need at least 1 die and at least 4 sides.");
      }

      this.dieArray = new Die[count];

      for ( int i = 0; i < count; i++ ) {
         dieArray[i] = new Die( sides );    //why isn't this this.dieArray???
      }
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {

      int result = 0;

      for ( int i = 0; i < this.dieArray.length; i++) {
         result = result + this.dieArray[i].getValue();
      }

      return result;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {

      System.out.println( "\nYou are rolling all the die." );

      for ( int i = 0; i < this.dieArray.length; i++) {
         this.dieArray[i].roll();
      }
   }

   /**
    * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
    * @param  dieIndex int of which die to roll
    * @return the integer value of the newly rolled die
    * @throws IllegalArgumentException if the index is out of range
    */

   public void rollIndividual( int dieIndex ) {

      if ( (dieIndex < 0) || (dieIndex > this.dieArray.length) ) {
         throw new IllegalArgumentException( "Die index out of range" );
      }

      System.out.println( "\nYou are rolling die number " + (dieIndex + 1) + "." );

      this.dieArray[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @throws IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {

      if ( (dieIndex < 0) || (dieIndex > this.dieArray.length) ) {
         throw new IllegalArgumentException( "Die index out of range" );
      }

      return this.dieArray[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {

      String result = "";

      for ( int i = 0; i < this.dieArray.length; i++ ) {
         result = result + this.dieArray[i].toString();
      }

      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {

      String result = "";

      for ( int i = 0; i < ds.dieArray.length; i++ ) {
         result = result + ds.dieArray[i].toString();
      }

      return result;
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {

       if ( ds.dieArray.length == this.dieArray.length ) {
           return true;
       } else return false;
    }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      System.out.println( "\nCheck out these TESTS for DiceSet.java !");
      System.out.println( "\nTesting methods for a DiceSet with 3 6-sided Die: ");
      DiceSet d = new DiceSet( 3, 6 );
      d.roll();
      System.out.println( "\nNow the dice values are: " + d.toString() );
      System.out.println( "\nSum of all dice values is " + d.sum() );
      d.rollIndividual(1);
      System.out.println( "\nNow the dice values are: " + d.toString() );
      System.out.println( "\nSum of all dice values is " + d.sum() );
      System.out.println( "\nReturn value of dice 1: " + d.getIndividual(0) );
      System.out.println( "Return value of dice 2: " + d.getIndividual(1) );
      System.out.println( "Return value of dice 3: " + d.getIndividual(2) );
   }
}
