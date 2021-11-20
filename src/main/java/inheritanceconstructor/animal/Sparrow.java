package inheritanceconstructor.animal;

public class Sparrow extends Bird {

    public Sparrow() {
        super();
        System.out.println("Sparrow class constructor");
    }


    public static void main(String[] args) {

        new Sparrow();

    }

}