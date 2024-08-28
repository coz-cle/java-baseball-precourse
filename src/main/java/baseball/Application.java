package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumber;
import baseball.service.impl.BaseballServiceImpl;

public class Application {
    public static void main(String[] args) {

        BaseballServiceImpl baseballService = new BaseballServiceImpl();

        boolean isGameRunning = true;
        while (isGameRunning) {

            // 게임 시작
            BaseballGame baseballGame = baseballService.gameStart();

            // 게임 진행
            baseballService.runGame(baseballGame);

            // 게임 완료
            boolean endSignal = baseballService.gameEnd();

            if(endSignal) {
                isGameRunning = false;
            }

        }

    }
}
