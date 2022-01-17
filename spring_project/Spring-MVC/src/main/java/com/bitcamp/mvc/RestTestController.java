package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc/simple")
public class RestTestController {

	@GetMapping
	public String form() {
		return "mc/form";
	}
	
	@PostMapping
	@ResponseBody  // return 하는 내용(응답타입 : String) 을 ResponseBody 내용으로 쓰겠다는 의미 -> 단순한 문자열을 응답하고 싶을 때
	public String simple(@RequestBody String bodyContent) {    // RequestBody : form의 파라미터 (uname=cool&age=11) 들어오는 내용을 bodyContent로 받겠다는 의미
		System.out.println("bodyContent :" +bodyContent);
		return "Rest Test";
	}
}
