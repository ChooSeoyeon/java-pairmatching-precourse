package pairmatching.model.dto;

import java.util.List;

public class MatchingResult {
    private final List<String> crewNames;

    public MatchingResult(List<String> memberNames) {
        this.crewNames = memberNames;
    }

    public void addMember(String memberName) {
        this.crewNames.add(memberName);
    }

    @Override
    public String toString() {
        return String.join(" : ", crewNames);
    }
}