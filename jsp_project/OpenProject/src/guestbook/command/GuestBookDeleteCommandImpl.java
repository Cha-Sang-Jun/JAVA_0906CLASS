package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookDeleteService;
import member.domain.LoginInfo;

public class GuestBookDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// 게시물 idx
		int idx = Integer.parseInt(request.getParameter("idx"));
		// 현재 로긍니 중인 사용자의 idx
		int memberIdx = ((LoginInfo) request.getSession().getAttribute("loginInfo")).getIdx();
		
		request.setAttribute(
				"result", 
				GuestBookDeleteService.getInstance().deleteMessage(idx, memberIdx) == 1 ? "삭제되었습니다." : "문제가 발생되어 삭제되지않았습니다. 다시 시도해주세요."
				);
		
		return "/WEB-INF/views/guestbook/delete.jsp";
	}

}







