package chapter11;

import java.util.HashSet; 
import java.util.Iterator;

public class HashSetTest1 {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("First");
		hashSet.add("Second");
		hashSet.add("Third");
		hashSet.add("First"); // 같다고 판단되는것은 입력 X --> 무엇을 보고 같다고 판단하는가?
		
		System.out.println("모든 요소의 갯수: " + hashSet.size());
		
		Iterator<String> itr = hashSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()); // 순서를 가지고 있지 않기 때문에 index를 가지고 순차적인 참조 하는 것은 할 수 없다(?)
		}
	
	
	}
}
