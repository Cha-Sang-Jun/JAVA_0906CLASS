package classEx;
// Database 연결을 담당할 클래스들이 가지고 있을
// 메소드를 선언한 인터페이스

public interface DBConnector {
	public void makeConnection();
	public void destroyConnection();
	public void insert();
	public void delete();
	public void selectAll();
	public void selectOne();
	public void update();

}
