package exceptions.sum;

public class NumbersSum {

    public long getSum(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("numbers can't null!");
        }

        long sum = 0;
        for (int n : numbers) {
            sum += n;
        }

        return sum;
    }


    public long getSum(String[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("numbers can't null!");
        }

        long sum =0;
        for (String n : numbers) {
            try {
                sum += Integer.parseInt(n);
            }catch (NumberFormatException nfe){
                throw new IllegalArgumentException("invalid number!", nfe);
            }
        }

        return sum;
    }

}
