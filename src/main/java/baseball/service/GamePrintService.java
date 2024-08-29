package baseball.service;

import baseball.domain.BaseBallCount;

public interface GamePrintService {
    void printInputNumberHeader();

    void printResult(BaseBallCount baseBallCount);

    void printOutMessage();

	void printGameControlMessage();
}
