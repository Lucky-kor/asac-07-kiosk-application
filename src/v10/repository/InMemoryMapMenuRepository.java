package v10.repository;

import v10.entity.Menu;
import v10.entity.KimbapMenu;
import v10.entity.KoreaMenu;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMapMenuRepository implements MenuRepository<Map<Integer, Menu>>{
    private Map<Integer, Menu> menus;

    public InMemoryMapMenuRepository() {
        this.menus = new HashMap<>();

        menus.put(1, new KimbapMenu("김밥",1000, "당근, 오이, 단무지"));
        menus.put(2, new KoreaMenu("참치 덮밥", 3000, 600 , Menu.SaleStatus.UNAVAILABLE));
        menus.put(3, new KimbapMenu("충무 김밥",1000, "단무지"));
        menus.put(4, new KoreaMenu("떡볶이",2000, 500, Menu.SaleStatus.COMING_SOON));
        menus.put(5, new KimbapMenu("계란 김밥",1500, "당근, 단무지, 계란"));

//        menus.get(3).setStatus(Menu.SaleStatus.DISCONTINUED);
    }

    @Override
    public Map<Integer, Menu> findAll() {
        Map<Integer, Menu> foundMenus = new HashMap<>();

        Integer currentKey = 1;

        for(Map.Entry<Integer, Menu> entry: menus.entrySet()) {
            Menu menu = entry.getValue();
            if(saleStatusMenu(menu)) {
                foundMenus.put(currentKey, menu);
                currentKey++;
            }
        }

        return foundMenus;
    }

    @Override
    public Menu findById(int id) {
        Map<Integer, Menu> foundMenus = findAll();

        if(isValidIndex(id, foundMenus.size()) && saleStatusMenu(foundMenus.get(id))) {
            return foundMenus.get(id);
        }

        return null;
    }

    @Override
    public void save(Menu menu) {
        menus.put(menus.size() + 1, menu);
    }

    @Override
    public void delete(int id) {
        if(isValidIndex(id, menus.size()) && menus.get(id).getStatus() != Menu.SaleStatus.DISCONTINUED) {
            menus.get(id).setStatus(Menu.SaleStatus.DISCONTINUED);
        }
    }

    private boolean saleStatusMenu(Menu menu) {
        Menu.SaleStatus status = menu.getStatus();
        return status == Menu.SaleStatus.AVAILABLE || status == Menu.SaleStatus.DISCOUNT;
    }

    private boolean isValidIndex(int menuId, int maxSize) {
        return menuId >= 1 && menuId <= maxSize;
    }
}
