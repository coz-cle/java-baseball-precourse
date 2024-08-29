package baseball.service.impl;

import baseball.domain.BaseballNumber;
import baseball.service.GameInitService;
import baseball.service.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.util.Constants.*;

public class GameInitServiceImpl implements GameInitService {

	private final NumberGenerator numberGenerator;

	public GameInitServiceImpl(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	@Override
	public BaseballNumber init() {
		Set<String> duplicationFilter = new HashSet<>();

		while (duplicationFilter.size() < BASEBALL_NUMBER_SIZE) {
			// 난수 생성
			final String randomNumber = String.valueOf(numberGenerator.randomNumber());
			// 난수 추가
			duplicationFilter.add(randomNumber);
		}

		final String randomNumber = String.join("", duplicationFilter);
		return BaseballNumber.from(randomNumber);
	}
}
