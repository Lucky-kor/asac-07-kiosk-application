package v3;

import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    private Menu menu1 = new Menu("김밥",1000);
    private Menu menu2 = new Menu("계란 김밥",1500);
    private Menu menu3 = new Menu("충무 김밥",1000);
    private Menu menu4 = new Menu("떡볶이",2000);

    // 1. 웰컴 메시지 출력
    public void printWelcomeMessage() {
        System.out.println("[안내] 안녕하세요. 분식점에 오신것을 환영합니다.");
        System.out.println("-------------------------------------");
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
        System.out.printf("[안내] 주문하신 %s 메뉴의 총 금액은 %d원 입니다.%n",
                menu.getName(), calculateOrderPrice(menu, count));
        System.out.println("이용해 주셔서 감사합니다.");
    }


    private void printMenuSelectMessage() {
        System.out.println("[안내] 원하시는 메뉴의 번호를 입력하여 주세요.");
        System.out.println("1) 김밥(1000원) 2) 계란 김밥(1500원) 3) 충무 김밥(1000원) 4) 떡볶이(2000원)");
    }
    private void printMenuSelectExceptionMessage() {
        System.out.println("[안내] 메뉴에 포함된 번호를 입력해 주세요.");
    }

    private void printMenuCountMessage() {
        System.out.println("-------------------------------------");
        System.out.println("[안내] 선택하신 메뉴의 수량을 입력하여 주세요.");
        System.out.println("* 최대 주문 가능 수량: 99");
    }

    private void printMenuCountExceptionMessage(int count) {
        System.out.printf("[경고] %d개는 입력할 수 없습니다.\n", count);
        System.out.println("[안내] 수량 선택 화면으로 돌아갑니다.");
    }

    private int inputMenuCountNumber() {
        int count = 0;
        do {
            count = sc.nextInt();
            if(count <= 0 || count >= 100) {
                printMenuCountExceptionMessage(count);
            }
        } while(count <= 0 || count >= 100);
        return count;
    }

    // 사용자의 입력에 따라 선택한 번호를 반환하는 메서드

    private int inputMenuNumber() {
        int menuNumber = 0;

        do {
            menuNumber = sc.nextInt();
            if(menuNumber < 1 || menuNumber > 4) {
                printMenuSelectExceptionMessage();
            }
        } while(menuNumber < 1 || menuNumber > 4);

        return menuNumber;
    }

    // 6. 총 금액을 계산하는 메서드
    private int calculateOrderPrice(Menu menu, int count) {
        return menu.getPrice() * count;
    }
}
