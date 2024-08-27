package baseball.util;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.util.Constants.MAX_BASE_BALL_NUMBER;

public class BasicUtils {

    // 1~9까지의 수 중에서 난수 제공
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_BASE_BALL_NUMBER, MAX_BASE_BALL_NUMBER);
    }

    // 사용자 입력
    public static String readLine() {
        return Console.readLine();
    }

}
