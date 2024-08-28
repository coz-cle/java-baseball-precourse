package baseball.dto;

import baseball.domain.BaseballNumber;

public class GameStartDto {
	private final BaseballNumber systemNumber;
	private final BaseballNumber userNumber;

	private GameStartDto(BaseballNumber systemNumber, BaseballNumber userNumber) {
		this.systemNumber = systemNumber;
		this.userNumber = userNumber;
	}

	public static GameStartDto from(BaseballNumber systemNumber, BaseballNumber userNumber) {
		return new GameStartDto(systemNumber, userNumber);
	}

	public BaseballNumber getSystemNumber() {
		return systemNumber;
	}

	public BaseballNumber getUserNumber() {
		return userNumber;
	}

	@Override
	public String toString() {
		return "GameStartDto{" +
				"systemNumber=" + systemNumber +
				", userNumber=" + userNumber +
				'}';
	}
}
