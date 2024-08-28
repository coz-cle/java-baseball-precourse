package baseball;

import baseball.domain.BaseballNumber;
import baseball.dto.GameStartDto;
import baseball.enums.GameControlSwitch;
import baseball.enums.GameStatus;
import baseball.service.GameReadyService;
import baseball.service.GameExecuteService;
import baseball.service.impl.BaseBallGameReadyService;
import baseball.service.impl.BaseBallGameExecuteService;
import baseball.service.impl.BaseBallNumberValidator;
import baseball.util.BasicUtils;

public class Application {

	private static final String GAME_CONTROL_TITLE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


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

		    // 게임 완료
			// TODO 개선 리팩터링 필요
		    System.out.println(GAME_CONTROL_TITLE_MESSAGE);
		    GameControlSwitch gameControlSwitch = GameControlSwitch.of(BasicUtils.readLine());
			if(gameControlSwitch.isEndSwitch()) {
				gameStatus = GameStatus.OVER;
			}
		} while (!gameStatus.isOver());
    }
}
