package categories.upperSection;

import categories.Category;
import player.Dice;

public class Fives extends Category implements UpperSection {

	public Fives() {
		super(4);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		int score = 0;
		for (Dice d : dice){
			if (d.getValue() == 5){
				score += 5;
			}
		}
		return score;
	}
	
	public String getCall(){
		return "fives";
	}
	
	public String toString(){
		return "Fives: " + super.toString();
	}
}
