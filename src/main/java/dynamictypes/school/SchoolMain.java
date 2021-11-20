package dynamictypes.school;

public class SchoolMain {

    public static void main(String[] args) {

        School school = new School("ős",0);
        School primarySchool = new PrimarySchool("Német Nemzetiségi", 8);
        School secondarySchool = new SecondarySchool("Gépipari szakközép", 4);

        System.out.println(school);
        System.out.println(primarySchool);
        System.out.println(secondarySchool);
    }

}
