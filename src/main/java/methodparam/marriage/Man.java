package methodparam.marriage;

import java.util.ArrayList;
import java.util.List;

public class Man {

    private final String name;

    private final List<RegisterDate> registerDates = new ArrayList<>();

    public Man(String name, RegisterDate registerBorn) {
        this.name = name;
        registerDates.add(registerBorn);
    }

    public void addEvent(RegisterDate registerDate) {
        registerDates.add(registerDate);
    }

    public String getName() {
        return name;
    }

    public List<RegisterDate> getRegisterDates() {
        return List.copyOf(registerDates);
    }
}
