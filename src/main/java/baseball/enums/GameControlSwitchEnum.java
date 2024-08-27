package baseball.enums;

import static baseball.util.Constants.*;

public enum GameControlSwitchEnum {
	RESTART(GAME_RESTART_SWITCH),
	END(GAME_END_SWITCH)
	;
	private String value;

	GameControlSwitchEnum(String value) {
		this.value = value;
	}

}
