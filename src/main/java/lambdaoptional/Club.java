package lambdaoptional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Club {

    private List<Member> members;

    public Club(List<Member> members) {
        this.members = members;
    }

    public Optional<Member> findFirst(Predicate<Member> predicate) {
        for (Member member : members) {
            if (predicate.test(member)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> averageNumberOfSkills() {
        if (members.isEmpty()) return Optional.empty();
        int sum = members.stream()
                .mapToInt(member -> member.getSkills().size())
                .sum();
        return Optional.of((double) sum / members.size());
    }

}
