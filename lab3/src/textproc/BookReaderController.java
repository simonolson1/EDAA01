package textproc;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import javafx.collections.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BookReaderController extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();

		HBox hbox = new HBox(8);
		Button button1 = new Button("Alphabetic");
		Button button2 = new Button("Frequency");
		Button button3 = new Button("Go");
		button3.setDefaultButton(true);
		TextField field = new TextField();
		hbox.getChildren().addAll(button1, button2, field, button3);
		root.setBottom(hbox);

		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>(); // en lämplig mängd
														// skapas
		while (scan.hasNext()) {
			String w = scan.next().toLowerCase();// undantagsorden läggs till i
													// mängden
			stopwords.add(w);
		}
		scan.close();

		GeneralWordCounter gwc = new GeneralWordCounter(stopwords);// skapar gwc
																	// object

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		while (s.hasNext()) {
			String word = s.next().toLowerCase();// Läser in boken
			gwc.process(word);
		}
		s.close();

		ObservableList<Entry<String, Integer>> words = FXCollections.observableArrayList(gwc.getWords());
		ListView<Entry<String, Integer>> listView = new ListView<Entry<String, Integer>>(words);
		root.setCenter(listView);// Observable list skapas ovan

		button1.setOnAction(event -> {
			AlphabeticalComparator c = new AlphabeticalComparator();
			words.sort(c);
		});

		button2.setOnAction(event -> {
			WordCountComparator c = new WordCountComparator();
			words.sort(c);
		});

		button3.setOnAction(event -> {
			String text = field.getText();
			int size = words.size();
			int j = -1;
			for (int i = 0; i < size; i++) {
				if (words.get(i).getKey().equals(text)) {
					j = i;
					break;
				}
			}
			if(j == -1){
				Alert alert = new Alert(AlertType.ERROR, "Ord finns ej i bok");
				alert.showAndWait();
			}
			listView.getSelectionModel().select(j);
			listView.scrollTo(j);
		});

		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
