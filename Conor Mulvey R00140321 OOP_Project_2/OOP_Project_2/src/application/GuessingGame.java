package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;	
import java.util.Scanner;  // Import the Scanner class
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class GuessingGame extends Tab {

	Stage window;
	Button button;
	private GuessingGameController control = new GuessingGameController();
	TextArea resultArea = new TextArea();
	int max_moves = 0;


	public GuessingGame() {
		setText("Guessing");
		control = new GuessingGameController();
		FlowPane fp = new FlowPane();
		control.startGame();
		
		resultArea.setText("Please choose a number using the choice box");

		ChoiceBox firstChoiceBox = new ChoiceBox();

		firstChoiceBox.getItems().add("0");
		firstChoiceBox.getItems().add("1");
		firstChoiceBox.getItems().add("2");
		firstChoiceBox.getItems().add("3");
		firstChoiceBox.getItems().add("4");
		firstChoiceBox.getItems().add("5");
		firstChoiceBox.getItems().add("6");
		firstChoiceBox.getItems().add("7");
		firstChoiceBox.getItems().add("8");
		firstChoiceBox.getItems().add("9");

		HBox hbox = new HBox(firstChoiceBox);

		ChoiceBox secondChoiceBox = new ChoiceBox();

		secondChoiceBox.getItems().add("0");
		secondChoiceBox.getItems().add("1");
		secondChoiceBox.getItems().add("2");
		secondChoiceBox.getItems().add("3");
		secondChoiceBox.getItems().add("4");
		secondChoiceBox.getItems().add("5");
		secondChoiceBox.getItems().add("6");
		secondChoiceBox.getItems().add("7");
		secondChoiceBox.getItems().add("8");
		secondChoiceBox.getItems().add("9");

		HBox hbox2 = new HBox(secondChoiceBox);

		Button button = new Button("Click to place guess");
		button.setOnAction(action -> {
			String value = (String) secondChoiceBox.getValue() + (String) firstChoiceBox.getValue();
			resultArea.setText(value+" "+control.guessGame(value));
		});
		
		Button resetButton = new Button("Reset");
		resetButton.setOnAction(action -> {
			control.startGame();
			resultArea.setText("Please choose a number using the choice box");
		});
		

		fp.getChildren().add(secondChoiceBox);
		fp.getChildren().add(firstChoiceBox);
		fp.getChildren().add(resultArea);
		fp.getChildren().add(button);
		fp.getChildren().add(resetButton);

		setContent(fp);

	}



}





