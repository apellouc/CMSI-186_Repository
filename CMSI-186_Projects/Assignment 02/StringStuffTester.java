/**
 *  File name     :  StringStuffTester.java
 *  Purpose       :  Provides a tester class to test the methods in the StringStuff class
 *  Author        :  Amy Pellouchoud
 *  Date          :  2017-02-02
 *  Description   :  This file provides the tests for the methods in StringStuff.java for Assignment 02
 *                   in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-02-02  A. Pellouchoud  Initial writing
 *  @version 1.2.0  2017-02-07  A. Pellouchoud  Made A BUNCH of tests, worked out compiler issues
 *  @version 1.3.0  2017-02-08  A. Pellouchoud  Made last couple of tests
 */

public class StringStuffTester {

   /**
    * the main method which calls all of the test methods in the StringStuffTester class
    */

   public static void main ( String [] args ) {
      test_containsVowel();    // 3 tests
      test_isPalindrome();     // 7 tests
      test_evensOnly();        // 8 tests
      test_oddsOnly();         // 8 tests
      test_evensOnlyNoDupes(); // 2 tests
      test_oddsOnlyNoDupes();  // 2 tests
      test_reverse();          // 2 tests

   }

   /**
    * this method tests the "containsVowel()" method from the StringStuff class
    */

   static void test_containsVowel() {

      String park             = new String( "I went to the park" );
      String capConsonants    = new String( "QWRTYPLKJHGFDSZXCVBNM" );
      String lowerConsonants  = new String( "qwrtyplkjhgfdszxcvbnm" );


      System.out.println( "\nTESTS FOR containsVowel() :" );

      System.out.print( "Test for string 'I went to the park' : " );
      try { System.out.println( StringStuff.containsVowel( park ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "Test for string 'QWRTYPLKJHGFDSZXCVBNM' : " );
      try { System.out.println( StringStuff.containsVowel( capConsonants ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "Test for string 'qwrtyplkjhgfdszxcvbnm' : " );
      try { System.out.println( StringStuff.containsVowel( lowerConsonants ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }


   }

   /**
    * this method tests the "isPalindrome()" method from the StringStuff class
    */

   static void test_isPalindrome() {

      String pal1 = new String( "a" );
      String pal2 = new String( "ab" );
      String pal3 = new String( "aba" );
      String pal4 = new String( "amanaplanacanalpanama" );
      String pal5 = new String( "abba" );
      String pal6 = new String( "Racecar" );
      String pal7 = new String( "RacecaR" );


      System.out.println( "\nTESTS FOR isPalindrome() : " );

      System.out.print( "Test for string 'a' : " );
      try { System.out.println( StringStuff.isPalindrome( pal1 ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "Test for string 'ab' : " );
      try { System.out.println( StringStuff.isPalindrome( pal2 ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "Test for string 'aba' : " );
      try { System.out.println( StringStuff.isPalindrome( pal3 ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "Test for string 'amanaplanacanalpanama' : " );
      try { System.out.println( StringStuff.isPalindrome( pal4 ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "Test for string 'abba' : " );
      try { System.out.println( StringStuff.isPalindrome( pal5 ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "Test for string 'Racecar' : " );
      try { System.out.println( StringStuff.isPalindrome( pal6 ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "Test for string 'RacecaR' : " );
      try { System.out.println( StringStuff.isPalindrome( pal7 ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

    /**
    * this method tests the "evensOnly()" method from the StringStuff class
    */

   static void test_evensOnly() {

      System.out.println( "\nTESTS for evensOnly() : ");


      System.out.print( "String 'BDFHJLNPRTVXZbdfhjlnprtvxz' returns: " );
      try { System.out.println(StringStuff.evensOnly( "BDFHJLNPRTVXZbdfhjlnprtvxz" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'ACEGIKMOQSUWYacegikmoqsuwy' returns: " );
      try { System.out.println(StringStuff.evensOnly( "ACEGIKMOQSUWYacegikmoqsuwy" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'REHEARSALSZ' returns: ");
      try { System.out.println( StringStuff.evensOnly( "REHEARSALSZ" ) ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'REhearSALsz' returns: ");
      try { System.out.println(StringStuff.evensOnly( "REhearSALsz" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'PhiLanThropic' returns: " );
      try { System.out.println(StringStuff.evensOnly( "PhiLanThropic" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'I ran across campus' returns: " );
      try { System.out.println(StringStuff.evensOnly( "I ran across campus" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'ppppppp' returns: " );
      try { System.out.println(StringStuff.evensOnly( "ppppppp" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String '12345' returns: " );
      try { System.out.println(StringStuff.evensOnly( "12345" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

   }

   /**
    * this method tests the "oddsOnly()" method from the StringStuff class
    */

   static void test_oddsOnly() {

      System.out.println( "\nTESTS for oddsOnly() : " );

      System.out.print( "String 'BDFHJLNPRTVXZbdfhjlnprtvxz' returns: " );
      try { System.out.println(StringStuff.oddsOnly( "BDFHJLNPRTVXZbdfhjlnprtvxz" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'ACEGIKMOQSUWYacegikmoqsuwy' returns: " );
      try { System.out.println(StringStuff.oddsOnly( "ACEGIKMOQSUWYacegikmoqsuwy" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'xylophones' returns: " );
      try { System.out.println(StringStuff.oddsOnly( "xylophones" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'XYloPHonES' returns: " );
      try { System.out.println(StringStuff.oddsOnly( "XYloPHonES" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'evaNescenT' returns: " );
      try { System.out.println(StringStuff.oddsOnly( "evaNescenT" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'I love lambs!' returns: " );
      try { System.out.println(StringStuff.oddsOnly( "I love lambs!" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'ooooooooo' returns: " );
      try { System.out.println(StringStuff.oddsOnly( "ooooooooo" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String '12345' returns: " );
      try { System.out.println(StringStuff.oddsOnly( "12345" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }



   }

   /**
    * this method tests the "evensOnlyNoDupes()" method from the StringStuff class
    */

   static void test_evensOnlyNoDupes() {

      System.out.println( "\nTESTS for evensOnlyNoDupes() : " );

      System.out.print( "String 'BBddHHjj' returns: " );
      try { System.out.println( StringStuff.evensOnlyNoDupes( "BBddHHjj" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'BcdBcdBcd' returns: " );
      try { System.out.println( StringStuff.evensOnlyNoDupes( "BcdBcdBcd" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }


   }

   /**
    * this method tests the "oddsOnlyNoDupes()" method from the StringStuff class
    */

   static void test_oddsOnlyNoDupes() {

      System.out.println( "\nTESTS for oddsOnlyNoDupes() : " );

      System.out.print( "String 'AAccQQww' returns: " );
      try { System.out.println( StringStuff.oddsOnlyNoDupes( "AAccQQww" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'AbcAbcAbc' returns: " );
      try { System.out.println( StringStuff.oddsOnlyNoDupes( "AbcAbcAbc" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }


   }

   /**
    * this method tests the "reverse()" method from the StringStuff class
    */

    static void test_reverse() {

      System.out.println( "\nTESTS for reverse() : " );

      System.out.print( "String 'Racecar' returns : " );
      try { System.out.println(StringStuff.reverse( "Racecar" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.print( "String 'sbmal EVOL I' returns : " );
      try { System.out.println(StringStuff.reverse( "sbmal EVOL I" ) ); }
      catch ( Exception e ) { System.out.println ( false ); }

   }



}
