package com.bitcamp.op.guestbook.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.guestbook.dao.GuestBookDao;
import com.bitcamp.op.guestbook.domain.WriteRequest;

@Service
public class GuesteBookWriteService {

	private GuestBookDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int writeArticle(WriteRequest writeRequest, HttpServletRequest request) {
		
		int resultCnt = 0;
		
		dao = template.getMapper(GuestBookDao.class);
		
		resultCnt = dao.writeArticle(writeRequest);
		
		return resultCnt;
	}
}
