package exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import chapter11.Person;
import chapter11.SimpleNumber;

public class FootballPlayer implements Comparable<FootballPlayer> {
	private String name;
	private int number;
	private String team;
	private int age;
//	축구선수 클래스를 만들어 봅시다. 
//	1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다. 
//	 
//	2. 축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도록 
//     Set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
//	 
//	3. TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 
//	       같은 팀의 선수들은 이름 순으로 정렬하고, 
//	       같은 이름의 선수는 번호 순으로 저장하는 프로 그램을 만들어 봅시다. 
//
//	 4. 축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는 
//	    Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다. 

	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public FootballPlayer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}

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

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null && obj instanceof FootballPlayer) {
			FootballPlayer player = (FootballPlayer) obj;
			if (this.team.contentEquals(player.team) && this.name.equals(player.name) && this.age == player.age) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public int hashCode() {
		return this.number % 3;
	}

	@Override
	public int compareTo(FootballPlayer o) {
		int compare = this.team.compareTo(o.team);
		int nameCompare = this.name.compareTo(o.name);

		if (compare > 0) {
			return -(this.team.compareTo(o.team));
		} else if (nameCompare > 0) {
			return -(this.name.compareTo(o.name));
		} else if (this.age < o.age) {
			return 1;
		}

		return nameCompare;

	}
}
