package baseball.service.impl;

import baseball.domain.BaseballNumber;
import baseball.service.BaseballService;
import baseball.util.BasicUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

import static baseball.exception.ErrorMessages.INVALID_NON_DIGIT;
import static baseball.exception.ErrorMessages.INVALID_THREE_DIGIT;
import static baseball.util.Constants.BASEBALL_NUMBER_SIZE;
import static baseball.util.Constants.INPUT_NUMBER;


public class BaseballServiceImpl implements BaseballService {

    @Override
    public BaseballNumber gameStart() {
        BaseballNumber baseballNumber = new BaseballNumber();
        return baseballNumber;
    }


    @Override
    public void runGame() {
        BasicUtils basicUtils = new BasicUtils();
        while (true) {
            try {
                System.out.print(INPUT_NUMBER);
                String inputNumbers = basicUtils.readLine();

                this.isValidInputNumbers(inputNumbers);
                // TODO: 사용자가 입력한 값도 중복체크

                Integer[] convertToNumber = new Integer[BASEBALL_NUMBER_SIZE];
                for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
                    convertToNumber[i] = Character.getNumericValue(inputNumbers.charAt(i));
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    private boolean isValidThreeDigit(String inputNumbers) {
        return inputNumbers.length() > BASEBALL_NUMBER_SIZE;
    }


    private void isValidInputNumbers(String inputNumbers) {

        if (isValidThreeDigit(inputNumbers)) {
            throw new IllegalArgumentException(INVALID_THREE_DIGIT);
        }

        if(StringUtils.isBlank(inputNumbers)){
            throw new IllegalArgumentException(INVALID_NON_DIGIT);
        }
        if (!Pattern.matches("^[1-9]+$", inputNumbers)) {
            throw new IllegalArgumentException(INVALID_NON_DIGIT);
        }
    }



    @Override
    public void gameEnd() {

    }
}
