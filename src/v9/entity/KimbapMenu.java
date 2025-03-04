package v9.entity;

public class KimbapMenu extends Menu {
    private String ingredients;

    public KimbapMenu(String name, int price, String ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    @Override
    public String displayDetails() {
        return "메뉴: "+ ingredients+"를 재료로 사용한 "+ getName()+ ", 가격: "+ getPrice();
    }
}
