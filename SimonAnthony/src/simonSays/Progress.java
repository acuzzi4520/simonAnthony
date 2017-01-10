package simonSays;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Progress extends Component implements ProgressInterfaceAnthonyCuzzi {
	
	private int round;
	private int seqSize;
	private boolean isGameOver;
	private static int w = 200;
	private static int h = 100;

	public Progress() {
		super();
	}

	@Override
	public void gameOver() {
		this.isGameOver = true;
		update();
	}

	@Override
	public void setRound(int i) {
		this.round = i;
		update();
	}

	@Override
	public void setSequenceSize(int i) {
		this.seqSize = i;
		update();
	}
	
	@Override
	public void update(Graphics2D g){
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(isGameOver){
			g.setColor(Color.yellow);
			g.fillRect(0, 0, w, h);
			g.setColor(Color.black);
			
		}else{
			
		}
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
