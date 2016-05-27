package categories.upperSection;

import categories.Category;
import main.Dice;

public class Sixes extends Category implements UpperSection {

	public Sixes() {
		super(5);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		int score = 0;
		for (Dice d : dice){
			if (d.getValue() == 6){
				score += 6;
			}
		}
		return score;
	}

	public String getCall(){
		return "sixes";
	}
	
	public String toString(){
		return "Sixes: " + super.toString();
	}
}
