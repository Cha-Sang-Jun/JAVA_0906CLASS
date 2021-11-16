package controller;

import java.util.ArrayList; 
import java.util.Calendar;

import model.ReplyDTO;

public class ReplyController {
	private ArrayList<ReplyDTO> list;
	private int nextId;
	
	public ReplyController() {
		list = new ArrayList<>();
		nextId = 1;
	}
	
	public void insert(ReplyDTO r) {
		r.setId(nextId++);
		r.setWrittenDate(Calendar.getInstance());
		
		list.add(r);
	}
	
	public ArrayList<ReplyDTO> selectByBoarId(int boardId){  // 글에 댓글을 달기 위해 그 글의 ID 를 불러와야함
		ArrayList<ReplyDTO> temp = new ArrayList<>();
		
		for(ReplyDTO r : list) {
			if(r.getBoardId() == boardId) {
				ReplyDTO tempR = new ReplyDTO(r);
				temp.add(tempR);
			}
		}
		
		return temp;
	}
	
	public void deleteByWrtierId(int writerId) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getWriterId() == writerId) {
				list.remove(i);
				i = -1; // 처음부터 다시 검사할수 있도록 i = -1
			}
		}
	}
}
