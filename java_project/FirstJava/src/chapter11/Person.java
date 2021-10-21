package chapter11;

public class Person implements Comparable<Person> {
	
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		if(this.age > o.age) {
			return 1; // 양수
		} else if(this.age < o.age) {
			return -1; // 음수
		} else {
			return (this.name.compareTo(o.name)) * -1;  // 나이가 같을 경우 이름순으로 정렬
		}
//		return -(this.age - o.age);  // 간결화  // 정렬을 반전시키고 싶을때 (-) 연산자
	}
	
	
}
