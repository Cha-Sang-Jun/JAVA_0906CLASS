package viewer;

import model.BoardDTO;
import controller.BoardController;

import java.util.Scanner;

import util.ScannerUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BoardViewer {
	// 변수
	private Scanner scanner;
	private BoardController controller;

	// 상수
	private final String DATE_FORMAT_STRING = "y:M:d HH:mm:ss";

	// 생성자
	public BoardViewer() {
		scanner = new Scanner(System.in);
		controller = new BoardController();
	}

	// 메뉴 출력
	public void showMenu() {
		String message = new String("1. 새 글 작성 2. 글 목록보기 3. 종료");
		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message);
			if (userChoice == 1) {
				// 새글 작성 메소드 실행
				writeBoard();
			} else if (userChoice == 2) {
				// 글 목록보기 메소드 실행
				printList();
			} else if (userChoice == 3) {
				// 메시지 출력 후 종료
				System.out.println("사용해주셔서 감사합니다.");
				scanner.close();
				break;
			}

		}
	}

	// 글 입력 UI
	private void writeBoard() {
		BoardDTO b = new BoardDTO();

		String message;

		message = new String("글의 제목을 입력해주세요.");
		b.setTitle(ScannerUtil.nextLine(scanner, message));

		message = new String("글의 작성자를 입력해주세요.");
		b.setWriter(ScannerUtil.nextLine(scanner, message));

		message = new String("글의 내용을 입력해주세요.");
		b.setContent(ScannerUtil.nextLine(scanner, message));
		controller.insert(b);
	}

	// 글 목록 출력 UI
	private void printList() {
		if (controller.selectAll().isEmpty()) {
			System.out.println("-------------------------");
			System.out.println("아직 작성된 글이 존재하지 않습니다.");
			System.out.println("-----------------------\n");
		} else {
			System.out.println("번호\t제목\t작성자");
			System.out.println("---------------------------\n");
			for (BoardDTO b : controller.selectAll()) {
				System.out.printf("%d.\t%s\t%s\n", b.getId(), b.getTitle(), b.getWriter());
			}
			System.out.println("----------------------------\n");
			String message = new String("상세보기할 글이 번호나 뒤로가시려면 0을 입력해주세요.");
			int userChoice = ScannerUtil.nextInt(scanner, message);

			while (userChoice != 0 && controller.selectOne(userChoice) == null) {
				System.out.println("해당 글 번호는 존재하지 않는 번호입니다!\n");
				userChoice = ScannerUtil.nextInt(scanner, message);
			}

			if (userChoice != 0) {
				printOne(userChoice);
			}
		}
	}

	// 글 개별보기 UI
	private void printOne(int id) {
		BoardDTO b = controller.selectOne(id);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STRING);
		System.out.println("--------------------------");
		System.out.println("제목: " + b.getTitle());
		System.out.println("--------------------------");
		System.out.printf("번호: %d, 작성자: %s\n", b.getId(), b.getWriter());
		System.out.printf("작성일: %s 수정일: %s\n", sdf.format(b.getWrittenDate().getTime()),
				sdf.format(b.getUpdateDate().getTime()));
		System.out.println(b.getContent());
		System.out.println("------------------------------------");
		String message = new String("1.수정 2.삭제 3.뒤로가기");
		int userChoice = ScannerUtil.nextInt(scanner, message);

		if (userChoice == 1) {
			// 수정 메소드 실행
			update(id);
		} else if (userChoice == 2) {
			// 삭제 메소드 실행
			delete(id);
		} else if (userChoice == 3) {
			// 목록 출력 메소드 실행
			printList();
		}
	}

	// 글 수정 UI
	private void update(int id) {
		BoardDTO b = controller.selectOne(id);
		String message;

		message = new String("새로운 제목을 입력해주세요.");
		b.setTitle(ScannerUtil.nextLine(scanner, message));

		message = new String("새로운 글 내용을 입력해주세요.");
		b.setContent(ScannerUtil.nextLine(scanner, message));

		controller.update(b);

		printOne(id);

	}

	// 글 삭제 UI
	private void delete(int id) {
		String message = new String("해당 글을 적말로 삭제하시겠습니까? y/n");
		String yesNo = ScannerUtil.nextLine(scanner, message);

		if (yesNo.equalsIgnoreCase("y")) {
			controller.delete(id);
			printList();
		} else {
			printOne(id);
		}
	}

}