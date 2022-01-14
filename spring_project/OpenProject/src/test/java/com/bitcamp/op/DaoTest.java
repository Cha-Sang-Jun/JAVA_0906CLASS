package com.bitcamp.op;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.EditRequest;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.domain.SearchParams;

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
	// 전체 회원수 반환 메소드 테스트
	public void selectTotalCountTest() {

		dao = template.getMapper(MemberDao.class);

		// 전체 회원의 수를 반환하는 메소드 테스트는 결과가 MysqSql Workbench에서 select 한 결과 9와 같아야 한다.
		int cnt = dao.selectTotalCount(new HashMap<String, String>());
		assertEquals("전체 회원수 확인: 기대값 9", 9, cnt);
	}


	@Test
	// 회원가입 메소드 테스트
	public void insertMemberTest() {
		dao = template.getMapper(MemberDao.class);

		MemberRegRequest regRequest = new MemberRegRequest("cool33", "123", "tester", "img1.jpg");

		int resultCnt = dao.insertMember(regRequest);
		
		assertEquals("정상적 회원가입 될 경우 기댓값  : 1", 1, resultCnt);
	}
	
	@Test
	// 아이디 검색 메소드
	public void selectByIdTest() {
		dao = template.getMapper(MemberDao.class);

		// 검색 타입과 검색어를 전달해주면 결과가 2가 반환되어야한다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchType", "uid");
		map.put("keyword", "test");
		int cnt = dao.selectTotalCount(map);
		assertEquals("아이디가 test 문자열을 포함하는 회원의 수", 3, cnt);
	}
	
	@Test
	// 회원 전체 출력 메소드 테스트
	public void selectListTest() {  
		dao = template.getMapper(MemberDao.class);
		
		SearchParams params = new SearchParams(0, 3, "uid", "test");
		
		List<Member> list = dao.selectList(params);
		
		// 회원 아이디
		String real = "test33";
		
		// 회원 아이디 값 비교
		assertEquals("파라미터가 포함된 회원정보 출력", real, list.get(0).getUserid());
	}
	
	@Test 
	// 회원 번호로 검색 메소드
	public void selectByIdxTest() {
		dao = template.getMapper(MemberDao.class);
		
		// 회원번호
		int memberIdx = 40;
		
		Member member = dao.selectByIdx(memberIdx);
		
		// 회원번호가 일치하는지 확인
		assertEquals("회원번호 일치비교", 40, member.getIdx());
	}
	
	@Test
	// 회원정보삭제 메소드 테스트
	public void deleteByIdxTest() {
		dao = template.getMapper(MemberDao.class);
		
		int memberIdx = 32;
		
		int resultCnt = dao.deleteByIdx(memberIdx);
		
		assertEquals("번호에 맞는 회원정보가 삭제됐을경우 기댓값 1", 1, resultCnt);
	}
	
	@Test
	// 회원정보 수정 메소드 테스트
	public void editMemberTest() {
		dao = template.getMapper(MemberDao.class);
		
		EditRequest editRequest = new EditRequest(30, "333", "new", "img02.png");
		
		int resultCnt = dao.editMember(editRequest);
		
		assertEquals("수정 성공시 기대값 1 반환", 1, resultCnt);
	}

}
