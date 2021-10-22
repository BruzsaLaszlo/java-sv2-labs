package algorithmsmax.trainer;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer getTrainerWithMaxAge(List<Trainer> trainers) {

        Trainer max = null;

        for (Trainer trainer : trainers)
            if (max == null || max.getAge() < trainer.getAge())
                max = trainer;

        return max;

    }

}
