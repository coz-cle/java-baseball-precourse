package baseball.service.impl;

import baseball.domain.BaseballNumber;
import baseball.service.BaseballService;


public class BaseballServiceImpl implements BaseballService {

    @Override
    public BaseballNumber gameStart() {
        BaseballNumber baseballNumber = new BaseballNumber();
        return baseballNumber;
    }




    @Override
    public void runGame() {

    }


    @Override
    public void gameEnd() {

    }
}
