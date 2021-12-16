package dept.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	// 추상메소드 : public abstract
	// Command 의 역할 : view page 경로 반환
	// 내부 처리는 : 사용자 요청하는 데이터 처리 -> 결과 data를 request의 속성에 데이터 저장
	String getPage(HttpServletRequest request, HttpServletResponse response);
}
