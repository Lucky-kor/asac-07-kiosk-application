package v6.utils;

import v6.entity.Menu;

public class KioskUtils {
    // 주문에 필요한 총 금액 계산
    public static int calculateTotalPrice(Menu menu, int count) {
        return menu.getPrice() * count;
    }

    // 메뉴 선택시 숫자 범위 유효성 검증
    public static boolean isValidMenuOption(int option, int maxOption) {
        return option >= 1 && option <= maxOption;
    }

    // 수량 선택시 숫자 범위 유효성 검증
    public static boolean isValidQuantity(int quantity, int maxQuantity) {
        return quantity >= 1 && quantity <= maxQuantity;
    }

    // String to Int
    public static int StringToInt(String input) {
        if(isNumeric(input)) {
            return Integer.parseInt(input);
        } else {
            return -1;
        }
    }
    // 변환 가능한가? -> String to int에서 사용되기 때문에, private
    private static boolean isNumeric(String input) {
        String number = "0123456789";

        if(input.isEmpty()) return false;

        for(int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if(number.indexOf(curChar) == -1) {
                return false;
            }
        }
        return true;
    }
}
