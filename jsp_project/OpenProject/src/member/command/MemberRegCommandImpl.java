package member.command;

import java.sql.SQLException; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberRegService;

public class MemberRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		String view = null;

		// 회원 가입을 위한 form (Get) -> 가입 처리 (POST)
		if (request.getMethod().equals("GET")) {

			view = "/WEB-INF/views/member/regform.jsp";

		} else if (request.getMethod().equals("POST")) {

			// int cnt = MemberRegService.getInstance().insertMember(request, response);

			// request 속성 처리 (여기서 해도 되고 밑에서 해도 됨)
			// request.setAttribute("result", cnt);
			request.setAttribute("result", MemberRegService.getInstance().insertMember(request, response));
			
			view = "/WEB-INF/views/member/reg.jsp";

		}

		// request 속성 처리
		return view;
	}

}
