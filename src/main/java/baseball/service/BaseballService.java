package baseball.service;

import baseball.domain.BaseballNumber;

public interface BaseballService {
    // 게임 시작
    BaseballNumber gameStart();

    // 게임 진행
    void runGame();

    // 게임 완료
    void gameEnd();
}
