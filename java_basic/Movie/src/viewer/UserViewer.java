package viewer;

import java.util.Scanner;

import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
    private MovieViewer movieViewer;
    private RatingViewer ratingViewer;
    private ShowViewer showViewer;
    private TheaterViewer theaterViewer;
    private UserDTO logIn;
    private Scanner scanner;
    private UserController userController;

    private final int RANK_ADMIN = 1;
    private final int RANK_CRITIC = 2;

    // 컨트롤러 초기화를 위한 생성자
    public UserViewer() {
        userController = new UserController();
        scanner = new Scanner(System.in);
    }

    // 의존성 주입을 위한 setter
    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
        this.movieViewer.setScanner(scanner);
    }

    public void setRatingViewer(RatingViewer ratingViewer) {
        this.ratingViewer = ratingViewer;
        this.ratingViewer.setScanner(scanner);
    }

    public void setShowViewer(ShowViewer showViewer) {
        this.showViewer = showViewer;
        this.showViewer.setScanner(scanner);
    }

    public void setTheaterViewer(TheaterViewer theaterViewer) {
        this.theaterViewer = theaterViewer;
        this.theaterViewer.setScanner(scanner);
    }

    // 인덱스 출력 메소드
    public void showIndex() {
        String message = new String(" 1. 회원가입 2. 로그인 3. 종료");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                register();
            } else if (userChoice == 2) {
                logIn();

                // 로그인 객체가 널이 아닐 경우,
                // 등급에 따라 관리자용 메뉴 혹은 비관리자용 메뉴를 실행한다.
                if (logIn != null) {
                    // 각 뷰어에 logIn 객체에
                    // setter를 통해 UserViewer의 logIn 객체를
                    // 주입한다.
                    movieViewer.setLogIn(logIn);
                    ratingViewer.setLogIn(logIn);
                    theaterViewer.setLogIn(logIn);

                    if (logIn.getRank() == RANK_ADMIN) {
                        showAdminMenu();
                    } else {
                        showNonAdminMenu();
                    }
                }
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                scanner.close();
                break;
            }
        }
    }

    // 회원 가입 메소드
    public void register() {
        String message;

        message = new String("사용하실 아이디를 입력해주세요.");
        String username = ScannerUtil.nextLine(scanner, message);

        // 해당 아이디가 유효한 아이디인지 검사 후
        // 올바르지 않으면 다시 입력을 받거나
        // 종료 옵션을 입력받는다.
        while (userController.validate(username)) {
            System.out.println("해당 아이디는 사용하실 수 없습니다.");
            System.out.println("만약 회원가입을 원치 않으신 경우에는 X를 입력해주세요.");
            username = ScannerUtil.nextLine(scanner, message);

            if (username.equalsIgnoreCase("X")) {
                break;
            }
        }

        // 사용할 아이디가 X 가 아닐 경우에만
        // 추가적인 정보를 입력받고
        // UserDTO 객체에 정보를 저장하고
        // 컨트롤러를 통해 추가한다.

        if (!username.equalsIgnoreCase("X")) {
            message = new String("사용하실 비밀번호를 입력해주세요.");
            String password = ScannerUtil.nextLine(scanner, message);

            message = new String("사용하실 닉네임을 입력해주세요.");
            String nickname = ScannerUtil.nextLine(scanner, message);

            UserDTO u = new UserDTO();
            u.setUsername(username);
            u.setPassword(password);
            u.setNickname(nickname);

            userController.insert(u);

        }

    }

    // 회원 로그인 메소드
    public void logIn() {
        String message;

        message = new String("아이디를 입력해주세요.");
        String username = ScannerUtil.nextLine(scanner, message);

        message = new String("비밀번호를 입력해주세요.");
        String password = ScannerUtil.nextLine(scanner, message);

        while (userController.auth(username, password) == null) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("로그인을 원치 않으실 경우에는 X를 입력해주세요.");

            message = new String("아이디를 입력해주세요.");
            username = ScannerUtil.nextLine(scanner, message);

            if (username.equalsIgnoreCase("X")) {
                break;
            }

            message = new String("비밀번호를 입력해주세요.");
            password = ScannerUtil.nextLine(scanner, message);
        }

        logIn = userController.auth(username, password);
    }

    // 회원 로그아웃 메소드
    public void logOut() {
        System.out.println("정상적으로 로그아웃되었습니다.");
        // logIn 객체를 null 로 초기화한다.
        logIn = null;

        // 각 뷰어의 logIn 객체에
        // null을 넘겨서 초기화한다.
        movieViewer.setLogIn(null);
        ratingViewer.setLogIn(null);
        theaterViewer.setLogIn(null);
    }

    // 관리자용 메뉴 출력 메소드
    public void showAdminMenu() {
        String message = new String("1. 영화 관리 메뉴 2. 극장 관리 메뉴 3. 상영 관리 메뉴 4. 로그아웃");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
            if (userChoice == 1) {
                // 관리자용 영화 관리 메뉴 호출
                movieViewer.printAdminMenu();
            } else if (userChoice == 2) {
                // 관리자용 극장 관리 메뉴 호출
                theaterViewer.printAdminMenu();
            } else if (userChoice == 3) {
                // 관리자용 상영 관리 메뉴 호출
                showViewer.showAdminMenu();
            } else if (userChoice == 4) {
                logOut();
                break;
            }
        }
    }

    // 비관리자용 메뉴 출력 메소드
    public void showNonAdminMenu() {
        String message = new String("1. 영화 목록 보기 2. 극장 목록 보기 3. 내 정보 보기 4. 로그아웃");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
            if (userChoice == 1) {
                // 영화 목록 출력
                movieViewer.printNonAdminMenu();
            } else if (userChoice == 2) {
                // 극장 목록 출력
                theaterViewer.printNonAdminMenu();
            } else if (userChoice == 3) {
                // 회원 정보 개별 출력
                printOne(logIn.getId());
            } else if (userChoice == 4) {
                logOut();
            }

            // 로그아웃 혹은 회원탈퇴시에는
            // 메뉴 출력 메소드를 종료시킨다.
            if (logIn == null) {
                break;
            }
        }
    }

    // 회원 정보 개별 출력 메소드
    public void printOne(int id) {
        UserDTO u = userController.selectOne(id);

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(u.getNickname() + "회원 님의 정보");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("회원 닉네임: " + u.getNickname());
        System.out.println("-----------------------------------------------------------------------------");

        // 회원 등급을 출력하기위한 String
        String title = new String("일반 회원");

        if (u.getRank() == RANK_ADMIN) {
            title = new String("관리자");
        } else if (u.getRank() == RANK_CRITIC) {
            title = new String("전문 평론가");
        }

        System.out.println("회원 등급: " + title);

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();

        String message = new String("1. 회원 정보 수정 2. 회원 탈퇴 3. 뒤로 가기");

        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            withdrawl(id);
        }

    }

    // 회원 정보 수정 메소드
    public void update(int id) {
        UserDTO u = userController.selectOne(id);

        String message;

        message = new String("새로운 비밀번호를 입력해주세요.");
        u.setPassword(message);

        message = new String("새로운 닉네임을 입력해주세요.");
        u.setNickname(message);

        userController.update(u);

        System.out.println("새로운 정보로 정상적으로 수정되었습니다.");

        printOne(id);
    }

    // 회원 탈퇴 메소드
    public void withdrawl(int id) {
        String message = new String("정말로 탈퇴하시겠습니까? Y/N");

        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            userController.delete(id);
            ratingViewer.deleteByWriterId(id);
            logIn = null;
            System.out.println("회원 탈퇴가 완료되었습니다.");
        } else {
            printOne(id);
        }
    }

    // 닉네임 출력 메소드
    public void printNickname(int id) {
        System.out.print(userController.selectOne(id).getNickname());
    }

    // 회원등급을 리턴하는 메소드
    public int selectRankById(int id) {
        // 원래대로라면 Viewer 클래스는
        // "출력만" 담당하는 것이 올바르지만
        // 지금같은 경우는 우리가 데이터베이스가 따로 존재하지 않으므로
        // private 접근제한자가 적용된 userController의 메소드 실행 결과값을
        // 이용하는 메소드를 만들어주게 된다.
        return userController.selectOne(id).getRank();
    }
}
