package numbers;

public class Percent {

    public double getValue(int number, int percent) {
        return (double) number * percent / 100;
    }

    public double getBase(int number, int percent) {
        return (double) number / percent * 100;
    }

    public double getPercent(int number, int anotherNumber) {
        return (double) anotherNumber / number * 100;
    }


    public static void main(String[] args) {

        Percent percent = new Percent();

        System.out.println(percent.getValue(200, 30));
        System.out.println(percent.getBase(60, 30));
        System.out.println(percent.getPercent(200, 60));

    }

}
