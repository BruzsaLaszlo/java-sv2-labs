package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem a termék nevét és árat: ");
        Product product = new Product(scanner.nextLine(), scanner.nextInt());

        product.decreasePrice(product.getPrice()/2);
        System.out.println("Akció 50%  "+ product.getName() + " " + product.getPrice());

        product.increasePrice(product.getPrice()*3);
        System.out.println("Áremelés 2X ár  "+ product.getName() + " " + product.getPrice());

    }

}
