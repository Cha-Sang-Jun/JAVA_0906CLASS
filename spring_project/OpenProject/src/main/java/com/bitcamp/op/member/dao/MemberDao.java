package com.bitcamp.op.member.dao;

import java.util.List;
import java.util.Map;

import com.bitcamp.op.member.domain.EditRequest;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.Member2;
import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.domain.SearchParams;

public interface MemberDao {

	// public Member selectByIdPw(LoginParams params);
	// 파라미터가 기본형, 문자열일 경우
	public Member selectByIdPw(String uid, String pw);
	
	// public int selectTotalCount();
	public int selectTotalCount(Map<String, String> params);
	
	public List<Member> selectList(SearchParams params);
	// public List<Member> selectList(int count, int index);
	
	public int insertMember(MemberRegRequest regRequest);
	
	public Member selectByIdx(int idx);
	
	public Member2 selectByIdx2(int idx);

	public int deleteByIdx(int memberIdx);

	public int editMember(EditRequest editRequest);
	
}
