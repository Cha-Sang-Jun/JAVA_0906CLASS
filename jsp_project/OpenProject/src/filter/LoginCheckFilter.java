package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {  
		// 인터페이스를 상속할 경우 사용하지 않는 메소드도 이런식으로 구현해주어야 한다.
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 요청할 때 처리
		// 로그인 체크 하고, 로그아웃 상태이면 로그인 폼 페이지로 이동,
		// 로그인 상태면 정상적으로 처리
		
		// 로그인 상태 체크 : HttpSession 객체의 속성에 loginInfo 이름의 속성이 존재하는지 체크
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		if(session != null && session.getAttribute("loginInfo") != null) {
			// 로그인 상태일시 -> 정상처리
			chain.doFilter(request, response); // 다음 체인으로 이동을 시킨다?
		} else {
			// 로그아웃 상태일 때
			String uri = ((HttpServletRequest)request).getContextPath() + "/member/login.do";
			((HttpServletResponse)response).sendRedirect(uri);
		}
		
		
		// 사용자 요청을 처리하고 응답하기 전에 처리
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
