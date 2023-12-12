package pairmatching.exception;

public class PairIllegalStateException extends IllegalStateException {
    public PairIllegalStateException(ErrorCode errorCode) {
        super(errorCode.getFormattedMessage());
    }
}
