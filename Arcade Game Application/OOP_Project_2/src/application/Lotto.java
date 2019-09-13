package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;

public class Lotto extends Tab {

	Stage window;
	Button button;
	TextArea resultArea = new TextArea();
	private LottoController control = new LottoController();
	private static List<Integer> guessList = new ArrayList<Integer>();
	private static List<Integer> randomNumList = new ArrayList<Integer>();
	
	public Lotto(){
		setText("Lottery");
		FlowPane fp = new FlowPane();
		
		//creates an arrayList of random numbers
		randomNumList = control.createLottoNumber();
		
		resultArea.setText("Please select five numbers");
		
		
		//when this button is clicked, send its value to a new method in LottoController
		Button button1 = new Button("1");
		button1.setOnAction(action -> {
			guessList = control.createGuessNumber(guessList,1);});
			
		
		Button button2 = new Button("2");
		button2.setOnAction(action -> {
			guessList = control.createGuessNumber(guessList,2);});
		
		Button button3 = new Button("3");
		button3.setOnAction(action -> {
			guessList = control.createGuessNumber(guessList,3);});
		
		Button button4 = new Button("4");
		button4.setOnAction(action -> {
			guessList = control.createGuessNumber(guessList,4);});
		
		Button button5 = new Button("5");
		button5.setOnAction(action -> {
			guessList = control.createGuessNumber(guessList,5);});
		
		Button button6 = new Button("6");
		button6.setOnAction(action -> {
			guessList = control.createGuessNumber(guessList,6);});
		
		Button button7 = new Button("7");
		button7.setOnAction(action -> {
			guessList = control.createGuessNumber(guessList,7);});
		
		Button button8 = new Button("8");
		button8.setOnAction(action -> {
			guessList = control.createGuessNumber(guessList,8);});
		
		Button button9 = new Button("9");
		button9.setOnAction(action -> {
			guessList = control.createGuessNumber(guessList,9);});
		
		Button button = new Button("Click to place a guess");
		button.setOnAction(action -> {
			resultArea.setText(control.lottoGame(guessList,randomNumList));
		});
		
		
		fp.getChildren().add(resultArea);
		fp.getChildren().add(button);
		fp.getChildren().add(button1);
		fp.getChildren().add(button2);
		fp.getChildren().add(button3);
		fp.getChildren().add(button4);
		fp.getChildren().add(button5);
		fp.getChildren().add(button6);
		fp.getChildren().add(button7);
		fp.getChildren().add(button8);
		fp.getChildren().add(button9);
		
		
		setContent(fp);
	}
}

