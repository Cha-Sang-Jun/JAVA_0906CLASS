package com.bitcamp.op.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.domain.Member;

@Service
public class MailSenderService {
	
	@Autowired
	private JavaMailSender sender;
	
	public int send(String email, String userName) {
		
		int resultCnt = 1;
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			// 메일 제목
			message.setSubject("[안내]" +userName+ " 님 회원가입을 축하합니다.", "utf-8");

			// 메일 내용 : html
			String html = "<h1>회원가입을 축하합니다.</h1>";
			html += "<a href = \"http//www.naver.com\">네이버 </a> <br>";
			html += "<a href = \"http//localhost:8080/op\">OpenProject</a> <br>";
			
			message.setText(html, "utf-8", "html");
			
			// from : 보내는 사람 설정, 구글 정책은 setFrom 이 적용되지 않는다.
			message.setFrom(new InternetAddress("test@gmail.com"));
			
			// to : 받는 사람의 이메일 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(email, userName+"님", "utf-8"));
			
			// 메일 발송
			sender.send(message);
			
		} catch (MessagingException | UnsupportedEncodingException e) {
			resultCnt = 0;
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
	public int send(String subject, String content, String email) {
		return 0;
	}
	
	public int send(String[] emails) {
		return 0;
	}
	
	public int send(Member member) {
		return 0;
	}
}
