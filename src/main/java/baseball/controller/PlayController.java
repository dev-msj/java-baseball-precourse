package baseball.controller;

import baseball.model.Ball;
import baseball.model.Hint;
import baseball.service.ComputerService;
import baseball.service.serviceImpl.ComputerServiceImpl;

public class PlayController {
    ComputerService computerService = new ComputerServiceImpl();

    public void initialize() {
        computerService.createGameNumber();
    }

    public Hint guess(final Ball playerBall) {
        return computerService.compare(playerBall);
    }
}
