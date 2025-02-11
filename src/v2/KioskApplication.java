package v2;

public class KioskApplication {
    public static void main(String[] args) {
        // 1. Kiosk 객체 생성
        Kiosk kiosk = new Kiosk();

        // 웰컴 메시지 출력
        kiosk.printWelcomeMessage();
        // 주문 안내 메시지 출력
        kiosk.printMenuSelectMessage();
        // 주문할 메뉴(메뉴 번호)를 선택
        int menuNumber = kiosk.selectMenu();
        // 주문할 메뉴의 수량을 선택
        int count = kiosk.selectMenuCount();

        // 전체 주문 금액을 계산
        int currentOrderPrice = kiosk.calculateOrderPrice(menuNumber, count);
        // 총 주문 금액을 출력하고 종료
        kiosk.printOrderPriceMessage(currentOrderPrice);
    }
}
