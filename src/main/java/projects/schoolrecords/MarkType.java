package projects.schoolrecords;

public enum MarkType {

    A(5, "excellent"), B(4, "very good"), C(3, "improvement needed"), D(2, "close fail"), F(1, "fail");

    private int number;
    private String excellent;

    MarkType(int number, String excellent) {
        this.number = number;
        this.excellent = excellent;
    }

    @Override
    public String toString() {
        return excellent + '(' + number + ')';
    }

    public int getNumber() {
        return number;
    }

    public String getExcellent() {
        return excellent;
    }
}
