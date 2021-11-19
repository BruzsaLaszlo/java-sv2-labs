package methodvarargs.examstats;

public class ExamStats {

    private final int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {

        if (results == null || results.length == 0)
            throw new IllegalArgumentException("Number of results must not be empty!");

        int limitInPoints = (int) (maxPoints * (limitInPercent / 100d));

        int sum = 0;
        for (int i : results) {
            if (i > limitInPoints)
                sum++;
        }

        return sum;

    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {

        if (results.length == 0)
            throw new IllegalArgumentException("Number of results must not be empty!");

        int limitInPoints = (int) (maxPoints * (limitInPercent / 100d));

        for (int i : results) {
            if (i < limitInPoints) {
                return true;
            }
        }

        return false;

    }

}
