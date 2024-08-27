package baseball.view;

import static baseball.util.BasicUtils.readLine;
import static baseball.view.OutputView.printEnterMessage;
import static baseball.view.OutputView.printMessage;

public class InputView {

    public static String inputNumber() {
        try {
            printMessage("숫자를 입력해주세요 : ");
            return readLine();
        } catch (IllegalArgumentException exception) {
            printMessage(exception.getMessage());
            return inputNumber();
        }
    }

    public static String inputRestartNumber() {
        try {
            printEnterMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return readLine();
        } catch (IllegalArgumentException exception) {
            printMessage(exception.getMessage());
            return inputRestartNumber();
        }
    }

}
