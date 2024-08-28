package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.dto.GameStartDto;
import baseball.enums.GameStatus;

public interface GameExecuteService {

	GameStartDto ready(BaseballNumber systemNumber);

	GameStatus run(GameStartDto gameStartDto);

	GameStatus handleExecution();
}
