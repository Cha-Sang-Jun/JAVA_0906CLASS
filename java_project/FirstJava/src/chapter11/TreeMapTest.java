package chapter11;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
		// 데이터 저장
		map.put(1, "AAA");
		map.put(5, "EEE");
		map.put(3, "CCC");
		map.put(2, "BBB");
		map.put(4, "DDD");
		
		NavigableSet<Integer> navi = map.navigableKeySet();
		
		System.out.println("key 값의 오름차순 출력");
		
		Iterator<Integer> itr = navi.iterator();
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
		
		System.out.println("---------------------------");
		
		System.out.println("key 값의 내림차순 출력");
		
		itr = navi.descendingIterator(); // 역순으로 -> key값이 역으로 들어간다.
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
	
	
	}
}
