package member.service;

import java.sql.Connection;
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
import member.dao.MemberDao;
import member.domain.Member;

public class MemberEditService {
	
	private MemberEditService() {}
	private static MemberEditService service = new MemberEditService();
	public static MemberEditService getInstance() {
		return service;
	}

	
	// idx 값으로 Member 객체를 반환하는 메소드
	public Member getMember(int idx) {
		
		Member member = null;
		
		Connection conn = null;
		
		try {
			conn =  ConnectionProvider.getConnection();
			
			member = MemberDao.getInstance().selectByIdx(conn, idx);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	
	public int editMember(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				
				String idx = null;
				String userid = null;
				String password = null;
				String username = null;
				String oldfile = null;
				String filename = null;  // photo를 가져옴
				
				List<FileItem> items = upload.parseRequest(request);
				
				Iterator<FileItem> itr = items.iterator();
				
				while(itr.hasNext()) { // 폼인지 아닌지 확인해야 한다.
					
					FileItem item = itr.next();
					
					if(item.isFormField()) {
						// not file
						
					} else {
						// file
						
					}
				}
				
				// DB : Update처리
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		
		return resultCnt;
	}
	

}
