package categories.upperSection;

import categories.Category;
import main.Dice;

public class Ones extends Category implements UpperSection {

	public Ones() {
		super(0);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		int score = 0;
		for (Dice d : dice){
			if (d.getValue() == 1){
				score += 1;
			}
		}
		return score;
	}
	
	public String getCall(){
		return "ones";
	}
	
	public String toString(){
		return "Ones: " + super.toString();
	}

}
