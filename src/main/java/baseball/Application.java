package baseball;

import baseball.config.AppConfig;
import baseball.controller.GameController;

public class Application {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();

		GameController gameController = appConfig.gameController();

		gameController.execute();
	}
}
