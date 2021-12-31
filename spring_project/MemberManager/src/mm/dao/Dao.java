package mm.dao;

import java.util.Collection;

import mm.domain.Member;

public interface Dao {

	// 회원 정보 저장
	void insert(Member member);
	
	// 회원 정보 수정
	void update(Member member);
	
	// 회원 정보 검색(email) -> Member 객체로 반환
	Member selectByEmail(String email);
	
	// 전체 데이터 반환 (출력목적)
	Collection<Member> selectAll();
}
