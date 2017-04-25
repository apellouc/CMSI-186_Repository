/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  GinormousInt.java
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
 *  @version 1.1.0  2017-04-11  A. Pellouchoud  Wrote constructor
 *  @version 1.2.0  2017-04-13  A. Pellouchoud  Updated constructor, Worked on toString
 *  @version 1.     2017-04-20  BJ Johnson      Prof. saves the day and fixes my constructor and other issues
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.lang.Character;
import java.util.Arrays;

public class GinormousInt {

 /**
  *  Class field definintions
  */
  private int[]  intArray = null;             // used for reverseString set as an array of integers for math purposes
  private byte   sign = 0;                    // "0" is positive, "1" is negative
  private String stringValue = "";            // Stores the inputted string
  private String stringWithoutSign = "";      // String representation of inputted string not including the sign
  private String reverseString = "";

  public static final GinormousInt ZERO = new GinormousInt( "0" );
  public static final GinormousInt ONE = new GinormousInt( "1" );
  public static final GinormousInt TWO = new GinormousInt( "2" );
  public static final GinormousInt TEN = new GinormousInt( "10" );

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a GinormousInt
   */
   public GinormousInt( String value ) {

      stringValue = value;

      if ( ( value.charAt(0) == '-' ) ||
           ( value.charAt(0) == '+' ) ||
           ( ( value.length() > 1 ) && ( value.charAt(0) == '0' ) ) ) {
         stringWithoutSign = value.substring(1);
      } else {
         stringWithoutSign = value;
      }

      //Check if string input without sign are all digits
      if ( !checkIfDigits( stringWithoutSign ) ) {
         throw new IllegalArgumentException( "Input must contain only numbers and a sign" );
      }

      //Set sign byte value to 1 if negative
      if ( value.charAt(0) == '-' ) {
         sign = 1;
      }

      //reverse the string and store in reverseString
      reverser();

      //Turn inputted string into array of digits
      intArray = new int[ reverseString.length() ];

      for ( int i = 0; i < reverseString.length(); i++ ) {
         intArray[i] = Character.digit( reverseString.charAt( i ), 10 );
      }
   }

   /**
    *  Method to validate that all the characters in the value are valid decimal digits
    *  @param s String
    *  @return boolean true if all digits are good
    */
   public static Boolean checkIfDigits( String s ) {

      int k = s.length();

      if ( k == 0 ) {
         return false;
      }

      for ( int i = 0; i < k; i++ ) {
         if ( !Character.isDigit( s.charAt( i ) ) ) {
            return false;
         }
      }

      return true;
   }

   /**
    *  Method to reverse the value of this GinormousInt
    *  @return GinormousInt that is the reverse of the value of this GinormousInt
    */
   public void reverser() {

      StringBuffer sb = new StringBuffer( stringWithoutSign );
      reverseString = sb.reverse().toString();

   }

   /**
    *  Method to reverse the value of a GinormousIntk passed as argument
    *  Note: static method
    *  @param  String s String to reverse
    *  @return String that is the reverse of the string passed in
    */
    public static String reverser( String s ) {

      StringBuffer sb = new StringBuffer( s );
      String result = sb.reverse().toString();
      return result;

    }

   /**
    *  Method to add the value of a GinormousIntk passed as argument to this GinormousInt using int array
    *  @param gint GinormousInt to add to this
    *  @return GinormousInt whose value is the sum of this plus the argument
    */
    public GinormousInt addInt( GinormousInt gint ) {

      int carry = 0;
      int[] a = intArray;
      int[] b = gint.intArray;

      //POINT: to make sure b is always the one that is less in LENGTH than a
      if ( gint.intArray.length > intArray.length ) {
         a = gint.intArray;
         b = intArray;
      }

      //c Array to store result of addition
      int[] c = new int[ a.length + 1 ];

      //Organization for signs pt. 1
      if ( ( ( this.sign == 0 ) && ( gint.sign == 0 ) ) ||
           ( ( this.sign == 1 ) && ( gint.sign == 1) ) )  {

             int i = 0;
             //DO THE ADDITION
             for ( int j = i; j < b.length; j++ ) {

                c[j] = a[j] + b[j] + carry;

                if ( c[j] > 9 ) {
                   carry = 1;
                   c[j] -= 10;
                } else {
                   carry = 0;
                }

                i = j;
             }

             //increment i to start next loop where b array ends
             i += 1;

             for ( int k = i; k < a.length; k++ ) {

                c[k] = a[k] + carry;

                if ( c[k] > 9 ) {
                   carry = 1;
                   c[k] -= 10;
                } else {
                   carry = 0;
                }

                i = k;
             }

             if ( carry == 1 ) {
                c[ a.length ] = 1;
             } else c[ a.length ] = 0;

             //Turn c Array into a GinormousInt and return the result
             String cAsString = Arrays.toString( c ).replaceAll("\\[|\\]|,|\\s", "");

             // Added: Beej 2017-04-20
             // check if the last character is a zero and remove it - (extra carry space could be filled with a 0)
             if( cAsString.charAt( cAsString.length() - 1 ) == '0' ) {
                cAsString = cAsString.substring( 0, cAsString.length() - 1 );
             }

             //Add negative sign if need be
             if ( ( this.sign == 1 ) && ( gint.sign == 1) ) {
                cAsString = cAsString.concat( "-" );
             }

             cAsString = reverser( cAsString );

             GinormousInt result = new GinormousInt( cAsString );

             return result;

     //Organization for signs pt. 2 - If signs are different, send to subtractInt
     } else if ( ( this.sign == 0 ) && ( gint.sign == 1 ) ) {

        //Initializes this GinormousInt as itself to pass to subtract
        GinormousInt addHelper1 = new GinormousInt( stringValue );

        //Initializes inputted gint as a positive to pass to subtract
        GinormousInt addHelper2 = new GinormousInt( gint.stringWithoutSign );

        //Uses addHelper1 to pass this GinormousInt to subtract
        return addHelper1.subtractInt( addHelper2 );

     } else if ( ( this.sign == 1 ) && ( gint.sign == 0) ) {

        //Initializes this GinormousInt as a positive to pass to subtract
        GinormousInt addHelper3 = new GinormousInt( this.stringWithoutSign );

        return gint.subtractInt( addHelper3 );
     }

     throw new UnsupportedOperationException( "\n         Method does not reach this point" );
  }

