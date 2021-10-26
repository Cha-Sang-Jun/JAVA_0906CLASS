package chapter12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBufferedCopy {

	public static void main(String[] args) {

		try {
			// 프로그램에서 파일 복사
			// 프로그램이 파일 원본을 읽고 -> 새로운 파일을 생성(쓰기)
			// 원본파일의 데이터를 읽기 위한 스트림 클래스 생성 : InputStream, FileInputStream
			InputStream in = new FileInputStream("eclipse-jee-2019-09-R-win32-x86_64.zip");

			OutputStream out = new FileOutputStream("copy3.zip");

			// 보조 스트림(필터 스트림) : 필터스트림을 사용하기 위해서는 기본 스트림이 필요
			BufferedInputStream bin = new BufferedInputStream(in, 1024*2);
			BufferedOutputStream bout = new BufferedOutputStream(out);

			int copyByte = 0; // 복사한 바이트 사이즈 계산

			int bData = -1; // 스트림으로부터 읽어온 byte 단위의 데이터

			while (true) {
				// 파일 읽기
				bData = bin.read();

				if (bData == -1) {
					break;
				}
				System.out.println(".");

				// 파일쓰기
				out.write(bData);

				copyByte++;
			}

			in.close();
			out.close();

			System.out.println("복사된 byte size : " + copyByte);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
