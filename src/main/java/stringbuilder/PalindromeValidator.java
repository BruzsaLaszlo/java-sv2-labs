package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String word) {
        return word.toLowerCase().equals(new StringBuilder(word.toLowerCase()).reverse().toString());
    }

    public static void main(String[] args) {

        PalindromeValidator pv = new PalindromeValidator();
        System.out.println(pv.isPalindrome("Racecar"));
        System.out.println(pv.isPalindrome("Rotator"));
        System.out.println(pv.isPalindrome("Java"));

    }

}
