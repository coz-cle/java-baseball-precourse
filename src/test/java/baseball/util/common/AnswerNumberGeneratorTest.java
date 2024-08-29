package baseball.util.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerNumberGeneratorTest {

    @Test
    @DisplayName("서로다른 3자리의 수를 생성할 수 있다.")
    void generate() {
        // given
        AnswerNumberGenerator answerNumberGenerator = AnswerNumberGenerator.create();
        // when
        List<Integer> result = answerNumberGenerator.generate();
        // then
        assertThat(result).hasSize(3).doesNotHaveDuplicates();
    }

}
