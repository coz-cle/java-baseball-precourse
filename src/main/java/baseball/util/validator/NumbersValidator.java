package baseball.util.validator;

import baseball.util.enums.NumbersType;

import java.util.List;

import static baseball.util.enums.NumbersType.INPUT_NUMBER;
import static baseball.exception.ErrorMessages.*;

public class NumbersValidator {

    private NumbersValidator() {
    }

    public static NumbersValidator create() {
        return new NumbersValidator();
    }

    public void validateInput(String inputNumbers) {
        validateSize(inputNumbers);
        validateNumber(inputNumbers);
        validateUnique(inputNumbers);
    }

    private void validateSize(String inputStringNumbers) {
        if (inputStringNumbers.length() != 3) {
            throw new IllegalArgumentException(INVALID_THREE_DIGIT);
        }
    }

    private void validateNumber(String inputStringNumbers) {
        if(isNotNumber(inputStringNumbers)) {
            throw new IllegalArgumentException(INVALID_NON_DIGIT);
        }
    }

    private void validateUnique(String inputStringNumbers) {
        long count = inputStringNumbers.chars()
                .distinct()
                .count();
        if (count != 3) {
            throw new IllegalArgumentException(INVALID_UNIQUE_NUMBER);
        }
    }

    public void validateList(List<Integer> numbers, NumbersType numbersType) {
        validateSize(numbers, numbersType);
        validateUnique(numbers, numbersType);
    }

    private void validateSize(List<Integer> numbers, NumbersType numbersType) {
        if (numbersType.getKey().equals(INPUT_NUMBER.getKey())) {
            checkSizeToInput(numbers);
        }
        checkSizeToAnswer(numbers);
    }

    private void checkSizeToInput(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(INVALID_THREE_DIGIT);
        }
    }

    private void checkSizeToAnswer(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(INVALID_ANSWER_THREE_DIGIT);
        }
    }

    private void validateUnique(List<Integer> numbers, NumbersType numbersType) {
        if (numbersType.getKey().equals(INPUT_NUMBER.getKey())) {
            checkUniqueNumberToInput(numbers);
        }
        checkUniqueNumberToAnswer(numbers);
    }

    private void checkUniqueNumberToInput(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != 3) {
            throw new IllegalArgumentException(INVALID_UNIQUE_NUMBER);
        }
    }

    private void checkUniqueNumberToAnswer(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != 3) {
            throw new IllegalArgumentException(INVALID_ANSWER_UNIQUE_NUMBER);
        }
    }

    private boolean isNotNumber(String inputStringNumbers) {
        return inputStringNumbers.chars()
                .anyMatch(number -> number < '1' || number > '9');
    }

    public void validateRestartNumber(String inputRestartNumber) {
        if (isNotRestartNumber(inputRestartNumber)) {
            throw new IllegalArgumentException(INVALID_EXIT_CHOICE);
        }
    }

    private boolean isNotRestartNumber(String inputRestartNumber) {
        return inputRestartNumber.chars()
                .noneMatch(number -> number == '1' || number == '2');
    }
}
