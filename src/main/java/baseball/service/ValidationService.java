package baseball.service;

import baseball.model.Ball;

public interface ValidationService {
    public void validateBallNumberLength(final String ball) throws IllegalArgumentException;
    public void validateBallNumberZero(final String ball) throws IllegalArgumentException;
    public void validateBallNumberType(final String ball) throws IllegalArgumentException;
    public void validateDuplicateBallNumber(final Ball ball) throws IllegalArgumentException;
    public void validateFinishNumber(final String finishNumber) throws IllegalArgumentException;
}
