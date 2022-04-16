package baseball.service;

import baseball.model.Ball;

public interface ValidationService {
    public boolean validateBallNumberLength(final Ball ball);
    public boolean validateDuplicateBallNumber(final Ball ball);
    public boolean validateFinishNumber(final int finishNumber);
}
