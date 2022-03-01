package com.bitcamp.op.member.service;

import java.sql.SQLException; 

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.LoginInfo;
import com.bitcamp.op.member.domain.Member;

@Service
public class MemberMyPageService {

	// @Autowired
	// private MemberDao dao;

	// @Autowired
	// private JdbcTemplateMemberDao dao;
		
	// @Autowired
	// private MybatisMemberDao dao;
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public Member getMember(HttpSession session) throws SQLException {

		int memberIdx = ((LoginInfo) session.getAttribute("loginInfo")).getIdx();
		Member member = null;
		dao = template.getMapper(MemberDao.class);
		// Connection conn = null;

		// try {
		// conn = ConnectionProvider.getConnection();

		// member = dao.selectByIdx(conn, memberIdx);\
		
		member = dao.selectByIdx(memberIdx);
		
		System.out.println(dao.selectByIdx2(memberIdx));

		// } finally {
		// JdbcUtil.close(conn);
		// }

		return member;
	}
}
