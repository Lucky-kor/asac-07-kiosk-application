package v8.entity;

public abstract class Menu {
    private String name;
    private int price;
    private SaleStatus status;

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
        this.status = SaleStatus.AVAILABLE;
    }

    public Menu(String name, int price, SaleStatus status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public abstract String displayDetails();

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public enum SaleStatus {
        AVAILABLE("판매 중"),
        UNAVAILABLE("판매 중지"),
        DISCOUNT("할인 상품"),
        COMING_SOON("판매 예정"),
        DISCONTINUED("판매 종료");

        private String status;

        SaleStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return this.status;
        }
    }
}
