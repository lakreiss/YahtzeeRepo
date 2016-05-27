package categories.upperSection;

import categories.Category;
import main.Dice;

public class Twos extends Category implements UpperSection {

	public Twos() {
		super(1);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		int score = 0;
		for (Dice d : dice){
			if (d.getValue() == 2){
				score += 2;
			}
		}
		return score;
	}

	public String getCall(){
		return "twos";
	}
	
	public String toString(){
		return "Twos: " + super.toString();
	}
}
