package exam2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class PlayerMain {
	public static void main(String[] args) {
		
		List<FootballPlayer> player = new ArrayList<>();

		player.add(new FootballPlayer("손흥민", 7, "토트넘", 28));
		player.add(new FootballPlayer("박지성", 44, "맨유", 25));
		player.add(new FootballPlayer("황희찬", 27, "울버햄튼", 26));
		player.add(new FootballPlayer("이영표", 14, "PSV", 27));

		for (int i = 0; i < player.size(); i++) {
			System.out.print(player.get(i) + "\t");
			System.out.println();
		}

		System.out.println("---------------------------");
		
		HashSet<FootballPlayer> set = new HashSet<FootballPlayer>();

		set.add(new FootballPlayer("음바페", 8, "파리생제르망", 25));
		set.add(new FootballPlayer("음바페", 7, "파리생제르망", 25));
		set.add(new FootballPlayer("음바페", 12, "파리생제르망", 25));

		Iterator<FootballPlayer> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("---------------------------");

		TreeSet<FootballPlayer> set2 = new TreeSet<FootballPlayer>();
		set2.add(new FootballPlayer("손흥민", 7, "A", 23));
		set2.add(new FootballPlayer("박지성", 44, "B", 24));
		set2.add(new FootballPlayer("이영표", 27, "D", 22));
		set2.add(new FootballPlayer("이영표", 14, "D", 21));

		Iterator<FootballPlayer> itr2 = set2.descendingIterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}

		System.out.println("---------------------------");

		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "손흥민");
		map.put(2, "이강인");
		map.put(3, "황희찬");
		map.put(5, "박주영");

		Iterator<Integer> itr3 = map.keySet().iterator();

		while (itr3.hasNext()) {
			System.out.println(map.get(itr3.next()));

		}
	}
}
