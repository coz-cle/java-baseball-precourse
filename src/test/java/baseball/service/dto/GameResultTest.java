package baseball.service.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    @DisplayName("게임 진행 중 스트라이크와 볼이 하나도 없을 경우 낫싱을 반환한다.")
    void createNothing() {
        // given
        BaseBallTotalCount baseBallTotalCount = BaseBallTotalCount.create(0, 0);
        // when
        GameResult result = GameResult.create(baseBallTotalCount);
        // then
        assertThat(result.getResultString()).contains("낫싱");
    }

    @Test
    @DisplayName("게임 진행 중 스트라이크와 볼이 나왔다면 볼 및 스트라이크 현황을 반환한다.")
    void createStrikeWithBall() {
        // given
        BaseBallTotalCount baseBallTotalCount = BaseBallTotalCount.create(1, 2);
        // when
        GameResult result = GameResult.create(baseBallTotalCount);
        // then
        assertThat(result.getResultString()).contains("2볼 1스트라이크");
    }

}
