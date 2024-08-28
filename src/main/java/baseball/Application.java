package baseball;

import baseball.domain.BaseballNumber;
import baseball.dto.GameStartDto;
import baseball.enums.GameStatus;
import baseball.service.GameReadyService;
import baseball.service.GameExecuteService;
import baseball.service.impl.BaseBallGameReadyService;
import baseball.service.impl.BaseBallGameExecuteService;
import baseball.service.impl.BaseBallNumberValidator;
import baseball.util.BasicUtils;

public class Application {


    public static void main(String[] args) {
	    GameReadyService gameReadyService = new BaseBallGameReadyService(new BaseBallNumberValidator());
	    GameExecuteService gameExecuteService = new BaseBallGameExecuteService();
	    GameStatus gameStatus;

	    do{
		    BaseballNumber systemNumber = gameReadyService.createSystemNumber();
			do{
				//게임 준비
	            GameStartDto startDto = gameReadyService.ready(systemNumber);

				//게임 진행
	            gameStatus = gameExecuteService.run(startDto);
		    } while (gameStatus.isRunning());

			gameStatus = gameExecuteService.handleExecution(BasicUtils.readLine());

	    } while (!gameStatus.isOver());
    }
}
