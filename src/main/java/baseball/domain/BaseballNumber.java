package baseball.domain;

public class BaseballNumber {

    private final int number;

    private BaseballNumber(int number) {
        this.number = number;
    }

    public static BaseballNumber create(int number) {
        return new BaseballNumber(number);
    }

}
