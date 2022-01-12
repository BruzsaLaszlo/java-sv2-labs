package collectionsautoboxing;

import java.util.HashMap;
import java.util.Map;

public class Vote {

    public Map<VoteResult, Integer> getResult(Map<String, VoteResult> voteByName) {
        var result = new HashMap<VoteResult, Integer>();
        result.put(VoteResult.YES, 0);
        result.put(VoteResult.NO, 0);
        result.put(VoteResult.ABSTAIN, 0);

        for (VoteResult voteResult : voteByName.values()) {
            switch (voteResult) {
                case YES -> result.put(VoteResult.YES, result.get(VoteResult.YES) + 1);
                case NO -> result.put(VoteResult.NO, result.get(VoteResult.NO) + 1);
                case ABSTAIN -> result.put(VoteResult.ABSTAIN, result.get(VoteResult.ABSTAIN) + 1);
            }
        }
        return result;
    }

}
