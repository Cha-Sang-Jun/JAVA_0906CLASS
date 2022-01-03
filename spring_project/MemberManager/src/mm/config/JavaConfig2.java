package mm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

@Configuration
public class JavaConfig2 {
	
	@Autowired
	MemberDao memberDao;
	
	// ChangePasswordService : dao 주입 받는다
	public ChangePasswordService changeService() {
		ChangePasswordService service = new ChangePasswordService();
		service.setDao(memberDao);
		return service;
	}
}
