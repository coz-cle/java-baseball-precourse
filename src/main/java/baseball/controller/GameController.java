package baseball.controller;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;
import baseball.enums.GameControlSwitch;
import baseball.service.GameExecuteService;
import baseball.service.GameInitService;
import baseball.service.GamePrintService;
import baseball.util.BasicUtils;

public class GameController {

    private final GameInitService gameInitService;
	private final GameExecuteService gameExecuteService;
	private final GamePrintService gamePrintService;

    private GameController(
			GameInitService gameInitService,
			GameExecuteService gameExecuteService,
			GamePrintService gamePrintService
    ) {
        this.gameInitService = gameInitService;
		this.gameExecuteService = gameExecuteService;
		this.gamePrintService = gamePrintService;
    }

    public static GameController from(
			GameInitService gameInitService,
			GameExecuteService gameExecuteService,
			GamePrintService gamePrintService
    ) {
        return new GameController(gameInitService, gameExecuteService, gamePrintService);
    }

    public void execute(){
        do{
            // 게임 초기화
            BaseballNumber systemNumber = gameInitService.init();

            // 게임 시작
            process(systemNumber);

            // 게임 마무리
            gamePrintService.printGameControlMessage();
        } while (isRestart());
    }

	private void process(BaseballNumber systemNumber){

        do{
            gamePrintService.printInputNumberHeader();
	        final String inputValue = BasicUtils.readLine();
			// 게임 준비
	        BaseballNumber inputNumber = gameExecuteService.ready(inputValue);

	        // 게임 실행
            BaseBallCount resultCount = gameExecuteService.run(systemNumber, inputNumber);

            // 비교 결과 출력
            gamePrintService.printResult(resultCount);

            // 게임 제어
            if(resultCount.isStrikeOut()){
                gamePrintService.printOutMessage();
                break;
            }

        } while (true);
    }

	private boolean isRestart() {
		GameControlSwitch gameControlSwitch = convertControlSwitch(BasicUtils.readLine());
		return gameControlSwitch.isRestart();
	}

    private GameControlSwitch convertControlSwitch(String input) {
        return GameControlSwitch.of(input);
    }
}
