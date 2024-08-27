package baseball.service.impl;

import baseball.domain.BaseballNumber;
import baseball.enums.GameControlSwitchEnum;
import baseball.service.BaseballGameService;

public class BaseballGameServiceImpl implements BaseballGameService {

	@Override
	public BaseballNumber readyPlayGame() {

		// 반복문
			// 난수 생성

			// 난수 중복 검증

			// 숫자 추가

		return new BaseballNumber("");
	}

	@Override
	public void executeGame(BaseballNumber systemNumber, String inputNumber) {
		int strikeCount = 0;

		// while 문
			// 입력 값과 시스템 값 비교

			// 비교 결과 출력

		// 스트라이크 아웃 메세지 출력

	}

	@Override
	public boolean isFinishedGame(GameControlSwitchEnum gameControlSwitch) {
		return GameControlSwitchEnum.END.equals(gameControlSwitch);
	}

}
