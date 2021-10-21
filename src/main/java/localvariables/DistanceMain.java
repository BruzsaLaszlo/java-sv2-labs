package localvariables;

public class DistanceMain {

    public static void main(String[] args) {

        Distance distance = new Distance(3.33, false);

        System.out.println("Distance: " + distance.getDistanceInKm());
        System.out.println("Exact: " + distance.isExact());

        int i = (int) distance.getDistanceInKm();
        System.out.println("Egészrész: " + i);
    }
}
