package pairmatching.exception;

public enum ErrorCode {
    NOT_FOUND_MATCHING("매칭 이력이 없습니다."),
    PROGRAM_ERROR_MATCHING("매칭이 불가능합니다."),
    NON_FORMAT_FUNCTION("기능은 숫자로 입력합니다."),
    NOT_FOUND_FUNCTION("존재하지 않는 기능입니다."),
    NOT_FOUND_COURSE("존재하지 않는 과정입니다."),
    NOT_FOUND_LEVEL("존재하지 않는 레벨입니다."),
    NOT_FOUND_MISSION("존재하지 않는 미션입니다."),
    NON_FORMAT_COURSE("과정, 레벨, 미션을 쉼표로 구분해 입력합니다."),
    NON_FORMAT_REMATCHING("재매칭 여부는 네 또는 아니오로 입력합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getFormattedMessage() {
        return "[ERROR] " + message;
    }
}