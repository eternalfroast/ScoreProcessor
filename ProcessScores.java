/**
@author:Saurav Pradhan

In each round teams play against each other and the score of each team 
is recorded as an integer and kept in the text file referred to above (afl.txt)

It is a a complete java program (a java class with the main method) called ProcessScores, which will read 
the scores from the text file provided, store the scores in an array of integers and then using a 
number of independent static methods, calculate and display the required statistics relating the afl scores. 
**/



//importing the necessary libraries
import java.util.*;
import java.io.*;

//ProcessScores is the main method of this java program
public class ProcessScores {

	//declaring and assigning the constant based on the data provided. 
	/*League consists of 18 football teams
	There are 22 rounds in each season*/

	public static final int FOOTBALL_PLAYERS = 18;
	public static final int ROUNDS_IN_SESSION = 22;
	
	//declaring the integer array to store the number extracted from the file
	static int[] aflScores;


	public static void main(String [] args) throws Exception{

		//creating an object to get the data from
		File afl = new File("afl.txt");

		//using scanner to importing the data from afl.txt
		Scanner input = new Scanner(afl);  

		//assigning the size of the integer array based on the data from the interact                              
		aflScores = new int[FOOTBALL_PLAYERS * ROUNDS_IN_SESSION];


		//start of the while loop to extract the data from the file line by line
		while (input.hasNext()){

			//implementing the for loop to get the data one by one and store in the array 
			for(int fileLineCounter = 0; fileLineCounter < aflScores.length; fileLineCounter++){
				aflScores[fileLineCounter] = input.nextInt();
			}//end of the for loop

			//displaying the lowest score to the user taking aflScore as argument
			System.out.println("\nCalculating lowest score in the session\n");
			System.out.println("The lowest among all the scores is: " + lowest(aflScores));
			System.out.println("Lowest score in the session is calculated\n");


			//displaying the highest score to the user taking aflScore as argument
			System.out.println("\nCalculating highest scores in the session\n");
			System.out.println("The highest among all the scores is: " + highest(aflScores));
			System.out.println("Highest score in the session is calculated\n");


			//displaying the range  to the user taking aflScore as argument
			System.out.println("\nCalculating range of scores in the session\n");
			System.out.println(range(aflScores));
			System.out.println("Range of the session is calculated\n");

			//displaying the average to the user taking aflScore as argument
			System.out.println("\nCalculating average of scores in the session\n");
			System.out.println("The average is: " + average(aflScores));
			System.out.println("Average of the session is calculated\n");

			//displaying the median to the user taking aflScore as argument
			System.out.println("\nCalculating median of scores in the session\n");
			System.out.println(median(aflScores));
			System.out.println("Median of the session is calculated\n");

			//displaying the mode to the user taking aflScore as argument
			System.out.println("\nCalculating mode of scores in the session\n");
			System.out.println(mode(aflScores));
			System.out.println("Mode of the session is calculated\n");
			
			

		}

	
	}


	//static method for taking array of scores as an argument and return the lowest score in the season
	public static int lowest(int[] inputArray){

		int minimum = inputArray[0]; //assigning the value of the integer minimum

		/*setting up for loop for calculating the lowest score among all the score by going through
		all the individual score and comparing with the assigned minimum*/

		for (int countForMinimum = 1; countForMinimum < inputArray.length; countForMinimum ++){
			if(inputArray[countForMinimum] < minimum){
				minimum = inputArray[countForMinimum];
			}
		}//end of the for loop

		return(minimum); // returning the minimum in the integer form
	}//end of minimum method

	//static method for taking array of scores as an argument and return the highest score in the season
	public static int highest(int[] inputArray){

		int highest = inputArray[0];

		/*setting up for loop for calculating the highest score among all the score by going through
		all the individual score and comparing with the assigned minimum*/
		for (int countForHighest = 1; countForHighest < inputArray.length; countForHighest ++){
			if(inputArray[countForHighest] > highest){
				highest = inputArray[countForHighest];
			}
		}

		return(highest); // returning the highest in the integer form
	}//end of highest method

	public static String range(int[] inputArray){
		Arrays.sort(inputArray); // sorting array in the ascending order 

		//displaying the message to the user to notify that sorting is initated
		System.out.println("Sorting the numbers in asceding order:\n");


		//start of the foor loop for displaying the sorted array

		//sorted data are individually displayed followed by comma
		for (int countForRange = 0; countForRange<=inputArray.length -1; countForRange++){
				
				//this if statement makes sure that there will be no comma after final number in sorting 
				if (inputArray[countForRange] == inputArray[inputArray.length-1]){
					System.out.print(inputArray[inputArray.length-1]);
					break;
				} // end of the if statement

				String stored = (inputArray[countForRange] + ","); /*the sorted data is stored in String stored*/
				System.out.print(stored); //finally the sorted data is shown to the user
		}
		
		//the range formula
		/*for range the last sorted data and the first data in the array is substracted.*/
		int range = inputArray[inputArray.length - 1]-inputArray[0];

		return("\n\nThe range is:"+ range ); //returning the range in String form
	}//end of range method