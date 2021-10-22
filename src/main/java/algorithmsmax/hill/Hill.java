package algorithmsmax.hill;

import java.util.List;

public class Hill {

    public int getMax(List<Integer> hills) {

        int max = -100;

        for(Integer hill: hills)
            if (max < hill)
                max = hill;

        return max;

    }

}
