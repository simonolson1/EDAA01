package Sudoko;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SudokoSolverController extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		int xaxis = 450;
		int yaxis = 450;
		
		HBox hbox = new HBox(8);
		Button button1 = new Button("Solve");
		Button button2 = new Button("Clear");
		hbox.getChildren().addAll(button1, button2);
		
		
		TilePane tile = new TilePane();
				
		for (int i = 0; i < 81; i++){
			TextField textBox = new TextField();
			textBox.setPrefWidth(xaxis/9);
			textBox.setPrefHeight(yaxis/9);
			
			tile.getChildren().add(textBox);
		}
		
		
		BorderPane root = new BorderPane();
		root.setCenter(tile);
		root.setBottom(hbox);
		
		button1.setOnAction(event -> {
			
		});
		button2.setOnAction(event -> {
			
		});
		
		Scene scene = new Scene(root, xaxis, yaxis + 25);
		primaryStage.setTitle("SudokoSolver");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
