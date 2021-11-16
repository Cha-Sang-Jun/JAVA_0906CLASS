package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ShowController;
import model.ShowDTO;
import util.ScannerUtil;

public class ShowViewer {
    private MovieViewer movieViewer;
    private TheaterViewer theaterViewer;
    private Scanner scanner;
    private ShowController showController;

    // 컨트롤러 초기화를 위한 생성자
    public ShowViewer() {
        showController = new ShowController();
    }

    // 의존성 주입을 위한 setter
    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }

    public void setTheaterViewer(TheaterViewer theaterViewer) {
        this.theaterViewer = theaterViewer;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    // 관리자용 메뉴 출력 메소드
    public void showAdminMenu() {
        String message = new String("1. 상영 정보 목록 보기 2. 상영 정보 입력 3. 뒤로 가기");
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

    // 모든 상영 정보를 출력하는 메소드
    public void printList() {
        ArrayList<ShowDTO> list = showController.selectAll();

        if (list.isEmpty()) {
            System.out.println("현재 상영중인 영화가 없습니다.");
        } else {
            for (ShowDTO s : list) {
                System.out.printf("%d. ", s.getId());
                movieViewer.printTitle(s.getMovieId());
                System.out.print(" AT ");
                theaterViewer.printName(s.getTheaterId());
                System.out.printf(" - %s\n", s.getShowTime());
            }
            String message = new String("상세보기할 상영 번호나 뒤로 가실려면 0을 입력해주세요.");
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice != 0 && showController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }

        }

    }

    // 해당 극장의 상영 정보를 출력하는 메소드
    public void printListByTheaterId(int theaterId) {
        ArrayList<ShowDTO> list = showController.selectByTheaterId(theaterId);

        if (list.isEmpty()) {
            System.out.println("해당 극장에서 상영중인 영화가 없습니다.");
        } else {
            for (ShowDTO s : list) {
                System.out.printf("%d. ", s.getId());
                movieViewer.printTitle(s.getMovieId());
                System.out.printf(" - %s\n", s.getShowTime());
            }
        }
    }

    // 상영 정보 개별 출력 메소드
    private void printOne(int id) {
        ShowDTO s = showController.selectOne(id);
        System.out.println("------------------------------------------");
        movieViewer.printTitle(s.getMovieId());
        System.out.println(" 상영 정보");
        System.out.println("------------------------------------------");
        System.out.print("상영 극장: ");
        theaterViewer.printName(s.getTheaterId());
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("상영 시간: " + s.getShowTime());
        System.out.println("------------------------------------------");

        String message = new String("1. 상영 정보 수정 2. 상영 정보 삭제 3. 뒤로 가기");
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        } else if (userChoice == 3) {
            printList();
        }
    }

    // 상영 정보 수정 메소드
    private void update(int id) {
        ShowDTO s = showController.selectOne(id);
        String message = new String("새로운 상영 시간을 입력해주세요.");
        s.setShowTime(ScannerUtil.nextLine(scanner, message));

        showController.update(s);
        printOne(id);
    }

    // 상영 정보 삭제 메소드
    private void delete(int id) {
        String message = new String("정말로 삭제하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            showController.delete(id);
            printList();
        } else {
            printOne(id);
        }
    }

    // 상영 정보 입력 메소드
    private void add() {
        ShowDTO s = new ShowDTO();

        int movieId = movieViewer.printIdName();

        int theaterId = theaterViewer.printIdName();

        if (movieId != 0 && theaterId != 0) {
            s.setMovieId(movieId);
            s.setTheaterId(theaterId);

            String message = new String("상영 시간을 입력해주세요.");
            s.setShowTime(ScannerUtil.nextLine(scanner, message));

            showController.insert(s);
        }
    }

    // ShowController 필드의
    // deleteByMovieId()를
    // 대신 실행할 메소드
    public void deleteByMovieId(int movieID) {
        showController.deleteByMovieId(movieID);
    }

    // ShowController 필드의
    // deleteByTheaterId()를
    // 대신 실행할 메소드
    public void deleteByTheaterId(int theaterId) {
        showController.deleteByTheaterId(theaterId);
    }

}
