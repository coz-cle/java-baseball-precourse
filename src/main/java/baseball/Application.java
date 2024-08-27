package baseball;

import baseball.domain.BaseballNumber;
import baseball.enums.GameControlSwitchEnum;
import baseball.service.BaseballGameService;
import baseball.service.InputValidator;
import baseball.service.impl.BaseballGameServiceImpl;
import baseball.service.impl.InputValidatorImpl;
import baseball.util.BasicUtils;

public class Application {
    public static void main(String[] args) {
	    BaseballGameService baseballGameService = new BaseballGameServiceImpl();
	    InputValidator inputValidator = new InputValidatorImpl();

	    while (true) {
		    // 게임 준비
		    BaseballNumber baseballNumber = baseballGameService.readyPlayGame();

		    // 게임 진행
		    final String validatedBaseBallNumber = inputValidator.validationBaseBallNumber(BasicUtils.readLine());
		    baseballGameService.executeGame(baseballNumber, validatedBaseBallNumber);

		    // 게임 완료
		    final String validatedGameControlSwitch = inputValidator.validationGameControlSwitch(BasicUtils.readLine());
		    GameControlSwitchEnum gameControlSwitch = GameControlSwitchEnum.valueOf(validatedGameControlSwitch);
		    final boolean finishedGame = baseballGameService.isFinishedGame(gameControlSwitch);
			if(finishedGame) {
				break;
			}
	    }
    }
}
