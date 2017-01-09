package simonSays;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickableScreen;

public class SimonScreenAnthonyCuzzi extends ClickableScreen implements Runnable{
	
	TextLabel label;
	ButtonInterfaceAnthonyCuzzi[] button;
	ProgressInterfaceAnthonyCuzzi progress;
	ArrayList<MoveInterfaceAnthonyCuzzi> pattern;
	
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;

	public SimonScreenAnthonyCuzzi() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();
	}
	
	public void nextRound(){
		acceptingInput = false;
		roundNumber += 1;
		pattern.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(pattern.size());
		changeText("Simon's Turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceAnthonyCuzzi b = null;
		for(int i = 0; i < pattern.size(); i++){
			if(b != null){
				b.dim();
				b = ((MoveInterfaceAnthonyCuzzi) pattern).getButton();
				b.highlight();
				int sleepTime = 800-(roundNumber*20);
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		b.dim();
	}

	private void changeText(String string) {
		label = new TextLabel(130,230,300,40,string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		pattern = new ArrayList<MoveInterfaceAnthonyCuzzi>();
		//add 2 moves to start
		lastSelectedButton = -1;
		pattern.add(randomMove());
		pattern.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceAnthonyCuzzi randomMove() {
		ButtonInterfaceAnthonyCuzzi b = null;
		int rdm = (int)(1 + (Math.random()*6));
		if(rdm == lastSelectedButton){
			while(rdm == lastSelectedButton){
				rdm = (int)(1 + (Math.random()*6));
			}
			b = (ButtonInterfaceAnthonyCuzzi) button[rdm];
		}
		return getMove(b);
	}


	private void addButtons() {
		int numberOfButtons = 6;
		Color[] Colors = {Color.red,Color.blue,Color.green,Color.orange,Color.yellow,Color.magenta};
		for(int i = 0; i < numberOfButtons; i++){
			 final ButtonInterfaceAnthonyCuzzi b = getAButton();
			 	b.setColor(Colors[i]); 
			    b.setX(60 + i*20);
			    b.setY(60);
			    b.setAction(new Action(){

			    	public void act(){
			    		if(acceptingInput){
			    			Thread blink = new Thread(new Runnable(){

			    				public void run(){
			    					 b.highlight();
			    					 Thread.sleep(800);
			    					 b.dim();
			    				}

			    				});
			    			blink.start();
			    			
			    		}
			    		if(b == pattern.get(sequenceIndex).getButton()){
			    			sequenceIndex++;
			    		}else{
			    			progress.gameOver();
			    		}
			    	}

			    	}); 
		}
		if(sequenceIndex == pattern.size()){
		Thread nextRound = new Thread(SimonScreenAnthonyCuzzi.this);
		nextRound.start(); 
		}
		viewObjects.add(b);
	}
	
	/**
	Placeholder until partner finishes creation of Button class
	 * @return 
	*/

	private ButtonInterfaceAnthonyCuzzi getAButton() {
		return new Button();
	}
	
	/**
	Placeholder until partner finishes creation of Move class
	*/
	private MoveInterfaceAnthonyCuzzi getMove(ButtonInterfaceAnthonyCuzzi b) {
		return new Move(b);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceAnthonyCuzzi getProgress() {
		return new Progress();
	}

}
