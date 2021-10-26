package literals;

public class LiteralsMain {


    public static void main(String[] args) {

        String s1 = "1" + "2";
        String s2 = '1' + "2";
        String s3 = "";
        s3 += '1';
        s3 += '2';
        System.out.println(s3);

        double qutotient = 3d / 4;
        System.out.println(qutotient);

        long big = 3_244_444_444L;
        System.out.println(big);

        String word = "title".toUpperCase();

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));

    }

}
