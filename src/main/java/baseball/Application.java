package baseball;

import baseball.domain.GameResult;
import baseball.service.BaseballNumbersManager;
import baseball.service.GameManager;
import baseball.view.InputProcessor;
import baseball.view.OutputProcessor;

public class Application {

    public static void main(String[] args) {

        boolean isRunning = true;

        while (isRunning) {
            // 게임 준비
            InputProcessor inputProcessor = new InputProcessor();
            BaseballNumbersManager baseballNumbersManager = new BaseballNumbersManager();
            GameManager gameManager = new GameManager(inputProcessor, baseballNumbersManager);

            // 게임 시작
            GameResult result = gameManager.startGame();

            // 게임 완료
            OutputProcessor outputProcessor = new OutputProcessor();
            outputProcessor.printGameResult(result.getResultString());

            // TODO: 게임 종료시 재시작 여부 입력받아야 함.
            isRunning = gameManager.askForRestart(inputProcessor);
        }

    }

}
