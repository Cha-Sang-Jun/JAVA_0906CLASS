package com.bitcamp.op.guestbook.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.guestbook.dao.GuestBookDao;
import com.bitcamp.op.guestbook.domain.WriteRequest;

@Service
public class GuestBookEditService {

	private GuestBookDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public WriteRequest getGuestBook(int idx) {
		
		dao = template.getMapper(GuestBookDao.class);
		
		// System.out.println(dao.selectByIdx2(idx));

		return dao.selectByIdx2(idx);
	}
	
	
	public int updateGuestBook(WriteRequest writeRequest) {
		
		int resultCnt = 0;
		
		dao = template.getMapper(GuestBookDao.class);
		
		resultCnt = dao.updateGuestbook(writeRequest);
		
		return resultCnt;
	}

}
