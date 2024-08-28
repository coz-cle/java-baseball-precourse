package baseball.enums;


public enum GameStatus {
	RUNNING,
	NOT_RUNNING,
	OVER
	;

	public boolean NotRunning(){
		return this == NOT_RUNNING;
	}

	public boolean isOver() {
		return this == OVER;
	}
}
