package model;

// 회원 정보를 담당하는 모델 클래스
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private int rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean equals(Object o) {
        if (o instanceof UserDTO) {
            UserDTO u = (UserDTO) o;
            return id == u.id;
        }

        return false;
    }

    // 파라미터 없이 각 필드를 0과 "" 으로 초기화하는
    // 생성자
    public UserDTO() {
        id = 0;
        username = new String();
        password = new String();
        nickname = new String();
        rank = 0;
    }

    // 파라미터로 들어온 객체의 필드 값을
    // 새로운 객체에 복사하는 생성자
    public UserDTO(UserDTO u) {
        id = u.id;
        username = new String(u.username);
        password = new String(u.password);
        nickname = new String(u.nickname);
        rank = u.rank;
    }
}
