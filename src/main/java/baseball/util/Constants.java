package baseball.util;


public class Constants {

    // 시스템 상수
    public static final int MIN_BASE_BALL_NUMBER = 1;
    public static final int MAX_BASE_BALL_NUMBER = 9;

    // 입력 관련 상수
    public static final int BASEBALL_NUMBER_SIZE  = 3;

    // 게임 진행 관련 상수
    public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String RESULT_STRIKE = "스트라이크";
    public static final String RESULT_BALL = "볼";
    public static final String RESULT_NOT_THING = "낫싱";

    public static final String WHITE_SPACE = " ";
    public static final String VALID_NUMBER_REX_PATTERN = "^[1-9]+$";

    // 게임 종료 관련 상수
    public static final String GAME_RESULT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String VALID_RESTART_REX_PATTERN = "^[1-2]+$";
    public static final String END_GAME = "게임 종료";
    public static final String RESTART_SIGNAL = "1";
    public static final String END_GAME_SIGNAL = "2";

}
