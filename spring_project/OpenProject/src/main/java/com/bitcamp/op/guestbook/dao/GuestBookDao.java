package com.bitcamp.op.guestbook.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Select;

import com.bitcamp.op.guestbook.domain.GuestBookListMessage;
import com.bitcamp.op.guestbook.domain.PageView;
import com.bitcamp.op.guestbook.domain.ReplyListItem;
import com.bitcamp.op.guestbook.domain.WriteRequest;

public interface GuestBookDao {

	@Select("select count(*) from guestbook")
	public int selectTotalCount();
	
	public List<GuestBookListMessage> selectList(int index, int count);
	
	public PageView selectByIdx(int idx);

	public List<ReplyListItem> selectReplyList(int idx);

	int writeArticle(WriteRequest writeRequest);

	int updateGuestbook(WriteRequest writeRequest);

	public WriteRequest selectByIdx2(int idx);

	public int deleteByIdx2(int idx);
}
