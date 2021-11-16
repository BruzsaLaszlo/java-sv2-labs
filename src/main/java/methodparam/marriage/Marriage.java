package methodparam.marriage;

import java.time.LocalDate;

public class Marriage {

    public void getMarried(Woman woman, Man man) {

        RegisterDate rd = new RegisterDate("házasságkötés ideje", LocalDate.now());

        woman.addEvent(rd);
        man.addEvent(rd);
        setMarriedName(woman, man);

    }

    private void setMarriedName(Woman woman, Man man) {
        String newFirstName = man.getName().split("[ ]")[0];
        String oldLastname = woman.getName().split("[ ]")[1];
        woman.setName(newFirstName + " " + oldLastname);
    }

}
