package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.model.enums.Course;

public class Crews {
    private final List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public List<String> getCrewNamesByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.isSameCourse(course))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
