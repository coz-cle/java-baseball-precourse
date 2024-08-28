package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersTest {

    @Test
    @DisplayName("입력한 숫자 중 특정 수가 스트라이크인지 판별하여 카운트를 반환한다.")
    void isStrike() {
        // given
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3);
        BaseballNumbers baseballNumbers = BaseballNumbers.createAnswerNumbers(answerNumbers);
        // when
        int result = baseballNumbers.getStrikeCount(0, 1);
        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("입력한 숫자 중 특정 수가 볼인지 판별하여 카운트를 반환한다.")
    void isBall() {
        // given
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3);
        BaseballNumbers baseballNumbers = BaseballNumbers.createAnswerNumbers(answerNumbers);
        // when
        int result = baseballNumbers.getBallCount(1, 1);
        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 목록을 반환한다.")
    void getNumbers() {
        // given
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3);
        BaseballNumbers baseballNumbers = BaseballNumbers.createAnswerNumbers(answerNumbers);
        // when
        List<Integer> result = baseballNumbers.getNumbers();
        // then
        assertThat(result).hasSize(3)
                .containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("숫자 목록 중 요청한 인덱스의 수를 반환한다.")
    void getNumber() {
        // given
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3);
        BaseballNumbers baseballNumbers = BaseballNumbers.createAnswerNumbers(answerNumbers);
        // when
        Integer result = baseballNumbers.getNumber(0);
        // then
        assertThat(result).isEqualTo(1);
    }

}
