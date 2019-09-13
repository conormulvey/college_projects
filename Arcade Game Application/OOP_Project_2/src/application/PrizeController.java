package application;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PrizeController {

	private static List<String> starList = new ArrayList<String>();
	static HashMap<String, String> hm = new HashMap<String, String>();

	public void PrizeController() throws Exception{

	}

	public static List<String> addStar(){

		starList.add("*");

		System.out.print(starList);

		return starList;
	}

	public static HashMap<String,String> makeHashMap(){

		HashMap<String, String> hm = new HashMap<String, String>(); 

		//when making hashmap, check how many stars in starList to determine what goes in hashmap
		if (starList.size() >= 5){
			hm.put("Apple", "100"); 
			hm.put("Pear", "1000"); 
			hm.put("Banana", "Trip");
		}
		else if (starList.size() == 4){
			hm.put("Apple", "100"); 
			hm.put("Pear", "1000");
		}
		else if (starList.size() == 3){
			hm.put("Apple", "100"); 
		}

		return hm;
	}
	//check if pick matches with any element in the hash map, then displays the corresponding value value
	public static String showPrize(HashMap hm,String pick){

		try{
			String res = "";

			if (hm.containsKey(pick)){
				Object toConvert = hm.get(pick);
				res = toConvert.toString();
			}
			else{
				res = "Invalid choice";
			}

			return res;}

		catch(Exception e){
			return "Invalid entry";
		}

	}

}



