package baseball.service.serviceImpl;

import baseball.model.Ball;
import baseball.model.Hint;
import baseball.service.ComputerService;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class ComputerServiceImpl implements ComputerService {
    private Ball playerBall;
    private Ball computerBall;
    private Hint hint;

    @Override
    public void createGameNumber() {
        this.computerBall = new Ball(pickGameNumberList());
    }

    private List<Integer> pickGameNumberList() {
        List<Integer> numberList = Arrays.asList(0, 0, 0);
        for (int i = 0; i < 3; i++) {
            int pickedNumber = pickRandomNumber(numberList);
            numberList.set(i, pickedNumber);
        }

        return numberList;
    }

    private int pickRandomNumber(final List<Integer> numberList) {
        int pickedNumber;
        do {
            pickedNumber = Randoms.pickNumberInRange(1, 9);
        } while (isDuplicateNumber(numberList, pickedNumber));

        return pickedNumber;
    }

    private boolean isDuplicateNumber(final List<Integer> numberList, final int pickedNumber) {
        return numberList.contains(pickedNumber);
    }

    @Override
    public Hint compare(final Ball playerBall) {
        this.playerBall = playerBall;
        this.hint = new Hint();
        for (int i = 0; i < 3; i++) {
            int computerBallNumber = this.computerBall.getBallNumber().get(i);
            checkHintFromComputerBallNumber(computerBallNumber, i);
        }

        return this.hint;
    }

    private void checkHintFromComputerBallNumber(final int computerBallNumber, final int index) {
        if (isContainComputerBallNumber(computerBallNumber)) {
            updateHint(computerBallNumber, index);
        }
    }

    private boolean isContainComputerBallNumber(final int computerBallNumber) {
        return this.playerBall.getBallNumber().contains(computerBallNumber);
    }

    private void updateHint(final int computerBallNumber, final int index) {
        if (findIndexFromPlayerBallNumber(computerBallNumber) == index) {
            this.hint.setStrike(this.hint.getStrike() + 1);

            return;
        }

        this.hint.setBall(this.hint.getBall() + 1);
    }

    private int findIndexFromPlayerBallNumber(final int computerBallNumber) {
        return this.playerBall.getBallNumber().indexOf(computerBallNumber);
    }
}
