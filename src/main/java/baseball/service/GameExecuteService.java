package baseball.service;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;

public interface GameExecuteService {

	BaseballNumber ready(String inputNumber);

	BaseBallCount run(BaseballNumber systemNumber, BaseballNumber inputNumber);
}
