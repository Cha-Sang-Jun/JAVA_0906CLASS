package mm.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import mm.assembler.Assembler;
import mm.dao.MemberDao;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;
import mm.exception.IdPasswordNotMatchingException;
import mm.exception.NotFoundMemberException;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

public class MemberManagerSpring8 {

	static ApplicationContext ctx;

	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtxMain.xml");
		
		Scanner sc = new Scanner(System.in);

		while (true) {

			printMenu();

			String command = sc.nextLine();

			// exit
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				return;
			}

			if (command.startsWith("new")) {
				String[] values = command.split(" ");
				processNewMember(values);
			}

			if (command.startsWith("change")) {
				processChangePassword(command.split(" "));
			}

		}
	}

	private static void processChangePassword(String[] values) {

		ChangePasswordService changePassword = ctx.getBean("changeService", ChangePasswordService.class);
		
		try {
			changePassword.changePassword(values[1], values[2], values[3]);
		} catch (NotFoundMemberException e) {
			System.out.println(e.getMessage());
		} catch (IdPasswordNotMatchingException e) {
			System.out.println(e.getMessage());
		}
	}
	

	private static void processNewMember(String[] values) {

		MemberRegService regService = ctx.getBean("regService", MemberRegService.class);
		RegRequest request = new RegRequest(values[1], values[3], values[4], values[2]);

		// 비밀번호와 비밀번호 확인 비교
		if (!request.isPwRePwEquals()) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		try {
			regService.regMember(request);
			
		} catch (DuplicateMemberException e) {
			System.out.println(e.getMessage());
		}

	}
	
	static void printMenu() {
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("------------------------------");
		System.out.println("신규 입력");
		System.out.println("new 이메일 이름 비밀번호 비밀번호확인"); // new son@gmail.com 손흥민 123 123 => split으로 글자를 잘라서 객체로 생성
		System.out.println("new son@gmail.com 손흥민  123 123");
		System.out.println("비밀번호 수정");
		System.out.println("change 이메일 현재비번 새로운비번"); // change son@gmail.com 손흥민 123 000
		System.out.println("change son@gmail.com 123 000");
	}
}
