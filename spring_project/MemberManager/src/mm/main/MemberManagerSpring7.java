package mm.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import mm.assembler.Assembler;
import mm.config.JavaConfig;
import mm.config.JavaConfig1;
import mm.config.JavaConfig2;
import mm.config.JavaConfigMain;
import mm.dao.MemberDao;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;
import mm.exception.IdPasswordNotMatchingException;
import mm.exception.NotFoundMemberException;
import mm.service.ChangePasswordService;
import mm.service.ChangePasswordService2;
import mm.service.MemberRegService;
import mm.service.MemberRegService2;

public class MemberManagerSpring7 {

	static ApplicationContext ctx;

	public static void main(String[] args) {
		
		// ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");
		ctx = new AnnotationConfigApplicationContext(JavaConfigMain.class);
		
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

		/*
		 * 컨테이너가 가지고 있다가 필요할 때 준다. Dao dao = assembler.getDao();
		 * 
		 * MemberRegService regService = assembler.getRegService();
		 * 
		 * ChangePasswordService passwordService = assembler.getPasswordService();
		 * 
		 * Dao dao1 = assembler.getDao(); --> assembler 의 역할을 하는 컨테이너는 자동으로 싱글톤 효과를 가지게
		 * 된다. Dao dao2 = assembler.getDao();
		 */

	}

	private static void processChangePassword(String[] values) {

		ChangePasswordService changePassword = ctx.getBean("changeService", ChangePasswordService.class);
		
		// change[0] son@gmail.com[1] 123[2] 000[3]
		try {
			changePassword.changePassword(values[1], values[2], values[3]);
		} catch (NotFoundMemberException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (IdPasswordNotMatchingException e) {
			System.out.println(e.getMessage());
			// 	e.printStackTrace();
		}
	}

	private static void processNewMember(String[] values) {

		MemberRegService regService = ctx.getBean("regService", MemberRegService.class);

		// new[0] son@gmail.com[1] 손흥민[2] 123[3] 123[4]
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
			// e.printStackTrace();
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
