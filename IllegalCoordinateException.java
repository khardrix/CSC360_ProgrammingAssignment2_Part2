/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                       Programming Assignment #2                                           *****
 *****                                               Part 2                                                      *****
 *****                                 Exception : IllegalCoordinateException                                    *****
 *****___________________________________________________________________________________________________________*****
 *****                        The IllegalCoordinateException will require two constructors,                      *****
 *****                  a no-arg constructor which will simply do super(“some useful message”);                  *****
 *****                      such as “Point with coordinate less than 20 or greater than 350”;                    *****
 *****                                                                                                           *****
 *****                      A 1-arg constructor which will pass on the message it receives.                      *****
 *****    The IllegalCoordinateException arises for points with a coordinate less than 20 or greater than 350.   *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// Exception class that extends Exception, used to handle when the user inputs coordinates for a point that are
    // either less than 20 or greater than 350
public class IllegalCoordinateException extends Exception {


    // No-arg constructor for IllegalCoordinateException used to provide a default IllegalCoordinateException message
        // to the parent Exception class
    public IllegalCoordinateException(){
        super("Point with coordinate less than 20 or greater than 350");
    }


    // 1-arg constructor for IllegalCoordinateException used to send a passed in String parameter message to the
        // to the parent Exception class
    public IllegalCoordinateException(String message){
        super(message);
    }
}
