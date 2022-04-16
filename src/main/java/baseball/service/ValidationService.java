package baseball.service;

import baseball.model.Ball;

public interface ValidationService {
    public boolean validateBallNumber(final Ball ball);
    public boolean validateFinishNumber(final int finishNumber);
}
