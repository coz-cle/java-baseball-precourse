package baseball;

import baseball.domain.BaseballNumber;
import baseball.enums.GameControlSwitch;
import baseball.service.GameInitService;
import baseball.service.GamePrintService;
import baseball.util.BasicUtils;

public class GameController {


    private final GameInitService gameInitService;
	private final GamePrintService gamePrintService;

    private GameController(GameInitService gameInitService, GamePrintService gamePrintService) {
        this.gameInitService = gameInitService;
		this.gamePrintService = gamePrintService;
    }

    public static GameController from(GameInitService gameInitService, GamePrintService gamePrintService) {
        return new GameController(gameInitService, gamePrintService);
    }

    public void execute(GameProcessor gameProcessor){
        GameControlSwitch gameControlSwitch;
        do{
            // 게임 초기화
            BaseballNumber systemNumber = gameInitService.init();

            // 게임 시작
            gameProcessor.process(systemNumber);

            // 게임 마무리
            gamePrintService.printGameControlMessage();
            gameControlSwitch = convertControlSwitch(BasicUtils.readLine());
        } while (gameControlSwitch.isRestart());
    }

    private GameControlSwitch convertControlSwitch(String input) {
        return GameControlSwitch.of(input);
    }
}
