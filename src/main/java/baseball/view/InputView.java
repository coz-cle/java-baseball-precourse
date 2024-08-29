package baseball.view;

import static baseball.util.enums.GameMessage.GAME_RETRY;
import static baseball.util.enums.GameMessage.INPUT_NUMBER;
import static baseball.util.common.BasicUtils.readLine;
import static baseball.view.OutputView.printEnterMessage;
import static baseball.view.OutputView.printMessage;

public class InputView {

    public static String inputNumber() {
        try {
            printMessage(INPUT_NUMBER.getValue());
            return readLine();
        } catch (IllegalArgumentException exception) {
            printMessage(exception.getMessage());
            return inputNumber();
        }
    }

    public static String inputRestartNumber() {
        try {
            printEnterMessage(GAME_RETRY.getValue());
            return readLine();
        } catch (IllegalArgumentException exception) {
            printMessage(exception.getMessage());
            return inputRestartNumber();
        }
    }

}
