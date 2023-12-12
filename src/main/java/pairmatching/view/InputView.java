package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.enums.Function;

public class InputView {
    public Function readFunction() {
        String input = Console.readLine();
        return Function.findByKey(input);
    }
}
