package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.dto.GameStartDto;

public interface GameReadyService {

	GameStartDto ready(BaseballNumber systemNumber);

	BaseballNumber createSystemNumber();
}
