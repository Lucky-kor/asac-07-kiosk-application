package v6.entity;

public class KoreaMenu extends Menu {
    private int kcal;

    public KoreaMenu(String name, int price, int kcal) {
        this(name, price);
        this.kcal = kcal;
    }

    public KoreaMenu(String name, int price) {
        super(name, price);
    }

    @Override
    public String displayDetails() {
        return "메뉴: " + getName() + ", 가격: "+ getPrice() + ", Kcal: " + kcal;
    }
}
