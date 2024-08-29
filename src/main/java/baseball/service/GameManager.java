package baseball.service;

import baseball.domain.BaseballNumbers;
import baseball.service.dto.BaseBallTotalCount;
import baseball.service.dto.GameResult;
import baseball.view.InputProcessor;
import baseball.view.OutputProcessor;

import java.util.List;

import static baseball.util.enums.GameMessage.CORRECT_ANSWER;

public class GameManager {

    private final InputProcessor inputProcessor;
    private final OutputProcessor outputProcessor;
    private final BaseballNumbersManager baseballNumbersManager;

    private GameManager(
            InputProcessor inputProcessor,
            OutputProcessor outputProcessor,
            BaseballNumbersManager baseballNumbersManager
    ) {
        this.inputProcessor = inputProcessor;
        this.outputProcessor = outputProcessor;
        this.baseballNumbersManager = baseballNumbersManager;
    }

    public static GameManager create(
            InputProcessor inputProcessor,
            OutputProcessor outputProcessor,
            BaseballNumbersManager baseballNumbersManager
    ) {
        return new GameManager(inputProcessor, outputProcessor, baseballNumbersManager);
    }

    public void startGame() {
        BaseballNumbers answerNumbers = baseballNumbersManager.createAnswerNumbers();

        boolean isGameOver = false;
        while (!isGameOver) {
            BaseballNumbers inputNumbers = getInputNumbers();
            BaseBallTotalCount baseballTotalCount = getTotalCount(answerNumbers, inputNumbers);
            provideHint(baseballTotalCount);
            if (isCorrectAnswer(baseballTotalCount)) {
                printCorrectAnswer();
                isGameOver = true;
            }
        }
    }

    private BaseballNumbers getInputNumbers() {
        List<Integer> input = inputProcessor.inputBaseballNumbers();
        BaseballNumbers inputNumbers = baseballNumbersManager.createInputNumbers(input);
        return inputNumbers;
    }

    private BaseBallTotalCount getTotalCount(BaseballNumbers answerNumbers, BaseballNumbers inputNumbers) {
        BaseBallTotalCount baseballTotalCount = baseballNumbersManager.getTotalCount(answerNumbers, inputNumbers);
        return baseballTotalCount;
    }

    private void provideHint(BaseBallTotalCount baseballTotalCount) {
        GameResult resultString = GameResult.create(baseballTotalCount);
        outputProcessor.printGameResult(resultString.getResultString());
    }

    private boolean isCorrectAnswer(BaseBallTotalCount baseballTotalCount) {
        return baseballNumbersManager.isThreeStrike(baseballTotalCount);
    }

    private void printCorrectAnswer() {
        outputProcessor.printEnterGameResult(CORRECT_ANSWER.getValue());
    }

    public boolean askForRestart(InputProcessor inputProcessor) {
        int restartNumber = inputProcessor.inputRestartFlag();
        return restartNumber == 1;
    }
}
