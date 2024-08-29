package baseball;

import baseball.util.validator.NumbersValidator;
import baseball.service.BaseballNumbersManager;
import baseball.service.GameManager;
import baseball.util.common.AnswerNumberGenerator;
import baseball.util.common.NumberGenerator;
import baseball.view.InputProcessor;
import baseball.view.OutputProcessor;

public class Application {

    public static void main(String[] args) {
        NumbersValidator numbersValidator = NumbersValidator.create();
        InputProcessor inputProcessor = InputProcessor.create(numbersValidator);
        OutputProcessor outputProcessor = OutputProcessor.create();
        NumberGenerator numberGenerator = AnswerNumberGenerator.create();
        BaseballNumbersManager baseballNumbersManager = BaseballNumbersManager.create(numberGenerator);

        boolean isRetryGame = true;
        while (isRetryGame) {
            GameManager gameManager = GameManager.create(inputProcessor, outputProcessor, baseballNumbersManager);
            gameManager.startGame();
            isRetryGame = gameManager.askForRestart(inputProcessor);
        }
    }

}
