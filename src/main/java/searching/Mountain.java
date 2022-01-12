package searching;

import java.util.Arrays;

public class Mountain {

    private int[] heigths;

    public Mountain(int[] heigths) {
        this.heigths = heigths;
    }

    public boolean searchPike(Pike pike) {
        return searchPikeByRecursion(0, heigths.length - 1, pike)
                && searchPikeByIteration(pike)
                && Arrays.binarySearch(heigths, pike.heigth()) >= 0;
    }

    private boolean searchPikeByRecursion(int min, int max, Pike pike) {
        int middle = (min + max) / 2;
        if (min != max) {
            if (heigths[middle] < pike.heigth()) {
                searchPikeByRecursion(middle + 1, max, pike);
            } else if (heigths[middle] > pike.heigth()) {
                searchPikeByRecursion(min, middle, pike);
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean searchPikeByIteration(Pike pike) {
        int min = 0;
        int max = heigths.length - 1;
        while (min != max) {
            int middle = (min + max) / 2;
            if (heigths[middle] < pike.heigth()) {
                min = middle + 1;
            } else if (heigths[middle] > pike.heigth()) {
                max = middle;
            } else {
                return true;
            }
        }
        return false;
    }

}
