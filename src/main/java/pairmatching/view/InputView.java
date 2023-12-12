package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.exception.ErrorCode;
import pairmatching.exception.PairIllegalArgumentException;
import pairmatching.model.enums.Course;
import pairmatching.model.enums.Function;
import pairmatching.model.enums.Level;
import pairmatching.model.enums.Mission;
import pairmatching.view.dto.Target;

public class InputView {
    public Function readFunction() {
        String input = Console.readLine();
        return Function.findByKey(input);
    }

    public Target readTarget() {
        String targetInput = Console.readLine();
        String[] targetInputList = parseTargetInputToList(targetInput);
        validTargetInputList(targetInputList);
        Course course = Course.findByName(targetInputList[0]);
        Level level = Level.findByName(targetInputList[1]);
        Mission mission = Mission.findByName(targetInputList[2]);
        return new Target(course, level, mission);
    }

    private String[] parseTargetInputToList(String input) {
        try {
            return input.split(", ");
        } catch (Exception e) {
            throw new PairIllegalArgumentException(ErrorCode.NON_FORMAT_COURSE);
        }
    }

    private void validTargetInputList(String[] targetInputList) {
        if (targetInputList.length != 3) {
            throw new PairIllegalArgumentException(ErrorCode.NON_FORMAT_COURSE);
        }
    }
}
