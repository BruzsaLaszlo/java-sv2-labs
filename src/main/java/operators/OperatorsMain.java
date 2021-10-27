package operators;

public class OperatorsMain {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(65535));
        System.out.println();

        Operators operators = new Operators();

        System.out.println(operators.isNull(null));
        System.out.println(operators.isNull(new String()));
        System.out.println();

        System.out.println(operators.getResultOfDivision(1024,1000));
        System.out.println();

        System.out.println(operators.isEmpty(null));
        System.out.println(operators.isEmpty(""));
        System.out.println(operators.isEmpty("Valami"));
        System.out.println();

        System.out.println(operators.isEven(12));
        System.out.println(operators.isEven(123));
    }

}
