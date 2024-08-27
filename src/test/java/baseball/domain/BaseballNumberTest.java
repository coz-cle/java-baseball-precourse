package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {

    @Test
    @DisplayName("BaseballNumber는 중복된 값 없이 고유한 숫자를 반환한다.")
    void BaseballNumber는_중복된_값_없이_고유한_숫자를_반환한다() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber();
        // when
        int firstNumber = baseballNumber.getBaseball_numbers()[0];
        int secondNumber = baseballNumber.getBaseball_numbers()[1];;
        int thirdNumber = baseballNumber.getBaseball_numbers()[2];;

        // then
        assertAll(() -> {
            assertNotEquals(firstNumber,secondNumber);
            assertNotEquals(firstNumber,thirdNumber);
            assertNotEquals(secondNumber,thirdNumber);
        });
    }

}