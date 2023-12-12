package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.model.enums.Function;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.dto.Target;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Function function = repeatUntilSuccess(this::selectFunction);
        Target target = repeatUntilSuccess(this::selectTarget);
    }

    private Function selectFunction() {
        // TODO: 출력문
        System.out.println("기능을 선택하세요.");
        return inputView.readFunction();
    }

    private Target selectTarget() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        return inputView.readTarget();
    }

    private <T> T repeatUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
