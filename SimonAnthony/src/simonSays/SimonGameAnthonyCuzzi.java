package simonSays;

import guiPractice.GUIApplication;

public class SimonGameAnthonyCuzzi extends GUIApplication{

	public SimonGameAnthonyCuzzi() {
		super();
		Thread app = new Thread(this);
		app.start();
	}

	public static void main(String[] args) {
		SimonScreenAnthonyCuzzi ssac =
				new SimonScreenAnthonyCuzzi();
		setScreen(ssac);
	}

	@Override
	protected void initScreen() {
		SimonGameAnthonyCuzzi game = new SimonGameAnthonyCuzzi();
		Thread app = new Thread(game);
		app.start();
	}

}
