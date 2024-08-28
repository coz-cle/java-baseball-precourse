package baseball;

import baseball.domain.BaseballNumber;
import baseball.enums.GameControlSwitch;
import baseball.service.GameInitService;
import baseball.util.BasicUtils;

public class GameController {
    private static final String GAME_CONTROL_TITLE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final GameInitService gameInitService;

    private GameController(GameInitService gameInitService) {
        this.gameInitService = gameInitService;
    }

    public static GameController from(GameInitService gameInitService) {
        return new GameController(gameInitService);
    }

    public void execute(GameProcessor gameProcessor){
        GameControlSwitch gameControlSwitch;
        do{
            // 게임 초기화
            BaseballNumber systemNumber = gameInitService.init();

            // 게임 시작
            gameProcessor.process(systemNumber);

            // 게임 마무리
            System.out.println(GAME_CONTROL_TITLE_MESSAGE);
            gameControlSwitch = convertControlSwitch(BasicUtils.readLine());
        } while (gameControlSwitch.isRestart());
    }

    private GameControlSwitch convertControlSwitch(String input) {
        return GameControlSwitch.of(input);
    }
}
