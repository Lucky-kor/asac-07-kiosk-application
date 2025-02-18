package v5;

import v5.helper.KioskConsoleIOHandler;

public class KioskApplication {
    public static void main(String[] args) {

        // 1. Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(new KioskConsoleIOHandler());

        // 웰컴 메시지 출력
        kiosk.printWelcomeMessage();

        // 주문할 메뉴(메뉴 번호)를 선택
        Menu menu = kiosk.selectMenu();

        // 주문할 메뉴의 수량을 선택
        int count = kiosk.selectMenuCount();

        // 총 주문 금액을 출력하고 종료
        kiosk.printOrderPriceMessage(menu, count);
    }
}
