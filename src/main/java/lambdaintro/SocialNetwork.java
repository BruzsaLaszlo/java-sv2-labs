package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public List<Member> findMembersBy(Predicate<Member> predicate) {
        var result = new ArrayList<Member>();
        for (Member member : members) {
            if (predicate.test(member)) {
                result.add(member);
            }
        }
        return result;
    }

    public void applyToSelectedMembers(Predicate<Member> predicate, Consumer<Member> consumer) {
        for (Member member : members) {
            if (predicate.test(member)) {
                consumer.accept(member);
            }
        }
    }

    public <R> List<R> transformMembers(Function<Member, R> function) {
        var result = new ArrayList<R>();
        for (Member member : members) {
            result.add(function.apply(member));
        }
        return result;
    }
}
