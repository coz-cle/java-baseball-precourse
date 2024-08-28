package baseball.service.impl;

import baseball.domain.BaseBallCount;
import baseball.domain.BaseballNumber;
import baseball.dto.GameStartDto;
import baseball.enums.GameControlSwitch;
import baseball.enums.GameStatus;
import baseball.service.GameExecuteService;
import baseball.service.InputValidator;
import baseball.util.BasicUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBallGameExecuteService implements GameExecuteService {
	private static final String INPUT_NUMBER_TITLE_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String STRIKE_OUT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String NOT_THING_MESSAGE = "낫싱";
	private static final String BALL_MESSAGE_SUFFIX = "볼";
	private static final String STRIKE_MESSAGE_SUFFIX = "스트라이크";
	private static final String GAME_CONTROL_TITLE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private final InputValidator inputValidator;

	public BaseBallGameExecuteService(InputValidator inputValidator) {
		this.inputValidator = inputValidator;
	}

	@Override
	public GameStartDto ready(BaseballNumber systemNumber) {

		System.out.print(INPUT_NUMBER_TITLE_MESSAGE);
		String inputNumber = BasicUtils.readLine();

		inputValidator.isAvailableGameNumber(inputNumber);
		BaseballNumber userNumber = createUserNumber(inputNumber);

		return GameStartDto.from(systemNumber, userNumber);
	}


	// TODO 개선 리팩터링 필요
	@Override
	public GameStatus run(GameStartDto gameStartDto) {

		List<String> systemNumberChars = gameStartDto.getSystemNumber().getNumbers();
		List<String> inputNumberChars = gameStartDto.getUserNumber().getNumbers();

		BaseBallCount baseBallCount = BaseBallCount.from();

		// 입력 값과 시스템 값 비교
		for(int i = 0; i < systemNumberChars.size(); i++){
			String numberChar = systemNumberChars.get(i);
			String inputChar = inputNumberChars.get(i);

			if(numberChar.equals(inputChar)){
				baseBallCount.addStrike();
				continue;
			}

			if(inputNumberChars.contains(numberChar)){
				baseBallCount.addBall();
			}
		}

		System.out.println(baseBallCount);
		// 비교 결과 출력
		printRoundResult(baseBallCount);

		if(baseBallCount.isStrikeOut()){
			System.out.println(STRIKE_OUT_MESSAGE);
			return GameStatus.NOT_RUNNING;
		}

		return GameStatus.RUNNING;
	}

	@Override
	public GameStatus handleExecution() {
		System.out.println(GAME_CONTROL_TITLE_MESSAGE);
	    GameControlSwitch gameControlSwitch = GameControlSwitch.of(BasicUtils.readLine());
		if(gameControlSwitch.isEndSwitch()) {
			return GameStatus.OVER;
		}
		return GameStatus.RUNNING;
	}


	private void printRoundResult(BaseBallCount baseBallCount){
		String roundResult = getResultMessage(baseBallCount);
	    System.out.println(roundResult);
	}


	private String getResultMessage(BaseBallCount baseBallCount) {
		List<String> result = new ArrayList<>();

		if(baseBallCount.isNoting()){
			return NOT_THING_MESSAGE;
		}

		if(baseBallCount.hasBall()){
			result.add(baseBallCount.getBall() + BALL_MESSAGE_SUFFIX);
		}

		if(baseBallCount.hasStrike()){
			result.add(baseBallCount.getStrike() + STRIKE_MESSAGE_SUFFIX);
		}

		return String.join(" ", result);
	}

	private BaseballNumber createUserNumber(String number) {
		List<String> numbers = number.chars()
				.mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.toList());
		return BaseballNumber.from(numbers);
	}

}
