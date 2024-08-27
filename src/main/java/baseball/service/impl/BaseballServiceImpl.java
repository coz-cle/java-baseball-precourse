package baseball.service.impl;

import baseball.domain.BaseballNumber;
import baseball.service.BaseballService;
import baseball.util.BasicUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

import static baseball.exception.ErrorMessages.*;
import static baseball.util.Constants.*;


public class BaseballServiceImpl implements BaseballService {

    @Override
    public BaseballNumber gameStart() {
        BaseballNumber baseballNumber = new BaseballNumber();
        return baseballNumber;
    }


    @Override
    public void runGame(BaseballNumber baseballNumber) {
        while (true) {

            // FIXME: 무한루프 돌지 않고 try-catch 에서 처리할 수 있는 방법
            try {
                System.out.print(INPUT_NUMBER);
                String inputNumbers = BasicUtils.readLine();

                this.isValidInputNumbers(inputNumbers);

                // 비교 대상
                Integer[] convertToNumber = getConvertToNumber(inputNumbers);

                // 기준
                Integer[] baseballNumbers = baseballNumber.getBaseball_numbers();

                this.printAnswer(baseballNumbers);

                // 아무것도 포함하지 않는 경우
                boolean notIncluded = Arrays.stream(convertToNumber).noneMatch(value -> Arrays.asList(baseballNumbers).contains(value));

                if(notIncluded){
                    System.out.println(RESULT_NOT_THING);
                }else {
                    // FIXME: if ~ else 구문 삭제
                    // 인덱스의 값은 일치하지만 순서가 다른 경우
                    int ballCnt = (int) Arrays.stream(convertToNumber)
                            .filter((value) -> Arrays.asList(baseballNumbers).contains(value))
                            .filter((value) -> Arrays.asList(convertToNumber).indexOf(value) != Arrays.asList(baseballNumbers).indexOf(value))
                            .count();


                    // 인덱스의 값과 순서가 일치하는 경우
                    int strikeCnt = (int) Arrays.stream(convertToNumber)
                            .filter((value) -> Arrays.asList(baseballNumbers).contains(value))
                            .filter((value) -> Arrays.asList(convertToNumber).indexOf(value) == Arrays.asList(baseballNumbers).indexOf(value))
                            .count();

                    this.printResult(ballCnt, strikeCnt);

                    if (strikeCnt == 3) {
                        return;
                    }

                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 정답 빨리 확인하고 싶어서 넣었어용
     * @param baseballNumbers
     */
    private void printAnswer(Integer[] baseballNumbers) {
        StringBuilder answer = new StringBuilder();
        answer.append("정답은 ");

          for (Integer number : baseballNumbers) {
              answer.append(number);
          }
        System.out.println(answer);
    }

    private Integer[] getConvertToNumber(String inputNumbers) {
        Integer[] convertToNumber = new Integer[BASEBALL_NUMBER_SIZE];
        for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
            convertToNumber[i] = Character.getNumericValue(inputNumbers.charAt(i));
        }
        return convertToNumber;
    }

    private boolean isValidThreeDigit(String inputNumbers) {
        return inputNumbers.length() != BASEBALL_NUMBER_SIZE;
    }

    private void isValidInputNumbers(String inputNumbers) {

        if (isValidThreeDigit(inputNumbers)) {
            throw new IllegalArgumentException(INVALID_THREE_DIGIT);
        }

        if(StringUtils.isBlank(inputNumbers)){
            throw new IllegalArgumentException(INVALID_NON_DIGIT);
        }
        if (!Pattern.matches(VALID_NUMBER_REX_PATTERN, inputNumbers)) {
            throw new IllegalArgumentException(INVALID_NON_DIGIT);
        }

        if (hasDuplicates(inputNumbers)) {
            throw new IllegalArgumentException(INVALID_UNIQUE_NUMBER);
        }
    }

    private boolean hasDuplicates(String inputNumbers) {
        HashSet<Character> uniqueNumber = new HashSet<>();
        for (char c : inputNumbers.toCharArray()) {
            if (!uniqueNumber.add(c)) {
                return true;
            }
        }
        return false;
    }

    private void printResult(int ballCnt, int strikeCnt) {
        StringBuilder result = new StringBuilder();
        if (ballCnt > 0) {
            result.append(ballCnt).append(RESULT_BALL).append(WHITE_SPACE);
        }

        if (strikeCnt > 0) {
            result.append(strikeCnt).append(RESULT_STRIKE);
        }

        System.out.println(result);
    }

    @Override
    public boolean gameEnd() {
        System.out.println(GAME_RESULT);

        while (true) {
            try {
                System.out.println(GAME_RETRY);
                String tmp = BasicUtils.readLine();
                this.isValidRestartNumber(tmp);
                return processInput(tmp);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidRestartNumber(String inputNumbers) {
        if (!Pattern.matches(VALID_RESTART_REX_PATTERN, inputNumbers)) {
            throw new IllegalArgumentException(INVALID_EXIT_CHOICE);
        }
    }

    private boolean processInput(String input) {
        switch (input) {
            case RESTART_SIGNAL:
                return false;
            case END_GAME_SIGNAL:
                System.out.println(END_GAME);
                return true;
            default:
                throw new IllegalArgumentException(INVALID_EXIT_CHOICE);
        }
    }


}