   /**
    *  Method to subtract the value of a GinormousIntk passed as argument to this GinormousInt
    *  @param gint GinormousInt to subtract from this
    *  @return GinormousInt that is the difference of the value of this GinormousInt and the one passed in
    *  @throws UnsupportedOperationException
    */
    public GinormousInt subtractInt( GinormousInt gint ) {

      //Initializes this GinormousInt as itself to reference & pass to other methods
      GinormousInt subHelper1 = new GinormousInt( stringValue );

      int[] a = intArray;        //Lexicographically bigger array (or =) stored here
      int[] b = gint.intArray;   //Lexicographically smaller array (or =) stored here

      //POINT: Store the LEXICOGRAPHICALLY bigger number in a, and smaller in b
      if ( compareTo( subHelper1, gint ) < 1 ) {
         a = gint.intArray;
         b = intArray;
      }

      //c Array to store result of subtraction
      int[] c = new int[ a.length ];

      //Organization for signs pt. 1
      if ( ( this.sign == 0 ) && ( gint.sign == 0 ) ) {

         int i = 0;

         //DO THE SUBTRACTION
         for ( int j = i; j < b.length; j++ ) {

            if ( b[j] > a[j] ) {
               a[ j + 1 ] = ( a[ j + 1 ] - 1 );
               a[j] = ( a[j] + 10 );
            }

            c[j] = a[j] - b[j];

            i = j;
         }

         i += 1;

         for ( int k = i; k < a.length; k++ ) {

            c[k] = a[k];
         }

         //Turn c Array into a GinormousInt and return the result
         String cAsString = Arrays.toString( c ).replaceAll( "\\[|\\]|,|\\s", "" );

         //Add negative sign if bigger pos number was subtracted from other pos number
         if ( ( compareTo( subHelper1, gint ) < 1 ) ) {
            cAsString = cAsString.concat( "-" );
         }

         cAsString = reverser( cAsString );
         GinormousInt result = new GinormousInt( cAsString );

         return result;

      } else if ( ( this.sign == 0 ) && ( gint.sign == 1 ) ) {

         //Initialize gint as a positive to pass to addInt()
         GinormousInt subHelper2 = new GinormousInt( gint.stringWithoutSign );

         return subHelper1.addInt( subHelper2 );

      } else if ( ( this.sign == 1 ) && ( gint.sign == 1 ) ) {

         //Treat it as positive gint minus positive THIS
         GinormousInt subHelper3 = new GinormousInt( gint.stringWithoutSign );
         GinormousInt subHelper4 = new GinormousInt( this.stringWithoutSign );
         return subHelper3.subtractInt( subHelper4 );

      } else if ( ( this.sign == 1 ) && ( gint.sign == 0 ) ) {

         //Treat it as adding two negatives
         //Initializes gint as a negative
         GinormousInt subHelper5 = makeNegative( gint );

         return subHelper1.addInt( subHelper5 );
      }

      throw new UnsupportedOperationException( "\n         Method does not reach this point." );
   }

   /**
    *  Method to make a positive GinormousInt into a negative GinormousInt
    *  Note: static method
    *  @param  gint positive GinormousInt to be returned as negative
    *  @return Negative version of inputted GinormousInt
    *  @throws IllegalArgumentException
    */
    public static GinormousInt makeNegative( GinormousInt gint ) {

      String s = new String( gint.stringValue );

      if ( s.charAt(0) == '-' ) {
         throw new IllegalArgumentException( "Input is already negative" );
      }

      s = reverser( s );
      s = s.concat( "-" );
      s = reverser( s );

      GinormousInt result = new GinormousInt( s );
      return result;
    }


