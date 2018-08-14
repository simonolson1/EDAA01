package textproc;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.*;

import javafx.collections.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
		hbox.getChildren().addAll(button1, button2);
		root.setBottom(hbox);
		
		
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>(); // en lämplig mängd skapas
		while(scan.hasNext()){
			String w = scan.next().toLowerCase();//undantagsorden läggs till i mängden
			stopwords.add(w);
		}
		scan.close();
		
		GeneralWordCounter gwc = new GeneralWordCounter(stopwords);
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			gwc.process(word);
		}
		s.close();
		
		
		ObservableList<Entry<String, Integer>> words= FXCollections.observableArrayList(gwc.getWords());
		ListView<Entry<String, Integer>> listView = new ListView<Entry<String, Integer>>(words);
		root.setCenter(listView);
		}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
