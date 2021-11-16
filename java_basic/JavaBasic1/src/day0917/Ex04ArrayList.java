package day0917;
// ArrayList  
// 우리가 지난 몇일간, 예제를 풀면서
// 동적할당 배열이 정적할당 배열보다 사용하기 편하다는 것을 배웠지만
// 문제는, 우리가 새로운 데이터 타입을 만들 때마다
// ArrayUtil에 동적할당 메소드를 매번 새롭게 만들어야 했다.
// 
// 하지만 객체지향 프로그래밍의 관점에서는
// 우리가 많은 클래스를 만들어서
// 해당 클래스의 객체들로 우리가 프로그램을 만들게 되는데,
// 그렇다면 그때마다 매번 동적할당 메소드를 만들어주어야 할꺄?
//		 
// 정답은 당연히 아니다 이다.
// 
// 자바에서 기본적으로 동적할당의 개념이 구현되어있는
// 클래스를 제공해준다.
// 
// ArrayList로 대표되는 Collections 라는 클래스들인데
// 해당 클래스들 안에는 크게 3가지 분류가 있다.
// 1. List: 리스트는 배열과 같이 우리가 추가하는대로 차례대로 객체가 추가되는 형태로써,
//          순서가 존재하고 중복된 값을 추가할 수 있다.
//          즉 우리의 ArrayUtil 안에 구현되어있는 동적 할당 배열과 가장 유사한 형태이다.
// 2. Set: 셋은 어레이리스트와 유사하게 순서가 존재하는 형태이지만
//         단, 중복된 값은 추가할 수 없다.
// 3. Map: 맵은 추가되는 요소가 순서가 존재하지 않고, 대신 해당 요소를 호출할 때에는
//         우리가 미리 지정한 키 값을 통해서 호출해야 한다.

// 우리가 여기서 배울것은 List 중에서 가장 많이 사용되는 ArrayList 이다.

import java.util.ArrayList;

public class Ex04ArrayList {
	public static void main(String[] args) {
		// ArrayList 클래스 객체를 우리가 선언과 초기화를 해주어야 하는데
		// 배열에서처럼, 우리가 해당 객체가 어떤 클래스의 모음인지를 명시해야 한다.
		// ArrayList<클래스 이름> 리스트객체의 이름 = new ArrayList<>();
		// 그렇다면 만약 우리가 int를 모아둔 ArrayList가 필요할 때에는?
		// 이런 경우를 대비해서 자바는 "Wrapper Class"가 존재한다.
		// Wrapper 클래스란 기본형 데이터타입을 클래스로 구현해둔 "포장 클래스" 이다.
		// int 는 Integer, double은 Double .....
		// 만약 기본형 데이터타입의 클래스 버젼이 필요할 때에는
		// 해당 포장 클래스를 사용하면 된다.
		
		// String 클래스를 모아둔 ArrayList 객체 list를 만들어보자
		ArrayList<String> list = new ArrayList<>();
		
		// String 객체를 5개 만들어보자
		String s1 = new String("a1");
		String s2 = new String("a2");
		String s3 = new String("a3");
		String s4 = new String("a4");
		String s5 = new String("a5");
		
		// 1. add(e)
		//    어레이리스트 객체에 새로운 요소를 추가할 때에는 add() 메소드를 실행하면 된다.
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add("a4");
		
		
		// 2. get(index)
		//    어레이리스트 객체에 특정 인덱스에 있는 요소를 호출할 때에는 get() 메소드를 실행하면 된다.
		System.out.println("2. get(index)");
		System.out.println("list.get(0) " + list.get(0));
		System.out.println("---------------------------------\n");
		// 단, 잘못된 인덱스를 호출할 시에는 당연히 에러가 발생된다.
		// System.out.println("list.get(55): " + list.get(55));
		System.out.println("-------------------------------------\n");
		
		// 3. add(index,e)
		//    어레이리스트 객체에 특정 인덱스에 새로운 값을 끼워넣고 싶을 때에는 add(index, e) 메소드를 실행하면 된다.
		System.out.println("3. add(index, e)");
		System.out.println("add() 전 list.get(1): " + list.get(1));
		System.out.println("add() 전 list.size(): " + list.size());
		list.add(1, s1);
		System.out.println("add() 후 list.get(1): " + list.get(1));
		System.out.println("add() 후 list.size(): " + list.size());
		System.out.println("----------------------------\n");
		
		// 4. size()
		//    어레이리스트 객체 안에 추가되어있는 요소의 갯수를 알고 싶을 때에는 size() 메소드를 실행하면 된다.
		System.out.println("4. size()");
		System.out.println("list.size(): " + list.size());
		System.out.println("----------------------------\n");
		
		// 5. isEmpty()
		//    어레이리스트 객체 안에 요소가 존재하지 않으면 true, 존재하면 false인지 알고 싶을 때에는
		//    isEmpty() 메소드를 실행하면 된다.
		System.out.println("5. isEmpty");
		System.out.println("list.isEmpty(): " + list.isEmpty());
		System.out.println("----------------------------\n");
		
		// 6. set(index, e)
		//    특정 인덱스에 새로운 값을 끼워 넣을 때에는 set(index,e) 메소드를 실행하면 된다.
		//    기존에 있던 값은 리턴된다.
		System.out.println("6. set(index, e)");
		String temp = "abcd3ef";
		System.out.println("set() 전 temp의 값: " + temp);
		System.out.println("set() 전 list.get(0)의 값: " + list.get(0));
		System.out.println("set() 전 list.size()의 값: " + list.size());
		temp = list.set(0, s2);
		
		System.out.println("set() 후 temp의 값: " + temp);
		System.out.println("set() 후 list.get(0)의 값: " + list.get(0));
		System.out.println("set() 후 list.size()의 값: " + list.size());
		System.out.println("-------------------------------\n");
		
		// 7. clear()
		//    현재 어레이리스트 객체의 내용을 싹 다 비우고 싶다면
		//    clear() 메소드를 실행하면 된다.
		System.out.println("7. clear()");
		System.out.println("clear() 전 list.isEmpty(): " + list.isEmpty());
		list.clear();
		System.out.println("clear() 후 list.isEmpty(): " + list.isEmpty());
		System.out.println("------------------------\n");
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s2);
		list.add(s1);
		list.add("a4");
		
