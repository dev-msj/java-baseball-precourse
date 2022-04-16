package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Ball {
    private final List<Integer> ballNumber;

    public Ball(final List<Integer> ballNumber) {
        this.ballNumber = ballNumber;
    }

    public Ball(final int ballNumber) {
        this.ballNumber = toList(ballNumber);
    }

    public List<Integer> getBallNumber() {
        return ballNumber;
    }

    private List<Integer> toList(final int ballNumber) {
        List<Integer> ballNumberList = new ArrayList<>();
        String ballNumberString = Integer.toString(ballNumber);

        for (char number : ballNumberString.toCharArray()) {
            int parseNumber = parseCharToInt(number);
            ballNumberList.add(parseNumber);
        }

        return ballNumberList;
    }

    private int parseCharToInt(char number) {
        return Character.getNumericValue(number);
    }
}
