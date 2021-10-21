package debug;

public class Star {

    public void writeStars(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int prev;
            if (i == 0)
                prev = 0;
            else
                prev = numbers[i - 1];
            int stars = numbers[i] - prev;
            printStars(stars);
            System.out.println();
        }
    }

    private void printStars(int stars) {
        for (int i = 1; i <= stars; i++) {
            System.out.print("*");
        }
    }

    public static void main(String[] args) {

        Star star = new Star();

        int[] nums = {1, 3, 5, 10, 12};

        star.writeStars(nums);

    }
}
