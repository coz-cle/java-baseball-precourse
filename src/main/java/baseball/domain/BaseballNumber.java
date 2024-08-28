package baseball.domain;


public class BaseballNumber {

	private final String value;

	private BaseballNumber(String value) {
		this.value = value;
	}

	public static BaseballNumber from(String value) {
		return new BaseballNumber(value);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "BaseballNumber{" +
				"value='" + value + '\'' +
				'}';
	}
}
