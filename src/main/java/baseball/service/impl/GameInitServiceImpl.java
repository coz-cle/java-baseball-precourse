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
		final String randomNumber = numberGenerator.randomNumber();
		return BaseballNumber.from(randomNumber);
	}
}
