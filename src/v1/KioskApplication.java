package v1;

import java.util.Scanner;

public class KioskApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 메뉴 안내 메시지 출력

        // 1. 웰컴 메시지 출력
        System.out.println("[안내] 안녕하세요. 분식점에 오신것을 환영합니다.");
        System.out.println("-------------------------------------");
        // 2. 주문 안내 메시지(메뉴 선택) 출력
        System.out.println("[안내] 원하시는 메뉴의 번호를 입력하여 주세요.");
        System.out.println("1) 김밥(1000원) 2) 계란 김밥(1500원) 3) 충무 김밥(1000원) 4) 떡볶이(2000원)");

        int menuNumber = 0;

        // 3. 주문할 음식을 선택(사용자의 입력)
        do {
            menuNumber = sc.nextInt();
            if(menuNumber < 1 || menuNumber > 4) {
                System.out.println("[안내] 메뉴에 포함된 번호를 입력해 주세요.");
            }
        } while(menuNumber < 1 || menuNumber > 4);

        // 4. 상품 갯수 선택(사용자 입력)

        // 입력을 위한 안내 메시지 출력
        int count = 0;
        do {
            System.out.println("-------------------------------------");
            System.out.println("[안내] 선택하신 메뉴의 수량을 입력하여 주세요.");
            System.out.println("* 최대 주문 가능 수량: 99");
            count = sc.nextInt();
            if(count <= 0 || count >= 100) {
                System.out.printf("[경고] %d개는 입력할 수 없습니다.\n", count);
                System.out.println("[안내] 수량 선택 화면으로 돌아갑니다.");
            }
        } while(count <= 0 || count >= 100);

        // 5. 상품과 수량을 곱해 총 금액을 계산
        int menuPrice = 0;
        switch (menuNumber) {
            case 1:
                menuPrice = 1000;
                break;
            case 2:
                menuPrice = 1500;
                break;
            case 3:
                menuPrice = 1000;
                break;
            case 4:
                menuPrice = 2000;
                break;
            default:
        }
        // 6. 총 금액을 출력하고 프로그램 종료
        int currentOrderPrice = menuPrice * count;
        System.out.printf("[안내] 주문하신 메뉴의 총 금액은 %d원 입니다.%n", currentOrderPrice);
        System.out.println("이용해 주셔서 감사합니다.");
    }
}