   /**
    *  Method to multiply the value of a GinormousIntk passed as argument to this GinormousInt
    *  @param gint GinormousInt to multiply by this
    *  @return GinormousInt that is the product of the value of this GinormousInt and the one passed in
    *  @throws UnsupportedOperationException
    */
    public GinormousInt multiply( GinormousInt gint ) {

      //Initializes GinormousInts as positive to manipulate and multiply
      GinormousInt mulHelper1 = new GinormousInt( stringWithoutSign );
      GinormousInt mulHelper2 = new GinormousInt( gint.stringWithoutSign);

      GinormousInt sum = new GinormousInt( "0" );
      Halver h = new Halver();

      if ( ( mulHelper1.equals(ZERO) ) || ( gint.equals(ZERO) ) ) {
         return ZERO;
      } else if ( mulHelper1.equals(ONE) ) {
         return gint;
      } else if ( gint.equals(ONE) ) {
         return mulHelper1;
      } else {

         //Russian Peasant Multiplication algorithm
         while ( mulHelper2.equals(ONE) != true ) {

            mulHelper1 = mulHelper1.addInt( mulHelper1 );
            mulHelper2 = new GinormousInt( h.halve( mulHelper2.toString() ) );

               if ( !mulHelper2.isEven() ) {
                  sum = sum.addInt( mulHelper1 );
               }
         }

         //concat the sign if one inputted GinormousInt is negative
         if ( ( ( this.sign == 1 ) && ( gint.sign == 0 ) ) ||
            ( ( gint.sign ==1 )  && ( this.sign == 0 ) ) ) {
               sum = new GinormousInt( reverser( sum.reverseString.concat( "-" ) ) );
           }

         return sum;

      }
   }

    /**
    *  Method to divide the value of this GinormousIntk by the GinormousInt passed as argument
    *  @param gint GinormousInt to divide by this
    *  @return GinormousInt that is the dividend of this GinormousInt divided by the one passed in
    *  @throws UnsupportedOperationException
    */
    public GinormousInt divide( GinormousInt gint ) {

      throw new UnsupportedOperationException( "Sorry, that operation is not yet implemented" );

   }

   /**
   *  Method to determine if a GinormousInt is even
   *  @param  gint         GinormousInt to determine if is even
   *  @return boolean true if GinormousInt input is Even
   */
   public boolean isEven() {

      if ( ( this.intArray[0] % 2 ) == 0 ) {
         return true;
      } else { return false; }

   }

    /**
    *  Method to get the remainder of division of this GinormousInt by the one passed as argument
    *  @param  gint         GinormousInt to divide this one by
    *  @return GinormousInt that is the remainder of division of this GinormousInt by the one passed in
    *  @throws UnsupportedOperationException
    */
    public GinormousInt remainder( GinormousInt value ) {

      throw new UnsupportedOperationException( "Sorry, that operation is not yet implemented" );

   }

    /**
    *  Method to return string representation of this GinormousInt
    *  @return String  which is the String representation of this GinormousInt
    *  @throws UnsupportedOperationException
    */
    public String toString() {

      String result = "";

      if ( this.sign == 1 ) {
         result = result.concat( "-" );
      }

      result = result.concat( stringWithoutSign );

      return result;

   }

    /**
    *  Method to compare a GinormousInt passed as argument to this GinormousInt
    *  @param gint Ginormous Int to compare to
    *  @return int that is one of neg/0/pos if this GinormousInt precedes/equals/follows the argument
    *  @throws UnsupportedOperationException
    */
    public int compareTo( GinormousInt gint ) {

      return ( stringWithoutSign.compareTo( gint.stringWithoutSign ) );

   }

   /**
   *  Method to compare 2 Ginormous Ints passed in as argument
   *  @param g1 Ginormous Int 1
   *  @param g2 Ginormous Int 2
   *  @return int that is one of neg/0/pos if GinormousInt 1 precedes/equals/follows GinormousInt 2
   *  @throws UnsupportedOperationException
   */
   public static int compareTo( GinormousInt g1, GinormousInt g2 ) {

     return ( ( g1.stringWithoutSign ).compareTo( g2.stringWithoutSign ) );

 }

    /**
    *  Method to check if a GinormousInt passed as argument is equal to this GinormousInt
    *  @param gint GinormousInt to compare to this
    *  @return boolean  that is true if they are equal and false otherwise
    *  @throws UnsupportedOperationException
    */
    public boolean equals( GinormousInt gint ) {

      return ( this.toString().equals( gint.toString() ) );

   }

    /**
    *  Method to return a GinormousInt given a long value passed as argument
    *  @param  value         long type number to make into a GinormousInt
    *  @return GinormousInt  which is the GinormousInt representation of the long
    *  @throws NumberFormatException
    */
    public static GinormousInt valueOf( long value ) {

      GinormousInt gi = null;

      try { gi = new GinormousInt( new Long( value ).toString() ); }
      catch( NumberFormatException nfe ) { System.out.println( "Inut must be of type LONG." ); }
      return gi;

   }

    /**
    *  Method to display an Array representation of this GinormousInt as its ints
    */
    public void toArray( int[] i ) {

      System.out.println( Arrays.toString( i ) );
   }


   /**
   *  Main Method redirects user to GinormousIntTester
   */
   public static void main( String[] args ) {

      System.out.println( "Use GinormousIntTester.java for testing!" );

   }

}
