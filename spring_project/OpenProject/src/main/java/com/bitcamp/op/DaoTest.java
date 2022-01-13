package com.bitcamp.op;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcamp.op.member.dao.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DaoTest {
	
	private MemberDao dao;
	
	@Autowired
	SqlSessionTemplate template;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void selectTotalCountTest() {
		
		dao = template.getMapper(MemberDao.class);
		
		// 전체 회원의 수를 반환하는 메소드 테스트는 결과가 MysqSql Workbench에서 select 한 결과 9와 같아야 한다.
		int cnt = dao.selectTotalCount(new HashMap<String, String>());
		assertEquals("전체 회원수 확인: 기대값 7", 7, cnt);
	}
	
	@Test
	public void selectByIdTest() {
		dao = template.getMapper(MemberDao.class);
		
		// 검색 타입과 검색어를 전달해주면 결과가 2가 반환되어야한다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchType", "uid");
		map.put("keyword", "test");
		int cnt = dao.selectTotalCount(map);
		assertEquals("아이디가 test 문자열을 포함하는 회원의 수", 1, cnt);
	}
	

}
