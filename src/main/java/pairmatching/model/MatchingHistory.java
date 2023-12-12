package pairmatching.model;

import java.util.HashMap;
import java.util.Map;
import pairmatching.model.dto.MatchingResult;
import pairmatching.model.enums.Course;
import pairmatching.model.enums.Level;
import pairmatching.view.dto.Target;

public class MatchingHistory {
    private final Map<MatchingResult, Target> matchingHistories;

    public MatchingHistory() {
        this.matchingHistories = new HashMap<>();
    }

    public void addMatchingHistory(MatchingResult matchingResult, Target target) {
        matchingHistories.put(matchingResult, target);
    }

    public boolean isExistByCourseAndLevel(Course course, Level level) {
        return matchingHistories.values().stream()
                .anyMatch(target -> target.isSameCourseAndLevel(course, level));
    }
}
