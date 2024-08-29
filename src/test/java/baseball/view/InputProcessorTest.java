package baseball.view;

import baseball.util.validator.NumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputProcessorTest {

    @Test
    @DisplayName("입력으로 받은 문자열을 숫자 목록으로 반환한다.")
    void inputBaseballNumbers() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        InputProcessor inputProcessor = InputProcessor.create(numbersValidator);
        System.setIn(new ByteArrayInputStream("123".getBytes()));
        // when
        List<Integer> result = inputProcessor.inputBaseballNumbers();
        // then
        assertAll(() -> {
            assertThat(result).isInstanceOf(List.class);
            assertThat(result).hasSize(3)
                    .containsExactly(1, 2, 3);
        });
    }

    @Test
    @DisplayName("게임 재시작을 위한 문자열을 입력받으면 1 또는 2를 반환한다.")
    void inputRestartFlag() {
        // given
        NumbersValidator numbersValidator = NumbersValidator.create();
        InputProcessor inputProcessor = InputProcessor.create(numbersValidator);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        // when
        int result = inputProcessor.inputRestartFlag();
        // then
        assertThat(result).isEqualTo(1);
    }

}
