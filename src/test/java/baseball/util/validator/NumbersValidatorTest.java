package baseball.util.validator;

import baseball.util.enums.NumbersType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.exception.ErrorMessages.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersValidatorTest {

    @Test
    @DisplayName("[Fail] 입력받은 숫자는 반드시 3자리 문자열이어야 한다.")
    void validateInputFromSize() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        String input = "1234";
        // when & then
        assertThatThrownBy(() -> numbersValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_THREE_DIGIT);
    }

    @Test
    @DisplayName("[Fail] 입력받은 숫자는 반드시 1 이상 9 이하의 숫자로만 이루어져야 한다.")
    void validateInputFromNumber() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        String input = "a12";
        // when & then
        assertThatThrownBy(() -> numbersValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NON_DIGIT);
    }

    @Test
    @DisplayName("[Fail] 입력받은 숫자는 반드시 서로 다른 수여야 한다.")
    void validateInputFromUniqueNumber() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        String input = "111";
        // when & then
        assertThatThrownBy(() -> numbersValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_UNIQUE_NUMBER);
    }

    @Test
    @DisplayName("[Fail] 컴퓨터는 반드시 3자리 수 정답을 생성해야 한다.")
    void validateListFromAnswerSize() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        List<Integer> generateNumbers = Arrays.asList(1, 2, 3, 4);
        NumbersType answerType = NumbersType.ANSWER_NUMBER;
        // when & then
        assertThatThrownBy(() -> numbersValidator.validateList(generateNumbers, answerType))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ANSWER_THREE_DIGIT);
    }

    @Test
    @DisplayName("[Fail] 컴퓨터는 반드시 서로 다른 수로 이루어진 정답을 생성해야 한다.")
    void validateListFromAnswerUniqueNumber() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        List<Integer> generateNumbers = Arrays.asList(1, 1, 1);
        NumbersType answerType = NumbersType.ANSWER_NUMBER;
        // when & then
        assertThatThrownBy(() -> numbersValidator.validateList(generateNumbers, answerType))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ANSWER_UNIQUE_NUMBER);
    }

    @Test
    @DisplayName("[Fail] 입력값으로 3자리 수 숫자 목록을 생성해야 한다.")
    void validateListFromInputSize() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        List<Integer> generateNumbers = Arrays.asList(1, 2, 3, 4);
        NumbersType answerType = NumbersType.INPUT_NUMBER;
        // when & then
        assertThatThrownBy(() -> numbersValidator.validateList(generateNumbers, answerType))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_THREE_DIGIT);
    }

    @Test
    @DisplayName("[Fail] 입력값으로 서로 다른 수로 이루어진 숫자 목록을 생성해야 한다.")
    void validateListFromInputUniqueNumber() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        List<Integer> generateNumbers = Arrays.asList(1, 1, 1);
        NumbersType inputType = NumbersType.INPUT_NUMBER;
        // when & then
        assertThatThrownBy(() -> numbersValidator.validateList(generateNumbers, inputType))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_UNIQUE_NUMBER);
    }

}
