package application;

import java.util.Random;
import java.util.Scanner;

import javafx.scene.control.TextArea;

public class GuessingGameController {

	private static PrizeController control = new PrizeController();
	Random rand = 	new Random();//Create the target int for the user to get
	static int goal = 		0;
	static int max_moves = 0;
	
	public static void startGame(){
		//resets number to guess and no of moves
		Random rand = 	new Random();//Create the target int for the user to get
		goal = 		rand.nextInt(50) + 1;
		
		System.out.println("\nYour guessing game goal "+goal);
		
		max_moves = 0;
	}


	public static String guessGame (String guess) {

		String res = "";
		
			//selection from chice box is taken as string, so this changes it to an int
			int useableGuess = Integer.parseInt(guess);


			if(max_moves > 4) {
				res = "To many guesses Game over";
				startGame();
			}

			else if (useableGuess > 50 || useableGuess < 0) {
				res = "Invalid choice please choose another";
			}
			else if (goal == useableGuess) {
				res = "WINNER!!!";
				control.addStar();
				startGame();
			}
			else if (goal > useableGuess) {
				res = "Higher";
				max_moves++;
			}
			else if (goal < useableGuess) {
				res = "Lower";
				max_moves++;
			}
		
		return res;
	}
}

