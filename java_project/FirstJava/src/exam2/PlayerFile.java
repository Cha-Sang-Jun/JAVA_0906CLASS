package exam2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PlayerFile {
//	2. 앞 Chapter에서 만들어본 축구선수 정보 파일로 저장하는 프로그램을 만들어 봅시다.

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		// 인스턴스 저장을 위한 스트림
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));

//		① 축구선수 정보 인스턴스를 List<E>에 저장하는 프로그램을 만들어 봅시다.
		ArrayList<FootballPlayer> player = new ArrayList<>();

		player.add(new FootballPlayer("손흥민", 7, "토트넘", 28));
		player.add(new FootballPlayer("박지성", 44, "맨유", 25));
		player.add(new FootballPlayer("황희찬", 27, "울버햄튼", 26));
		player.add(new FootballPlayer("이영표", 14, "PSV", 27));

//		② 이 인스턴스 들을 파일로 저장하는 기능을 만들어 봅시다.
		out.writeObject(player);

		out.close();

//		③ 저장된 파일을 객체로 만드는 기능을 만들어봅시다.
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));

		// 복원 -> 인스턴스 생성 후 반환
		ArrayList<FootballPlayer> p1 = (ArrayList) in.readObject();

		for (int i = 0; i < player.size(); i++) {
			System.out.print(p1);
		}

		in.close();

	}
}
