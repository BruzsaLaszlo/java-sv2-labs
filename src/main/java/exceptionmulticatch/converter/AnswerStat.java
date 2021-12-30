package exceptionmulticatch.converter;

public class AnswerStat {

    private BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String codedText) {
        try {
            return binaryStringConverter.binaryStringToBooleanArray(codedText);
        } catch (NullPointerException | IllegalArgumentException exception) {
            throw new InvalidBinaryStringException(exception);
        }
    }

    public int answerTruePercent(String answers) {
        int count = 0;
        for (boolean b : convert(answers)) {
            if (b) {
                count++;
            }
        }
        return count * 100 / answers.length();
    }
}
