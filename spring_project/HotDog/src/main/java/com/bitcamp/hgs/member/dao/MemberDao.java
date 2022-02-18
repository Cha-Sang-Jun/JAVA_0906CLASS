package com.bitcamp.hgs.member.dao;


import java.util.List;

import com.bitcamp.hgs.member.domain.InsertMember;
import com.bitcamp.hgs.member.domain.Logger;
import com.bitcamp.hgs.member.domain.MemberHashtag;

public interface MemberDao {
	
	// 유저 저장
	public void insertMemberInfo(InsertMember inserMember);
	
	// 유저가 선택한 해쉬태그 저장
	public void insertMemberHashtag(List<MemberHashtag> memberHashtagList);

	// 유저 잇는지 확인
	public Logger selectMember(String email, String password);

}
