package algorithmsmax;

public class Plane {

    public int getLongestOcean(String map) {

        int max = 0;
        int viz = 0;

        for (char c : map.toCharArray())
            if (c == '1') {
                if (max < viz)
                    max = viz;
                viz = 0;
            } else viz++;

        return max;

    }

}
