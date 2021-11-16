package model;

public class TheaterDTO {
    private int id;
    private String name;
    private String location;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean equals(Object o) {
        if (o instanceof TheaterDTO) {
            TheaterDTO t = (TheaterDTO) o;
            return id == t.id;
        }

        return false;
    }

    // 파라미터 없이 각 필드를 0과 "" 으로 초기화하는
    // 생성자
    public TheaterDTO() {
        id = 0;
        name = new String();
        location = new String();
        phoneNumber = new String();
    }

    // 파라미터로 들어온 객체의 필드 값을
    // 새로운 객체에 복사하는 생성자
    public TheaterDTO(TheaterDTO t) {
        id = t.id;
        name = new String(t.name);
        location = new String(t.location);
        phoneNumber = new String(t.phoneNumber);
    }
}
