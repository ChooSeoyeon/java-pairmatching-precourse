package pairmatching;

import java.io.IOException;
import pairmatching.controller.PairMatchingController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            new PairMatchingController(new InputView(), new OutputView()).run();
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
