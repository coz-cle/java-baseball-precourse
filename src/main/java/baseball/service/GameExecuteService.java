package baseball.service;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;

public interface GameExecuteService {

	BaseBallCount run(BaseballNumber systemNumber);
}
