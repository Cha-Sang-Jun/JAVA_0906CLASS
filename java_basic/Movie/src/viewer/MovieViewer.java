package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MovieController;
import model.MovieDTO;
import model.UserDTO;
import util.ScannerUtil;

public class MovieViewer {
    private RatingViewer ratingViewer;
    private ShowViewer showViewer;
    private UserDTO logIn;
    private Scanner scanner;
    private MovieController movieController;

    private final int CATEGORY_ALL = 1;
    private final int CATEGORY_CRITIC = 2;
    private final int CATEGORY_GENERAL = 3;
    private final int RANK_ADMIN = 1;

    // 컨트롤러 초기화를 위한 생성자
    public MovieViewer() {
        movieController = new MovieController();
    }

    // 의존성 주입을 위한 setter
    public void setShowViewer(ShowViewer showViewer) {
        this.showViewer = showViewer;
    }

    public void setRatingViewer(RatingViewer ratingViewer) {
        this.ratingViewer = ratingViewer;
    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    // 관리자용 영화 메뉴 출력 메소드
    public void printAdminMenu() {
        String message = new String("1. 영화 전체 목록 보기 2. 신규 영화 입력 3. 뒤로 가기");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                add();
            } else if (userChoice == 3) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }

    // 비관리자용 영화 메뉴 출력 메소드
    public void printNonAdminMenu() {
        String message = new String("1. 영화 전체 목록 보기 2. 뒤로 가기");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }

    // 영화 목록 출력 메소드
    public void printList() {
        ArrayList<MovieDTO> list = movieController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 영화가 존재하지 않습니다.");
        } else {
            System.out.println("===============================================");
            for (MovieDTO m : list) {
                System.out.printf("%d. %s \n", m.getId(), m.getTitle());
            }
            System.out.println("===============================================");
            String message = new String("상세보기할 영화의 번호를 입력하거나 뒤로 가실려면 0을 입력해주세요.");
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && movieController.selectOne(userChoice) == null) {
                System.out.println("해당 번호는 유효하지 않습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice, CATEGORY_ALL);
            }
        }
    }

    // 영화 개별 출력 메소드
    public void printOne(int id, int cateogry) {
        // 영화의 정보를 출력하는 코드
        MovieDTO m = movieController.selectOne(id);

        System.out.println("-----------------------------------");
        System.out.println("제목: " + m.getTitle());
        System.out.println("-----------------------------------");
        System.out.println("등급: " + m.getFilmRate() + "세 이용가");
        System.out.println("-----------------------------------");
        System.out.println("줄거리");
        System.out.println("-----------------------------------");
        System.out.println(m.getSummary());
        System.out.println("-----------------------------------");
        System.out.println();

        // 관리자 혹은 비관리자인지 확인하여
        // 관리자는 영화 수정, 삭제의 메뉴를 보여주고
        // 비관리자는 평점과 관련된 메뉴를 보여준다.
        String message;
        if (logIn.getRank() == RANK_ADMIN) {
            // 로그인한 사용자의 회원 등급이 관리자이므로
            // 개별 영화와 관련된 기능을 실행한다.
            message = new String("1. 영화 수정 2. 영화 삭제 3. 뒤로가기");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                update(id);
            } else if (userChoice == 2) {
                delete(id);
            } else if (userChoice == 3) {
                printList();
            }

        } else {
            // 로그인한 사용자의 회원 등급이 관리자가 아니므로
            // 평점 관련 코드를 실행한다.

            ratingViewer.printList(id, CATEGORY_ALL);

            message = new String("1. 전체 평점 출력 2. 평론가 평점 출력 3. 일반 회원 평점 출력 4. 평점 등록 5. 뒤로 가기");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 5);
            while (userChoice != 5) {
                if (userChoice == 1) {
                    ratingViewer.printList(id, CATEGORY_ALL);
                } else if (userChoice == 2) {
                    ratingViewer.printList(id, CATEGORY_CRITIC);
                } else if (userChoice == 3) {
                    ratingViewer.printList(id, CATEGORY_GENERAL);
                } else if (userChoice == 4) {
                    ratingViewer.add(id);
                    ratingViewer.printList(id, CATEGORY_ALL);
                }

                userChoice = ScannerUtil.nextInt(scanner, message, 1, 5);
            }

            if (userChoice == 5) {
                printList();
            }

        }
    }

    // 영화 입력 메소드
    private void add() {
        MovieDTO m = new MovieDTO();

        String message;

        message = new String("영화의 제목을 입력해주세요.");
        m.setTitle(ScannerUtil.nextLine(scanner, message));

        message = new String("영화의 줄거리를 입력해주세요.");
        m.setSummary(ScannerUtil.nextLine(scanner, message));

        message = new String("영화의 등급을 입력해주세요.");
        m.setFilmRate(ScannerUtil.nextInt(scanner, message));

        movieController.insert(m);
    }

    // 영화 수정 메소드
    private void update(int id) {
        MovieDTO m = movieController.selectOne(id);

        String message;

        message = new String("새로운 제목을 입력해주세요.");
        m.setTitle(ScannerUtil.nextLine(scanner, message));

        message = new String("새로운 줄거리를 입력해주세요.");
        m.setSummary(ScannerUtil.nextLine(scanner, message));

        message = new String("새로운 등급을 입력해주세요.");
        m.setFilmRate(ScannerUtil.nextInt(scanner, message));

        movieController.update(m);

        printOne(id, CATEGORY_ALL);
    }

    // 영화 삭제 메소드
    private void delete(int id) {
        String message = new String("정말로 삭제하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            movieController.delete(id);
            ratingViewer.deleteByMovieId(id);
            showViewer.deleteByMovieId(id);
            printList();
        } else {
            printOne(id, CATEGORY_ALL);
        }
    }

    // 영화 제목 출력 메소드
    public void printTitle(int movieId) {
        MovieDTO m = movieController.selectOne(movieId);
        System.out.printf("%s", m.getTitle());
    }

    // 영화 목록을 간략하게 출력하고
    // 관리자가 특정 영화를 선택할 수 있게 하는 메소드
    public int printIdName() {
        int userChoice = 0;
        ArrayList<MovieDTO> list = movieController.selectAll();

        if (list.isEmpty()) {
            System.out.println("등록된 영화가 존재하지 않습니다.");
        } else {
            for (MovieDTO m : list) {
                System.out.printf("%d. %s\n", m.getId(), m.getTitle());
            }

            String message = new String("영화 번호를 입력하시거나 뒤로 가실려면 0을 입력해주세요.");
            userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && movieController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }
        }

        return userChoice;
    }

}
