package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.enums.GameControlSwitchEnum;

public interface BaseballGameService {

	BaseballNumber readyPlayGame();

	void executeGame(BaseballNumber systemNumber, String inputNumber);

	boolean isFinishedGame(GameControlSwitchEnum gameControlSwitchEnum);
}
