package algorithmsdecision;

public class Prime {

    public boolean isPrime(int number) {

        if (number < 2)
            return false;
        else if (number == 2)
            return true;

        int sqrt = (int)Math.sqrt(number);
        for (int i = 3; i < sqrt; i++)
            if (number % i == 0)
                return false;

        return true;

    }

}
