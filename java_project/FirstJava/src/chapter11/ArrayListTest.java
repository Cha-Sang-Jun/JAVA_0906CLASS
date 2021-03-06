package chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {

		ArrayList<Integer> list = null;

		list = new ArrayList<Integer>(); // 변수타입 Integer는 생략 가능 -> ArrayList<Integer> 로 앞에서 정의해 놨기때문에

		List<Integer> list2 = new ArrayList<Integer>();

		// 데이터(인스턴스) 저장 : add(E e)
		list.add(new Integer(1));
		list.add(10); // new Integer(10) Auto Boxing
		// wrapper class Integer 원래는 new Integer(10)이 들어가야 하는데 내부적으로 auto boxing되어 바뀐다?
		list.add(13);
		list.add(5);
		list.add(1);

		// 리스트의 요소의 개수
		int size = list.size();
		System.out.println("요소의 개수 : " + size);

		// for 이용 일괄 참조
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("-------------------------------");
		// for-each 구문 사용
		for (Integer i : list) {
			System.out.println(i);
		}

		System.out.println("-------------------------------");

		// 정렬자를 이용한 전체 출력
		Iterator<Integer> itr = list.iterator();

		while (itr.hasNext()) {
			Integer i = itr.next();
			System.out.println(i);
		}

		System.out.println("-------------------------------");

		// 요소 삭제
		list.remove(2); // list 2번지 삭제
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
