package mm.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.dao.Dao;
import mm.dao.MemberDao;
import mm.domain.Member;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;

@Component("regService")
public class MemberRegService2 {
	
	// @Autowired // (required = false) // (required = false) 를 붙이면 bean이 없어도 pass 처리
	// @Qualifier("guestDao")
	@Resource
	private Dao dao;   // Dao 타입의 bean을 자동 주입
	
	public MemberRegService2() {}

	public void regMember(RegRequest request) throws DuplicateMemberException {
		
		// 이메일 중복체크
		Member member = dao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new DuplicateMemberException("!!! 이미 존재하고 있는 이메일 입니다.");
		}
		
		dao.insert(request.toMember());
		System.out.println("[System Message : 등록완료]");
	}
}
