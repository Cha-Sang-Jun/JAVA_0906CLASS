package com.bitcamp.hgs.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.member.dao.MemberDao;
import com.bitcamp.hgs.member.domain.EditMember;
import com.bitcamp.hgs.member.domain.Member;

@Service
public class MemberEditService {

	public MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public Member getMember(int memberIdx) {

		dao = template.getMapper(MemberDao.class);

		System.out.println("selectByIdx : " + dao.selectByIdx(memberIdx));

		return dao.selectByIdx(memberIdx);
	}

	public int editMember(EditMember editMember, HttpServletRequest request) throws IllegalStateException, IOException {

		int resultCnt = 0;

		File newFile = null;

		if (!editMember.getProfile().isEmpty() && editMember.getProfile().getSize() > 0) {

			String savePath = request.getSession().getServletContext().getRealPath("/uploadfile");

			String[] files = editMember.getProfile().getOriginalFilename().split("\\.");

			String exet = files[files.length - 1];

			String newFileName = System.nanoTime() + "." + exet;

			newFile = new File(savePath, newFileName);

			editMember.getProfile().transferTo(newFile);

			editMember.setFileName(newFileName);

		}

		try {
			dao = template.getMapper(MemberDao.class);

			resultCnt = dao.editMember(editMember);

		} catch (Exception e) {
			if (newFile != null && newFile.exists()) {
				newFile.delete();
			}

			e.printStackTrace();
			throw e;
		}

		return resultCnt;
	}
}
