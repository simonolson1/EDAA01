package Sudoko;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
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

		boolean switchColor = true;
		Paint value0 = Paint.valueOf("ff8668"); // bakgrundsfärg

		for (int i = 1; i <= 81; i++) {
			OneNumberTextField textBox = new OneNumberTextField();
			textBox.setPrefWidth(xaxis / 9);
			textBox.setPrefHeight(yaxis / 9);
			if (switchColor) {
				textBox.setStyle("-fx-control-inner-background: #" + value0.toString().substring(2));
			}

			if (i % 3 == 0) {
				switchColor = !switchColor;
			}
			if (i % 9 == 0) { // inte min vackraste kod
				if (i == 27 || i == 36 || i == 45) {
					switchColor = false;
				} else {
					switchColor = true;
				}
			}
			tile.getChildren().add(textBox);
		}

		BorderPane root = new BorderPane();
		root.setCenter(tile);
		root.setBottom(hbox);

		button1.setOnAction(event -> {
			SudokoSolver s = new SudokoSolver(getMatrix(tile));
			s.solve();
			
			
		 	/*int[][]testmatris = getMatrix(tile);
			System.out.println(testmatris[0][0]);
			System.out.println(testmatris[0][1]);
			System.out.println(testmatris[0][2]);
			System.out.println(testmatris[0][3]);
			System.out.println(testmatris[8][8]);*/
			
		});
		button2.setOnAction(event -> {
			clear(tile);
		});

		Scene scene = new Scene(root, xaxis, yaxis + 25);
		primaryStage.setTitle("SudokoSolver");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void clear(TilePane tile){
		for (Node node : tile.getChildren()) {
		    if (node instanceof OneNumberTextField) {
		        ((OneNumberTextField)node).setText("");
		    }
		}
	}
	private int[][] getMatrix(TilePane tile){
		int [][] sudokoMatrix = new int [9][9];
		int counter = 0;
		int b;
		for(Node node : tile.getChildren()){
			if(node instanceof OneNumberTextField){
				String a = ((OneNumberTextField) node).getText();
				if(a.equals("")){
					b = 0;
				}
				else{
					b = Integer.parseInt(a);
				}
				sudokoMatrix [(counter%9)][(counter/9)] = b;
			}
			counter++;
		}
		return sudokoMatrix;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
