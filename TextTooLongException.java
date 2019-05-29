/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                       Programming Assignment #2                                           *****
 *****                                               Part 2                                                      *****
 *****                                    Exception : TextTooLongException                                       *****
 *****___________________________________________________________________________________________________________*****
 *****                         T he TextTooLongException will require two constructors,                          *****
 *****                  a no-arg constructor which will simply do super(“some useful message”);                  *****
 *****                              such as “Text input was too many characters”;                                *****
 *****                                                                                                           *****
 *****                      A 1-arg constructor which will pass on the message it receives.                      *****
 *****          The TextTooLongException arises if the user inputs a Sting longer than 12 characters.            *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// Exception class that extends Exception, used to handle when the user inputs a String longer than 12 characters,
    // when the user is prompted to enter one of three Strings
public class TextTooLongException extends Exception {


    // No-arg constructor for TextTooLongException used to provide a default TextTooLongException message
        // to the parent Exception class
    public TextTooLongException(){
        super("Text input was too many characters");
    }


    // 1-arg constructor for TextTooLongException used to send a passed in String parameter message to the
        // to the parent Exception class
    public TextTooLongException(String message){
        super(message);
    }
}
