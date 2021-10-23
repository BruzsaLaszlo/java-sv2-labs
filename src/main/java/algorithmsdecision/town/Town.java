package algorithmsdecision.town;

import java.util.List;

public class Town {

    public boolean containsFewerHabitants(List<Integer> habitants, int min) {

        for(Integer hab: habitants)
            if (min > hab)
                return true;

        return false;

    }

}
