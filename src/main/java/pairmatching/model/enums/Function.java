package pairmatching.model.enums;

import pairmatching.exception.ErrorCode;
import pairmatching.exception.PairIllegalArgumentException;

public enum Function {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_VIEW("2", "페어 조회"),
    PAIR_RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String key;
    private final String description;

    Function(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public static Function findByKey(String key) {
        for (Function function : Function.values()) {
            if (function.key.equals(key)) {
                return function;
            }
        }
        throw new PairIllegalArgumentException(ErrorCode.NOT_FOUND_FUNCTION);
    }

    @Override
    public String toString() {
        return String.format("%s. %s", key, description);
    }
}

