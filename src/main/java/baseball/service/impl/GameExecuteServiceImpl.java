package baseball.service.impl;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;
import baseball.service.GameExecuteService;
import baseball.service.InputValidator;
import baseball.util.BasicUtils;


public class GameExecuteServiceImpl implements GameExecuteService {

	private final InputValidator inputValidator;

	public GameExecuteServiceImpl(InputValidator inputValidator) {
		this.inputValidator = inputValidator;
	}

	@Override
	public BaseBallCount run(BaseballNumber systemNumber) {

		final String inputNumber = BasicUtils.readLine();
		validateInput(inputNumber);

		BaseBallCounter baseBallCounter = BaseBallCounter.from(systemNumber);

		// 입력 값과 시스템 값 비교
		BaseballNumber target = BaseballNumber.from(inputNumber);
		return baseBallCounter.countBaseBall(target);
	}

	private void validateInput(String inputNumber) {
		inputValidator.validateInput(inputNumber);
	}
}
