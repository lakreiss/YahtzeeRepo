package categories.lowerSection;

import categories.Category;
import main.Dice;

public class Yahtzee extends Category implements LowerSection {

	//TODO allow for multiple yahtzees to be achieved in one game
	public Yahtzee() {
		super(5);
	}

	@Override
	public int calculateScore(Dice[] dice) {
		if (checkYahtzee(dice)){
			return 50;
		}
		return 0;
	}

	public String getCall(){
		return "yahtzee";
	}
	
	public String toString(){
		return "Yahtzee: " + super.toString();
	}
}
