package baseball.domain;

import baseball.util.BasicUtils;

import java.util.HashSet;

import static baseball.util.Constants.BASEBALL_NUMBER_SIZE;

public class BaseballNumber {

    private int first_number;
    private int second_number;
    private int third_number;

    public BaseballNumber() {
        Integer[] numbers = settingUniqueNumbers();

        this.first_number = numbers[0];
        this.second_number = numbers[1];
        this.third_number = numbers[2];
    }

    /**
     * 중복된 값 없이 고유한 숫자로 객체를 생성
     * @return
     */
    private Integer[] settingUniqueNumbers() {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
         for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
             uniqueNumbers.add(new BasicUtils().generateRandomNumber());
         }
         return uniqueNumbers.toArray(new Integer[uniqueNumbers.size()]);
     }


    public int getFirst_number() {
        return first_number;
    }

    public int getSecond_number() {
        return second_number;
    }

    public int getThird_number() {
        return third_number;
    }
}
