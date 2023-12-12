package pairmatching.view;

import java.util.List;
import pairmatching.model.dto.MatchingResult;
import pairmatching.model.enums.Course;
import pairmatching.model.enums.Function;
import pairmatching.model.enums.Level;
import pairmatching.model.enums.Mission;

public class OutputView {

    public void printFunctionPrompt() {
        System.out.println("기능을 선택하세요.");
        for (Function function : Function.values()) {
            System.out.println(function);
        }
    }

    public void printTargetPrompt() {
        printTargetInformation();
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    private void printTargetInformation() {
        System.out.println("############################################");
        System.out.print("과정: ");
        for (Course course : Course.values()) {
            System.out.print(course + " | ");
        }
        System.out.println("\n미션:");
        for (Level level : Level.values()) {
            if (hasMissions(level)) {
                System.out.print("  - " + level + ": ");
                for (Mission mission : Mission.values()) {
                    if (mission.getLevel() == level) {
                        System.out.print(mission + " | ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println("############################################");
    }

    private boolean hasMissions(Level level) {
        for (Mission mission : Mission.values()) {
            if (mission.getLevel() == level) {
                return true;
            }
        }
        return false;
    }

    public void printResult(List<MatchingResult> matchingResults) {
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(matchingResults);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
