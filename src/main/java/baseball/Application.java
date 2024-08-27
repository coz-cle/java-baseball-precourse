package baseball;

import baseball.domain.BaseballNumber;
import baseball.service.impl.BaseballServiceImpl;

public class Application {
    public static void main(String[] args) {

        BaseballServiceImpl baseballService = new BaseballServiceImpl();

        while (true) {
            // 게임 시작
            BaseballNumber baseballNumber = baseballService.gameStart();

            // 게임 진행
            baseballService.runGame(baseballNumber);

            // 게임 완료
            boolean stopFlag = baseballService.gameEnd();

            if(stopFlag) return;
        }

    }
}
