package baseball.service;

import baseball.domain.BaseballNumbers;
import baseball.service.dto.BaseBallTotalCount;
import baseball.util.common.NumberGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.util.common.Constants.BASEBALL_NUMBER_SIZE;

public class BaseballNumbersManager {

    private final NumberGenerator numberGenerator;

    private BaseballNumbersManager(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static BaseballNumbersManager create(NumberGenerator numberGenerator) {
        return new BaseballNumbersManager(numberGenerator);
    }

    /**
     * generate(): generateRandomNumber() 메서드를 반복적으로 호출하는 스트림 생성
     * distinct(): 스트림에서 중복숫자 제거
     * limit(3): 중복되지 않는 숫자 중 3개만 선택
     */
    public BaseballNumbers createAnswerNumbers() {
        List<Integer> answerNumbers = numberGenerator.generate();
        return BaseballNumbers.createAnswerNumbers(answerNumbers);
    }

    public BaseballNumbers createInputNumbers(List<Integer> inputNumbers) {
        return BaseballNumbers.createInputNumbers(inputNumbers);
    }

    public BaseBallTotalCount getTotalCount(BaseballNumbers answerNumbers, BaseballNumbers inputNumbers) {
        int strikes = calculateStrike(answerNumbers, inputNumbers);
        int balls = calculateBall(answerNumbers, inputNumbers);
        return BaseBallTotalCount.create(strikes, balls);
    }

    private int calculateStrike(BaseballNumbers answerNumbers, BaseballNumbers inputNumbers) {
        return IntStream.range(0, BASEBALL_NUMBER_SIZE)
                .map(position -> {
                    int inputNumber = getInputNumber(inputNumbers, position);
                    return calculateStrikeCount(answerNumbers, position, inputNumber);
                })
                .sum();
    }

    private int calculateBall(BaseballNumbers answerNumbers, BaseballNumbers inputNumbers) {
        return IntStream.range(0, BASEBALL_NUMBER_SIZE)
                .map(position -> {
                    int inputNumber = getInputNumber(inputNumbers, position);
                    return calculateBallCount(answerNumbers, position, inputNumber);
                })
                .sum();
    }

    private int getInputNumber(BaseballNumbers inputNumbers, int position) {
        return inputNumbers.getNumber(position);
    }

    private int calculateStrikeCount(BaseballNumbers answerNumbers, int position, int inputNumber) {
        return answerNumbers.getStrikeCount(position, inputNumber);
    }

    private int calculateBallCount(BaseballNumbers answerNumbers, int position, int inputNumber) {
        return answerNumbers.getBallCount(position, inputNumber);
    }

    public boolean isThreeStrike(BaseBallTotalCount baseballTotalCount) {
        if (baseballTotalCount.getStrikeCount() == 3) {
            return true;
        }
        return false;
    }
}
