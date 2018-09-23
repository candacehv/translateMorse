/**
* This program will prompt user to enter input in English or Morse code
* and then translate it to the other based on user selcections. It will
* use string arrays to store the values of the English text and Morse
* code values in a 2d array crosswalk.
*
* This program will satisfy 605.201.82 Module 5 Assignment.
*
* @author Candace Holcombe-Volke
*
*
*/

import java.util.Scanner;


public class TranslateMorse2
{
    /**
     * The main method creates a scanner and collects user input about 
     * what type of translation they need, and provides an option to 
     * exit the program. 
     * 
     * @param choice determines whether the translation will be made from 
     * English text to Morse code, or vice versa
     * 
     * precondition: choice must be an integer of 1, 2 or 3
     * postcondition: based on the user's selction, this method will
     * invoke getUserInput English or getUserInputMorseCode
     * 
     * @author Candace Holcombe-Volke
     */
    public static void main( String [] args )
    {
        // Create scanner to collect user input for which translation
        Scanner input = new Scanner( System.in ); 
        System.out.println( "Press 1 to Translate English to Morse." );
        System.out.println( "Press 2 to Translate Morse to English." );
        System.out.println( "Press 3 to quit." );
        int choice = input.nextInt();
        
        // Escape program on choice 3
        if( choice == 3 )
        {
            return;  // quit the program
        }

        // Error if not a valid selection, re input
        while( choice != 1 && choice != 2 && choice != 3 )
        {
            // Prompt user to re enter a valid selection
            System.out.println( 
            "Invalid. Please make a valid selection." );
            // Store newest user input
            choice = input.nextInt();
        }


        // Determine which way to translate from user input
        while( choice == 1 || choice == 2 )
        {
            switch ( choice )
            {
                // Engilsh text to Morse code
                case 1:
                    System.out.println(
                        translateIntoMorse( getUserInputEnglishText() ) );
                    System.out.println();
                    break;

                // Morse code to English, invoke getUserInputMorseCode  method
                case 2:
                    System.out.println(
                        translateIntoEnglish( getUserInputMorseCode() ) );
                        System.out.println();

                    break;
            }

        // Option to repeat after translation or quit program
        System.out.println( "Press 1 to Translate English to Morse." );
        System.out.println( "Press 2 to Translate Morse to English." );
        System.out.println( "Press 3 to quit." );

        // Update user choice to continue or quit after translation
        choice = input.nextInt();
        } // eEd while loop
    }  // End of main()
    
    /**
     * This method collects user input through creating a scanner, 
     * converts the input to upper case letters and returns the value
     * of the original English text input.
     *
     * @param scanner english collect user English text
     * @param origEnglish is the original English input
     * 
     * precondition: origEnglish is a string when entered
     * postcondition: origEnglish is returned as upper case
     * 
     * @author Candace Holcombe-Volke
     * 
     */

    // Collect user input of English text
    public static String getUserInputEnglishText()
    { 
        Scanner english = new Scanner ( System.in ); // create scanner
        System.out.println( "Enter your English text now. Separate"           
        + " each word with one space, and ignore punctuation.");

        String origEnglish = english.nextLine(); // English text into String
        origEnglish = origEnglish.toUpperCase(); // convert to upper case
        return origEnglish;   // now all upper case
    }  // End getUserInputEnglishText




    /**
     * This method takes in the origEnglish return from the 
     * getUserInputEnglishText method and replaces the English
     * text with the associated Morse code from the conversionCrosswalk
     * array. 
     * 
     * @param conversionCrosswalk is a 2d String array with the first array
     * holding the English values and the second array holding the 
     * corresponding Morse values. 
     * @param lookupLtr is the letter currently being looked for in the input
     * @param replacemenLtr is the reference to the location in the 
     * conversionCrosswalk that has the replacement Morse code
     * @param i is used for loop control
     *
     * precondition: i is an int and starts at 0
     * postcondition: englishText values will be replaced with morse codes
     * postcondition: i will be increased to 37 as it loops trhough all array 
     * elements
     *
     * @author Candace Holcombe-Volke
     */

    public static String translateIntoMorse( String englishText )
    {
        // create 2d arrays crosswalk values for English and Morse
        String [][] conversionCrosswalk = {{" ", "A", "B", "C", "D", "E", "F", 
        "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
        "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", 
        "9", "0" }, { "|", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", 
        "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", 
        "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", 
        "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
        "---..", "----.", "-----" }};

        int i = 0; // to control loop
        while( i <= 36 ) // stay within the size of each dimension of the array
        {
            // Search for this 
            String lookupLtr = conversionCrosswalk[0][i]; 
            // Replace with this
            String replacementLrt = conversionCrosswalk[1][i]; 
            // Perform replacement
            englishText = englishText.replace(
                lookupLtr, replacementLrt + " " ); // now updated text
            i++;  // search for next english value from array
        }
        return englishText;  // The result
    }  // End translateIntoMorse()

