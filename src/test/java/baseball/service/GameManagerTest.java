package baseball.service;

import baseball.util.validator.NumbersValidator;
import baseball.mock.MockNumberGenerator;
import baseball.util.common.NumberGenerator;
import baseball.view.InputProcessor;
import baseball.view.OutputProcessor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameManagerTest {

    @Disabled
    @Test
    @DisplayName("")
    void startGame() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        InputProcessor inputProcessor = InputProcessor.create(numbersValidator);
        OutputProcessor outputProcessor = OutputProcessor.create();
        NumberGenerator numberGenerator = MockNumberGenerator.create();
        BaseballNumbersManager baseballNumbersManager = BaseballNumbersManager.create(numberGenerator);
        GameManager gameManager = GameManager.create(inputProcessor, outputProcessor, baseballNumbersManager);
        // when
        gameManager.startGame();
        // then
        // TODO: startGame은 void 타입으로 반환하기에 모의 테스트가 어려움!
    }

    @Test
    @DisplayName("게임 종료 후, 재시작 여부를 입력받아 boolean 타입으로 반환한다.")
    void askForRestart() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        InputProcessor inputProcessor = InputProcessor.create(numbersValidator);
        OutputProcessor outputProcessor = OutputProcessor.create();
        NumberGenerator numberGenerator = MockNumberGenerator.create();
        BaseballNumbersManager baseballNumbersManager = BaseballNumbersManager.create(numberGenerator);
        GameManager gameManager = GameManager.create(inputProcessor, outputProcessor, baseballNumbersManager);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        // when
        boolean result = gameManager.askForRestart(inputProcessor);
        // then
        assertThat(result).isFalse();
    }

}
