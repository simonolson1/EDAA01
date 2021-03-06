package textproc;

import java.util.*;
import java.util.Map.Entry;

public class GeneralWordCounter implements TextProcessor {
	private Map<String, Integer> karta2;
	private Set<String> ban;

	public GeneralWordCounter(Set<String> words) {
		karta2 = new HashMap<String, Integer>();
		this.ban = words;
	}

	public void process(String word) {
		if (ban.contains(word)) {
		} else if (karta2.containsKey(word)) {
			int a = karta2.get(word);
			karta2.put(word, a + 1);
		} else {
			karta2.put(word, 1);
		}
	}

	public void report() {
		/*
		 * for (String key : karta2.keySet()) { if (karta2.get(key) >= 200)
		 * System.out.println(key + ": " + karta2.get(key));
		 */

		Set<Map.Entry<String, Integer>> wordSet = karta2.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());
		for (int i = 0; i < 50; i++) {
			System.out.println(wordList.get(i));
		}
	}
	

	public Set<Entry<String, Integer>> getWords() {
		return karta2.entrySet();
	}
}
