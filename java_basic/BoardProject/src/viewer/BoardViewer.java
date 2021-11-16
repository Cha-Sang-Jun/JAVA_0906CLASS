package viewer;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import controller.BoardController;
import model.BoardDTO;
import model.MemberDTO;
import util.ScannerUtil;

public class BoardViewer {
	private BoardController boardController;
	private Scanner scanner;
	private MemberDTO logIn;
	private MemberViewer memberViewer; // MemberController 는 private 필드라 의존적인 관계를 가질수 없음 따라서 Memberviewer 의 내용을 가져와서
										// 의존적인 관계를 가짐
	private ReplyViewer replyViewer;
	private String DATE_FORMAT_STRING = new String("yy/M/d H:m:s");

	// 의존성(Dependency)
	// 특정 클래스의 객체 내부에서 다른 클래스를 필드로 갖고 있는 경우,
	// 그 특정 클래스는 다른 클래스에 의존적인 관계가 만들어진다.
	// 즉, 다른 클래스에 변경점이 가해질 경우, 특정 클래스에도 그 영향이 미치게 된다.
	// 현재 BoardViewer 클래스는 BoardController 클래스와 Scanner 클래스에 의존적인 관계가 맺어져 있는 것이다.
	// 이 의존적인 관계는 우리가 피하는게 맞지만, 현재 BoardViewer 처럼 의존적인 관계의 클래스를 만들 수 밖에 없는
	// 경우가 발생하게 된다.

	// 지금 현재, 우리의 BoardViewer 생성자는 내부적으로 BoardController 필드를 초기화하고 있다.
	// 근데 만약 BoardController 가 파라미터 있는 생성자만 가지도록 변경된다면, 이 BoardViewer 도 수정이 가해져야만
	// 한다.
	// 즉, 이 BoardViewer 클래스는 BoardController 에게 지나치게 의존적인 관계인 것이다.

	// 그렇다면 이 의존성을 줄이기 위해서는 어떻게 해야할까?
	// 여기서 나온 개념이 바로 의존성 주입(Dependency Injection)이다.
	// 의존성 주입이 목표하는 것은 바로
	// 내부에서 힘들게 혼자 만들지 말고, 외부가 만들어준 객체를 받아와서 해당 필드를 초기화시키자 라는 것이다.

	// 의존성 주입은 2가지 방법이 있다.
//	// 1. 생성자를 통한 의존성 주입
//	public BoardViewer(BoardController boardController, Scanner scanner) {
//		this.boardController = new BoardController();
//		this.scanner = scanner;
//	}
//	
//	// 2. Setter를 통한 의존성 주입
//	public void setBoardController(BoardController boardController) {
//		this.boardController = boardController;
//	}
//	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
		replyViewer.setScanner(scanner);
	}

	public void setLogIn(MemberDTO logIn) {
		this.logIn = logIn;
		replyViewer.setLogIn(logIn);
	}

	public void setMemberViewer(MemberViewer memberViewer) {
		this.memberViewer = memberViewer;
		replyViewer.setMemberViewer(memberViewer);
	}

	public BoardViewer() {
		boardController = new BoardController();
		replyViewer = new ReplyViewer();

	}

	public void showMenu() {
		String message = new String("1. 새 글 등록 2. 글 목록 보기 3. 뒤로가기");
		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message);

			if (userChoice == 1) {
				writeBoard();
			} else if (userChoice == 2) {
				printList();
			} else if (userChoice == 3) {
				System.out.println("메인 화면으로 돌아갑니다.");
				break;
			}
		}
	}

	private void writeBoard() {
		BoardDTO b = new BoardDTO();

		String message;

		b.setWriterId(logIn.getId());

		message = new String("글의 제목을 입력해주세요.");
		b.setTitle(ScannerUtil.nextLine(scanner, message));

		message = new String("글의 내용을 입력해주세요.");
		b.setContent(ScannerUtil.nextLine(scanner, message));

		boardController.insert(b);
	}

	public void printList() {
		if (boardController.selectAll().isEmpty()) {
			System.out.println("-------------------------");
			System.out.println("아직 작성된 글이 존재하지 않습니다.");
			System.out.println("\n--------------------------\n");
		} else {
			System.out.println("글번호 제목 작성자");
			for (BoardDTO b : boardController.selectAll()) {
				System.out.printf("%d. %s by", b.getId(), b.getTitle());
				memberViewer.printNickName(b.getWriterId());
				System.out.println();
			}
			String message = new String("상세보기할 글의 번호를 입력하거나 뒤로 가시려면 0을 입력해주세요.");
			int userChoice = ScannerUtil.nextInt(scanner, message);

			while (userChoice != 0 && boardController.selectOne(userChoice) == null) {

				System.out.println("해당 글 번호는 존재하지 않습니다.");
				userChoice = ScannerUtil.nextInt(scanner, message);
			}

			if (userChoice != 0) {
				printOne(userChoice);
			}
		}
	}

	private void printOne(int id) {
		BoardDTO b = boardController.selectOne(id);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STRING);

		System.out.println("----------------------------------");
		System.out.println(b.getTitle());
		System.out.println("--------------------------------");
		System.out.println("글 번호 " + b.getId() + " ");
		memberViewer.printNickName(b.getWriterId());
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println("작성일: " + sdf.format(b.getWrittenDate().getTime()));
		System.out.println("수정일: " + sdf.format(b.getUpdatedDate().getTime()));
		System.out.println("-------------------------------------");
		System.out.println(b.getContent());

		if (b.getWriterId() == logIn.getId()) { // 글 작성자 id와 로그인한 회원의 id가 같으면 수정 삭제 가능
			String message = new String("1. 수정 2. 삭제 3. 뒤로가기");
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

			if (userChoice == 1) {
				update(id);
			} else if (userChoice == 2) {
				delete(id);
			} else if (userChoice == 3) {
				printList();
			}

		} else {
			int userChoice = replyViewer.printAll(id);
			
			if(userChoice == 1) {
				printOne(id);
			} else if(userChoice == 2) {
				printList();
			}
		}
	}

	// 글 수정 UI
	private void update(int id) {
		BoardDTO b = boardController.selectOne(id);
		String message;

		message = new String("새로운 제목을 입력해주세요.");
		b.setTitle(ScannerUtil.nextLine(scanner, message));

		message = new String("새로운 글 내용을 입력해주세요.");
		b.setContent(ScannerUtil.nextLine(scanner, message));

		boardController.update(b);

		printOne(id);

	}

	// 글 삭제 UI
	private void delete(int id) {
		String message = new String("해당 글을 적말로 삭제하시겠습니까? y/n");
		String yesNo = ScannerUtil.nextLine(scanner, message);

		if (yesNo.equalsIgnoreCase("y")) {
			boardController.delete(id);
			printList();
		} else {
			printOne(id);
		}
	}
	
	public void deleteByWriterId(int writerId) {
		replyViewer.deleteByWriterId(writerId);
		boardController.deleteByWriterId(writerId);
	}

}
