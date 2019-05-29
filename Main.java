/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                   Programming Assignment #2, Part 2                                       *****
 *****___________________________________________________________________________________________________________*****
 *****                                 Part 2: Creating Graphics from User Input                                 *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****     This program will require that you input values from the user via the keyboard (using a Scanner).     *****
 *****                 The input will consist of 3 Strings and several double (or int) values.                   *****
 *****                  In order to display the Strings, place each into its own Text object.                    *****
 *****          The second and third Text objects will have coordinates of 50,350 and 350,350 respectively       *****
 *****                                        (make your Scene 500,500),                                         *****
 *****        the first Text object will be the Node of a Polyline so you do not indicate its coordinates.       *****
 *****                    The double/int values will dictate the coordinates of the Polyline.                    *****
 *****                                                                                                           *****
 *****                   Create a PathTransition variable whose Path will be the Polyline and                    *****
 *****                             whose Node will be the first input Text object.                               *****
 *****    The other two Strings will be used as the Nodes in two RotateTransition objects to spin them around    *****
 *****           (NOTE: see chapter 15 exercise 2 or the javafx API for how to use RotateTransition).            *****
 *****             The PathTransition should autoReverse and the two RotateTransitions should not.               *****
 *****                     Have the RotateTransition objects spin a full 360 degrees and                         *****
 *****                             all three objects should animate indefinitely.                                *****
 *****                              Add the three Texts and Polyline to the Pane.                                *****
 *****                                                                                                           *****
 *****                 To create the Polyline, input all of the double/int values into an array.                 *****
 *****                              Set the array’s initial size to 100 elements.                                *****
 *****              If you only fill a portion of the array, the remaining elements will all be 0s.              *****
 *****                       This will cause your Polyline to include <0,0> as a point.                          *****
 *****                To prevent this, once you have finished inputting all values from the user,                *****
 *****            create a second array whose size is num (the number of int/double values input) and            *****
 *****     use a for loop that iterates from 0 to num to copy from the original array into the second array.     *****
 *****                                                                                                           *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                               For instance, the code might look like this:                                *****
 *****                                                                                                           *****
 *****                                   double[] array2 = new double[num];                                      *****
 *****                                                                                                           *****
 *****                                   for(int i=0;i<num;i++) {                                                *****
 *****                                       array2[i] = array[i];                                               *****
 *****                                   }                                                                       *****
 *****                                                                                                           *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                          Use this second, smaller, array to make your Polyline.                           *****
 *****                       In order to ensure that the Strings are not overly long and                         *****
 *****    that the end points of the Polyline are both within the Scene and do not run into the spinning text,   *****
 *****                            you will create and use two Exception classes:                                 *****
 *****                     TextTooLongException (for Strings greater than 12 characters) and                     *****
 *****         IllegalCoordinateException (for points with a coordinate less than 20 or greater than 350).       *****
 *****                                                                                                           *****
 *****   These two Exception classes should have a no-arg and a 1-arg constructor, similar to what you did in    *****
 *****                                              program #1.                                                  *****
 *****    When inputting a String, if it is too long, throw a TextTooLongException with a useful message that    *****
 *****                                indicates why the Exception was thrown.                                    *****
 *****                              When inputting the values for your Polyline,                                 *****
 *****                   use a while loop which continues while the user enters non-0 values.                    *****
 *****                 If an input value is outside of the legal bounds (< 20 but not 0, > 350),                 *****
 *****                                   throw an IllegalCoordinateException.                                    *****
 *****                The input value for an x-coordinate can be 0, which will terminate the loop,               *****
 *****         but if a valid x-coordinate is input and the y-coordinate is 0 (y is not legal but x is),         *****
 *****                                   throw the IllegalCoordinateException.                                   *****
 *****                                                                                                           *****
 *****          Again, make sure you have a useful message as the parameter of your throw statement.             *****
 *****            Place the code to input the three Strings and the doubles inside a try block and               *****
 *****                             explicitly throw the Exceptions as necessary.                                 *****
 *****                             The catch blocks should follow the try block.                                 *****
 *****                 You can add an additional catch for a NumberFormatException if you desire.                *****
 *****                        After successfully inputting all values, create the Polyline,                      *****
 *****      Text objects, PathTransition and RotateTransition objects, add the Polyline and Text objects to      *****
 *****                   the Pane and start the animation for all three Transition objects.                      *****
 *****                      As the inputs and while loop are all inside of one try block,                        *****
 *****              any Exception thrown will cause the program to discontinue further input and                 *****
 *****                             thus nothing will appear in the pop-up window.                                *****
 *****                                                                                                           *****
 *****                                 An example of my output is shown below.                                   *****
 *****                      There are two screen captures so you can see the Strings rotating.                   *****
 *****                                                                                                           *****
 *****___________________________________________________________________________________________________________*****
 *****                                  Program #2 submission instructions:                                      *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****           Submit all of your source code (the main program and three Exception classes for 2a,            *****
 *****                           the main program and two Exception classes for 2b),                             *****
 *****                the output created running 2a on input files input2.txt and input3.txt, and                *****
 *****           the output of running 2b on whatever input you like that does not throw an Exception.           *****
 *****                   Since these programs generate pop-up windows rather than text output,                   *****
 *****                                use screen captures to obtain each output.                                 *****
 *****               Place all code and output into either a single zip file as or copy all code and             *****
 *****                                 the outputs into a single Word document.                                  *****
 *****                            Email the zip file or Word document to foxr@nku.edu.                           *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;
import javafx.util.*;
import javafx.scene.text.*;



