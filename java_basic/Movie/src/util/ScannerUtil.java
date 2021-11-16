package util;

// Scanner 클래스 변수로
// 키보드 입력을 받을 때
// 도움이 될 메소드를 모아둔 클래스
import java.util.Scanner;

public class ScannerUtil {
    // 1. 입력시 입력 안내 문구 출력을 담당할
    // printMessage()
    private static void printMessage(String message) {
        System.out.println(message);
        System.out.print("> ");
    }

    // 2. int 입력을 담당할 nextInt()
    public static int nextInt(Scanner scanner, String message) {
        String temp = nextLine(scanner, message);

        String pattern = "^[0-9]+$";

        while (!temp.matches(pattern)) {
            System.out.println("숫자만 입력하실 수 있습니다.");
            temp = nextLine(scanner, message);
        }

        int result = Integer.parseInt(temp);

        return result;
    }

    // 3. 특정 범위의 int 입력을 담당할 nextInt()
    public static int nextInt(Scanner scanner, String message, int min, int max) {
        int num = nextInt(scanner, message);

        while (!(num >= min && num <= max)) {
            System.out.println("===============================");
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("===============================\n");
            num = nextInt(scanner, message);
        }

        return num;
    }

    // 4. 스캐너 버퍼메모리 버그를 내부적으로 해결하는
    // nextLine()
    public static String nextLine(Scanner scanner, String message) {
        printMessage(message);
        String temp = scanner.nextLine();

        if (temp.isEmpty()) {
            temp = scanner.nextLine();
        }

        return temp;
    }
}
