package baseball.service.impl;

import baseball.domain.BaseballNumber;
import baseball.dto.GameStartDto;
import baseball.service.GameReadyService;
import baseball.service.InputValidator;
import baseball.util.BasicUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBallGameReadyService implements GameReadyService {
	private static final String INPUT_NUMBER_TITLE_MESSAGE = "숫자를 입력해주세요 : ";

	private final InputValidator inputValidator;

	public BaseBallGameReadyService(InputValidator inputValidator) {
		this.inputValidator = inputValidator;
	}

	@Override
	public GameStartDto ready(BaseballNumber systemNumber) {

		System.out.print(INPUT_NUMBER_TITLE_MESSAGE);
		String inputNumber = BasicUtils.readLine();

		inputValidator.isAvailableGameNumber(inputNumber);
		BaseballNumber userNumber = createUserNumber(inputNumber);

		return GameStartDto.from(systemNumber, userNumber);
	}

	@Override
	public BaseballNumber createSystemNumber() {
		List<String> randomNumberList = new ArrayList<>();

		while (randomNumberList.size() < 3) {
			// 난수 생성
			final String randomNumber = String.valueOf(BasicUtils.generateRandomNumber());
			// 난수 중복 검증
			if(!randomNumberList.contains(randomNumber)){
				// 난수 추가
				randomNumberList.add(randomNumber);
			}
		}
		return BaseballNumber.from(randomNumberList);
	}

	private BaseballNumber createUserNumber(String number) {
		List<String> numbers = number.chars()
				.mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.toList());
		return BaseballNumber.from(numbers);
	}
}
