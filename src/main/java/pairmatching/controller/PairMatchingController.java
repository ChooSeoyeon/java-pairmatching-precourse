package pairmatching.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import pairmatching.model.Crew;
import pairmatching.model.Crews;
import pairmatching.model.enums.Course;
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

    public void run() throws IOException {
        Crews crews = settingCrews();
        Function function = repeatUntilSuccess(this::selectFunction);
        Target target = repeatUntilSuccess(this::selectTarget);
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
        System.out.println("기능을 선택하세요."); // TODO
        return inputView.readFunction();
    }

    private Target selectTarget() {
        System.out.println("과정, 레벨, 미션을 선택하세요."); // TODO
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
