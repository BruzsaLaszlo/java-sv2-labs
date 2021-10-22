package algorithmscount.height;

import java.util.List;

public class Height {

    public int countChildrenWithHeightGreaterThan(List<Integer> childrensHeight, int minHeight) {

        int count = 0;

        for (Integer ch : childrensHeight)
            if (minHeight <= ch)
                count++;

        return count;

    }

}
