package baseball.service;

import baseball.domain.BaseBallTotalCount;
import baseball.domain.BaseballNumbers;
import baseball.util.BasicUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.util.Constants.BASEBALL_NUMBER_SIZE;
import static java.util.stream.Stream.*;

public class BaseballNumbersManager {

    /**
     * generate(): generateRandomNumber() 메서드를 반복적으로 호출하는 스트림 생성
     * distinct(): 스트림에서 중복숫자 제거
     * limit(3): 중복되지 않는 숫자 중 3개만 선택
     */
    public BaseballNumbers createRandomBaseballNumbers() {
        return BaseballNumbers.create(
                generate(BasicUtils::generateRandomNumber)
                        .distinct()
                        .limit(3)
                        .collect(Collectors.toList())
        );
    }

    public BaseballNumbers create(List<Integer> inputNumbers) {
        return BaseballNumbers.create(inputNumbers);
    }

    public BaseBallTotalCount getGameResult(BaseballNumbers systemNumbers, BaseballNumbers inputNumbers) {
        int strikes = calculateStrike(systemNumbers, inputNumbers);
        int balls = calculateBall(systemNumbers, inputNumbers);
        return BaseBallTotalCount.create(strikes, balls);
    }

    private int calculateStrike(BaseballNumbers systemNumbers, BaseballNumbers inputNumbers) {
        return IntStream.range(0, BASEBALL_NUMBER_SIZE)
                .map(position -> {
                    int inputNumber = getInputNumber(inputNumbers, position);
                    return calculateStrikeCount(systemNumbers, position, inputNumber);
                })
                .sum();
    }

    private int calculateBall(BaseballNumbers systemNumbers, BaseballNumbers inputNumbers) {
        return IntStream.range(0, inputNumbers.getSize())
                .map(position -> {
                    int inputNumber = getInputNumber(inputNumbers, position);
                    return calculateBallCount(systemNumbers, position, inputNumber);
                })
                .sum();
    }

    private int getInputNumber(BaseballNumbers inputNumbers, int position) {
        return inputNumbers.getNumber(position);
    }

    private int calculateStrikeCount(BaseballNumbers systemNumbers, int position, int inputNumber) {
        return systemNumbers.getStrikeCount(position, inputNumber);
    }

    private int calculateBallCount(BaseballNumbers systemNumbers, int position, int inputNumber) {
        return systemNumbers.getBallCount(position, inputNumber);
    }
}
