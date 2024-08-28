package baseball.service.impl;

import baseball.domain.BaseBallCount;
import baseball.service.GamePrintService;

import java.util.ArrayList;
import java.util.List;

public class GamePrintServiceImpl implements GamePrintService {
    private static final String INPUT_NUMBER_TITLE_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRIKE_OUT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE_SUFFIX = "볼";
    private static final String STRIKE_MESSAGE_SUFFIX = "스트라이크";

    @Override
    public void printInputNumberHeader(){
        System.out.print(INPUT_NUMBER_TITLE_MESSAGE);
    }

    @Override
    public void printResult(BaseBallCount baseBallCount){
        final String roundResult = getResultMessage(baseBallCount);
        System.out.println(roundResult);
    }

    @Override
    public void printOutMessage(){
        System.out.println(STRIKE_OUT_MESSAGE);
    }

    private String getResultMessage(BaseBallCount baseBallCount) {
        List<String> result = new ArrayList<>();

        if(baseBallCount.isNothing()){
            return NOTHING_MESSAGE;
        }

        if(baseBallCount.getBall() > 0){
            result.add(baseBallCount.getBall() + BALL_MESSAGE_SUFFIX);
        }

        if(baseBallCount.getStrike() > 0){
            result.add(baseBallCount.getStrike() + STRIKE_MESSAGE_SUFFIX);
        }

        return String.join(" ", result);
    }
}
