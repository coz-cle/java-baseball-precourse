package baseball.service.impl;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;

import java.util.List;
import java.util.stream.Collectors;

public class BaseBallCounter {

    private final BaseballNumber systemNumber;


    private BaseBallCounter(BaseballNumber systemNumber) {
        this.systemNumber = systemNumber;
    }

    public static BaseBallCounter from(BaseballNumber baseballNumber) {
        return new BaseBallCounter(baseballNumber);
    }


    public BaseBallCount countBaseBall(BaseballNumber targetNumber){
        BaseBallCount baseBallCount = BaseBallCount.from();

        List<String> systemNumbers  = sliceBaseBallNumber(systemNumber.getValue());
        List<String> targetNumbers = sliceBaseBallNumber(targetNumber.getValue());

        final int bound = systemNumbers.size();
        for (int i = 0; i < bound; i++) {
            String systemChar = systemNumbers.get(i);
            String inputChar = targetNumbers.get(i);
            if (systemChar.equals(inputChar)) {
                baseBallCount.addStrike();
                continue;
            }
            if (targetNumbers.contains(systemChar)) {
                baseBallCount.addBall();
            }
        }
        return baseBallCount;
    }

    private List<String> sliceBaseBallNumber(String number) {
        return number.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toList());
    }
}
