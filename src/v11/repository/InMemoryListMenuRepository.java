package v11.repository;

import v11.entity.KimbapMenu;
import v11.entity.KoreaMenu;
import v11.entity.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryListMenuRepository implements MenuRepository<List<Menu>> {
    private List<Menu> menus;

    public InMemoryListMenuRepository() {
        this.menus = new ArrayList<>();

        menus.add(new KimbapMenu("김밥",1000, "당근, 오이, 단무지"));
        menus.add(new KoreaMenu("참치 덮밥", 3000, 600 , Menu.SaleStatus.UNAVAILABLE));
        menus.add(new KimbapMenu("충무 김밥",1000, "단무지"));
        menus.add(new KoreaMenu("떡볶이",2000, 500, Menu.SaleStatus.COMING_SOON));
        menus.add(new KimbapMenu("계란 김밥",1500, "당근, 단무지, 계란"));
    }

    @Override
    public List<Menu> findAll() {
        // 전체 메뉴를 리스트에 담아서 반환해야 합니다.
        // But! 판매 불가능한 상품을 제외해야 합니다.
        List<Menu> availableMenus = new ArrayList<>();

        for(Menu menu: menus) {
            if(saleStatusMenu(menu)) {
                availableMenus.add(menu);
            }
        }

        return availableMenus;
    }

    @Override
    public Optional<Menu> findById(int id) {
        // 특정 메뉴 하나만 반환. 해당 id - 1의 인덱스에 있는 상품을...!
        // 해당 상품이 판매 불가라면 null을 반환
        List<Menu> currentSoledMenus = findAll();

        if(isValidIndex(id) && saleStatusMenu(menus.get(id - 1))) {
            Menu currentSelectedMenu = currentSoledMenus.get(id - 1);
            return Optional.of(currentSelectedMenu);
        }

        return Optional.empty();
    }

    @Override
    public void save(Menu menu) {
        menus.add(menu);
    }

    @Override
    public void delete(int id) {
        if(isValidIndex(id)) menus.remove(id - 1);
    }

    private boolean saleStatusMenu(Menu menu) {
        Menu.SaleStatus status = menu.getStatus();
        return status == Menu.SaleStatus.AVAILABLE || status == Menu.SaleStatus.DISCOUNT;
    }

    private boolean isValidIndex(int menuId) {
        return menuId >= 1 && menuId <= menus.size();
    }
}
