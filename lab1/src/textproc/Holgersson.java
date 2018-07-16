package textproc;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		List<TextProcessor> nbrs = new ArrayList<TextProcessor>();
		TextProcessor p1 = new SingleWordCounter("nils");
		TextProcessor p2 = new SingleWordCounter("norge");
		nbrs.add(p1);
		nbrs.add(p2);
		
		TextProcessor p3 = new MultiWordCounter(REGIONS);
		nbrs.add(p3);
		
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>(); // en lämplig mängd skapas
		while(scan.hasNext()){
			String w = scan.next().toLowerCase();//undantagsorden läggs till i mängden
			stopwords.add(w);
		}
		scan.close();
		
		TextProcessor p4 = new GeneralWordCounter(stopwords);
		nbrs.add(p4);
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			for(TextProcessor a : nbrs){
			a.process(word);
			}
		}

		s.close();
		for(TextProcessor b : nbrs){
			b.report();
		}
	}
}