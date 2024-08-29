package baseball.view;

import baseball.util.validator.NumbersValidator;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.view.InputView.*;

public class InputProcessor {

    private final NumbersValidator numbersValidator;

    private InputProcessor(NumbersValidator numbersValidator) {
        this.numbersValidator = numbersValidator;
    }

    public static InputProcessor create(NumbersValidator numbersValidator) {
        return new InputProcessor(numbersValidator);
    }

    /**
     * Stream.chars(): 문자열의 각 문자를 IntStream으로 변환, 스트림은 각 문자의 유니코드 값(정수)로 구성
     * mapToObj(c -> Character.getNumericValue(c)): 유니코드 값을 Integer로 변환
     */
    public List<Integer> inputBaseballNumbers() {
        String inputStringNumbers = inputNumber();

        numbersValidator.validateInput(inputStringNumbers);

        return inputStringNumbers.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public int inputRestartFlag() {
        String inputRestartNumber = inputRestartNumber();

        numbersValidator.validateRestartNumber(inputRestartNumber);

        return Integer.parseInt(inputRestartNumber);
    }

}
