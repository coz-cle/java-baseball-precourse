package baseball.domain;

public class BaseBallTotalCount {

    private final int strikeCount;
    private final int ballCount;

    private BaseBallTotalCount(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static BaseBallTotalCount create(int strikeCount, int ballCount) {
        return new BaseBallTotalCount(strikeCount, ballCount);
    }

    public boolean isNothing() {
        if (this.getStrikeCount() == 0 && this.getBallCount() == 0) {
            return true;
        }
        return false;
    }

    public boolean hasStrike() {
        return this.strikeCount != 0;
    }

    public boolean hasBall() {
        return this.ballCount != 0;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

}
