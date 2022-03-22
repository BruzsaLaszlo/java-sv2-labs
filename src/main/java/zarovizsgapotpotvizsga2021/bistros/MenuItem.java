package zarovizsgapotpotvizsga2021.bistros;

public class MenuItem {

    private String name;
    private int price;
    private MenuItemType type;

    public MenuItem(String name, int price, MenuItemType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return (int) (price * (1 + type.getTax() / 100.0));
    }

    public MenuItemType getType() {
        return type;
    }
}
