package textproc;

import java.util.*;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> karta;

	public MultiWordCounter(String[] words) {
		karta = new HashMap<String, Integer>();
		int k = words.length;
		for (int i = 0; i < k; i++){
			karta.put(words[i], 0);
		}
	}

	public void process(String word) {
		if (karta.containsKey(word)) {
			int a = karta.get(word);
			karta.put(word, a + 1);
		}
	}

	public void report() {
		for (String key : karta.keySet()) {
			System.out.println(key + ": " + karta.get(key));
		}
	}
}
