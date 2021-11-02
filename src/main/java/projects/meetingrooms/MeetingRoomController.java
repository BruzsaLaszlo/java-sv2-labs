package projects.meetingrooms;

import java.util.Scanner;

public class MeetingRoomController {

    private Office office;

    public static void main(String[] args) {

        MeetingRoomController mrc = new MeetingRoomController();

        mrc.runMenu();

    }

    public MeetingRoomController() {
        office = new Office();
    }

    public void runMenu() {
        StringBuilder menu = new StringBuilder()
                .append("--------------- MENU ---------------\n")
                .append("1. Tárgyaló rögzítése\n")
                .append("2. Tárgyalók sorrendben\n")
                .append("3. Tárgyalók visszafele sorrendben\n")
                .append("4. Minden második tárgyaló\n")
                .append("5. Területek\n")
                .append("6. Keresés pontos név alapján\n")
                .append("7. Keresés névtöredék alapján\n")
                .append("8. Keresés terület alapján\n")
                .append("9. Kilépés\n")
                .append("------------------------------------");

        printMenu(menu.toString());
    }

    private void printMenu(String menu) {

        boolean exit = false;
        while (!exit) {
            System.out.println(menu);

            switch (getSelected()) {
                case 1:
                    readOffice();
                    break;
                case 2:
                    office.printNames();
                    break;
                case 3:
                    office.printNamesReverse();
                    break;
                case 4:
                    office.printEvenNames();
                    break;
                case 5:
                    office.printAreas();
                    break;
                case 6:
                    System.out.println("Kérem a nevet: ");
                    office.printMeetingRoomsWithName(getStringFromConsole());
                    break;
                case 7:
                    System.out.println("Kérem a névtöredéket: ");
                    office.printMeetingRoomsContains(getStringFromConsole());
                    break;
                case 8:
                    System.out.println("Kérem a területet: ");
                    office.printAreasLargerThan(getIntFromConsole());
                    break;
                case 9:
                    exit = true;
                    break;
                default:
            }
        }
    }

    private String getStringFromConsole() {
        return new Scanner(System.in).nextLine();
    }

    private int getIntFromConsole() {
        String s;
        boolean isDigit;
        do {
            isDigit = true;
            s = getStringFromConsole();
            for (int i = 0; i < s.length(); i++)
                if (!Character.isDigit(s.charAt(i))) {
                    isDigit = false;
                    System.out.println("Számot kérek: ");
                    break;
                }
        } while (!isDigit);

        return Integer.parseInt(s);
    }

    private int getSelected() {
        char c;
        do {
            String s = getStringFromConsole();
            c = s.isEmpty() ? 0 : s.charAt(0);
        }
        while (!Character.isDigit(c) && c != 0);

        return c - '0';
    }

    private void readOffice() {

        System.out.println("Kérem a nevet: ");
        String name = getStringFromConsole();

        System.out.println("Kérem a szélességet: ");
        int width = getIntFromConsole();

        System.out.println("Kérem a hosszt: ");
        int length = getIntFromConsole();

        MeetingRoom mr = new MeetingRoom(name, width, length);

        if (office.addMeetigRoom(mr))
            System.out.println("Sikeresen hozzáadva : " + mr);
    }

}
