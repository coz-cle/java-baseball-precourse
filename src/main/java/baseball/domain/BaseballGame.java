package baseball.domain;

import baseball.util.BasicUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

import static baseball.exception.ErrorMessages.*;
import static baseball.util.Constants.*;

public class BaseballGame {

    private final BaseballNumber baseballNumber;

    public BaseballGame() {
        this.baseballNumber = new BaseballNumber();;
    }

    public void run(){

        boolean isRunning = true;
        // FIXME: 무한루프 돌지 않고 try-catch 에서 처리할 수 있는 방법
        while (isRunning) {
            try {
                String inputNumbers = getInput();
                isValidInputNumbers(inputNumbers);

                // 비교 대상
                Integer[] userNumbers = getConvertToNumber(inputNumbers);

                // 기준
                Integer[] systemNumbers = baseballNumber.getBaseball_numbers();

                isRunning = processGameRound(systemNumbers, userNumbers);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean processGameRound(Integer[] systemNumbers, Integer[] userNumbers) {
        boolean isRunning = true;
        printAnswer(systemNumbers);
        if (isNotIncluded(systemNumbers, userNumbers)) {
            handleNotIncluded();
        } else {
            int strikeCount = handleIncluded(systemNumbers, userNumbers);
            isRunning = isEndGameCondition(strikeCount);
        }
        return isRunning;
    }

    private boolean isEndGameCondition(int strikeCount) {
        boolean isNotEnd = true;
        if (strikeCount == END_GAME_CONDITION) {
            System.out.println(END_GAME);
            isNotEnd = false;
        }
        return isNotEnd;
    }

    /**
     * 정답 빨리 확인하고 싶어서 넣었어용
     * @param systemNumbers
     */
    private void printAnswer(Integer[] systemNumbers) {
        StringBuilder answer = new StringBuilder();
        answer.append("정답은 ");

          for (Integer number : systemNumbers) {
              answer.append(number);
          }
        System.out.println(answer);
    }


    private boolean isNotIncluded(Integer[] systemNumbers, Integer[] userNumbers) {
        return Arrays.stream(userNumbers).noneMatch(value -> Arrays.asList(systemNumbers).contains(value));
    }

    private void handleNotIncluded() {
        System.out.println(RESULT_NOT_THING);
    }


    private int handleIncluded(Integer[] systemNumbers, Integer[] userNumbers) {
        int ballCount = calculateBallCount(systemNumbers, userNumbers);
        int strikeCount = calculateStrikeCount(systemNumbers, userNumbers);

        printResult(ballCount, strikeCount);

        return strikeCount;
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

    private int calculateBallCount(Integer[] systemNumbers, Integer[] userNumbers) {
        return (int) Arrays.stream(userNumbers)
                .filter((value) -> Arrays.asList(systemNumbers).contains(value))
                .filter((value) -> Arrays.asList(userNumbers).indexOf(value) != Arrays.asList(systemNumbers).indexOf(value))
                .count();
    }

    private int calculateStrikeCount(Integer[] systemNumbers, Integer[] userNumbers) {
         return (int) Arrays.stream(userNumbers)
                 .filter((value) -> Arrays.asList(systemNumbers).contains(value))
                 .filter((value) -> Arrays.asList(userNumbers).indexOf(value) == Arrays.asList(systemNumbers).indexOf(value))
                 .count();
     }


    private String getInput() {
        System.out.print(INPUT_NUMBER);
         return BasicUtils.readLine();
    }

    private boolean isValidThreeDigit(String inputNumbers) {
        return inputNumbers.length() != BASEBALL_NUMBER_SIZE;
    }

    private void isValidInputNumbers(String inputNumbers) {

        if (isValidThreeDigit(inputNumbers)) {
            throw new IllegalArgumentException(INVALID_THREE_DIGIT);
        }

        if (StringUtils.isBlank(inputNumbers)) {
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

    private Integer[] getConvertToNumber(String inputNumbers) {
        Integer[] convertToNumber = new Integer[BASEBALL_NUMBER_SIZE];
        for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
            convertToNumber[i] = Character.getNumericValue(inputNumbers.charAt(i));
        }
        return convertToNumber;
    }

    // FIXME? BaseballGame 도메인에 gameEnd 로직도 추가하는게 좋을까?


}
