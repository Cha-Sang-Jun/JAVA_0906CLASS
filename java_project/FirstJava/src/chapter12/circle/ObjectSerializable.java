package chapter12.circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectSerializable {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		// 인스턴스 저장을 위한 스트림
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.txt"));

		// 인스턴스 저장
		out.writeObject(new Circle(1, 1, 2.4));
		out.writeObject(new Circle(2, 2, 4.8));
		out.writeObject(new String("문자열"));
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("one");
		arr.add("two");
		arr.add("three");
		
		out.writeObject(arr);
		
		out.close();

		// 저장된 파일을 이용해서 인스턴스를 생성 -> 복원
		// 복원시에는 저장 순서에 맞게 복원해주어야 한다
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.txt"));
//		String str = (String) in.readObject(); --> 타입이 안맞아서 오류난다. 순서대로해야함


		// 복원 : 인스턴스 생성하고 반환
		Circle c1 = (Circle) in.readObject();
		Circle c2 = (Circle) in.readObject();
		
		String str = (String) in.readObject();

		ArrayList<String> arr1 = (ArrayList) in.readObject(); // ArrayList 만 직렬화 해주면 안에있는것들은 알아서 직렬화가 된다.
		
		for(String s : arr1) {
			System.out.println(s);
		}
		
		in.close();

		c1.showCircleInfo();
		c2.showCircleInfo();
		System.out.println(str);
		
		
	}
}
