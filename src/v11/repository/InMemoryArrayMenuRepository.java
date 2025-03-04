//package v11.repository;
//
//import v11.entity.KimbapMenu;
//import v11.entity.KoreaMenu;
//import v11.entity.Menu;
//
//import java.util.Arrays;
//
//public class InMemoryArrayMenuRepository implements MenuRepository<Menu[]> {
//    private Menu[] menus;
//    private int currentMaxMenuCount;
//    private static final int INCREMENT_COUNT = 10;
//
//    public InMemoryArrayMenuRepository() {
//        menus = new Menu[INCREMENT_COUNT];
////
//        menus[0] = new KimbapMenu("김밥",1000, "당근, 오이, 단무지");
//        menus[1] = new KoreaMenu("참치 덮밥", 3000, 600 , Menu.SaleStatus.UNAVAILABLE);
//        menus[2] = new KimbapMenu("충무 김밥",1000, "단무지");
//        menus[3] = new KoreaMenu("떡볶이",2000, 500, Menu.SaleStatus.COMING_SOON);
//        menus[4] = new KimbapMenu("계란 김밥",1500, "당근, 단무지, 계란");
//
//        currentMaxMenuCount = 5;
//    }
//
//    @Override
//    public Menu[] findAll() {
//        // 전체 메뉴를 반환해야 합니다.
//        // BUT! 판매가 불가능한 상품은 포함하지 말아야 합니다.
//            // 전체 메뉴를 순회
//        int availableMenuCount = 0;
//        for(int i = 0; i < currentMaxMenuCount; i++) {
//            // 그 중, 판매가 가능한 상품을 카운트
//            if(menus[i].getStatus() != Menu.SaleStatus.COMING_SOON && menus[i].getStatus() != Menu.SaleStatus.UNAVAILABLE) {
//                availableMenuCount++;
//            }
//        }
//            // 그 갯수만큼의 새로운 배열을 선언
//        Menu[] availableMenus= new Menu[availableMenuCount];
//            // 그 상품만 다시 순회하며 배열에 담고
//            // 해당 배열을 리턴
//
//        // 아래 순회는 데이터가 제대로 들어가지 못함. 배열의 한계(인덱스를 2개로 관리해야 합니다)
//        // 현재 새로운 배열의 인덱스, 전체 메뉴의 인덱스
////        for(int i = 0; i < availableMenuCount; i++) {
////            // 그 중, 판매가 가능한 상품을 카운트
////            if(menus[i].getStatus() != Menu.SaleStatus.COMING_SOON && menus[i].getStatus() != Menu.SaleStatus.UNAVAILABLE) {
////                availableMenus[i] = menus[i];
////            }
////        }
//        int currentIndex = 0;
//        for(int i = 0; i < currentMaxMenuCount; i++) {
//            if(menus[i].getStatus() != Menu.SaleStatus.COMING_SOON && menus[i].getStatus() != Menu.SaleStatus.UNAVAILABLE) {
//                availableMenus[currentIndex] = menus[i];
//                currentIndex++;
//            }
//        }
//
//        return availableMenus;
//    }
//
//    @Override
//    public Menu findById(int id) {
//        if(id >= 1 && id <= menus.length && menus[id].getStatus() != Menu.SaleStatus.DISCONTINUED && menus[id].getStatus() != Menu.SaleStatus.UNAVAILABLE) {
//            return menus[id];
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Menu menu) {
//        // 메뉴를 저장하는 기능
//
//        // 1. menus가 가득 차 있는 경우
//        if(currentMaxMenuCount == menus.length) {
//                // 1-1 menus의 크기를 늘리고
////            Menu[] extendMenuArray = new Menu[currentMaxMenuCount + INCREMENT_COUNT];
////
////            for(int i = 0; i < menus.length; i++) {
////                extendMenuArray[i] = menus[i];
////            }
////
////            menus = extendMenuArray;
//            // 위 코드는 아래 copyOf를 써서 한 줄로 대체할 수 있습니다.
//            menus = Arrays.copyOf(menus, menus.length + INCREMENT_COUNT);
//
//            // 늘린 배열에 상품을 추가
//        }
//        menus[++currentMaxMenuCount] = menu;
//    }
//
//    @Override
//    public void delete(int id) {
//        // id가 크기를 벗어나지 않을 경우에만 동작
//        // 아닐때는 그냥 종료
//        if(1 <= id && currentMaxMenuCount < id) return;
//
//        // id에 맞는 메뉴를 삭제해야 합니다.
//
//        // [김밥, 참치김밥, 계란김밥, 떡볶이] -> 계란김밥 삭제(id = 3)
//        // 새로운 배열을 선언 -> 크기는 3 ->[null, null, null]
//        Menu[] currentMenuArray = new Menu[menus.length];
//            // 해당 상품 전까지 데이터를 새로운 배열에 넣고 -> 순회를 2까지만-> [김밥, 참치김밥. null]
//            // 이후 데이터를 삽입 -> 계란김밥(3) 패스하고 4부터 순회하며 저장
//        int currentIndex = 0;
//        for(int i = 0; i < menus.length; i++) {
//            if(i != id - 1) {
//                currentMenuArray[currentIndex] = menus[i];
//                currentIndex++;
//            }
//        }
//
//        // 실제 서비스에서는 데이터를 삭제하지 않으므로, 상태만 변경하는 아래 코드를 작성하게 됩니다.
//
////        if(id >= 1 && id <= currentMaxMenuCount) {
////            menus[id - 1].setStatus(Menu.SaleStatus.DISCONTINUED);
////        }
//    }
//}
