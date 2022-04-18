package baseball.view;

import baseball.controller.PlayController;
import baseball.model.Ball;
import baseball.model.Hint;
import baseball.service.ValidationService;
import baseball.service.serviceImpl.ValidationServiceImpl;
import camp.nextstep.edu.missionutils.Console;

public class GameViewer {
    PlayController playController = new PlayController();
    ValidationService validationService = new ValidationServiceImpl();

    public void start() {
        playGame();

        System.out.println("프로그램을 종료합니다.");
    }

    private void playGame() {
        System.out.println("게임을 시작합니다.");
        do {
            playController.initialize();
            tryGuessNumber();
        } while(retryGame());
    }

    private void tryGuessNumber() {
        boolean result = false;
        do {
            Ball playerBall = receiveBallNumber();
            Hint hint = guess(playerBall);
            result = isCorrectNumber(hint);
        } while (!result);
    }

    private Ball receiveBallNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String playerBallString = Console.readLine();

        return makeBall(playerBallString);
    }

    private Ball makeBall(final String playerBall) {
        validationService.validateBallNumberLength(playerBall);
        validationService.validateBallNumberType(playerBall);
        validationService.validateBallNumberZero(playerBall);

        Ball ball = new Ball(Integer.parseInt(playerBall));

        validationService.validateDuplicateBallNumber(ball);

        return ball;
    }

    private Hint guess(final Ball playerBall) {
        Hint hint = playController.guess(playerBall);
        System.out.println(hint.toString());

        return hint;
    }

    private boolean isCorrectNumber(Hint hint) {
        boolean result = false;

        if (hint.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            result = true;
        }

        return result;
    }

    private boolean retryGame() {
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
        String finishNumber = Console.readLine();

        validationService.validateFinishNumber(finishNumber);

        return !finishNumber.equals("2");
    }
}