    /**
     * This method collects user input through creating a scanner, 
     * and returns the value of the original morse code input.
     *
     * @param scanner morse collect user morse code input
     * @param morseCode is the original morse input
     * 
     * precondition: each morse input letter is separated by a space
     * and words are separated by |. 
     *
     * postcondition: An extra space is added to the end of 
     * the input for later indexing and 
     * substring creation. morseCode is returned
     * translatIntoEnglish is invoked
     * 
     * @author Candace Holcombe-Volke
     * 
     */

    // Collect user input of Morse code
    public static String getUserInputMorseCode()
    {
        // Create scanner to get morse code input
        Scanner morse = new Scanner ( System.in );
        System.out.println( "Enter your Morse Code now. Separate"           
        + " each letter with one space, each word with ' | ' and ignore " + 
        "punctuation.");
        
        // collect all input to string
        String morseCode = morse.nextLine(); 

        // add space at the end of input
        morseCode = morseCode + " "; 
       
        translateIntoEnglish( morseCode ); // Pass to next method to convert
        return morseCode;

    }  // End getUserInputMorseCode()


    /** 
     * This method translates the morse code input into English based on the 
     * conversionCrosswalk array. First it creates a substring of the morse 
     * code based on the index of the next space in the input. Then it 
     * compares the substring to the conversionCrosswalk to find the matching 
     * element in the array. Then it converts it to the English character 
     * based on the corresponding location (determined by the i value 
     * of the matching morse location in the array)
     * 
     * @param i used to control loop and determine location within 
     * conversion crosswalk
     * @param morseCodeTranslated string created from appending replacement
     * english letters in place of Morse code
     * @param lastIndex the final space in the original Morse code, that is 
     * added. Used to control the loop and end when last index of space is 
     * equal to the length of the morse code input.
     * @param currentIndex is the index number of the next spacebar, and 
     * the one in the current substring iteration. Also controls end of loop
     * @param lookupCode is the substring created from the morse string 
     * between two spaces and is compared to conversionCrosswalk array values
     * 
     * preconditions: i, spaceIndex, lastIndex, currentIndex are int
     * preconditions: others are Strings
     * postcondition: i increased up to 36 in process of loops, then reset to 0
     * postcondition: currentIndex increases to length of morse code input
     * postcondition: morse is converted to English through the 
     * conversionCrosswalk array 
     * 
     * @author Candace Holcombe-Volke
     * 
     */   

    public static String translateIntoEnglish( String morseCode )
    {
        String [][] conversionCrosswalk = {{" ", "A", "B", "C", "D", "E", "F", 
        "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
        "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", 
        "9", "0" }, { "|", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", 
        "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", 
        "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", 
        "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
        "---..", "----.", "-----" }};


        int i = 0; //Controls loop within conversion arra
        String morseCodeTranslated = ""; // Initialize final result
        String lookupCode = " ";  // Initialize intermediary variable


        // index of end of last morse letter code substring
        int lastIndex = 0;  

        // Reset starting point to reindex and substring starting point
        int currentIndex = morseCode.indexOf( ' ', lastIndex ); 
        while ( currentIndex != -1 ) // -1 notes outside bounds of input
        {
            // Create substring for current morse pattern to find translation
            lookupCode = morseCode.substring( lastIndex, currentIndex );

            while( i <= 36 ) // Within conversion array
                {
                    // If Morse pattern matches conversion array element:
                    if ( lookupCode.compareTo( 
                        conversionCrosswalk[1][i] ) == 0 )
                    {
                        // Append conversion array element to result 
                        morseCodeTranslated = morseCodeTranslated + 
                            conversionCrosswalk[0][i];
                        break;
                    }
                    else
                    {
                        // Check next conversion element
                        i++;
                    }
                } 

                i = 0; // Reset loop control, start conversion array at 0 elem

            // Move index starting point up
            lastIndex = ( currentIndex + 1 ); 

            // Get next space
            currentIndex = morseCode.indexOf( ' ', lastIndex ); 

        } // End of user input, all letters translated
        
        return morseCodeTranslated; // Return the result
    } // End of translatIntoEnglish()
}// End of program