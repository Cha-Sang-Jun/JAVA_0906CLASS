package com.example.jpa.member.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.member.domain.MemberEntity;
import com.example.jpa.member.domain.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberRestController {

	// final 을 붙여서 상수처리 -> 초기화를 ??? 뭔소린가 -> 암튼 생성자 생략하고 쓸 수 있음 @RequiredArgsContstructor 필요
 	private final MemberRepository repository;

	// @Autowired 없이도 주입이 가능하다.
//	public MemberRestController(MemberRepository repository) {
//		this.repository = repository;
//	}
	
	// 전체 리스트 출력
	@GetMapping
	public List<MemberEntity> getMemberList(){
		return repository.findAll();
	}
	
	@PostMapping
	public String memberInsert() {

		MemberEntity entity = MemberEntity.builder()
				 .idx(0)
				 .userid("cool@gmail.com")
				 .password("1234")
				 .username("cool")
				 .photo("img1.jpg")
				 .regdate(new Date().toString())
				 .role("ADMIN")
				 .build();
		
		return repository.saveAndFlush(entity).toString();
		
	}
	
	// 개별 데이터 가져오기
	@GetMapping("/{idx}")  // 뒤에 들어오는 idx값을 받아서 처리
	public Optional<MemberEntity> getMember(
			@PathVariable("idx") Long idx) {
		
		return repository.findById(idx);
	}
	
	// 수정
	@PutMapping("/{idx}")
	public String memberUpdate(
			@PathVariable("idx") Long idx) {
		
		MemberEntity entity = MemberEntity.builder()
				 .idx(idx)
				 .userid("hot@gmail.com")
				 .password("0000")
				 .username("hot")
				 .photo("img02.png")
				 .regdate(new Date().toString())
				 .role("MEMBER")
				 .build();
		
		return repository.saveAndFlush(entity).toString();
	}
	
	// 삭제
	@DeleteMapping("/{idx}")
	public void memberDelete(
			@PathVariable("idx") Long idx) {
		
		MemberEntity entity = MemberEntity.builder().idx(idx).build();
		
		repository.delete(entity);
		
	}
}
