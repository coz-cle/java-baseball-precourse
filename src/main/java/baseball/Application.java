package baseball;

import baseball.domain.BaseballNumber;
import baseball.dto.GameStartDto;
import baseball.enums.GameStatus;
import baseball.service.GameInitializeService;
import baseball.service.GameExecuteService;
import baseball.service.impl.BaseBallGameInitializeService;
import baseball.service.impl.BaseBallGameExecuteService;
import baseball.service.impl.BaseBallNumberValidator;

public class Application {


    public static void main(String[] args) {
	    GameInitializeService gameInitializeService = new BaseBallGameInitializeService();
	    GameExecuteService gameExecuteService = new BaseBallGameExecuteService(new BaseBallNumberValidator());
	    GameStatus gameStatus;

	    do{
		    BaseballNumber systemNumber = gameInitializeService.createSystemNumber();
			do{
				//게임 준비
	            GameStartDto startDto = gameExecuteService.ready(systemNumber);

				//게임 진행
	            gameStatus = gameExecuteService.run(startDto);
		    } while (gameStatus.isRunning());

			gameStatus = gameExecuteService.handleExecution();

	    } while (!gameStatus.isOver());
    }
}
