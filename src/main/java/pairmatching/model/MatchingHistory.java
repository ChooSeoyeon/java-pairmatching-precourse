package pairmatching.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.model.dto.MatchingResult;
import pairmatching.model.enums.Course;
import pairmatching.model.enums.Level;
import pairmatching.view.dto.Target;

public class MatchingHistory {
    private final Map<MatchingResult, Target> matching; // TODO: Map 말고 List<Matching>으로 변경하면 순서 보장 가능

    public MatchingHistory() {
        this.matching = new HashMap<>();
    }

    public void addMatching(MatchingResult matchingResult, Target target) {
        matching.put(matchingResult, target);
    }

    public boolean isExistByCourseAndLevel(Course course, Level level) {
        return matching.values().stream()
                .anyMatch(target -> target.isSameCourseAndLevel(course, level));
    }

    public List<MatchingResult> findMatchingByCourseAndLevel(Course course, Level level) {
        List<MatchingResult> matchingResults = new ArrayList<>();
        for (Map.Entry<MatchingResult, Target> entry : matching.entrySet()) {
            if (entry.getValue().isSameCourseAndLevel(course, level)) {
                matchingResults.add(entry.getKey());
            }
        }
        return matchingResults;
    }

    public List<MatchingResult> findMatchingByTarget(Target target) {
        List<MatchingResult> matchingResults = new ArrayList<>();
        for (Map.Entry<MatchingResult, Target> entry : matching.entrySet()) {
            if (entry.getValue().equals(target)) {
                matchingResults.add(entry.getKey());
            }
        }
        return matchingResults;
    }

    public void deleteAll() {
        matching.clear();
    }
}
