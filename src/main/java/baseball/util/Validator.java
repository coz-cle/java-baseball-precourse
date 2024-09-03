package baseball.util;

public abstract class Validator<T> {
	private static final String ERROR_PREFIX = "[ERROR] ";

	protected static void throwException(String errorMessage) {
        throw new IllegalArgumentException(ERROR_PREFIX + errorMessage);
    }

	protected abstract void validate(T target);
}
