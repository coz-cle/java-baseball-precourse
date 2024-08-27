package baseball.enums;

import baseball.exception.ErrorMessages;
import baseball.util.Constants;

import java.util.Arrays;


public enum GameControlSwitch {
	RESTART(Constants.GAME_RESTART_SWITCH),
	END(Constants.GAME_END_SWITCH)
	;
	private final String value;

	GameControlSwitch(String value) {
		this.value = value;
	}

	public static GameControlSwitch of(final String value) {
			return Arrays.stream(values())
	        		.filter(switchEnum -> value.equals(switchEnum.value))
	                .findFirst()
					.orElseThrow(()-> new IllegalArgumentException(ErrorMessages.INVALID_EXIT_CHOICE));
	 }

	 public boolean isEndSwitch() {
		return this == END;
	 }
}
