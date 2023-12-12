package pairmatching.exception;

public class PairIllegalArgumentException extends IllegalArgumentException {
    public PairIllegalArgumentException(ErrorCode errorCode) {
        super(errorCode.getFormattedMessage());
    }
}
