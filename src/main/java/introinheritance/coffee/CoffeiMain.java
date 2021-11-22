package introinheritance.coffee;

public class CoffeiMain {

    public static void main(String[] args) {

        Coffee coffee = new Coffee();
        coffee.setName("CoffeName");
        coffee.setPrice(111);

        Cappucino cappucino = new Cappucino();
        cappucino.setName("CappucinoName");
        cappucino.setPrice(222);

        System.out.println(coffee);
        System.out.println(cappucino);
    }

}
