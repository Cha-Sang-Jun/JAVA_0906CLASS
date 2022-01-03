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

public class MemberManagerSpring3 {

	static ApplicationContext ctx;

	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");
		
		MemberDao dao1 = ctx.getBean("memberDao", MemberDao.class);
		MemberDao dao2 = ctx.getBean("memberDao", MemberDao.class);
		
		System.out.println("dao1 == dao2 => " + (dao1==dao2));
	}
}
