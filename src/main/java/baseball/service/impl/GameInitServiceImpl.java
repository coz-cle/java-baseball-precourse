package baseball.service.impl;

import baseball.domain.BaseballNumber;
import baseball.service.GameInitService;
import baseball.util.BasicUtils;

import java.util.ArrayList;
import java.util.List;

public class GameInitServiceImpl implements GameInitService {


	@Override
	public BaseballNumber init() {
		List<String> randomNumberList = new ArrayList<>();

		while (randomNumberList.size() < 3) {
			// 난수 생성
			final String randomNumber = String.valueOf(BasicUtils.generateRandomNumber());
			// 난수 중복 검증
			if(!randomNumberList.contains(randomNumber)){
				// 난수 추가
				randomNumberList.add(randomNumber);
			}
		}

		final String randomNumber = String.join("", randomNumberList);
		return BaseballNumber.from(randomNumber);
	}
}
