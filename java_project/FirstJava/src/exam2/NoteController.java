package exam2;

import java.util.ArrayList;

public class NoteController {

	private ArrayList<NoteDTO> list;
	private int nextId;

	public void makeConnection() {
		list = new ArrayList<>();
		nextId = 1;
	}

	public void insert(NoteDTO n) {
		n.setId(nextId++);
	}

	public ArrayList<NoteDTO> selectAll() {

		ArrayList<NoteDTO> temp = new ArrayList<>();
		for (NoteDTO n : list) {
			NoteDTO tempN = new NoteDTO();
			tempN.setId(n.getId());
			tempN.setName(new String(n.getName()));
			tempN.setTitle(new String(n.getTitle()));
			tempN.setDate(new String(n.getDate()));
			tempN.setContent(new String(n.getContent()));
			temp.add(tempN);
		}

		return temp;
	}

	public NoteDTO selectOne(int id) {
		for (NoteDTO n : list) {
			if (id == n.getId()) {
				NoteDTO temp = new NoteDTO();
				temp.setId(n.getId());
				temp.setName(new String(n.getName()));
				temp.setTitle(new String(n.getTitle()));
				temp.setDate(new String(n.getDate()));
				temp.setContent(new String(n.getContent()));

				return temp;
			}
		}

		return null;
	}
}
