package baseball;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;
import baseball.service.GameExecuteService;
import baseball.service.GamePrintService;

public class GameProcessor {
    private final GameExecuteService gameExecuteService;
    private final GamePrintService gamePrintService;

    private GameProcessor(GameExecuteService gameExecuteService, GamePrintService gamePrintService) {
        this.gameExecuteService = gameExecuteService;
        this.gamePrintService = gamePrintService;
    }

    public static GameProcessor from(GameExecuteService gameExecuteService, GamePrintService gamePrintService) {
        return new GameProcessor(gameExecuteService, gamePrintService);
    }

    public void process(BaseballNumber systemNumber){

        do{
            gamePrintService.printInputNumberHeader();

            // 게임 실행
            BaseBallCount resultCount = gameExecuteService.run(systemNumber);

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
