package baseball.util.common;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnswerNumberGenerator implements NumberGenerator {

    private AnswerNumberGenerator() {
    }

    public static AnswerNumberGenerator create() {
        return new AnswerNumberGenerator();
    }

    @Override
    public List<Integer> generate() {
        return Stream.generate(BasicUtils::generateRandomNumber)
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
    }

}
