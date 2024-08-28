package baseball.mock;

import baseball.util.common.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class MockNumberGenerator implements NumberGenerator {

    private MockNumberGenerator() {
    }

    public static MockNumberGenerator create() {
        return new MockNumberGenerator();
    }

    @Override
    public List<Integer> generate() {
        return Arrays.asList(1, 2, 3);
    }

}
