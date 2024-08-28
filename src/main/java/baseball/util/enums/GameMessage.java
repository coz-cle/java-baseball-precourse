package baseball.util.enums;

public enum GameMessage implements EnumUtil<String, String> {

    INPUT_NUMBER("숫자를 입력해주세요 : "),
    GAME_RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    CORRECT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ;

    private final String message;

    GameMessage(final String message) {
        this.message = message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }

}
