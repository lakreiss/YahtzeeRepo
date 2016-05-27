package categories.upperSection;

import categories.Category;
import player.Dice;

public class Fours extends Category implements UpperSection {

	public Fours() {
		super(3);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		int score = 0;
		for (Dice d : dice){
			if (d.getValue() == 4){
				score += 4;
			}
		}
		return score;
	}
	
	public String getCall(){
		return "fours";
	}
	
	public String toString(){
		return "Fours: " + super.toString();
	}
}
