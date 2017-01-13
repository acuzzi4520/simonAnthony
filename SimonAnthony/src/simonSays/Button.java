package simonSays;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiPractice.components.Action;
import guiPractice.components.Component;


public class Button extends Component implements ButtonInterfaceAnthonyCuzzi{
	
	private int xCoord;
	private int yCoord;
	private Color color;
	private Action action;

	public Button() {
		super(50,50,60,60);
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
	public void setAction(guiPractice.components.Action a) {
		this.action = a;
	}

	@Override
	public void highlight() {
		
	}

	@Override
	public void dim() {
		
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		if(x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight()){
			return true;
		}
		return false;
	}



	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub
		
	}

}
