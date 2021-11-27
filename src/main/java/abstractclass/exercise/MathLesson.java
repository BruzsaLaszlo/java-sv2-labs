package abstractclass.exercise;

public class MathLesson {

    public static void main(String[] args) {

        MathExercise adder = new Adder();
        MathExercise subtracter = new Subtracter();
        MathExercise multiplier = new Multiplier();
        MathExercise divisor = new Divisor();

        System.out.println(adder.getSolution(5, 5));
        System.out.println(subtracter.getSolution(5, 5));
        System.out.println(multiplier.getSolution(5, 5));
        System.out.println(divisor.getSolution(5, 5));

    }

}
