package simonSays;

public class Move implements MoveInterfaceAnthonyCuzzi {

	private ButtonInterfaceAnthonyCuzzi button;
	
	public Move(ButtonInterfaceAnthonyCuzzi b) {
		this.button = b;
	}

	@Override
	public ButtonInterfaceAnthonyCuzzi getButton() {
		return button;
	}

}
