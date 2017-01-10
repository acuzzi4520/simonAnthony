package simonSays;

import java.awt.Graphics2D;

import guiPractice.components.Visible;

public interface ProgressInterfaceAnthonyCuzzi extends Visible{
	
	void gameOver();
	
	void setRound(int i);
	
	void setSequenceSize(int i);

	void update(Graphics2D g);

}
