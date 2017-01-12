package simonSays;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Action;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class SimonScreenAnthonyCuzzi extends guiPractice.ClickableScreen implements Runnable{

	private guiPractice.components.TextLabel label;
	private ButtonInterfaceAnthonyCuzzi[] buttons;
	private ProgressInterfaceAnthonyCuzzi progress;
	private ArrayList<MoveInterfaceAnthonyCuzzi> sequence; 
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelected;

	public SimonScreenAnthonyCuzzi(int height, int width) {
		super(500, 500);
		Thread screen = new Thread(this);
		screen.start();
	}


	public void initAllObjects(List<Visible> viewObjects) {
		Color[] colors = {Color.red, Color.blue, new Color(240,160,70), new Color(20,255,140), Color.yellow, new Color(180,90,210)};
		int buttonCount = 6;
		buttons = new ButtonInterfaceAnthonyCuzzi[buttonCount];
		for(int i = 0; i < buttonCount; i++ ){
			buttons[i] = getAButton();
			buttons[i].setColor(colors[i]);
			buttons[i].setX(160 + (int)(100*Math.cos(i*2*Math.PI/(buttonCount))));
			buttons[i].setY(200 - (int)(100*Math.sin(i*2*Math.PI/(buttonCount))));
			final ButtonInterfaceAnthonyCuzzi b = buttons[i];
			System.out.println(b+" has x = "+b.getX()+", y ="+b.getY());
			b.dim();
			buttons[i].setAction(new Action() {

				public void act() {

						Thread buttonPress = new Thread(new Runnable() {
							
							public void run() {
								b.highlight();
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
								
							}
						});
						buttonPress.start();
						

						if(acceptingInput && sequence.get(sequenceIndex).getButton() == b){
							sequenceIndex++;
						}else if(acceptingInput){
							gameOver();
							return;
						}
						if(sequenceIndex == sequence.size()){
							Thread nextRound = new Thread(SimonScreenAnthonyCuzzi.this);
							nextRound.start();
						}
					}

			});
			viewObjects.add(buttons[i]);
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceAnthonyCuzzi>();
		//add 2 moves to start
		lastSelected = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;

		viewObjects.add(progress);
		viewObjects.add(label);
	}

	public void gameOver() {
		progress.gameOver();
	}

	public void nextRound() {
		acceptingInput = false;
		roundNumber ++;
		progress.setRound(roundNumber);
		sequence.add(randomMove());
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn.");
		label.setText("");
		showSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}


	private MoveInterfaceAnthonyCuzzi randomMove() {
		int select = (int) (Math.random()*buttons.length);
		while(select == lastSelected){
			select = (int) (Math.random()*buttons.length);
		}
		lastSelected = select;
		return new Move(buttons[select]);
	}

	private ProgressInterfaceAnthonyCuzzi getProgress() {
		return new Progress();
	}

	private ButtonInterfaceAnthonyCuzzi getAButton() {
		return new Button();
	}

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void run() {
		changeText("");
//		while(true){
			nextRound();
//			synchronized (this) {
//
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//		}
	}


	private void showSequence() {
		ButtonInterfaceAnthonyCuzzi b = null;
		for(MoveInterfaceAnthonyCuzzi m: sequence){
			if(b!=null)b.dim();
			b = m.getButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	@Override
	public void initObjects(List<Visible> arg0) {
		// TODO Auto-generated method stub
		
	}

}
