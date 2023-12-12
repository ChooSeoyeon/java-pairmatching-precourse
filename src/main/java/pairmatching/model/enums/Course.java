package pairmatching.model.enums;

import pairmatching.exception.ErrorCode;
import pairmatching.exception.PairIllegalArgumentException;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findByName(String name) {
        for (Course course : Course.values()) {
            if (course.name.equals(name)) {
                return course;
            }
        }
        throw new PairIllegalArgumentException(ErrorCode.NOT_FOUND_COURSE);
    }
}