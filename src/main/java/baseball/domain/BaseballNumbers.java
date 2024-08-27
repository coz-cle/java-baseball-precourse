package baseball.domain;

import java.util.List;

public class BaseballNumbers {

    private final List<Integer> numbers;

    private BaseballNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static BaseballNumbers create(List<Integer> number) {
        return new BaseballNumbers(number);
    }

    // Domain Logic
    public boolean isStrike(int position, int inputNumber) {
        return this.getNumber(position).equals(inputNumber);
    }

    private boolean isBall(int position, int inputNumber) {
        return this.getNumbers().contains(inputNumber) && !this.getNumber(position).equals(inputNumber);
    }

    public int getStrikeCount(int position, int inputNumber) {
        return isStrike(position, inputNumber) ? 1 : 0;
    }

    public int getBallCount(int position, int inputNumber) {
        return isBall(position, inputNumber) ? 1 : 0;
    }

    // Getter
    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getNumber(int position) {
        return numbers.get(position);
    }

    public int getSize() {
        return numbers.size();
    }

}
