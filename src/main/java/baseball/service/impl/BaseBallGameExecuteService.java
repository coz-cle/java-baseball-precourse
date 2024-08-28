package baseball.service.impl;

import baseball.domain.BaseBallCount;
import baseball.dto.GameStartDto;
import baseball.enums.GameStatus;
import baseball.service.GameExecuteService;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameExecuteService implements GameExecuteService {
	private static final String STRIKE_OUT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String NOT_THING_MESSAGE = "낫싱";
	private static final String BALL_MESSAGE_SUFFIX = "볼";
	private static final String STRIKE_MESSAGE_SUFFIX = "스트라이크";

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

		// 비교 결과 출력
		printRoundResult(baseBallCount);

		if(baseBallCount.isStrikeOut()){
			System.out.println(STRIKE_OUT_MESSAGE);
			return GameStatus.NOT_RUNNING;
		}

		return GameStatus.RUNNING;
	}


	private void printRoundResult(BaseBallCount baseBallCount){
		String roundResult = getResultMessage(baseBallCount);
	    System.out.println(roundResult);
	}


	private String getResultMessage(BaseBallCount baseBallCount) {
		List<String> result = new ArrayList<>();

		if(baseBallCount.isNothing()){
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
}
