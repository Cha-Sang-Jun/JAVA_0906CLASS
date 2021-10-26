package exam2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

public class Note {
//	1. 콘솔기반으로 메모장 기능을 만들어 봅시다.

//	② 문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
//	③ 파일의 이름은 날짜와 메모의 제목을 이용해서 생성
//	④ 메모리스트와 파일 읽기 기능을 구현해봅시다.

	public static void main(String[] args) throws IOException {
		
//		① File 클래스를 이용해서 저장 폴더 생성
		File myFile = new File("d:\\myJava\\Note");
		if(!myFile.exists()) {
			myFile.mkdir();
			System.out.println("파일이 존재하지 않습니다. 파일을 새로 생성합니다.");
		}
		
		
	
		String time = String.valueOf(Calendar.getInstance().getTime());
		
	}
}
