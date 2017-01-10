package simonSays;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;

import guiPractice.components.Action;


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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
