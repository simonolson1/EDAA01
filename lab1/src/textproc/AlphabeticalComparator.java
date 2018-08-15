package textproc;
import java.util.*;
import java.util.Map.Entry;

public class AlphabeticalComparator  implements Comparator<Map.Entry<String,Integer>>{

	@Override
	public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
		return arg0.getKey().compareTo(arg1.getKey()) ;
	}
	}	