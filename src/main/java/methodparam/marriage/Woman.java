package methodparam.marriage;

import java.util.ArrayList;
import java.util.List;

public class Woman {

    private String name;

    private final List<RegisterDate> registerDates = new ArrayList<>();

    public Woman(String name, RegisterDate registerBorn) {
        this.name = name;
        registerDates.add(registerBorn);
    }

    public void addEvent(RegisterDate registerDate) {
        registerDates.add(registerDate);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<RegisterDate> getRegisterDates() {
        return List.copyOf(registerDates);
    }

}
