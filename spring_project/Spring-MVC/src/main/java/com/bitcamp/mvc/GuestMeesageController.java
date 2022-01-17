package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mvc.domain.GuestMessage;
import com.bitcamp.mvc.domain.OrderItem;

// @Controller
@RestController // RestController를 사용할 경우 ResponseBody 생략가능
public class GuestMeesageController {

	// Jackson이라는 컨버터를 추가한 덕분에 list타입의 객체를 json 형식으로 바꾸어서 볼 수 있게 된다.
	@RequestMapping("/guest/list.json")
	// @ResponseBody // view가 아니라 일반 객체 타입으로 반환
	public List<GuestMessage> getMessageList() {

		List<GuestMessage> list = new ArrayList<GuestMessage>();
		list.add(new GuestMessage(1, "테스트메세지", new Date()));
		list.add(new GuestMessage(2, "인사합니다", new Date()));
		list.add(new GuestMessage(3, "다음에 만나요", new Date()));

		return list;
	}

	@RequestMapping("/simple")
	public String getString() {
		return "return String";
	}

	@RequestMapping("/orderItem")
	public OrderItem getOrderItem() {
		return new OrderItem("product-10", 10000, "파손주의");
	}

	@RequestMapping("/orderItems")
	public List<OrderItem> getOrderItems() {

		List<OrderItem> list = new ArrayList<OrderItem>();
		list.add(new OrderItem("product-10", 10000, "파손주의"));
		list.add(new OrderItem("product-11", 100, "파손주의"));

		return list;

	}

	@RequestMapping("/orderItems2")
	public Map<String, OrderItem> getOrderItems2() {

		Map<String, OrderItem> map = new HashMap<String, OrderItem>();
		map.put("product-10", new OrderItem("product-10", 10000, "파손주의"));   // 앞에있는 key값은 속성의 이름("product-10"), 뒤의 내용은 속성의 Data로 처리
		map.put("product-20", new OrderItem("product-20", 100, "파손주의"));  // map으로 입력할때는 key값은 중복되지 않게
		
		return map;
	}
}
