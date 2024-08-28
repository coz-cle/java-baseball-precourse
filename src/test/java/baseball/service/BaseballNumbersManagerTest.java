package baseball.service;

import baseball.domain.BaseballNumbers;
import baseball.mock.MockNumberGenerator;
import baseball.service.dto.BaseBallTotalCount;
import baseball.util.common.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseballNumbersManagerTest {

    @Test
    @DisplayName("정답으로 사용할 서로 다른 3자리의 수를 필드로 가지는 객체를 생성한다.")
    void createAnswerNumbersAnswerNumbers() {
        // given
        NumberGenerator numberGenerator = MockNumberGenerator.create();
        BaseballNumbersManager baseballNumbersManager = BaseballNumbersManager.create(numberGenerator);
        // when
        BaseballNumbers result = baseballNumbersManager.createAnswerNumbers();
        // then
        assertAll(() -> {
            assertThat(result).isInstanceOf(BaseballNumbers.class);
            assertThat(result.getNumbers()).hasSize(3)
                    .containsExactly(1, 2, 3)
                    .doesNotHaveDuplicates();
        });
    }

    @Test
    @DisplayName("입력받은 서로 다른 3자리의 수를 필드로 가지는 객체를 생성한다.")
    void createAnswerNumbersInputNumbers() {
        // given
        NumberGenerator numberGenerator = MockNumberGenerator.create();
        BaseballNumbersManager baseballNumbersManager = BaseballNumbersManager.create(numberGenerator);
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);
        // when
        BaseballNumbers result = baseballNumbersManager.createInputNumbers(inputNumbers);
        // then
        assertAll(() -> {
            assertThat(result).isInstanceOf(BaseballNumbers.class);
            assertThat(result.getNumbers()).hasSize(3)
                    .containsExactly(1, 2, 3)
                    .doesNotHaveDuplicates();
        });
    }

    @Test
    @DisplayName("입력받은 숫자와 정답 숫자를 비교하여 스트라이크와 볼 개수를 반환한다.")
    void getTotalCount() {
        // given
        NumberGenerator numberGenerator = MockNumberGenerator.create();
        BaseballNumbersManager baseballNumbersManager = BaseballNumbersManager.create(numberGenerator);
        List<Integer> input = Arrays.asList(1, 2, 3);
        BaseballNumbers answerNumbers = baseballNumbersManager.createAnswerNumbers();
        BaseballNumbers inputNumbers = baseballNumbersManager.createInputNumbers(input);
        // when
        BaseBallTotalCount result = baseballNumbersManager.getTotalCount(answerNumbers, inputNumbers);
        // then
        assertAll(() -> {
            assertThat(result).isInstanceOf(BaseBallTotalCount.class);
            assertThat(result.getStrikeCount()).isEqualTo(3);
            assertThat(result.getBallCount()).isEqualTo(0);
        });
    }

    @Test
    @DisplayName("입력받은 숫자가 3스트라이크로 정답인지 확인한다.")
    void isThreeStrike() {
        // given
        NumberGenerator numberGenerator = MockNumberGenerator.create();
        BaseballNumbersManager baseballNumbersManager = BaseballNumbersManager.create(numberGenerator);
        BaseBallTotalCount baseBallTotalCount = BaseBallTotalCount.create(3, 0);
        // when
        boolean result = baseballNumbersManager.isThreeStrike(baseBallTotalCount);
        // then
        assertThat(result).isTrue();
    }

}
