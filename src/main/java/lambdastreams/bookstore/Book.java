package lambdastreams.bookstore;

public record Book(

        String title,
        int yearOfPublish,
        int price,
        int piece

) {
}
