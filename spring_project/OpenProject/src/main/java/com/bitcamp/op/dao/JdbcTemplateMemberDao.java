package com.bitcamp.op.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Repository
public class JdbcTemplateMemberDao {

	@Autowired
	private JdbcTemplate template;

	// 로그인 처리를 위한 select
	public Member selectByIdPw(String uid, String pw) {

		String sql = "select * from member where userid =? and password=?";

//		List<Member> members = template.query(sql, new MemberRowMapper(), uid, pw); 
//		
//		Member member = members.isEmpty() ? null : members.get(0);

//		Member member = template.queryForObject(sql, new MemberRowMapper(), uid ,pw);
//		
//		return member;

		return template.queryForObject(sql, new MemberRowMapper(), uid, pw);
	}

	// 전체 회원의 수를 구하는 메소드
	public int selectTotalCount() {
		return template.queryForObject("Select count(*) from member", Integer.class);
	}

	// 리스트 페이지에 출력할 회원 정보 List<Member>
	public List<Member> selectList(int index, int count) {
		String sql = "select * from member order by regdate desc limit ?, ?";
		return template.query(sql, new MemberRowMapper(), index, count);
	}

	// 회원 가입을 위한 insert
	public int insertMember(MemberRegRequest request) {
		String sql = "INSERT INTO member (userid, password, username, photo) VALUES (?,?,?,?)";
		return template.update(sql, request.getUserid(), request.getPw(), request.getUsername(), request.getFileName());
	}

	// MyPage 를 위한 Member 객체를 구하는 Select
	public Member selectByIdx(int idx) {
		String sql = "select * from member where idx=?";

		List<Member> members = template.query(sql, new MemberRowMapper(), idx);

		return members.isEmpty() ? null : members.get(0);
	}
}
