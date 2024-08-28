package baseball.enums;


public enum GameStatus {
	RUNNING,
	NOT_RUNNING,
	OVER
	;

	public boolean isRunning(){
		return this == RUNNING;
	}

	public boolean isOver() {
		return this == OVER;
	}
}
