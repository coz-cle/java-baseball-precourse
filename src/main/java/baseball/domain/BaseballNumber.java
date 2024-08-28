package baseball.domain;

import java.util.List;

public class BaseballNumber {

	private final List<String> numbers;

	private BaseballNumber(List<String> numbers) {
		this.numbers = numbers;
	}

	public static BaseballNumber from(List<String> numbers) {
		return new BaseballNumber(numbers);
	}

	public List<String> getNumbers() {
		return numbers;
	}

	@Override
	public String toString() {
		return "BaseballNumber{" +
				"number='" + numbers + '\'' +
				'}';
	}
}
