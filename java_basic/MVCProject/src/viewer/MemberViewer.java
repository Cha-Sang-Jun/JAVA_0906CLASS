package viewer;

import java.util.Scanner;
import controller.MemberController;
import model.MemberDTO;
import util.ScannerUtil;

public class MemberViewer {
	private MemberController memberController;
	private Scanner scanner;
	private MemberDTO logIn;

	public MemberViewer() {
		memberController = new MemberController();
		scanner = new Scanner(System.in);
		logIn = null;

	}

	public void ShowIndex() {
		String message = new String("1. 로그인 2. 회원가입 3. 종료");
		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

			if (userChoice == 1) {
				// 로그인 메소드 실행 후 만약 로그인이 성공한다면
				// showMenu() 실행
				logIn();

				if (logIn != null) {
					showMenu();
				}

			} else if (userChoice == 2) {
				// 회원가입 메소드 실행
				register();
			} else if (userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				scanner.close();
				break;
			}
		}
	}

	private void register() {
		String message;

		message = new String("사용하실 아이디를 입력해주세요.");
		String username = ScannerUtil.nextLine(scanner, message);
		while (memberController.validateUsername(username)) {
			System.out.println("중복된 아이디는 사용하실 수 없습니다.");
			message = new String("사용하실 아이디를 입력하시거나 뒤로가시려면 X를 입력해주세요.");
			username = ScannerUtil.nextLine(scanner, message);
			if (username.equalsIgnoreCase("x")) {
				break;
			}
		}

		if (!username.equalsIgnoreCase("x")) {
			message = new String("사용하실 비밀번호를 입력해주세요.");
			String password = ScannerUtil.nextLine(scanner, message);

			message = new String("사용하실 닉네임을 입력해주세요.");
			String nickname = ScannerUtil.nextLine(scanner, message);

			MemberDTO m = new MemberDTO();

			m.setUsername(username);
			m.setPassword(password);
			m.setNickname(nickname);

			memberController.insert(m);
		}

	}

	// 로그인 메소드
	private void logIn() {
		String message;

		message = new String("아이디를 입력해주세요.");
		String username = ScannerUtil.nextLine(scanner, message);

		message = new String("비밀번호를 입력해주세요.");
		String password = ScannerUtil.nextLine(scanner, message);

		while (memberController.auth(username, password) == null) { // 정보가 올바르다면 deepCopy해서 넘겨져 올거고 올바르지 않다면 null이 넘어옴
			System.out.println("아이디 혹은 비밀번호가 잘못되었씁니다.");
			message = new String("아이디를 입력하시거나 뒤로가시려면 X를 입력해주세요.");
			username = ScannerUtil.nextLine(scanner, message);

			if (username.equalsIgnoreCase("x")) {
				break;
			}

			message = new String("비밀번호를 입력해주세요.");
			password = ScannerUtil.nextLine(scanner, message);

		}

		logIn = memberController.auth(username, password); // logIn 필드에는 두 가지 값이 들어갈 수 있다. 1. 올바른 정보가 들어가서 나오는 회원 2.
															// 올바르지 않은 정보가 들어가서 null로 다시 초기화

	}

	private void showMenu() {
		printOne(logIn.getId());
		String message = new String("1. 회원 정보 수정 2. 회원 탈퇴 3. 로그아웃");
		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
			if (userChoice == 1) {
				// 수정 메소드
				update(logIn.getId()); // 수정 및 탈퇴는 로그인한 사람이 해야하므로

			} else if (userChoice == 2) {
				// 탈퇴 메소드
				delete(logIn.getId());

			} else if (userChoice == 3) {
				System.out.println("로그아웃 되었습니다.");
				logIn = null;
			}

			if (logIn == null) { // 탈퇴했거나 or 로그아웃 했거나
				break;
			}
		}
	}

	private void printOne(int id) { // 파라미터로 id를 받아오지 않고 해도된다. logIn 필드에 정보가 다 있기 때문
		MemberDTO m = memberController.selectOne(id);
		System.out.println("회원번호 : " + m.getId());
		System.out.println("회원아이디 : " + m.getUsername());
		System.out.println("회원닉네임 : " + m.getNickname());
	}

	private void update(int id) {
		String message;
		message = new String("새로운 비밀번호를 입력해주세요.");
		String password = ScannerUtil.nextLine(scanner, message);

		message = new String("새로운 닉네임을 입력해주세요.");
		String nickname = ScannerUtil.nextLine(scanner, message);

		message = new String("정말로 수정하시겠습니까? y/n");
		String yesNo = ScannerUtil.nextLine(scanner, message);

		if (yesNo.equalsIgnoreCase("y")) {
			message = new String("기존 비밀번호를 입력해주세요.");
			String oldPassword = ScannerUtil.nextLine(scanner, message);
			if (memberController.auth(logIn.getUsername(), oldPassword) != null) {
				MemberDTO m = new MemberDTO();
				m.setId(logIn.getId());
				m.setUsername(logIn.getUsername());
				m.setPassword(password);
				m.setNickname(nickname);

				memberController.update(m);
			}
		}
	}

	private void delete(int id) {
		String message = new String("정말로 탈퇴하시겠습니까? Y/N");
		String yesNo = ScannerUtil.nextLine(scanner, message);

		if (yesNo.equalsIgnoreCase("y")) {

			message = new String("비밀번호를 입력해주세요.");
			String password = ScannerUtil.nextLine(scanner, message);

			if (memberController.auth(logIn.getUsername(), password) != null) { // 탈퇴하기전 회원 정보를 확인하는 메소드
				memberController.delete(id);
				logIn = null;
			}
		}
	}

}
