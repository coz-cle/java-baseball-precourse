package baseball.service.impl;

import baseball.domain.BaseballNumber;
import baseball.service.GameInitService;
import baseball.service.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.Constants.*;

public class GameInitServiceImpl implements GameInitService {

	private final NumberGenerator numberGenerator;

	public GameInitServiceImpl(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	@Override
	public BaseballNumber init() {
		List<String> randomNumberList = new ArrayList<>();

		while (randomNumberList.size() < BASEBALL_NUMBER_SIZE) {
			// 난수 생성
			final String randomNumber = String.valueOf(numberGenerator.randomNumber());
			// 난수 중복 검증
			if(!randomNumberList.contains(randomNumber)){
				// 난수 추가
				randomNumberList.add(randomNumber);
			}
		}

		final String randomNumber = String.join("", randomNumberList);
		return BaseballNumber.from(randomNumber);
	}
}
