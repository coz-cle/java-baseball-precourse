package baseball.domain;

import java.util.HashSet;

import static baseball.util.BasicUtils.generateRandomNumber;
import static baseball.util.Constants.BASEBALL_NUMBER_SIZE;

public class BaseballNumber {

    private final Integer[] baseball_numbers;

    public BaseballNumber() {
        this.baseball_numbers = settingUniqueNumbers();;
    }

    /**
     * 중복된 값 없이 고유한 숫자로 객체를 생성
     * @return
     */
    private Integer[] settingUniqueNumbers() {
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < BASEBALL_NUMBER_SIZE) {
            int number = generateRandomNumber();
            uniqueNumbers.add(number);
        }

         return uniqueNumbers.toArray(new Integer[uniqueNumbers.size()]);
     }

    public Integer[] getBaseball_numbers() {
        return baseball_numbers;
    }
}
