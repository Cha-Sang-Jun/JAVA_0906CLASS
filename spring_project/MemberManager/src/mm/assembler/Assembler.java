package mm.assembler;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

public class Assembler {
		
		// 조립기
		// 객체를 관리 : 객체 생성 (의존하고 있는 객체 주입), 보관, 제공
	
		// 보관 (변수로 보관)
		private MemberDao dao;
		private MemberRegService regService;
		private ChangePasswordService passwordService;
		
		// 객체 생성
		public Assembler() {
			dao = new MemberDao();
			regService = new MemberRegService();  // default 생성자 들어간 후 ->
			// regService.setDao(dao);               // 필요한 메소드 주입 하는 것이 assembler의 역할이다
			regService.setDao(new MemberDao()); 
			passwordService = new ChangePasswordService(dao);
		}
		
		// 객체 제공
		public MemberDao getDao() {
			return dao;
		}
		
		public MemberRegService getRegService() {
			return regService;
		}
		
		public ChangePasswordService getPasswordService() {
			return passwordService;
		}
	

}
