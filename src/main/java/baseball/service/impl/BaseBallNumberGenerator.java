package baseball.service.impl;

import baseball.service.NumberGenerator;
import baseball.util.BasicUtils;

public class BaseBallNumberGenerator implements NumberGenerator {

	@Override
	public int randomNumber() {
		return BasicUtils.generateRandomNumber();
	}
}
