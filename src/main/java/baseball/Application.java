package baseball;

import baseball.service.GameExecuteService;
import baseball.service.GameInitService;
import baseball.service.GamePrintService;
import baseball.service.impl.BaseBallNumberValidator;
import baseball.service.impl.GameExecuteServiceImpl;
import baseball.service.impl.GameInitServiceImpl;
import baseball.service.impl.GamePrintServiceImpl;

public class Application {


	public static void main(String[] args) {
		BaseBallNumberValidator baseBallNumberValidator = new BaseBallNumberValidator();
		GameInitService gameInitService = new GameInitServiceImpl();
		GameExecuteService gameExecuteService = new GameExecuteServiceImpl(baseBallNumberValidator);
		GamePrintService gamePrintService = new GamePrintServiceImpl();

		GameProcessor gameProcessor = GameProcessor.from(gameExecuteService, gamePrintService);
		GameController gameController = GameController.from(gameInitService);
		gameController.execute(gameProcessor);
	}
}
