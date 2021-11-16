package viewer;

import controller.ReplyController; 
import model.MemberDTO;
import model.ReplyDTO;
import util.ScannerUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ReplyViewer {
	private ReplyController replyController;
	private Scanner scanner;
	private MemberViewer memberViewer;
	private MemberDTO logIn;
	private final String DATE_TIME_FORMAT = new String("y/M/d H:m:s");

	public ReplyViewer() {
		replyController = new ReplyController();

	}

	public void setMemberViewer(MemberViewer memberViewer) {
		this.memberViewer = memberViewer;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public void setLogIn(MemberDTO logIn) {
		this.logIn = logIn;
	}

	public int printAll(int boardId) { // BoardViewer 에 있는 뒤로가기를 불러오기 위해? 리턴 값이 int로
		ArrayList<ReplyDTO> list = replyController.selectByBoarId(boardId);

		// 댓글이 존재 할 때에만 for문으로 출력
		if (!list.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
			for (ReplyDTO r : list) {
				System.out.printf("%s by ", r.getContent());
				memberViewer.printNickName(r.getWriterId());
				System.out.println(" at " + sdf.format(r.getWrittenDate().getTime()));
			}
		}

		String message = new String("1. 댓글 등록 2. 뒤로 가기");

		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);

		if (userChoice == 1) {
			// 새 댓글 작성 메소드 실행
			writeReply(boardId);
		}

		return userChoice;
	}

	private void writeReply(int boardId) { // 새 댓글 작성 메소드
		ReplyDTO r = new ReplyDTO();

		r.setBoardId(boardId);

		// 작성자 회원번호와 내용을 저장해준다
		String message = new String("댓글의 내용을 입력해주세요.");
		r.setContent(ScannerUtil.nextLine(scanner, message));
		
		r.setWriterId(logIn.getId());
		

		replyController.insert(r);
	}
	
	public void deleteByWriterId(int writerId) {
		replyController.deleteByWrtierId(writerId);
	}
}
