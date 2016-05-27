package categories.upperSection;

import categories.Category;
import player.Dice;

public class Threes extends Category implements UpperSection {

	public Threes() {
		super(2);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		int score = 0;
		for (Dice d : dice){
			if (d.getValue() == 3){
				score += 3;
			}
		}
		return score;
	}

	public String getCall(){
		return "threes";
	}
	
	public String toString(){
		return "Threes: " + super.toString();
	}
}
