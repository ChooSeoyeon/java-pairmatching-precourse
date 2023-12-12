package pairmatching.model;

import java.util.HashMap;
import java.util.Map;
import pairmatching.model.dto.MatchingResult;
import pairmatching.view.dto.Target;

public class MatchingHistory {
    private final Map<MatchingResult, Target> matchingHistories;

    public MatchingHistory() {
        this.matchingHistories = new HashMap<>();
    }

    public void addMatchingHistory(MatchingResult matchingResult, Target target) {
        matchingHistories.put(matchingResult, target);
    }
}
