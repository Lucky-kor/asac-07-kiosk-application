package v5;

import v5.helper.IOHandler;
import v5.helper.KioskConsoleIOHandler;
import v5.utils.KioskUtils;

import java.util.Scanner;

public class Kiosk {
    final IOHandler ioHandler;

    public Kiosk(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    private final Menu menu1 = new Menu("김밥",1000);
    private final Menu menu2 = new Menu("계란 김밥",1500);
    private final Menu menu3 = new Menu("충무 김밥",1000);
    private final Menu menu4 = new Menu("떡볶이",2000);

    public static final int MAX_QUANTITY = 99;


    // 1. 웰컴 메시지 출력
    public void printWelcomeMessage() {
        ioHandler.writeOutput("[안내] 안녕하세요. 분식점에 오신것을 환영합니다.");
        ioHandler.writeOutput("-------------------------------------");
    }

    // 3. 주문할 음식을 선택(사용자의 입력)
    public Menu selectMenu() {
        printMenuSelectMessage();
        int menuNumber = inputMenuNumber();

        return switch (menuNumber) {
            case 1 -> menu1;
            case 2 -> menu2;
            case 3 -> menu3;
            case 4 -> menu4;
            default -> null;
        };
    }

    // 4. 상품 갯수 선택(사용자 입력)
    public int selectMenuCount() {
        printMenuCountMessage();
        return inputMenuCountNumber();
    }

    // 7. 총 주문 금액을 출력하고 프로그램 종료
    public void printOrderPriceMessage(Menu menu, int count) {
        ioHandler.writeOutput(String.format("[안내] 주문하신 %s 메뉴의 총 금액은 %d원 입니다.%n",
                menu.getName(),
                KioskUtils.calculateTotalPrice(menu, count)));
        ioHandler.writeOutput("이용해 주셔서 감사합니다.");
    }


    private void printMenuSelectMessage() {
        ioHandler.writeOutput("[안내] 원하시는 메뉴의 번호를 입력하여 주세요.");
        ioHandler.writeOutput("1) 김밥(1000원) 2) 계란 김밥(1500원) 3) 충무 김밥(1000원) 4) 떡볶이(2000원)");
    }
    private void printMenuSelectExceptionMessage() {
        ioHandler.writeOutput("[안내] 메뉴에 포함된 번호를 입력해 주세요.");
    }

    private void printMenuCountMessage() {
        ioHandler.writeOutput("-------------------------------------");
        ioHandler.writeOutput("[안내] 선택하신 메뉴의 수량을 입력하여 주세요.");
        ioHandler.writeOutput("* 최대 주문 가능 수량: 99");
    }

    private void printMenuCountExceptionMessage(int count, String source) {
        if(count == -1) {
            ioHandler.writeOutput(String.format("[경고] %s개는 입력할 수 없습니다.\n", source));
        } else {
            ioHandler.writeOutput(String.format("[경고] %d개는 입력할 수 없습니다.\n", count));
        }
        ioHandler.writeOutput("[안내] 수량 선택 화면으로 돌아갑니다.");
    }

    private int inputMenuCountNumber() {
        int count = 0;
        do {
            String input = ioHandler.readInput();
            count = KioskUtils.StringToInt(input);

            if(!KioskUtils.isValidQuantity(count, MAX_QUANTITY)) {
                printMenuCountExceptionMessage(count, input);
            }
        } while(!KioskUtils.isValidQuantity(count, MAX_QUANTITY));
        return count;
    }

    // 사용자의 입력에 따라 선택한 번호를 반환하는 메서드

    private int inputMenuNumber() {
        int menuNumber = 0;

        do {
            String input = ioHandler.readInput();
            menuNumber = KioskUtils.StringToInt(input);
            if(!KioskUtils.isValidMenuOption(menuNumber, 4)) {
                printMenuSelectExceptionMessage();
            }
        } while(!KioskUtils.isValidMenuOption(menuNumber, 4));

        return menuNumber;
    }
}
