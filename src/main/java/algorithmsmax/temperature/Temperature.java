package algorithmsmax.temperature;

import java.util.List;

public class Temperature {

    public int getMin(List<Integer> temperatures) {

        int min = 1000;

        for(Integer temp: temperatures)
            if (min > temp)
                min = temp;

        return min;

    }

}
