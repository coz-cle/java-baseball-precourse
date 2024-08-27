package baseball.domain;

public class GameResult {

    private final String resultString;

    private GameResult(String resultString) {
        this.resultString = resultString;
    }

    public static GameResult createNothing() {
        StringBuilder result = new StringBuilder();
        result.append("낫싱").append("\n");
        return new GameResult(result.toString());
    }

    public static GameResult createStrikeWithBall(BaseBallTotalCount baseBallTotalCount) {
        StringBuilder result = new StringBuilder();

        if(baseBallTotalCount.hasBall()) {
            result.append(baseBallTotalCount.getBallCount() + "볼 ");
        }

        if(baseBallTotalCount.hasStrike()) {
            result.append(baseBallTotalCount.getStrikeCount() + "스트라이크");
        }
        result.append("\n");
        return new GameResult(result.toString());
    }

    public String getResultString() {
        return resultString;
    }

}
