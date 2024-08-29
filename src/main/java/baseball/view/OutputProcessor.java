package baseball.view;

public class OutputProcessor {

    private OutputProcessor() {
    }

    public static OutputProcessor create() {
        return new OutputProcessor();
    }

    public void printGameResult(String gameResult) {
        OutputView.printMessage(gameResult);
    }

    public void printEnterGameResult(String gameResult) {
        OutputView.printEnterMessage(gameResult);
    }

}
