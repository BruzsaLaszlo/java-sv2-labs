package inheritanceattributes;

public class BuildingMain {

    public static void main(String[] args) {

        Building building = new Building("Panelház", 50_000, 10);

        SchoolBuilding schoolBuilding = new SchoolBuilding("Oskola", 2000, 3, 12);

        System.out.println(
                        "name: " + building.name +
                        " area: " + building.area +
                        " floors: " + building.getFloors());


        System.out.println(
                "name: " + schoolBuilding.name +
                        " area: " + schoolBuilding.area +
                        " floors: " + schoolBuilding.getFloors() +
                        " classrooms: " + schoolBuilding.getNumberOfClassRooms());
    }

}
