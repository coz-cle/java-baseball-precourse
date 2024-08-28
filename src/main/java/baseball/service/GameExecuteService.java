package baseball.service;

import baseball.dto.GameStartDto;
import baseball.enums.GameStatus;

public interface GameExecuteService {

	GameStatus run(GameStartDto gameStartDto);
}
