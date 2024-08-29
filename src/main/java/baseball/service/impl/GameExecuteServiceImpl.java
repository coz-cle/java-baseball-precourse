package baseball.service.impl;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;
import baseball.service.GameExecuteService;
import baseball.service.InputValidator;
import baseball.util.BasicUtils;

import java.util.List;
import java.util.stream.Collectors;


public class GameExecuteServiceImpl implements GameExecuteService {

	private final InputValidator inputValidator;

	public GameExecuteServiceImpl(InputValidator inputValidator) {
		this.inputValidator = inputValidator;
	}

	@Override
	public BaseBallCount run(BaseballNumber systemNumber) {

		final String inputNumber = BasicUtils.readLine();
		validateInput(inputNumber);

		List<String> systemNumbers  = splitStringToList(systemNumber.getValue());
        List<String> inputNumbers = splitStringToList(inputNumber);

		// 입력 값과 시스템 값 비교
		return countBaseBall(systemNumbers,inputNumbers);
	}

	private BaseBallCount countBaseBall(List<String> systemNumbers,List<String> inputNumbers){
	        BaseBallCount baseBallCount = BaseBallCount.from();

	        final int bound = systemNumbers.size();
	        for (int i = 0; i < bound; i++) {
	            String systemChar = systemNumbers.get(i);
	            String inputChar = inputNumbers.get(i);
	            if (systemChar.equals(inputChar)) {
	                baseBallCount.addStrike();
	                continue;
	            }
	            if (inputNumbers.contains(systemChar)) {
	                baseBallCount.addBall();
	            }
	        }
	        return baseBallCount;
	}

	private List<String> splitStringToList(String number) {
      return number.chars()
              .mapToObj(c -> String.valueOf((char) c))
              .collect(Collectors.toList());
  }

	private void validateInput(String inputNumber) {
		inputValidator.validateInput(inputNumber);
	}
}
