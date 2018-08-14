package textproc;
import java.util.*;
import java.util.Map.Entry;

public class WordCountComparator implements Comparator<Map.Entry<String,Integer>>{

	@Override
	public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
		if (arg0.getValue() > arg1.getValue()){
			return -1;
		}
		else if(arg0.getValue() < arg1.getValue()){
			return 1;
		}
		else {
		return arg0.getKey().compareTo(arg1.getKey()) ;
	}
	}	

}
