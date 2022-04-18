package baseball.service.serviceImpl;

import baseball.model.Ball;
import baseball.service.ValidationService;

import java.util.HashSet;
import java.util.Set;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public void validateBallNumberLength(String ball) throws IllegalArgumentException {
        if (ball.length() != 3) {
            throw new IllegalArgumentException("입력한 문자의 길이가 3보다 작거나 큽니다.");
        }
    }

    @Override
    public void validateBallNumberZero(String ball) throws IllegalArgumentException {
        if (ball.contains("0")) {
            throw new IllegalArgumentException("1-9 외의 숫자를 입력했습니다.");
        }
    }

    @Override
    public void validateBallNumberType(String ball) throws IllegalArgumentException {
        try {
            Integer.parseInt(ball);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닌 다른 문자를 입력했습니다.");
        }
    }

    @Override
    public void validateDuplicateBallNumber(Ball ball) throws IllegalArgumentException {
        Set<Integer> ballSet = new HashSet<>(ball.getBallNumber());
        if (ballSet.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    @Override
    public void validateFinishNumber(String finishNumber) throws IllegalArgumentException {
        if (!finishNumber.equals("1") && !finishNumber.equals("2")) {
            throw new IllegalArgumentException("1 또는 2가 아닌 문자를 입력했습니다.");
        }
    }
}
