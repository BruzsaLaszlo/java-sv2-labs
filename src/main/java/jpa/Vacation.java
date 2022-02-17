package jpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Vacation {

    private LocalDate startTime;

    private int days;

}