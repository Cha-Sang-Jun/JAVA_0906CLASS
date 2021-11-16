package day0923;

import java.util.ArrayList;  
import java.util.Scanner;
import classEx.Board;
import util.ScannerUtil;

public class Ex02Board {
	static ArrayList<Board> list = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	static int nextId = 1;

	// 메인 메소드
	public static void main(String[] args) {
		showMenu();
	}

	// 메뉴 출력 메소드
	public static void showMenu() {
		while (true) {
			System.out.println("\n-----------------------------------");
			System.out.println("게시판 관리 프로그램");
			System.out.println("-----------------------------------\n");
			String message = new String("1.입력 2.목록보기 3.종료");
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
			if (userChoice == 1) {
				write();
			} else if (userChoice == 2) {
				printList();
			} else if (userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				scanner.close();
				break;
			}
		}
	}

	// 글 작성 메소드
	public static void write() {
		// 입력할 글의 내용을 담을 Board 객체 선언 및 초기화
		Board b = new Board();

		// 입력 시 출력할 메세지를 담을 String 객체
		String message;

		// 글 번호 입력 후 다음 글 번호 1 증가
		b.setId(nextId++);

		// 글 제목 입력
		message = new String("제목을 입력해주세요.");
		b.setTitle(ScannerUtil.nextLine(scanner, message));

		// 글 작성자 입력
		message = new String("작성자를 입력해주세요.");
		b.setWriter(ScannerUtil.nextLine(scanner, message));

		// 글 내용 입력
		message = new String("내용을 입력해주세요");
		b.setContent(new String(ScannerUtil.nextLine(scanner, message)));

		// 리스트에 추가
		list.add(b);

	}

	// 글 목록 출력 메소드
	public static void printList() {
		if (list.isEmpty()) {
			System.out.println("--------------------------");
			System.out.println("아직 입력된 글이 존재하지 않습니다.");
			System.out.println("--------------------------\n");
		} else {
			System.out.println("--------------------------\n");
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("%d. %s \n", list.get(i).getId(), list.get(i).getTitle());
			}
			System.out.println("-------------------------------\n");
			String message = new String("상세보기할 글의 번호나 혹은 뒤로가려면 0을 입력해주세요");
			int userChoice = ScannerUtil.nextInt(scanner, message);

			// 사용자가 0을 입력하지 않았을 경우,
			// 올바른 번호를 입력했는지 체크
			// 그 후에 올바른 번호이면 printOne,
			// 올바르지 않을 경우, 다시 입력

			while (!validateId(userChoice)) {
				System.out.println("해당 글 번호는 존재하지 않는 번호입니다.");
				userChoice = ScannerUtil.nextInt(scanner, message);
			}

			if (userChoice != 0) {
				printOne(userChoice);
			}

		}
	}

	// 글 개별 출력 메소드
	public static void printOne(int id) {
		int index = indexOf(id);

		list.get(index).printOne();
		String message = new String("1.수정 2. 삭제 3.뒤로가기");
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
		if (userChoice == 1) {
			update(id);
		} else if (userChoice == 2) {
			delete(id);
		} else if (userChoice == 3) {
			printList();
		}
	}

	// 글 수정 메소드
	public static void update(int id) {
		String message;
		int index = indexOf(id);

		message = new String("새로운 제목을 입려해주세요.");
		list.get(index).setTitle(ScannerUtil.nextLine(scanner, message));

		message = new String("새로운 내용을 입력해주세요.");
		list.get(index).setContent(ScannerUtil.nextLine(scanner, message));

		printOne(id);
	}

	// 글 삭제 메소드
	public static void delete(int id) {
		String message = new String("글을 정말로 삭제하시겠습니까? y/n");
		int index = indexOf(id);

		String yesNo = ScannerUtil.nextLine(scanner, message);
		if (yesNo.equalsIgnoreCase("Y")) {
			list.remove(index);
			printList();
		} else {
			printOne(id);
		}
	}

	// 해당 글 번호가 존재하는 글 번호인지 체크하는 메소드(목록보기에서 쓰임)
	public static boolean validateId(int id) {
		if (id == 0) {
			return true;
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return true;
			}
		}

		return false;
	}

	// 파라미터로 들어온 id 값과 일치하는 객체의 인덱스를 찾는
	// indexOf()
	public static int indexOf(int id) {
		Board b = new Board();
		b.setId(id);

		return list.indexOf(b);
	}
}
