package baseball.service.impl;

import baseball.service.NumberGenerator;
import baseball.util.BasicUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.util.Constants.BASEBALL_NUMBER_SIZE;

public class BaseBallNumberGenerator implements NumberGenerator {

	@Override
	public String randomNumber() {
		return Stream.generate(() -> String.valueOf(BasicUtils.generateRandomNumber()))
				.distinct()
				.limit(BASEBALL_NUMBER_SIZE)
				.collect(Collectors.joining());
	}
}