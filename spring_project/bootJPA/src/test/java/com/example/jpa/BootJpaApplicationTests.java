package com.example.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.member.domain.MemberEntity;
import com.example.jpa.member.domain.MemberRepository;

@SpringBootTest
class BootJpaApplicationTests {

	@Autowired
	MemberRepository repository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void 회원정보생성() {
		
		MemberEntity entity = MemberEntity.builder().idx(111)
													// .userid("cool@gmail.com")
													// .password("1234")
													// .username("cool")
													// .photo("img1.jpg")
													// .regdate(new Date().toString())  // 필요한 데이터만 입력하여 필요한 객체만 받아서 생성할수 있다?
													.role("ADMIN")
													.build();
		
		System.out.println(entity);
	
	}
	
	@Test
	void 회원정보생성및데이터가져오기() {  // entity에 있는 pk값이 같은 경우 데이터를 변경시키는 save and flush가 있으므로 idx 값은 0으로
		MemberEntity entity = MemberEntity.builder()
				 .idx(0)
				 .userid("cool@gmail.com")
				 .password("1234")
				 .username("cool")
				 .photo("img1.jpg")
				 .regdate(new Date().toString())
				 .role("ADMIN")
				 .build();
		
		repository.saveAndFlush(entity);
		System.out.println("저장완료");
		
		// 저장 됐으면 데이터 가져오기
		List<MemberEntity> list = repository.findAll();
		
		MemberEntity memberEntity = list.get(0);
		System.out.println(memberEntity);
		
		assertThat(memberEntity.getUserid()).isEqualTo("cool@gmail.com");
		assertThat(memberEntity.getRole()).isEqualTo("ADMIN");

	}
}
