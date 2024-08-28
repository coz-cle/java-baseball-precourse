package baseball.service.impl;

import baseball.service.InputValidator;
import baseball.util.Constants;
import baseball.util.Validator;

import java.util.HashSet;
import java.util.Set;

import static baseball.exception.ErrorMessages.*;

public class BaseBallNumberValidator extends Validator<String> implements InputValidator {

	@Override
	protected void validate(String target) {

		// 입력 받은 값이 숫자가 아닐 경우
		validateNumeric(target);

		// 입력 받은 값이 3자리보다 작거나 클 경우
		validateLength(target);

		// 입력 받은 값 중에서 중복이 존재 할 경우
		validateDuplication(target);
	}

	@Override
	public void validateInput(String gameNumber) {
		try {
			validate(gameNumber);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	private void validateNumeric(String target) {
		for (char c : target.toCharArray()) {
	        if (!Character.isDigit(c)) {
	            throwException(INVALID_NON_DIGIT);
	        }
	    }
	}

	private void validateLength(String target) {
		if(target.length() != Constants.BASEBALL_NUMBER_SIZE) {
			throwException(INVALID_THREE_DIGIT);
		}
	}

	private void validateDuplication(String target) {
		Set<Character> charSet = new HashSet<>();
		for (char c : target.toCharArray()) {
          if (!charSet.add(c)) { // add() 메서드는 중복된 값을 넣으려고 하면 false를 반환함
              throwException(INVALID_UNIQUE_NUMBER);
          }
      }
	}


}
