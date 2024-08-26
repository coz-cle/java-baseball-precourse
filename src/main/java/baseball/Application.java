package baseball;

import baseball.domain.BaseballNumber;
import baseball.service.impl.BaseballServiceImpl;

public class Application {
    public static void main(String[] args) {

        BaseballServiceImpl baseballService = new BaseballServiceImpl();

        // 게임 시작
        BaseballNumber baseballNumber = baseballService.gameStart();

        // 게임 진행
        baseballService.runGame();


        // 게임 완료
        baseballService.gameEnd();
    }
}
