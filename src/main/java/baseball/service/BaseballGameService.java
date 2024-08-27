package baseball.service;

import baseball.domain.BaseballNumber;

public interface BaseballGameService {

	BaseballNumber ready();

	void run(BaseballNumber systemNumber, String inputNumber);
}