		// 여기서부터는 <> 안에 클래스에 equals() 메소드가
		// 정확하게 구현되어있어야 정상적으로 실행이 된다.
		// 8. contains(e)
		//    어레이리스트가 해당 객체와 equals()가 true가 나오는 요소를 가지고 있는지 알고 싶다면
		//    contains(e)를 실행하면 된다.
		System.out.println("8. conatains(e)");
		System.out.println("list.contains(s1): " + list.contains(s1));
		System.out.println("list.contains(s4): " + list.contains(s4));
		System.out.println("list.contains(s5): " + list.contains(s5));
		System.out.println("---------------------------\n");
		// s4, s5는 추가를 해주지 않았지만 s4가 나오게 하는 add("a4")가 있으므로 s4는 true로 나옴 s5는 존재하지 않으므로 false
		
		// 9. indexOf(e)
		//    어레이리스트에서 해당 객체와 일치하는 요소의 가장 먼저 등장하는 인덱스를 알고 싶다면
		//    indexOf(e)를 실행하면 된다.
		//    만약 해당 객체와 일치하는 요소가 없을 경우 -1이 리턴된다.
		System.out.println("9. indexOf(e)");
		System.out.println("list.indexOf(s1): " + list.indexOf(s1));
		System.out.println("list.indexOf(s4): " + list.indexOf(s4));
		System.out.println("list.indexOf(s5): " + list.indexOf(s5));
		System.out.println("---------------------------\n");	
		
		// 10. lastIndexOf(e)
		//    어레이리스트에서 해당 객체와 일치하는 요소의 가장 마지막에 등장하는 인덱스를 알고 싶다면
		//    lastIndexOf(e)를 실행하면 된다.
		//    만약 해당 객체와 일치하는 요소가 없을 경우 -1이 리턴된다.
		System.out.println("10. lastIndexOf(e)");
		System.out.println("list.lastIndexOf(s1): " + list.lastIndexOf(s1));
		System.out.println("list.lastIndexOf(s4): " + list.lastIndexOf(s4));
		System.out.println("list.lastIndexOf(s5): " + list.lastIndexOf(s5));
		System.out.println("---------------------------\n");	
		
		// 11. remove(index)
		//     어레이리스트에서 특정 인덱스의 값을 삭제할 떄에는 remove(index)를 실행하면 된다.
		System.out.println("11. remove(index)");
		System.out.println("remove(index) 전 list.get(0): " + list.get(0));
		list.remove(0);
		System.out.println("remove(index) 후 list.get(0): " + list.get(0));
		System.out.println("---------------------------\n");
	
		// 12. remove(e)
		//     어레이리스트에서 가장 먼저 특정 객체와 일치하는 요소를 삭제할 때에는
		//     remove(e)를 실행하면 된다.
		//     만약 일치하는 요소가 존재하지 않으면 아무일도 발생되지 않는다.
		System.out.println("12. remove(e)");
		System.out.println("remove(e) 전 list.contains(s1): " + list.contains(s1));
		System.out.println("remove(e) 전 list.contains(s4): " + list.contains(s4));
		System.out.println("remove(e) 전 list.size(): " + list.size());
		list.remove(s1);
		list.remove(s4);
		list.remove(s5);
		System.out.println("remove(e) 후 list.contains(s1): " + list.contains(s1));
		System.out.println("remove(e) 후 list.contains(s4): " + list.contains(s4));
		System.out.println("remove(e) 후 list.size(): " + list.size());
		System.out.println("---------------------------\n");

	
	}

}
