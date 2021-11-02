package introexceptiontrycatch;

import java.util.Arrays;
import java.util.List;

public class FirstLetter {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("ez", "egy", "szó", "", "meg", "nem", "az");
        for (String s : words) {
            try {
                System.out.println(s.substring(0, 1));
            }
            catch (StringIndexOutOfBoundsException exception){
                exception.printStackTrace();
            }
        }

    }


}
