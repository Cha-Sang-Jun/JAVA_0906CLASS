package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Service
public class MemberRegService {
	
	// @Autowired
	// private MemberDao dao;
	
	// @Autowired
	// private JdbcTemplateMemberDao dao;
	
	// @Autowired
	// private MybatisMemberDao dao;
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int insertMember(MemberRegRequest regRequest, HttpServletRequest request) throws IllegalStateException, IOException, SQLException {
		
		int resultCnt = 0;
		
		dao = template.getMapper(MemberDao.class);
		
		// 파일이 없을경우 대비해서 default 설정
		regRequest.setFileName("img1.jpg");
		
		// DB관련 예외 발생 시 삭제처리를 위한 File 객체 변수 선언
		File newFile = null;
		
		// 파일이 있다면 -> 파일 저장
		if(!regRequest.getPhoto().isEmpty() && regRequest.getPhoto().getSize() > 0) {
			// 시스템의 경로
			String savePath = request.getSession().getServletContext().getRealPath(CommonsData.SAVE_URI);
			
			String[] files = regRequest.getPhoto().getOriginalFilename().split("\\.");
			String exet = files[files.length-1];
			
			String newFileName = System.nanoTime() + "." + exet;  // 위의 코드가 의미하는게 뭐지?
			
			newFile = new File(savePath, newFileName);
			
			regRequest.getPhoto().transferTo(new File(savePath, newFileName));
			
			regRequest.setFileName(newFileName);
		}
		
		// DAO를 이용해서 데이터베이스 처리
		// Connection conn = null;
		
		try {
			
			// conn = ConnectionProvider.getConnection();
			
			// resultCnt = dao.insertMember(conn, regRequest);
			
			System.out.println("idx => " + regRequest.getIdx());
			
			// resultCnt = dao.insertMember(regRequest);
			// resultCnt = dao.insert(regRequest);
			resultCnt = dao.insertMember(regRequest);
			
			System.out.println("idx => " + regRequest.getIdx());
			// 하위 테이블의 외래키로 사용해서 insert가 가능하다.
			
		} catch (Exception e) {
			// 파일이 저장된 후 DB관련 예외가 발생했을 때 : 저장했던 파일을 삭제
			if(newFile != null && newFile.exists()) {
				newFile.delete(); 
			}
			e.printStackTrace();
			throw e; // 예외는 Controller에서 처리하는 목적이기 때문에 던져서 처리한다.
		}
		
		// System.out.println(resultCnt);
		return resultCnt;
		
	}
}
