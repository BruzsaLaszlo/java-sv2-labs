package conversions;

import java.util.ArrayList;
import java.util.List;

public class Digits {

    private List<Integer> digitList = new ArrayList<>();

    public void addToDigitsToList(String text) {
        for (char c : text.toCharArray())
            if (Character.isDigit(c))
                digitList.add(c - '0');
    }

    public List<Integer> getDigitList() {
        return digitList;
    }

    public static void main(String[] args) {

        Digits digits = new Digits();
        digits.addToDigitsToList("2 * 2 néha 5");
        System.out.println(digits.getDigitList());

    }

}
