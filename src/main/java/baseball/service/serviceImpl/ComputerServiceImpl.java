package baseball.service.serviceImpl;

import baseball.model.Ball;
import baseball.model.Hint;
import baseball.service.ComputerService;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class ComputerServiceImpl implements ComputerService {
    private final Ball computerBall;
    private Hint hint;

    public ComputerServiceImpl() {
        this.computerBall = new Ball(createGameNumber());
    }

    private List<Integer> createGameNumber() {
        List<Integer> numberList = Arrays.asList(0, 0, 0);
        for (int i = 0; i < 3; i++) {
            int pickedNumber = pickRandomNumber(numberList);
            numberList.set(i, pickedNumber);
        }

        return numberList;
    }

    private int pickRandomNumber(final List<Integer> numberList) {
        int pickedNumber = Randoms.pickNumberInRange(1, 9);
        if (isDuplicateNumber(numberList, pickedNumber)) {
            pickedNumber = pickRandomNumber(numberList);
        }

        return pickedNumber;
    }

    private boolean isDuplicateNumber(final List<Integer> numberList, final int pickedNumber) {
        return numberList.contains(pickedNumber);
    }

    @Override
    public Hint compare(final Ball playerBall) {
        this.hint = new Hint();
        for (int i = 0; i < 3; i++) {
            int playerBallNumber = playerBall.getBallNumber().get(i);
            checkHintFromComputerNumber(playerBallNumber, i);
        }

        return this.hint;
    }

    private void checkHintFromComputerNumber(final int playerBallNumber, final int index) {
        if (isContainPlayerBallNumber(playerBallNumber)) {
            isStrike(playerBallNumber, index);
        }
    }

    private boolean isContainPlayerBallNumber(final int playerBallNumber) {
        return this.computerBall.getBallNumber().contains(playerBallNumber);
    }

    private void isStrike(final int playerBallNumber, final int index) {
        if (findComputerBallNumberIndex(playerBallNumber) == index) {
            this.hint.setStrike(this.hint.getStrike() + 1);

            return;
        }

        this.hint.setBall(this.hint.getBall() + 1);
    }

    private int findComputerBallNumberIndex(final int playerBallNumber) {
        return this.computerBall.getBallNumber().indexOf(playerBallNumber);
    }
}
