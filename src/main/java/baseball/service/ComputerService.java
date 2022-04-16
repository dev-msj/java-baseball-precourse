package baseball.service;

import baseball.model.Ball;
import baseball.model.Hint;

public interface ComputerService {
    public Hint compare(final Ball playerBall);
}
