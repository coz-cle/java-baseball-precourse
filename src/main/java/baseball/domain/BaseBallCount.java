package baseball.domain;

public class BaseBallCount {
	private int strike = 0;
	private int ball = 0;

	private BaseBallCount() {
	}

	public static BaseBallCount from(){
		return new BaseBallCount();
	};

	public boolean isStrikeOut(){
		return strike == 3;
	}

	public void addStrike(){
		strike++;
	}

	public void addBall(){
		ball++;
	}

	public boolean hasBall(){
		return hasCount(ball);
	}

	public boolean hasStrike(){
		return hasCount(strike);
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean isNoting(){
		return !hasBall() && !hasStrike();
	}

	private boolean hasCount(int count){
		return count > 0;
	}
}
