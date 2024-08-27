package baseball.exception;

public class ErrorMessages {

    /**
     * 기본으로 제공할 예외 메시지
     * 1. 입력받은 숫자가 3자리가 아닐 경우 예외 발생
     * 2. 입력받은 숫자가 숫자(1~9)가 아닐 경우 예외 발생
     * 3. 게임 종료 후 1 또는 2가 입력되지 않을 경우 예외 발생
     */

    public static final String INVALID_THREE_DIGIT = "입력한 숫자가 3자리가 아닙니다. 3자리 숫자를 입력해주세요.";

    public static final String INVALID_NON_DIGIT = "입력한 값이 숫자가 아닙니다. 1부터 9 사이의 숫자를 입력해주세요.";

    public static final String INVALID_UNIQUE_NUMBER = "중복된 숫자를 입력할 수 없습니다. 서로 다른 숫자를 입력해주세요.";

    public static final String INVALID_EXIT_CHOICE = "게임 종료 후 1 또는 2를 입력해야 합니다. 올바른 값을 입력해주세요.";


}
