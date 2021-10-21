package exam;

import java.util.Iterator;
import java.util.TreeSet;

public class PlayerTreeSet {
	public static void main(String[] args) {
		
		TreeSet<FootballPlayer> set = new TreeSet<FootballPlayer>();
		set.add(new FootballPlayer("손흥민", 7, "A", 23));
		set.add(new FootballPlayer("박지성", 44, "B", 24));
		set.add(new FootballPlayer("이영표", 27, "D", 22));
		set.add(new FootballPlayer("이영표", 14, "D", 21));
		
		Iterator<FootballPlayer> itr = set.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
	}
}
