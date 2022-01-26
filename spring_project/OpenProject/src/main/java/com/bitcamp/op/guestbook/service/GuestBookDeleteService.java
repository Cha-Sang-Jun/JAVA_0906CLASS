package com.bitcamp.op.guestbook.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.guestbook.dao.GuestBookDao;
import com.bitcamp.op.guestbook.domain.WriteRequest;

@Service
public class GuestBookDeleteService {

	private GuestBookDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int deleteGuestbook(int idx) {
		
		int resultCnt = 0;
		
		dao = template.getMapper(GuestBookDao.class);
		
		WriteRequest writeRequest = dao.selectByIdx2(idx);
		
		if(writeRequest != null) {
			resultCnt = dao.deleteByIdx2(idx);
		}
		
		return resultCnt;
		
	}
}
