package baseball.config;

import baseball.controller.GameController;
import baseball.service.*;
import baseball.service.impl.*;

public class AppConfig {

	public NumberGenerator numberGenerator(){
		return new BaseBallNumberGenerator();
	}

	public InputValidator inputValidator(){
		return new BaseBallNumberValidator();
	}

	public GameInitService gameInitService(){
		return new GameInitServiceImpl(numberGenerator());
	}

	public GameExecuteService gameExecuteService(){
		return new GameExecuteServiceImpl(inputValidator());
	}

	public GamePrintService gamePrintService(){
		return new GamePrintServiceImpl();
	}

	public GameController gameController(){
		return GameController.from(gameInitService(), gameExecuteService(), gamePrintService());
	}
}
