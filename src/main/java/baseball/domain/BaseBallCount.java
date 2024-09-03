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

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean isNothing(){
		return strike == 0 && ball == 0;
	}

	@Override
	public String toString() {
		return "BaseBallCount{" +
				"strike=" + strike +
				", ball=" + ball +
				'}';
	}
}
