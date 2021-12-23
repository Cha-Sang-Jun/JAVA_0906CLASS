package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {

	// Service 클래스도 메소드만 있는 클래스다! -> 싱글톤 처리
	private MemberRegService() {
	}

	private static MemberRegService regService = new MemberRegService();

	public static MemberRegService getInstance() {
		return regService;
	}

	// 사용자가 전달한 요청 데이터를 받아서 Dao insert 메소드로 전달하는 기능
	// return : 입력 결과 데이터 반환한다. 사용자 요청 처리 및 응답 처리를 필요로 한다.
	public int insertMember(HttpServletRequest request, HttpServletResponse response) {

		int resultCnt = 0;

		// 파일 업로드
		// 파라미터 받기, 파일 업로드, 저장 파일 이름 생성
		// RegRequest 객체 생성

		// 1. multipart 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			
			String userId = null;
			String pw = null;
			String userName = null;
			String fileName = null; // 파일이 있으면 업로드 하고 저장된 파일의 이름 저장
			
			File newFile = null;
			Connection conn = null;

			// 데이터 받기, 파일 업로드
			
			// 2. 파일 저장을 위한 Factory 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 3. 요청을 구분(form 안에 있는 input들 분리)
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			

			try {
				List<FileItem> items = upload.parseRequest(request); // 입력 정보를 전부 FileItem으로 감싸서 변환
				
				Iterator<FileItem> itr = items.iterator();
				
				while(itr.hasNext()) {
					
					FileItem item = itr.next();
				
					// 일반 파라미터와 file을 구분해서 처리한다.
					if(item.isFormField()) {
						// 일반 파라미터
						// 파라미터 이름에 맞는 데이터를 받고 변수에 저장
						String paramName = item.getFieldName();
						
						if(paramName.contentEquals("userid")) {
							userId = item.getString("utf-8");
						} else if (paramName.equals("pw")) {
							pw = item.getString("utf-8");
						} else if (paramName.equals("username")) {
							userName = item.getString("utf-8");
						}
						
					} else {
						// file
						if(item.getFieldName().equals("photo") && item.getSize()>0) {
							// 웹 저장경로
							String uploadURI = "/uploadfile";
							// 시스템 경로
							String saveDir = request.getSession().getServletContext().getRealPath(uploadURI);
							
							// 새로운 파일 이름은 중복되지 않는 숫자로 생성
							String newFileName = String.valueOf(System.nanoTime());
							
							// file 저장을 위한 File 객체 생성
							newFile = new File(saveDir, newFileName);
							
							// 파일 저장
							 item.write(newFile);
							// item.write(new File(request.getSession().getServletContext().getRealPath(uploadURI)));
							 
							System.out.println("파일 저장 완료");
							
							fileName = newFileName;
						}
						
					}
				}
				
				if(fileName == null) {
					fileName = "img1.jpg";
				}
			
				// Dao 호출
				conn = ConnectionProvider.getConnection();
				
				RegRequest regRequest = new RegRequest(userId, pw, userName, fileName);
				
				resultCnt = MemberDao.getInstance().insertMember(conn, regRequest);
				
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				// 저장된 파일이 있다면 파일을 삭제  -> 원하지 않는 잘못된 파일이 업로드 되었을 경우
				if(newFile != null && newFile.exists()) {
					newFile.delete();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn);
			}

		}

		return resultCnt; // 결과 값은 0과 1 혹은 예외 발생시 -1이 나온다.

	}

}
