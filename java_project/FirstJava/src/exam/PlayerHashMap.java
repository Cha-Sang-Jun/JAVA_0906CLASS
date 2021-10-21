package exam;

import java.util.HashMap;
import java.util.Iterator;

public class PlayerHashMap {
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "손흥민");
		map.put(2, "이강인");
		map.put(3, "황희찬");
		map.put(5, "박주영");
		
		Iterator<Integer> itr = map.keySet().iterator();
		
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
			
		}
	}
}
