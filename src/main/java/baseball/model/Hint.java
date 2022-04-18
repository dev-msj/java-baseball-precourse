package baseball.model;

public class Hint {
    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String toString() {
        if (this.strike == 0 && this.ball == 0) {
            return "낫싱";
        }

        String strikeString = parseStrikeToString();
        String ballString = parseBallToString();
        String space = makeSpace(strikeString, ballString);

        return String.format("%s%s%s", ballString, space, strikeString);
    }

    private String parseStrikeToString() {
        if (this.strike == 0) {
            return "";
        }

        return String.format("%s스트라이크", this.strike);
    }

    private String parseBallToString() {
        if (this.ball == 0) {
            return "";
        }

        return String.format("%s볼", this.ball);
    }

    private String makeSpace(final String strikeString, final String ballString) {
        String space = "";

        if (!strikeString.isEmpty() && !ballString.isEmpty()) {
            space = " ";
        }

        return space;
    }
}
