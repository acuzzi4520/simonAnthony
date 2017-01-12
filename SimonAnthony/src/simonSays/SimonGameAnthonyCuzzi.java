package simonSays;

import guiPractice.GUIApplication;

public class SimonGameAnthonyCuzzi extends GUIApplication{

	public SimonGameAnthonyCuzzi(int width,int height) {
		super();
	}


	@Override
	protected void initScreen() {
		SimonScreenAnthonyCuzzi s = new SimonScreenAnthonyCuzzi(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		SimonGameAnthonyCuzzi game = new SimonGameAnthonyCuzzi(800, 500);
		Thread app = new Thread(game);
		app.start();
	}
}
