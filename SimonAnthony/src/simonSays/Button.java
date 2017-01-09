package simonSays;

import java.awt.Color;
import java.awt.Component;

import components.Action;

public class Button extends Component implements ButtonInterfaceAnthonyCuzzi{
	
	private int xCoord;
	private int yCoord;
	private Color color;
	private Action action;

	public Button() {
		
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void setX(int i) {
		this.xCoord = i;
	}

	@Override
	public void setY(int i) {
		this.yCoord = i;
	}

	@Override
	public void setAction(Action a) {
		this.action = a;
	}

	@Override
	public void highlight() {
		
	}

	@Override
	public void dim() {
		
	}

}
