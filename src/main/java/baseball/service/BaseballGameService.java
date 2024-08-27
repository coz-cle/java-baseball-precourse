package baseball.service;

import baseball.domain.BaseballNumber;

public interface BaseballGameService {

	BaseballNumber readyPlayGame();

	void executeGame(BaseballNumber systemNumber, String inputNumber);
}
