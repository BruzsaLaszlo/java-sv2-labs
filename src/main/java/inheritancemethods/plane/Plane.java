package inheritancemethods.plane;

public class Plane {

    public static void main(String[] args) {

        Passenger passenger = new Passenger("Pista", 50_000);
        System.out.println(passenger);

        PriorityPassenger priorityPassenger = new PriorityPassenger("Jancsi", 50_000, 50);
        System.out.println(priorityPassenger);

        FirstClassPassenger firstClassPassenger = new FirstClassPassenger("Juliska", 50_000, 50);
        System.out.println(firstClassPassenger);

    }

}
