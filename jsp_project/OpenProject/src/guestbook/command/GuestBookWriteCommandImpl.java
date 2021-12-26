package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

public class GuestBookWriteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		if(request.getMethod().equals("GET")) {
			
			view = "/WEB-INF/views/guestbook/writeform.jsp";
			
		} else if (request.getMethod().equals("POST")) {
			
			
			view = "/WEB-INF/views/guestbook/write.jsp";
		}
		
		return view;
	}

}