public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage){
        // Create the Pane
        Pane pane = new Pane();

        // Create the Scanner variable to get user input from the keyboard
        Scanner input = new Scanner(System.in);

        // String variable to capture user input
        String userInput = "";

        // String variables used to store user text input
        String input1 = null;
        String input2 = null;
        String input3 = null;

        // Create the int array for the Polyline coordinates, an int counter variable and an int coordinate variable
        int[] numInputs = new int[100];
        int num = 0;
        int coordinate = 0;

        try{
            // Get the first String (the PathTransition one that travels along the Polyline) and
                // store it in a String variable
            System.out.print("(1 of 3) Enter some text (12 characters or less): ");
            userInput = input.nextLine();

            if(userInput.length() > 12){
                throw new TextTooLongException("You entered a String consisting of " + userInput.length() +
                        " characters. The maximum amount of allowed characters is 12");
            }else{
                input1 = userInput;
                userInput = "";
            }

            // Get the second String (spinning text in bottom left corner) and store it in a String variable
            System.out.print("(2 of 3) Enter some text (12 characters or less): ");
            userInput = input.nextLine();

            if(userInput.length() > 12){
                throw new TextTooLongException("You entered a String consisting of " + userInput.length() +
                        " characters. The maximum amount of allowed characters is 12");
            }else{
                input2 = userInput;
                userInput = "";
            }

            // Get the third String (spinning text in bottom right corner) and store it in a String variable
            System.out.print("(3 of 3) Enter some text (12 characters or less): ");
            userInput = input.nextLine();

            if(userInput.length() > 12){
                throw new TextTooLongException("You entered a String consisting of " + userInput.length() +
                        " characters. The maximum amount of allowed characters is 12");
            }else{
                input3 = userInput;
                userInput = "";
            }

            while(!userInput.equals("0")){
                System.out.print("Enter an x-coordinate between 20 and 350 for the Polyline (or \"0\" to quit: ");
                userInput = input.next();

                if(userInput.equals("0")){
                    break;
                }

                if(allDigits(userInput)){
                    coordinate = Integer.parseInt(userInput);

                    if((coordinate < 20) || (coordinate > 350)){
                        throw new IllegalCoordinateException("You entered a x-coordinate value of " + coordinate +
                                ". All coordinates must be between 20 and 350");
                    }else{
                        numInputs[num] = coordinate;
                        num++;
                    }
                } else{
                    throw new NumberFormatException("\"" + userInput + "\" is not a valid integer");
                }

                System.out.print("Enter an y-coordinate between 20 and 350 for the Polyline: ");
                userInput = input.next();

                if(allDigits(userInput)){
                    coordinate = Integer.parseInt(userInput);

                    if((coordinate < 20) || (coordinate > 350)){
                        throw new IllegalCoordinateException("You entered a y-coordinate value of " + coordinate +
                                ". All coordinates must be between 20 and 350");
                    }else{
                        numInputs[num] = coordinate;
                        num++;
                    }
                } else{
                    throw new NumberFormatException("\"" + userInput + "\" is not a valid integer");
                }
            }

            // Create the second array that will be used to create the Polyline
            double[] array2 = new double[num];
            for(int i = 0; i < num; i++){
                array2[i] = numInputs[i];
            }

            // Create the Polyline
            Polyline poly = new Polyline(array2);

            // Create the Text objects (location and text)
            Text text1 = new Text(input1);
            Text text2 = new Text(50, 350, input2);
            Text text3 = new Text(350, 350, input3);

            // Create the PathTransition variable
            PathTransition pt = new PathTransition();

            // Set the first String as a Node. Set the AutoReverse to true, Set the CycleCount to INDEFINITE,
                // Set the Path to the Polyline, Set the Duration and Play the PathTransition
            pt.setNode(text1);
            pt.setAutoReverse(true);
            pt.setCycleCount(Timeline.INDEFINITE);
            pt.setPath(poly);
            pt.setDuration(Duration.millis(4000));
            pt.play();

            // Create the RotateTransition objects
            RotateTransition rt2 = new RotateTransition(Duration.millis(4000), text2);
            RotateTransition rt3 = new RotateTransition(Duration.millis(4000), text3);

            // Set the Angle, CycleCount and AutoReverse and animate the RotateTransition rt2 object
            rt2.setByAngle(360);
            rt2.setCycleCount(Timeline.INDEFINITE);
            rt2.setAutoReverse(false);
            rt2.play();

            // Set the Angle, CycleCount and AutoReverse and animate the RotateTransition rt3 object
            rt3.setByAngle(360);
            rt3.setCycleCount(Timeline.INDEFINITE);
            rt3.setAutoReverse(false);
            rt3.play();

            // Add the Polyline with the PathTransition Text object and RotateTransition Text objects to the Pane
            pane.getChildren().addAll(text1,text2, text3, poly);

            // Set the Scene, Set the Title, Set the Scene to the Stage and show the Stage
            Scene scene = new Scene(pane, 500, 500);
            primaryStage.setTitle("Ryan Huffman: Part 2: Creating Graphics from User Input ");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(TextTooLongException ttlExc){
            System.out.println(ttlExc);
        }
        catch(IllegalCoordinateException corExc){
            System.out.println(corExc);
        }
        catch(NumberFormatException numExc){
            System.out.println(numExc);
        }
    }


    // boolean method to return whether a String is made up entirely of integers.
    private static boolean allDigits(String str){

        // boolean variable to find out if the passed in string contains only integers.
        boolean allDigits = true;

        // for loop to test that all the characters that should be digits, are digits
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                allDigits = false;
            }
        }

        // returns true or false on whether all the digits that should have been digits were digits
        return allDigits;
    }
}
