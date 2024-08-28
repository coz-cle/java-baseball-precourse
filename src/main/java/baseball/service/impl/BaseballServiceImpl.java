package baseball.service.impl;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumber;
import baseball.service.BaseballService;
import baseball.util.BasicUtils;

import java.util.regex.Pattern;

import static baseball.exception.ErrorMessages.*;
import static baseball.util.Constants.*;


public class BaseballServiceImpl implements BaseballService {


    @Override
    public BaseballGame gameStart() {
        return new BaseballGame();
    }


    @Override
    public void runGame(BaseballGame baseballGame) {
        baseballGame.run();
    }


    @Override
    public boolean gameEnd() {
        System.out.println(GAME_RESULT);
        // FIXME: 무한루프 돌지 않고 try-catch 에서 처리할 수 있는 방법?
        while (true) {
            try {
                System.out.println(GAME_RESTART);
                String restartNumber = BasicUtils.readLine();
                this.isValidRestartNumber(restartNumber);
                return findEndSignal(restartNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidRestartNumber(String restartNumber) {
        if (!Pattern.matches(VALID_RESTART_REX_PATTERN, restartNumber)) {
            throw new IllegalArgumentException(INVALID_EXIT_CHOICE);
        }
    }

    private boolean findEndSignal(String inputNumber) {
        switch (inputNumber) {
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
