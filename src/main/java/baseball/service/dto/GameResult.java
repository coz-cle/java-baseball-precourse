package baseball.service.dto;

public class GameResult {

    private final String resultString;

    private GameResult(String resultString) {
        this.resultString = resultString;
    }

    public static GameResult create(BaseBallTotalCount baseballTotalCount) {
        if(baseballTotalCount.isNothing()) {
            return createNothing();
        }
        return createStrikeWithBall(baseballTotalCount);
    }

    private static GameResult createNothing() {
        return new GameResult("낫싱" + "\n");
    }

    private static GameResult createStrikeWithBall(BaseBallTotalCount baseBallTotalCount) {
        StringBuilder result = new StringBuilder();

        if(baseBallTotalCount.hasBall()) {
            result.append(baseBallTotalCount.getBallCount()).append("볼 ");
        }

        if(baseBallTotalCount.hasStrike()) {
            result.append(baseBallTotalCount.getStrikeCount()).append("스트라이크");
        }

        result.append("\n");
        return new GameResult(result.toString());
    }

    public String getResultString() {
        return resultString;
    }

}
