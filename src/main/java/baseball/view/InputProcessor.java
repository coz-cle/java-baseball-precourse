package baseball.view;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.view.InputView.*;

public class InputProcessor {

    /**
     * Stream.chars(): 문자열의 각 문자를 IntStream으로 변환, 스트림은 각 문자의 유니코드 값(정수)로 구성
     * mapToObj(c -> Character.getNumericValue(c)): 유니코드 값을 Integer로 변환
     */
    public List<Integer> inputBaseballNumbers() {
        String inputStringNumbers = inputNumber();

        // TODO: 입력값 유효성 검사 필요

        return inputStringNumbers.chars()
                .mapToObj(c -> Character.getNumericValue(c))
                .collect(Collectors.toList());
    }

    public int inputRestartFlag() {
        String inputRestartNumber = inputRestartNumber();
        return Integer.parseInt(inputRestartNumber);
    }
}
