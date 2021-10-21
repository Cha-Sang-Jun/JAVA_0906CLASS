package exam;

import java.util.HashSet;
import java.util.Iterator;

public class PlayerHashSet {
	public static void main(String[] args) {
		HashSet<FootballPlayer> set = new HashSet<FootballPlayer>();
		
		set.add(new FootballPlayer("음바페", 8, "파리생제르망", 25));
		set.add(new FootballPlayer("음바페", 7, "파리생제르망", 25));
		set.add(new FootballPlayer("음바페", 12, "파리생제르망", 25));
		
		Iterator<FootballPlayer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
