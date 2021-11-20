package inheritanceconstructor.tea;

public class Teamain {

    public static void main(String[] args) {

        Tea tea = new Tea("zöld",500);
        HerbalTea herbalTea = new HerbalTea("fekete", 666);

        System.out.println(tea.getName() + " " + tea.getPrice());
        System.out.println(herbalTea.getName() + " " + herbalTea.getPrice());

    }

}
