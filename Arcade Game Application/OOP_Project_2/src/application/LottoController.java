package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LottoController {
	private static Random rand = 	new Random();//Create the target int for the user to get
	private static List<String> randomNum = new ArrayList<String>();
	private static PrizeController control = new PrizeController();

	
	public static String lottoGame(List<Integer> guess, List<Integer> randomNum) {
		String res = "";
		int score = 0;
		
		if ( guess.size() > 5){
			res = "Please choose only 5 numbers";
		}
		
		else{
		//compare each element in randomNum the element in useableGuess
		for (int position = 0;position < 5;position++) {
			if(randomNum.get(position) == guess.get(position)) {
				score++;
			}
		}
		
		if (score == 4) {
			res = "Four star prize";
			for(int i = 0;i<4;i++){
				control.addStar();
				}
		}
		else if (score == 5) {
			res ="Five star prize";
			for(int i = 0;i<5;i++){
				control.addStar();
				}
		}
		}
		
		return res;
	}
	
	public static List<Integer> createLottoNumber() {
		List<Integer> res = new ArrayList<Integer>();
		
		//while position is less than 5, make a new random number and add it to array res
		for (int position = 0;position < 5;position++) {
			int goal = 		rand.nextInt(8) + 1;
			res.add(goal);
		}
		System.out.print("Your lotto game goal "+res);
		return res;
	}
	
	//adds whatever number is selected to arrayList then returns the new list
	public static List<Integer> createGuessNumber(List<Integer> guessList,int guess){
		List<Integer> res = new ArrayList<Integer>();

		res = guessList;
		res.add(guess);

		return res;
	}

}

