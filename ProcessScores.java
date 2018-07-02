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


	