package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumber;

public interface BaseballService {
    // 게임 시작
    BaseballGame gameStart();

    // 게임 진행
    void runGame(BaseballGame baseballGame);

    // 게임 완료
    boolean gameEnd();
}
