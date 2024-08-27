package baseball.service;

import baseball.domain.BaseBallTotalCount;
import baseball.domain.BaseballNumbers;
import baseball.domain.GameResult;
import baseball.view.InputProcessor;

import java.util.List;

public class GameManager {

    private final InputProcessor inputProcessor;
    private final BaseballNumbersManager baseballNumbersManager;

    public GameManager(
            InputProcessor inputProcessor,
            BaseballNumbersManager baseballNumbersManager
    ) {
        this.inputProcessor = inputProcessor;
        this.baseballNumbersManager = baseballNumbersManager;
    }

    public GameResult startGame() {
        // 1. 랜덤
        BaseballNumbers systemNumbers = baseballNumbersManager.createRandomBaseballNumbers();

        // 2. 사용자 입력
        List<Integer> input = inputProcessor.inputBaseballNumbers();
        BaseballNumbers inputNumbers = baseballNumbersManager.create(input);

        // 3. 스트라이크, 볼 개수
        BaseBallTotalCount baseballTotalCount = baseballNumbersManager.getGameResult(systemNumbers, inputNumbers);

        if(baseballTotalCount.isNothing()) {
            return GameResult.createNothing();
        }
        return GameResult.createStrikeWithBall(baseballTotalCount);
    }

    public boolean askForRestart(InputProcessor inputProcessor) {
        int restartNumber = inputProcessor.inputRestartFlag();
        return restartNumber == 1;
    }
}
