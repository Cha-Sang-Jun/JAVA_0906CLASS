package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;
		
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// request 에 대한 필터 처리
		request.setCharacterEncoding(encoding);
		
		// response에 대한 처리
		chain.doFilter(request, response);  // 다음 필터로 넘어가서 처리 -> 필터 처리가 끝난 후에는 사용자가 요청한 Servlet으로

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.encoding = filterConfig.getInitParameter("encoding");
		
		if(encoding == null) {
			this.encoding = "utf-8";
		}
	}

}
