package com.bitcamp.op.member.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.MybatisMemberDao;
import com.bitcamp.op.member.domain.ListPageView;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchParams;

@Service
public class MemberListService {

	// @Autowired
	// private MemberDao dao;

	// @Autowired
	// private JdbcTemplateMemberDao dao;

	@Autowired
	private MybatisMemberDao dao;
	
	// 페이지 당 표현할 회원의 수
	private final int COUNT_PER_PAGE = 3;

	public ListPageView getPageView(int pageNum) throws SQLException {

		ListPageView view = null;
		// Connection conn = null;

		// try {

		// conn = ConnectionProvider.getConnection();

		// 전체 회원의 수
		// int totalCount = dao.selectTotalCount(conn);
		
		 int totalCount = dao.selectTotalCount();
		
		// 현재 페이지 번호
		// int currentPage = pageNum; -> pageNum으로 쓰면 되기 때문에 굳이 변수 생성 하지 않는다.

		int index = (pageNum - 1) * COUNT_PER_PAGE;
		// List<Member> list = dao.selectList(conn, index, COUNT_PER_PAGE);
		// List<Member> list = dao.selectList(index, COUNT_PER_PAGE);
		
		SearchParams params = new SearchParams(index, COUNT_PER_PAGE, null, null);
		List<Member> list = dao.selectList(params);

		view = new ListPageView(totalCount, pageNum, COUNT_PER_PAGE, list);

		// } finally {
		// JdbcUtil.close(conn);
		// }

		return view;
	}

}
