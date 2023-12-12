package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pairmatching.model.dto.MatchingResult;
import pairmatching.model.enums.Course;
import pairmatching.view.dto.Target;

public class MatchingManager {
    private final Crews crews;

    public MatchingManager(Crews crews) {
        this.crews = crews;
    }

    public List<MatchingResult> doMatching(Target target) {
        List<String> crewNames = shuffleCrewNamesWithCourse(target.getCourse());
        List<MatchingResult> matchingResults = createPairs(crewNames);

        handleOddMember(crewNames, matchingResults);

        return matchingResults;
    }

    private List<String> shuffleCrewNamesWithCourse(Course course) {
        List<String> crewNames = crews.getCrewNamesByCourse(course);
        return Randoms.shuffle(crewNames);
    }

    private List<MatchingResult> createPairs(List<String> crewNames) {
        List<MatchingResult> matchingResults = new ArrayList<>();
        for (int i = 0; i < crewNames.size() - 1; i += 2) {
            matchingResults.add(new MatchingResult(Arrays.asList(crewNames.get(i), crewNames.get(i + 1))));
        }
        return matchingResults;
    }

    private void handleOddMember(List<String> crewNames, List<MatchingResult> matchingResults) {
        if (isOddNumberOfCrews(crewNames)) {
            matchingResults.get(matchingResults.size() - 1)
                    .addMember(crewNames.get(crewNames.size() - 1));
        }
    }

    private boolean isOddNumberOfCrews(List<String> crewNames) {
        return crewNames.size() % 2 != 0;
    }
}
