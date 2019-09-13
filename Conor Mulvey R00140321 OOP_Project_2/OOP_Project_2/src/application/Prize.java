package application;

import java.io.FileReader;

import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Prize extends Tab{
	Stage window;
	Button button;
	TextArea resultArea = new TextArea();
	private PrizeController control = new PrizeController();

	public Prize() throws Exception{
		setText("Prize");
		FlowPane fp = new FlowPane();
		control = new PrizeController();
		
		Label label = new Label("Pick a fruit and type in your answer-->\nApple \tPear \tBanana");
		
		Button button = new Button("Click to get your prize");
		button.setOnAction(action -> {
			resultArea.setText(control.showPrize(control.makeHashMap(),resultArea.getText()));
		});
			
		fp.getChildren().add(button);
		fp.getChildren().add(resultArea);
		fp.getChildren().add(label);
		
		setContent(fp);
	} 
	
}




