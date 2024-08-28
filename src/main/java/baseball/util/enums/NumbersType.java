package baseball.util.enums;

public enum NumbersType implements EnumUtil<String, String>{

    INPUT_NUMBER("입력 숫자"),
    ANSWER_NUMBER("정답 숫자")
    ;

    private final String type;

    NumbersType(final String type) {
        this.type = type;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return type;
    }

}
