package sorting.webshop;

import java.time.LocalDateTime;

public record Product(

        String name,
        int price,
        LocalDateTime from

) {
}
