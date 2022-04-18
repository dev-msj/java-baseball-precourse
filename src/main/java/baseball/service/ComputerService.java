package baseball.service;

import baseball.model.Ball;
import baseball.model.Hint;

public interface ComputerService {
    public void createGameNumber();
    public Hint compare(final Ball playerBall);
}
