package baseball.domain;

import baseball.util.enums.NumbersType;
import baseball.util.validator.NumbersValidator;

import java.util.List;

import static baseball.util.enums.NumbersType.ANSWER_NUMBER;
import static baseball.util.enums.NumbersType.INPUT_NUMBER;

public class BaseballNumbers {

    private final List<Integer> numbers;

    private BaseballNumbers(List<Integer> numbers, NumbersType numbersType) {
        this.numbers = numbers;
        NumbersValidator numbersValidator = NumbersValidator.create();
        numbersValidator.validateList(numbers, numbersType);
    }

    public static BaseballNumbers createAnswerNumbers(List<Integer> numbers) {
        return new BaseballNumbers(numbers, ANSWER_NUMBER);
    }

    public static BaseballNumbers createInputNumbers(List<Integer> numbers) {
        return new BaseballNumbers(numbers, INPUT_NUMBER);
    }

    // Domain Logic
    public int getStrikeCount(int position, int inputNumber) {
        if (isStrike(position, inputNumber)) return 1;
        return 0;
    }

    public int getBallCount(int position, int inputNumber) {
        if (isBall(position, inputNumber)) return 1;
        return 0;
    }

    private boolean isStrike(int position, int inputNumber) {
        return this.getNumber(position).equals(inputNumber);
    }

    private boolean isBall(int position, int inputNumber) {
        return this.getNumbers().contains(inputNumber) && !this.getNumber(position).equals(inputNumber);
    }

    // Getter
    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getNumber(int position) {
        return numbers.get(position);
    }

}
