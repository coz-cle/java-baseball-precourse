package baseball;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;
import baseball.service.GameExecuteService;
import baseball.service.GamePrintService;
import baseball.util.BasicUtils;

public class GameProcessor {
    private final GameExecuteService gameExecuteService;
    private final GamePrintService gamePrintService;

    private GameProcessor(
			GameExecuteService gameExecuteService,
			GamePrintService gamePrintService
    ) {
        this.gameExecuteService = gameExecuteService;
        this.gamePrintService = gamePrintService;
    }


    public static GameProcessor from(
			GameExecuteService gameExecuteService,
			GamePrintService gamePrintService
    ) {
        return new GameProcessor(gameExecuteService, gamePrintService);
    }


    public void process(BaseballNumber systemNumber){

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

}
