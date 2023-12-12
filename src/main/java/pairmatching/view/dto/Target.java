package pairmatching.view.dto;

import pairmatching.model.enums.Course;
import pairmatching.model.enums.Level;
import pairmatching.model.enums.Mission;

public class Target {
    private Course course;
    private Level level;
    private Mission mission;

    public Target(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    public boolean isSameCourseAndLevel(Course course, Level level) {
        return this.course == course && this.level == level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Target)) {
            return false;
        }
        Target target = (Target) o;
        return course == target.course && level == target.level && mission == target.mission;
    }
}
