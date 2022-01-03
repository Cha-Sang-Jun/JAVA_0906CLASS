package mm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

@Configuration
public class JavaConfig {
	
	// MemberDao
	@Bean(name = "dao")
	@Scope(value = "Singleton")
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	// MemberRegService : dao 주입 받는다
	public MemberRegService regService() {
		return new MemberRegService(memberDao());
	}
	
	// ChangePasswordService : dao 주입 받는다
	public ChangePasswordService changeService() {
		ChangePasswordService service = new ChangePasswordService();
		service.setDao(memberDao());
		return service;
	}
}
