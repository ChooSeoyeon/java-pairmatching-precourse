package pairmatching.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import pairmatching.model.Crew;
import pairmatching.model.Crews;
import pairmatching.model.MatchingHistory;
import pairmatching.model.MatchingManager;
import pairmatching.model.dto.MatchingResult;
import pairmatching.model.enums.Course;
import pairmatching.model.enums.Function;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.dto.Target;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MatchingHistory matchingHistory;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.matchingHistory = new MatchingHistory();
    }

    public void run() throws IOException {
        Crews crews = settingCrews();
        while (true) {
            Function function = repeatUntilSuccess(this::selectFunction);
            if (function == Function.PAIR_MATCHING) {
                pairMatching(crews);
            }
            if (function == Function.QUIT) {
                break;
            }
        }
    }

    public void pairMatching(Crews crews) {
        Target target = repeatUntilSuccess(this::selectTarget);
        MatchingManager matchingManager = new MatchingManager(crews);
        List<MatchingResult> matchingResults = matchingManager.doMatching(target);
        outputView.printResult(matchingResults);
        for (MatchingResult matchingResult : matchingResults) {
            matchingHistory.addMatchingHistory(matchingResult, target);
        }
    }

    private Crews settingCrews() throws IOException {
        List<Crew> allCrews = new ArrayList<>();
        allCrews.addAll(readCrewFromFile("src/main/resources/backend-crew.md", Course.BACKEND));
        allCrews.addAll(readCrewFromFile("src/main/resources/frontend-crew.md", Course.FRONTEND));
        return new Crews(allCrews);
    }

    private List<Crew> readCrewFromFile(String filePath, Course course) throws IOException {
        List<Crew> crewList = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String name : lines) {
            Crew crew = new Crew(course, name);
            crewList.add(crew);
        }

        return crewList;
    }

    private Function selectFunction() {
        outputView.printFunctionPrompt();
        return inputView.readFunction();
    }

    private Target selectTarget() {
        outputView.printTargetPrompt();
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
