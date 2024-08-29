package baseball.service;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;
import baseball.mock.FakeInputValidator;
import baseball.service.impl.GameExecuteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameExecuteServiceTest {

	private GameExecuteService gameExecuteService;

	@BeforeEach
	void setUp() {
		InputValidator inputValidator = new FakeInputValidator();
		gameExecuteService = new GameExecuteServiceImpl(inputValidator);
	}

	@Test
	@DisplayName("[Green] 게임 진행 후 정상정으로 볼 카운트를 반환한다.")
	void 게임_진행_후_정상적으로_볼_카운트를_반환한다(){
	    //given
		BaseballNumber systemNumber = getSystemNumber();
		BaseballNumber inputNumber = getInputNumber();

		//when
		BaseBallCount baseBallCount = gameExecuteService.run(systemNumber, inputNumber);

		//then
		assertAll(
				()-> assertThat(baseBallCount.getBall()).isEqualTo(2),
				()-> assertThat(baseBallCount.getStrike()).isEqualTo(1)
		);
	}


	private static BaseballNumber getSystemNumber() {
		return BaseballNumber.from("921");
	}

	private static BaseballNumber getInputNumber() {
		return BaseballNumber.from("912");
	}
}